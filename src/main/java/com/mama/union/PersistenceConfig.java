//package com.mama.union;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.ValidationMode;
//import java.sql.SQLException;
//
//public class PersistenceConfig {
//    @Bean
//    public EntityManagerFactory entityManagerFactory() throws SQLException {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(false);
//        vendorAdapter.setDatabase(Database.POSTGRESQL);
//        vendorAdapter.setShowSql(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        String[] packagesToScan = new String[] {"com.mama.union"};
//        factory.setPackagesToScan(packagesToScan);
//        factory.setDataSource(this.dataSource());
//        factory.setValidationMode(ValidationMode.NONE); // <--------
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }
//}