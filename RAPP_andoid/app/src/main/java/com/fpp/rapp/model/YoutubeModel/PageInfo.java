package com.fpp.rapp.model.YoutubeModel;

public class PageInfo {
    String totalResults;
    String resultsPerPage;

    public PageInfo(String totalResults, String resultsPerPage) {
        this.totalResults = totalResults;
        this.resultsPerPage = resultsPerPage;

    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(String resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
