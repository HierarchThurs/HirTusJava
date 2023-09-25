package out;

import java.util.*;

/**
 * CRAPS又称花旗骰，是美国拉斯维加斯非常受欢迎的一种的桌上赌博游戏。
 * 该游戏使用两粒骰子，玩家通过摇两粒骰子获得点数进行游戏。
 * 简化后的规则是：玩家第一次摇骰子如果摇出了7点或11点，玩家胜；
 * 玩家第一次如果摇出2点、3点或12点，庄家胜；
 * 玩家如果摇出其他点数则玩家继续摇骰子，如果玩家摇出了7点，庄家胜；
 * 如果玩家摇出了第一次摇的点数，玩家胜；其他点数玩家继续摇骰子，直到分出胜负。
 */
public class Gaming {
    public static void main(String[] args) {
        System.out.println("Gaming");
        Game game = new Game();
        game.begin();
        System.out.println("Game Over");
    }
}

class Game {
    private int dice1;
    private int dice2;
    private double wager;
    private double money = 2000;
    private int sum;

    Game() {
    }

    public void begin() {
        Scanner input = new Scanner(System.in);
        while (true) {
            if (money <= 0) { // 判断是否有钱
                System.out.println("You have no money");
                break;
            }
            System.out.println("Do you play? 1 is play and 0 is end.");
            int isPlay = input.nextInt();
            if (isPlay == 1) {

                wager = makeBet();
                playGame();
            } else if (isPlay == 0) {
                System.out.println("Bye");
                break;
            } else {
                System.out.println("Invalid input");
                continue;
            }
        }
    }

    public void playGame() {
        // 一次游戏;
        Random rand = new Random();
        dice1 = rand.nextInt(6) + 1;
        dice2 = rand.nextInt(6) + 1;
        int dice = dice1 + dice2; // 摇骰子
        sum += 1;
        System.out.println("No." + sum + " , you rolled " + dice);
        if (dice == 7 || dice == 11) {
            money += wager;
            System.out.println("Player win!");
        } else if (dice == 2 || dice == 3 || dice == 12) {
            money -= wager;
            System.out.println("Player lose!");
        } else {
            while (true) {
                dice1 = rand.nextInt(6) + 1;
                dice2 = rand.nextInt(6) + 1;
                int diceAgain = dice1 + dice2;
                sum += 1;
                System.out.println("No." + sum + " , you rolled " + diceAgain);
                if (diceAgain == 7) { // 庄家胜
                    money -= wager;
                    System.out.println("Player lose!");
                    break;
                } else if (diceAgain == dice) { // 如果和第一次的相同
                    money += wager;
                    System.out.println("Player win!");
                    break;
                }
            }
        }
        // 打印余额
        System.out.println("You have " + money + " dollars left.");
    }

    public double makeBet() {
        Scanner inputWager = new Scanner(System.in);
        boolean suc = false;
        double input = 0.0;
        while (!suc) {
            try {
                System.out.println("Please input wager:");
                input = inputWager.nextDouble();
                suc = true;
            } catch (Exception e) {
                System.out.println("Please input double number");
                inputWager.nextLine(); // 清除缓存区
            }
        }
        return input;
    }
}
