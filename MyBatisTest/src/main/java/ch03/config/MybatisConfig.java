package ch03.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.session.Configuration;

//mybatis-config-2대체
public class MybatisConfig {
	 public SqlSessionFactory getSqlSessionFactory() {
	        
	        PooledDataSource dataSource = new PooledDataSource();
	        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis_basic");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        Configuration configuration = new Configuration();
	        configuration.setEnvironment(new org.apache.ibatis.mapping.Environment("development",
	                new JdbcTransactionFactory(), dataSource));
	        configuration.addMapper(ch03.dao.BookDao.class);        
	        
	        return new SqlSessionFactoryBuilder().build(configuration);
	    }
}
