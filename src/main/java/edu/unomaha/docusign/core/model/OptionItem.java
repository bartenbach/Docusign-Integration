package edu.unomaha.docusign.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OptionItem {
    private String text;
    private String documentId;
}
