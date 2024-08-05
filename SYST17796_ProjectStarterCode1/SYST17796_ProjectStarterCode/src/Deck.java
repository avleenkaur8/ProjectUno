import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Design Patterns and Principles Used:
 * 1. Singleton Pattern: Ensures only one instance of Deck.
 * 2. Encapsulation: Private fields with methods to manage the deck.
 * 3. DRY: Reusable methods for deck operations.
 */
public class Deck {
    private static Deck instance; // Singleton Pattern: Static instance variable
    private List<Card> cards;   // Encapsulation: Private field to store cards


    Deck() {
        cards = new LinkedList<>();
    }
    /**
     * Provides access to the single instance of Deck.
     * 
     * @return The singleton instance of Deck.
     */
    public static Deck getInstance() {
        if (instance == null) {
            instance = new Deck(); 
        }
        return instance;
    }

    public void initializeUnoDeck() {
        // Example initialization for a simple deck with a few cards
        // You should add all necessary UNO cards here
        cards.clear(); // DRY: Clear any existing cards before adding new ones
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};

        for (String color : colors) {
            for (String value : values) {
                cards.add(new Card.CardBuilder().setColor(color).setValue(value).build());
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1); // DRY: Draw the top card from the deck
    }

    public void addCard(Card card) {
        cards.add(card); // DRY: Add a new card to the deck
    }
}
