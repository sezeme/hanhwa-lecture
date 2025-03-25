package com.sezeme.section02.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USERNAME = "swcamp";
    private static String PASSWORD = "swcamp";
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        if(sqlSessionFactory == null) {
            Environment environment = new Environment(
                    "development",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD)
            );
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(MenuMapper.class);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }
        return sqlSessionFactory.openSession(false);
    }
}
