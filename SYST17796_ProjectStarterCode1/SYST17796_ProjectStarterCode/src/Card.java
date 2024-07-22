public class Card {

    private String color;
    private String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    // Getter method for color
    public String getColor() {
        return this.color;
    }

    /**
    * 
    * @param color
    */
    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return this.value;
    }

    /**
    * 
    * @param value
    */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " of " + color;
    }
}