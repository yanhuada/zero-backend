package com.yanhuada.mybatis.generator;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 17:41
 */
public class GenerateConfiguration {

    private static String XML_PATH = "mybatis-generator/src/main/resources/mybatisGeneratorConfiguration.xml";

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Properties properties = getProperties();

        List<String> tableNameList = getTableName(properties);
        String content = createXmlContent(tableNameList);

        writeFile(content,"UTF8");

    }

    private static Properties getProperties() throws ClassNotFoundException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(GenerateConfiguration.class.getResource("/config.private.properties").getPath()));
        return properties;
    }

    private static List<String> getTableName(Properties properties) throws ClassNotFoundException, SQLException {
        List<String> tableNameList = new ArrayList<>();

        Class.forName(properties.getProperty("DRIVER_CLASS"));

        Connection connection = DriverManager.getConnection("jdbc:mysql://" + properties.get("DB_HOST") + ":" + properties.get("DB_PORT") + "/" + properties.get("DB_NAME")
                + "?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8", properties.getProperty("DB_USER"), properties.getProperty("DB_PASSWORD"));
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        ResultSet rs = databaseMetaData.getTables(null, null, null, new String[]{"TABLE", "VIEW"});
        while (rs.next()) {
            tableNameList.add(rs.getString(3));
        }
        return tableNameList;
    }

    private static String createXmlContent(List<String> tableNameList) {
        String content =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<!DOCTYPE generatorConfiguration\n" +
                        "        PUBLIC \"-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN\"\n" +
                        "        \"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd\">\n" +
                        "\n" +
                        "<generatorConfiguration>\n" +
                        "    <properties resource=\"config.private.properties\"/>\n" +
                        "    <context id=\"testTables\" targetRuntime=\"MyBatis3\" defaultModelType=\"flat\">\n" +
                        "        <property name=\"isMergeable\" value=\"false\"/>\n" +
                        "        <plugin type=\"org.mybatis.generator.external.plugins.SerializablePlugin\" />\n" +
                        "        <commentGenerator type=\"org.mybatis.generator.external.CommentGeneratorWithSwagger\">\n" +
                        "            <property name=\"suppressAllComments\" value=\"false\"/>\n" +
                        "        </commentGenerator>\n" +
                        "        <jdbcConnection driverClass=\"${DRIVER_CLASS}\" userId=\"${DB_USER}\" password=\"${DB_PASSWORD}\"\n" +
                        "                        connectionURL=\"jdbc:mysql://${DB_HOST}:3306/${DB_NAME}?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf8\">\n" +
                        "        </jdbcConnection>\n" +
                        "        <javaTypeResolver type=\"org.mybatis.generator.external.types.JavaTypeResolverCustomImpl\">\n" +
                        "            <property name=\"forceBigDecimals\" value=\"false\"/>\n" +
                        "        </javaTypeResolver>\n" +
                        "        <javaModelGenerator targetPackage=\"com.yanhuada.model\" targetProject=\"${modelTargetProject}\">\n" +
                        "            <property name=\"enableSubPackages\" value=\"false\"/>\n" +
                        "            <property name=\"trimStrings\" value=\"true\"/>\n" +
                        "            <property name=\"rootClass\" value=\"com.yanhuada.common.model.BaseModelWithId\"/>\n" +
                        "        </javaModelGenerator>\n" +
                        "        <sqlMapGenerator targetPackage=\"com.yanhuada.dao.mapper\" targetProject=\"${mapper_common_parent_path}/resources\">\n" +
                        "            <property name=\"enableSubPackages\" value=\"false\"/>\n" +
                        "        </sqlMapGenerator>\n" +
                        "" +
                        "        <javaClientGenerator type=\"XMLMAPPER\" targetPackage=\"com.yanhuada.dao.mapper\"\n" +
                        "                             targetProject=\"${mapper_common_parent_path}/java\">\n" +
                        "            <property name=\"enableSubPackages\" value=\"false\"/>\n" +
                        "        </javaClientGenerator>\n";

        for (String tableName : tableNameList) {
            content += "<table tableName=\"" + tableName + "\"></table>\n";
        }
        content += "    </context>\n";
        content += "</generatorConfiguration>\n";
        return content;
    }


    private static void writeFile(String content, String fileEncoding) throws IOException {
        File file = new File(XML_PATH);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file, false);
        OutputStreamWriter osw;
        if (fileEncoding == null) {
            osw = new OutputStreamWriter(fos);
        } else {
            osw = new OutputStreamWriter(fos, fileEncoding);
        }

        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(content);
        bw.close();
    }
}
