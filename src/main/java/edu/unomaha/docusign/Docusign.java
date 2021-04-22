package edu.unomaha.docusign;

public class Docusign extends ApiBinding {

    private static final String API_BASE_URL = "";

    public Docusign(String accessToken) {
        super(accessToken);
        System.out.println("ACCESS TOKEN ACQUIRED: " + accessToken);
    }

    public String getDocument() {
        return "blah";
    }
}
