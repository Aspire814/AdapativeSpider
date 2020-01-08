package com.storm.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
 
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
 
public class MBGUtil {
    public static void main(String[] args) throws Exception {
        Mbg();
    }

    public static void Mbg() throws Exception {
        List<String> warnings = new ArrayList<>();
        ClassLoader classLoader = MBGUtil.class.getClassLoader();
        //getResource()方法会去classpath下找这个文件，获取到url resource,
        //得到这个资源后，调用url.getFile获取到 文件 的绝对路径
        URL url = classLoader.getResource("generatorConfig.xml");
        assert url != null;
        File configFile = new File(url.getFile());//默认会从calsspath下加载文件
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
