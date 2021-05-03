package edu.unomaha.docusign.common;

public enum ApiIndex {
    ESIGNATURE("/components/esignature/index", "/restapi");
    private final String indexPath;
    private final String baseUrlSuffix;

    ApiIndex(final String indexPath, final String baseUrlSuffix) {
        this.indexPath = indexPath;
        this.baseUrlSuffix = baseUrlSuffix;
    }

    public String getBaseUrlSuffix() {
        return baseUrlSuffix;
    }

    @Override
    public String toString() {
        return this.indexPath;
    }
}
