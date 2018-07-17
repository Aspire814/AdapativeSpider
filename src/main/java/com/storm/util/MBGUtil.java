package com.storm.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
 
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
 
public class MBGUtil {
    @Test
    public void testMbg() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ClassLoader classLoader = getClass().getClassLoader();
        //getResource()方法会去classpath下找这个文件，获取到url resource, 
        //得到这个资源后，调用url.getFile获取到 文件 的绝对路径
        URL url = classLoader.getResource("generatorConfig.xml");
        File configFile = new File(url.getFile());//默认会从calsspath下加载文件
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
