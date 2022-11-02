package automation.selenide.model.enams;

public enum Color {

    BLUE_HIGHLIGHTED_FREQUENT_SEARCH_ITEM("rgba(118, 205, 216, 1)");

    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}