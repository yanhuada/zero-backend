package com.yanhuada.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 17:41
 */
public class MybatisGenerator {

    public static void main(String[] args) {
        try {
            generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generate() throws Exception {
        List<String> warnings = new ArrayList<>();
        DefaultShellCallback callback = new DefaultShellCallback(true);
        File configFile = new File(Objects.requireNonNull(MybatisGenerator.class.getClassLoader().getResource("mybatisGeneratorConfiguration.xml")).getPath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
