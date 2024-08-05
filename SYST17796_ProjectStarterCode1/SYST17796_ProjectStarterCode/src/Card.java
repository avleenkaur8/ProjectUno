/**
 * Design Patterns and Principles Used:
 * 1. Immutable Object: The Card class is designed to be immutable once created.
 * 2. Encapsulation: Private fields with public getter methods.
 * 3. Builder Pattern: Provides a flexible way to construct Card objects.
 */

// Immutable Object: 'color' and 'value' are final to ensure immutability
public final class Card {
    private final String color;
    private final String value;

    // Immutable Object: 'color' and 'value' are set once during construction
    private Card(CardBuilder builder) {
        this.color = builder.color;
        this.value = builder.value;
    }
     // Encapsulation: 'color' is private
    public String getColor() {
        return this.color;
    }

    // Encapsulation: 'value' is private
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return value + " of " + color;
    }

    /**
     * Builder class for constructing Card objects.
     * 
     * Design Patterns and Principles Used:
     * Builder Pattern: Provides a flexible way to construct Card objects.
     */
    public static class CardBuilder {
        private String color;
        private String value;

        public CardBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CardBuilder setValue(String value) {
            this.value = value;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }
}
