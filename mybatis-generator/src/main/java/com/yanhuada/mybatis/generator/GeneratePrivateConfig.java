package com.yanhuada.mybatis.generator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 17:41
 */
public class GeneratePrivateConfig {

    private static String PROPERTIES_PATH = "mybatis-generator/src/main/resources/config.private.properties";

    public static void main(String[] args) throws IOException {
        generate();
    }

    private static void generate() throws IOException {
        Map<String, Object> data = new HashMap<>();

        File currentDirectory = new File(System.getProperty("user.dir"));
        for (File file : currentDirectory.listFiles()) {
            if (file.getName().equals("model")) {
                data.put("modelTargetProject", convertWindowsPath(file.getCanonicalPath()) + "/src/main/java");
            } else if (file.getName().equals("dao")) {
                data.put("sqlTargetProject", convertWindowsPath(file.getCanonicalPath()) + "/src/main/resources");
                data.put("javaClientTargetProject", convertWindowsPath(file.getCanonicalPath()) + "/src/main/java");

                data.put("mapper_common_parent_path", convertWindowsPath(file.getCanonicalPath()) + "/src/main");
            }
        }

        String content =
                "DRIVER_CLASS=com.mysql.jdbc.Driver\n" +
                        "DB_HOST = localhost\n" +
                        "DB_PORT = 3306\n" +
                        "DB_NAME =\n" +
                        "DB_USER = root\n" +
                        "DB_PASSWORD =\n" +
                        "modelTargetProject=" + data.get("modelTargetProject") + "\n" +
                        "mapper_common_parent_path = " + data.get("mapper_common_parent_path");
        File file = new File(PROPERTIES_PATH);
        writeFile(file, content, "UTF-8");
    }

    private static String convertWindowsPath(String originPath) {
        String targetPath = originPath;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            targetPath = originPath.replaceAll("\\\\", "/");
        }
        return targetPath;
    }

    private static void writeFile(File file, String content, String fileEncoding) throws IOException {
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
