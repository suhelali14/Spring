package com.infosys.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.infosys")
@Component
public class JdbcConfig {
	@Bean
	public BasicDataSource dbconn() {
		
		BasicDataSource dbs=new BasicDataSource();
		dbs.setDriverClassName("org.postgresql.Driver");
		dbs.setUrl("jdbc:postgresql://localhost:5432/Spring");
		dbs.setUsername("postgres");
		dbs.setPassword("Suhel@786");
		return dbs;
		
	}
	
	@Bean
	public JdbcTemplate myjdbcTemplate(BasicDataSource ds) {
		return new JdbcTemplate(ds);
	}
}
