package edu.unomaha.docusign;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
public class DSConfiguration {
    
    @Value("https://github.com/docusign/code-examples-java/blob/master/src/main/java/")
    private String exampleUrl;
    
    @Value("")
    private String documentationPath;

    @Value("55788584-a2f9-4396-8858-69844d1590d5")
    private String targetAccountId;

    @Value("http://localhost:8080")
    private String appUrl;

    @Value("ESIGNATURE")
    private String apiName;

    @Value("https://demo.docusign.net")
    private String basePath;

    @Value("blakebartenbach@gmail.com")
    private String signerEmail;

    @Value("Herbert Kerschmucketty")
    private String signerName;

    public String getDsReturnUrl() {
        return appUrl + "/ds-return";
    }

    public String getDsPingUrl() {
        return appUrl + "/";
    }

}
