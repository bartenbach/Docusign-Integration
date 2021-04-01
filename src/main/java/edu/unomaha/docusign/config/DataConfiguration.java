package edu.unomaha.docusign.config;

import edu.unomaha.docusign.document.ejb.DocumentServiceImpl;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class DataConfiguration {

    @Bean
    public DocumentServiceImpl getDocumentServiceImpl() {
        return new DocumentServiceImpl();
    }

}
