public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(new Player("Alan"), new Player("Max"));
        game.startGame();
    }

}

