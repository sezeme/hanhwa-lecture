package com.sezeme.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "swcamp";
    private static String PASSWORD = "swcamp";

    public static void main(String[] args) {
        // JdbcTransactionFactory : 수동 커밋, ManagesTransactionFactory : 자동 커밋
        Environment environment = new Environment(
                "dev", // 환경 정보 이름
                new JdbcTransactionFactory(), // 트랜잭션 매니저 종류 (JDBC or MANAGE)
                new PooledDataSource(
                    DRIVER, URL, USER, PASSWORD
                ) // Connection Pool 사용 유무 (Pooled or UnPooled)
        );

        // 생성한 환경 설정 정보로 Mybatis 설정 객체 생성
        Configuration configuration = new Configuration(environment);

        // 설정 객체에 Mapper(수행하고 싶은 sql 구문 담겨있음) 등록
        configuration.addMapper(Mapper.class);

        // SqlSessionFactoryBuilder ; SqlSessionFactory 타입의 하위 구현체 객체를 생성하기 위한 빌더 클래스
        // SqlSessionFactory : !! SqlSession 객체 !! 생성을 위한 팩토리 역할의 인터페이스
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        // openSession : SqlSession 타입의 인터페이스를 반환하는 메소드
        // -false : DML 수행 후 auto commit 옵션을 false로 지정
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // getMapper : Configuration에 등록 된 Mapper의 구현체 반환
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        java.util.Date now = mapper.selectDate();
        System.out.println("now = " + now);

        // SqlSession 반납
        sqlSession.close();


    }
}
