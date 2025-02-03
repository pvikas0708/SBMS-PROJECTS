package in.vikas.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



public class ConnectionFactory {

	private static DataSource ds = null;

	public static Connection getConnection() throws Exception {

		if (ds == null) {

			FileInputStream fis = new FileInputStream(new File("C:\\Users\\user\\eclipse-workspace\\A_Vikas_JavaProgramming\\servlet\\08-Book-Project-Servlet-DTO-DAO\\dbconfig.properties"));

			Properties p = new Properties();
			p.load(fis);

			String uname = p.getProperty("db.username");
			String password = p.getProperty("db.password");
			String url = p.getProperty("db.url");
			String driver=p.getProperty("db.driver");

			HikariConfig config = new HikariConfig();
			config.setUsername(uname);
			config.setPassword(password);
			config.setJdbcUrl(url);
			config.setDriverClassName(driver);

			HikariDataSource ds = new HikariDataSource(config);

			ds=new HikariDataSource(config);
		}

		return ds.getConnection();

	}
}
