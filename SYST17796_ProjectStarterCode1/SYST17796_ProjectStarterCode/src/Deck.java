import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    //Shuffles deck
    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Deck has been shuffled.");
    }

    //Draw a card from top of the deck
    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            System.out.println("Deck is empty. Can't draw card.");
            return null;
        }
    }

    //Initialize a standard Uno deck
    public void initializeUnoDeck() {
        String[] colors = {"Red", "Yellow", "Green", "Blue"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};

        for (String color : colors) {
            for (String value : values) {
                cards.add(new Card(color, value));
                if (!value.equals("0")) {
                    cards.add(new Card(color, value));
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new Card("Wild", "Wild"));
            cards.add(new Card("Wild", "Wild Draw Four"));
        }

        System.out.println("Initialized Uno deck with " + cards.size() + " cards.");
    }

    //Testing the Deck class
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.initializeUnoDeck();
        deck.shuffle();

        for (int i = 0; i < 5; i++) {
            Card drawnCard = deck.drawCard();
            if (drawnCard != null) {
                System.out.println("Drew card: " + drawnCard);
            }
        }
    }
}