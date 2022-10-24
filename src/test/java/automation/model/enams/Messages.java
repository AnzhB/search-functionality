package automation.model.enams;

public enum Messages {

    SEARCH_RETURNED_NO_RESULTS("Sorry, but your search returned no results. Please try another query.");

    private String value;

    Messages(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

