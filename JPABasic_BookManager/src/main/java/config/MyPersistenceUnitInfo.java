package config;

import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

public class MyPersistenceUnitInfo implements PersistenceUnitInfo{

	   @Override
	    public String getPersistenceUnitName() {
	        return "my-pu";
	    }
	    @Override
	    public String getPersistenceProviderClassName() {
	        return "org.hibernate.jpa.HibernatePersistenceProvider";
	    }
	    @Override
	    public PersistenceUnitTransactionType getTransactionType() {
	        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
	    }
	    //////////////////////////////// DataSource  설정
	    @Override
	    public DataSource getJtaDataSource() {
	        HikariDataSource dataSource = new HikariDataSource(); // Connection Pool 구현체
	        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jpa_basic_madang");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        return dataSource;
	    }
	    @Override
	    public DataSource getNonJtaDataSource() {
	    	return null;
	    }
		
 
		@Override
		public List<String> getMappingFileNames() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<URL> getJarFileUrls() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public URL getPersistenceUnitRootUrl() {
			// TODO Auto-generated method stub
			return null;
		}
		/////////////////////// jpa 대상이 되는 클래스 리스트
		@Override
		public List<String> getManagedClassNames() {
			// TODO Auto-generated method stub
			return List.of("app.book.entity.Book");
			
		}
		@Override
		public boolean excludeUnlistedClasses() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public SharedCacheMode getSharedCacheMode() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ValidationMode getValidationMode() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Properties getProperties() {
		    Properties props = new Properties();
		    props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); // 또는 MySQLDialect
		    props.setProperty("hibernate.hbm2ddl.auto", "update");
		    props.setProperty("hibernate.show_sql", "true");
		    return props;
		}
		@Override
		public String getPersistenceXMLSchemaVersion() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ClassLoader getClassLoader() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void addTransformer(ClassTransformer transformer) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public ClassLoader getNewTempClassLoader() {
			// TODO Auto-generated method stub
			return null;
		}
	

}
