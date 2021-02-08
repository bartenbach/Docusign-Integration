package edu.unomaha.docusign.ejb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceManager {

    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:h2:file:./h2/data;DATABASE_TO_UPPER=false");
        return dataSource;
    }

    @Bean
    public DocumentServiceImpl getDocumentServiceImpl() {
        return new DocumentServiceImpl();
    }
}
