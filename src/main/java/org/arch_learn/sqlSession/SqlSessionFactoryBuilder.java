package org.arch_learn.sqlSession;

import org.arch_learn.config.XmlConfigBuilder;
import org.arch_learn.po.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream) throws DocumentException, PropertyVetoException {
        //1.使用dom4j解析配置文件，将解析出来内容封装到Configuration中。
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(inputStream);
        //2.创建SqlSessionFactory对象。工厂类，主要作用是生产sqlSession。
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        return defaultSqlSessionFactory;
    }
}
