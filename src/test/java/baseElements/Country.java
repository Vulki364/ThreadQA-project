package baseElements;

public enum Country {
    RUSSIA("Россия"),
    USA("США"),
    GERMANY("Германия"),
    FRANCE("Франция");

    private final String value;

    Country(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}