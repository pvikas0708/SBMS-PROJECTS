package in.vikasit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource ds=null; // we don't want to create connection every time . just one time in start
	
	public static Connection getConnection() throws Exception {

		if(ds==null) // it will create connection pool only one time when getConnection will be called ds=null value checked if not null condition will be satisfied 
		{
		
			FileInputStream fis=new FileInputStream(new File("C:\\Users\\user\\eclipse-workspace\\A_Vikas_JavaProgramming\\servlet\\05-Book-Project-Servlet-DAO\\dbconfig.properties"));
			
			Properties p=new Properties();
			p.load(fis);
			
			String url = p.getProperty("db.url");
			String user = p.getProperty("db.username");
			String password = p.getProperty("db.password");
			String driver=p.getProperty("db.driver");
			
			HikariConfig config=new HikariConfig();
			config.setJdbcUrl(url);
			config.setUsername(user);
			config.setPassword(password);
			config.setDriverClassName(driver);
			
			ds=new HikariDataSource(config);
			
		}
		
		return ds.getConnection();
		
	}
}
