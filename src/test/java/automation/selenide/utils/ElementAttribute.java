package automation.selenide.utils;

public enum ElementAttribute {

    CURSOR("cursor"),
    COLOR("color");

    private String attribute;

    ElementAttribute (String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

}
