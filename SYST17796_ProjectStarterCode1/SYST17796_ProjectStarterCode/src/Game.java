import java.util.List;

/**
 * Design Patterns and Principles Used:
 * 1. SRP: Manages game operations like starting, ending, and player turns.
 * 2. DIP: Depends on abstractions (`Deck`, `Player`).
 * 3. DRY: Avoids redundancy with reusable methods.
 */

// DIP : Dependency Inversion Principle
public class Game {
    private final List<Player> players;
    private final Deck drawPile;
    private final Deck discardPile;
    private int currentPlayerIndex; // Encapsulation: Private state for tracking the current player

    public Game(List<Player> players, Deck drawPile, Deck discardPile) {
        this.players = players;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.currentPlayerIndex = 0;
    }

    //DRY principle is used
    public void startGame() {
        System.out.println("Game has started!");
        players.forEach(player -> dealInitialCards(player, 7));
        players.forEach(Player::showHand); // Show each player's hand after dealing
    }

    private void dealInitialCards(Player player, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            player.drawCard(drawPile); // DRY: Reusable method for dealing cards to a player
        }
    }
    
    //DRY principle is used
    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        System.out.println("It's " + players.get(currentPlayerIndex).getName() + "'s turn.");
    }

    public void declareUno() {
        Player currentPlayer = players.get(currentPlayerIndex);
        if (currentPlayer.getHand().size() == 1) {
            System.out.println(currentPlayer.getName() + " declares UNO!");
        } else {
            System.out.println(currentPlayer.getName() + " cannot declare UNO.");
        }
    }

    public void endGame() {
        Player winner = players.stream()
            .min((p1, p2) -> Integer.compare(p1.getHand().size(), p2.getHand().size()))
            .orElse(null);
        
        if (winner != null) {
            System.out.println("The game is over! The winner is " + winner.getName() + " with " + winner.getHand().size() + " cards left.");
        } else {
            System.out.println("The game is over! No winner could be determined.");
        }
    }

    public static void main(String[] args) {
        Deck drawPile = Deck.getInstance(); // Singleton Pattern: Get the singleton instance of Deck
        drawPile.initializeUnoDeck();  //DRY
        drawPile.shuffle();  //DRY

        Deck discardPile = new Deck();

        Player player1 = new Player("Avleen");
        Player player2 = new Player("Muskan");

        Game game = new Game(List.of(player1, player2), drawPile, discardPile);
        game.startGame();
        game.nextPlayer();
        game.declareUno();
        game.nextPlayer();
        game.endGame();
    }
}
