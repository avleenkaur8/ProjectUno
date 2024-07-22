import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> hand;
    private String name;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }
    
    /**
    * 
    * @param deck
    */
    //Draw a card from the deck
    public void drawCard(Deck deck) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            hand.add(drawnCard);
            System.out.println(name + " drew a " + drawnCard);
        }
    }
    
    /**
    * 
    * @param card
     * @return 
    */
    //Play a card from player hand
    public boolean playCard(Card card) {
        if (hand.contains(card)) {
            hand.remove(card);
            System.out.println(name + " played a " + card);
            return true;
        } else {
            System.out.println(name + " doesn't have " + card + " in hand.");
            return false;
        }
    }

    // Shows the player's hand
    public void showHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public String getName() {
        return name;
    }

    //Testing the Player class
    public static void main(String[] args) {
        // Create a deck and a player for testing
        Deck deck = new Deck();
        deck.initializeUnoDeck();
        deck.shuffle();

        Player player = new Player("Avleen");

        player.drawCard(deck);
        player.drawCard(deck);
        player.showHand();

        if (!player.getHand().isEmpty()) {
            player.playCard(player.getHand().get(0));
        }
        player.showHand();
    }

    public List<Card> getHand() {
        return hand;
    }
}