//package com.mama.union;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories(basePackages = "com.mama.union", entityManagerFactoryRef = "managerFactory", transactionManagerRef = "transactionManager")
//public class DataSourceConfig {
//
//	public final DataSource ds;
//
//    public DataSourceConfig(DataSource ds) {
//        this.ds = ds;
//    }
//
//    @Primary
//	@Bean(name = "managerFactory")
//	public LocalContainerEntityManagerFactoryBean managerFactory(EntityManagerFactoryBuilder builder) {
//		return builder.dataSource(ds).packages("com.mama.union").build();
//	}
//
//	@Primary
//	@Bean
//	public PlatformTransactionManager transactionManager(@Qualifier("managerFactory") LocalContainerEntityManagerFactoryBean memberEntityManagerFactory) {
//		return new JpaTransactionManager(memberEntityManagerFactory.getObject());
//	}
//
//}