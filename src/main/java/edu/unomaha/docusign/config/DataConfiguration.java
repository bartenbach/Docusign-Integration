package edu.unomaha.docusign.config;

import edu.unomaha.docusign.project.ejb.ProjectServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {

    @Bean
    public ProjectServiceImpl getDocumentServiceImpl() {
        return new ProjectServiceImpl();
    }

}
