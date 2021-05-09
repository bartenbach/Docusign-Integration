package edu.unomaha.docusign.docusign;

public class GetEnvelopeResponse {

    private int resultSetSize;
    private int totalSetSize;
    private String nextUri;
    private String previousUri;


    public int getResultSetSize() {
        return resultSetSize;
    }

    public void setResultSetSize(int resultSetSize) {
        this.resultSetSize = resultSetSize;
    }

    public int getTotalSetSize() {
        return totalSetSize;
    }

    public void setTotalSetSize(int totalSetSize) {
        this.totalSetSize = totalSetSize;
    }

    public String getNextUri() {
        return nextUri;
    }

    public void setNextUri(String nextUri) {
        this.nextUri = nextUri;
    }

    public String getPreviousUri() {
        return previousUri;
    }

    public void setPreviousUri(String previousUri) {
        this.previousUri = previousUri;
    }

}
