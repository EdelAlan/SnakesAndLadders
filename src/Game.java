import java.util.HashMap;
import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;
    private int p1roll;
    private int p2roll;
    private HashMap<Integer, Integer> sal = new HashMap<>();

    public Game (Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }



    public void startGame() throws InterruptedException {
        System.out.println();

        sal.put(25, 35);
        sal.put(50, 60);
        sal.put(75, 85);
        sal.put(30, 20);
        sal.put(45, 35);
        sal.put(99, 0);

        while (true) {

        //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– Player 1
            makeMove(player1);
            if (player1.getPosition() >= 100 ) {
                System.out.println(player1.getName() + " is winner!");
                break;
            }

        //–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––– Player 2
            makeMove(player2);
            if (player2.getPosition() >= 100 ) {
                System.out.println(player2.getName() + " is winner!");
                break;
            }

        }
    }

    private void makeMove(Player player) throws InterruptedException {
        int diceRoll = throwDice();
        int currentPos = player.getPosition();

        int p = currentPos + diceRoll;
        Integer value = sal.get(p);

        if (value != null) {
            player.setPosition(value);
            System.out.println(player.getName() + " rolled " + diceRoll + ", and found something, position from " + p + " to " + player.getPosition());
        } else {
            player.setPosition(p);
            System.out.println(player.getName() + " rolled " + diceRoll + ", position from " +currentPos + " to " + player.getPosition());
        }
        Thread.sleep(250);
    }

    private int throwDice() {
        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        return dice1 + dice2;
    }
}
