package com.yanhuada.common.config;

import com.yanhuada.common.model.BaseModel;
import com.yanhuada.common.model.BaseModelWithId;
import com.yanhuada.common.util.snowflake.SnowflakeUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class}
        )
})
public class IdAndTimeAutoUpdatePlugin implements Interceptor {

    private SnowflakeUtil idWorker;
    private SnowflakeUtil versionWorker;

    public IdAndTimeAutoUpdatePlugin(SnowflakeUtil idWorker) throws Exception {
        this(idWorker, null);
    }

    public IdAndTimeAutoUpdatePlugin(SnowflakeUtil idWorker, SnowflakeUtil versionWorker) throws Exception {
        if (idWorker == null) {
            throw new Exception("idWorker cannot be null");
        }

        this.idWorker = idWorker;
        this.versionWorker = versionWorker == null ? idWorker : versionWorker;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String mappedId = mappedStatement.getId();
        String operation = mappedId.substring(mappedId.lastIndexOf(".") + 1).toLowerCase();
        Object object = invocation.getArgs()[1];

        if (operation.contains("insert")) {
            // 插入
            if (object instanceof Map && ((Map) object).get("list") != null && ((Map) object).get("list") instanceof List && !((List) ((Map) object).get("list")).isEmpty()) {
                // 批量插入
                for (Object item : (List) ((Map) object).get("list")) {
                    autoInsertBaseModel(item);
                }
            } else {
                // 插入单条数据
                autoInsertBaseModel(object);
            }
        } else if (operation.contains("update")) {
            // 更新

            if (object != null && object instanceof Map) {
                autoUpdateBaseModel(((Map) object).get("record"));
            } else {
                autoUpdateBaseModel(object);
            }
        }

        return invocation.proceed();
    }

    protected void autoInsertBaseModel(Object object) {
        LocalDateTime now = LocalDateTime.now();

        if (object != null && object instanceof BaseModel) {
            if (((BaseModel) object).getCreatedAt() == null) ((BaseModel) object).setCreatedAt(now);
            if (((BaseModel) object).getUpdatedAt() == null) ((BaseModel) object).setUpdatedAt(now);
            if (((BaseModel) object).getVersion() == null) ((BaseModel) object).setVersion(idWorker.nextId());
        }

        if (object != null && object instanceof BaseModelWithId && ((BaseModelWithId) object).getId() == null) {
            ((BaseModelWithId) object).setId(idWorker.nextId());
        }
    }

    protected void autoUpdateBaseModel(Object object) {
        LocalDateTime now = LocalDateTime.now();

        if (object != null && object instanceof BaseModel) {
            ((BaseModel) object).setUpdatedAt(now);
            ((BaseModel) object).setVersion(idWorker.nextId());
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
