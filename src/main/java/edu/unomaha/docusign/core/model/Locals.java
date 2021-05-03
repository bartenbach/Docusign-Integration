package edu.unomaha.docusign.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import edu.unomaha.docusign.docusign.DSConfiguration;


@Data
@AllArgsConstructor
public class Locals {
    private DSConfiguration dsConfig;
    private Session session;
    private User user;
    private String messages;
}
