package edu.unomaha.docusign.config;

import edu.unomaha.docusign.document.ejb.DocumentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {

    @Bean
    public DocumentServiceImpl getDocumentServiceImpl() {
        return new DocumentServiceImpl();
    }

}
