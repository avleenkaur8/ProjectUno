import java.util.List;

public class Game {

    private List<Player> players;
    private Deck drawPile;
    private Deck discardPile;
    private int currentPlayerIndex;

    public Game(List<Player> players, Deck drawPile, Deck discardPile) {
        this.players = players;
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.currentPlayerIndex = 0;
    }
    //Starting the game
    public void startGame() {
        System.out.println("Game has started!");
        for (Player player : players) {
            for (int i = 0; i < 7; i++) { // Each player draws 7 cards to start the game
                player.drawCard(drawPile);
            }
        }
    }

    // Moving to next player
    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        System.out.println("Player playing now: " + players.get(currentPlayerIndex).getName());
    }

    //Player to declare UNO
    /**
     * 
     * @param playerIndex
     */
    public void declareUno(int playerIndex) {
        if (playerIndex >= 0 && playerIndex < players.size()) {
            System.out.println(players.get(playerIndex).getName() + " has declared UNO!");
        } else {
            throw new IllegalArgumentException("Invalid player index");
        }
    }

    //End the game
    public void endGame() {
        System.out.println("Game ended!");
    }

    // Main method for testing the Game class
    public static void main(String[] args) {
        // Creating players, draw pile, and discard pile for testing
        Player player1 = new Player("Avleen");
        Player player2 = new Player("Muskan");
        List<Player> players = List.of(player1, player2);

        Deck drawPile = new Deck();
        drawPile.initializeUnoDeck();
        drawPile.shuffle();

        Deck discardPile = new Deck();

        // Create and start the game here
        Game game = new Game(players, drawPile, discardPile);
        game.startGame();
        game.nextPlayer();
        game.declareUno(1);
        game.endGame();
    }
}