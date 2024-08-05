import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns and Principles Used:
 * 1. Encapsulation: Private fields with public methods to manage the player's hand.
 * 2. SRP: Handles player-specific actions such as drawing cards.
 */
public class Player {
    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {  //Encapsulation
        return this.name;
    }

    public List<Card> getHand() {
        return new ArrayList<>(this.hand); // Encapsulation: Return a copy of the hand to maintain encapsulation
    }

    public void drawCard(Deck deck) {
        Card card = deck.drawCard();
        if (card != null) {
            hand.add(card);
            System.out.println(name + " drew " + card); // SRP: Output card draw action
        } else {
            System.out.println(name + " could not draw a card."); // SRP: Output failure to draw card
        }
    }

    public void showHand() {
        System.out.println(name + "'s hand: " + hand);  // SRP: Output the player's hand
    }
}
