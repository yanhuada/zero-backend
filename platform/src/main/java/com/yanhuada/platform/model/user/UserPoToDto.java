package com.yanhuada.platform.model.user;

import com.yanhuada.common.util.aliyun.oss.OssUtil;
import com.yanhuada.model.Author;
import com.yanhuada.model.User;
import com.yanhuada.platform.model.user.rsp.UserAuthorRsp;
import com.yanhuada.platform.model.user.rsp.UserDetailRsp;
import com.yanhuada.platform.model.user.rsp.UserPagerRsp;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yanhuada
 * CREATE ON 2020/8/12 15:28
 */
public class UserPoToDto {

    public static UserPagerRsp copyUserPagerRsp(User user, OssUtil ossUtil) {
        UserPagerRsp rsp = new UserPagerRsp();
        rsp.setId(user.getId());
        rsp.setAvatar(ossUtil.getFileUrl(user.getAvatar()));
        rsp.setNickname(user.getNickname());
        rsp.setIdentity(identity(user));
        rsp.setIfEnable(user.getIfEnable());
        rsp.setCreatedAt(user.getCreatedAt());
        rsp.setPhone(user.getPhone());
        rsp.setIfAuthor(user.getIfAuthor());
        rsp.setIfCustomerService(user.getIfCustomerService());
        return rsp;
    }

    public static UserDetailRsp copyUserDetailRsp(User user) {

        return new UserDetailRsp();
    }

    public static UserAuthorRsp copyUserAuthorRsp(Author author, OssUtil ossUtil) {
        UserAuthorRsp rsp = new UserAuthorRsp();
        rsp.setId(author.getId());
        rsp.setUserAvatar(StringUtils.isBlank(author.getUserAvatar()) ? "" : ossUtil.getFileUrl(author.getUserAvatar()));
        rsp.setUserNickname(author.getUserNickname());
        return rsp;
    }

    private static String identity(User user) {
        if (user.getIfAuthor() && user.getIfCustomerService()) {
            return "作者、客服";
        } else if (user.getIfAuthor() && !user.getIfCustomerService()) {
            return "作者";
        } else if (!user.getIfAuthor() && user.getIfCustomerService()) {
            return "客服";
        } else {
            return "普通用户";
        }
    }
}
