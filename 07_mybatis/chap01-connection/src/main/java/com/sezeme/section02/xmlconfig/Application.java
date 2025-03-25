package com.sezeme.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(false);
            // selectOne : 조회 결과가 1행인 경우 사용하는 메소드
            // mapper.xml 파일의 namespace 와 select 태그의 id를 통해 수행 구문을 찾아옴
            java.util.Date now = sqlSession.selectOne("mapper.selectDate");
            System.out.println("now : " + now);
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
