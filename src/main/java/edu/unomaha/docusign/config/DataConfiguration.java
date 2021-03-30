package edu.unomaha.docusign.config;

import edu.unomaha.docusign.document.ejb.DocumentServiceImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataConfiguration {

    @Bean
    public DocumentServiceImpl getDocumentServiceImpl() {
        return new DocumentServiceImpl();
    }
}
