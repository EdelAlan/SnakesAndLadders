import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;
    private int p1roll;
    private int p2roll;
    private final int BOARD = 100;
    private int dice;

    public Game (Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }



    public void startGame() throws InterruptedException {
        System.out.println();


        while (true) {
            int currentPos1 = player1.getPosition();
            int currentPos2 = player2.getPosition();

            p1roll = throwDice();
            player1.setPosition(player1.getPosition() + p1roll);
            System.out.println(player1.getName() + " rolled " + p1roll + ", position from " +currentPos1 + " to " + player1.getPosition());
            Thread.sleep(250);

            if (player1.getPosition() >= 100 ) {
                System.out.println(player1.getName() + " is winner!");
                break;
            }

            p2roll = throwDice();
            player2.setPosition(player2.getPosition() + p2roll);
            System.out.println(player2.getName() + " rolled " + p2roll + ", position from " +currentPos2 + " to " + player2.getPosition());
            Thread.sleep(250);

            if (player2.getPosition() >= 100 ) {
                System.out.println(player2.getName() + " is winner!");
                break;
            }
        }



    }

    private int throwDice() {
        Random random = new Random();
        dice = random.nextInt(6) + 1;
        return dice;
    }
}
