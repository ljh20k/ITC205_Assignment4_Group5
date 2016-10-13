import java.util.List;

public class Test {

    public void testRandomDiceSet() {
        System.out.println("Start Testing: Print 5 sets of random dice set");
        for (int i = 1; i < 6; i++) {
            Dice d1 = new Dice();
            Dice d2 = new Dice();
            Dice d3 = new Dice();

            Game game = new Game(d1, d2, d3);

            List<DiceValue> cdv = game.getDiceValues();

            System.out.printf("SET " + i + ": " + "Rolled %s, %s, %s\n",
                    cdv.get(0), cdv.get(1), cdv.get(2));
        }
    }

    public void testReceiveWinnings() {
        System.out.println("Start Testing: Print Balance when Player wins");
        Player player = new Player("Fred", 100);
        int bet = 5;

        while (true) {
            //setup
            Dice d1 = new Dice();
            Dice d2 = new Dice();
            Dice d3 = new Dice();
            Game game = new Game(d1, d2, d3);
            List<DiceValue> cdv = game.getDiceValues();
            DiceValue pick = DiceValue.getRandom();

            //run game
            int winnings = game.playRound(player, pick, bet);

            System.out.printf("Rolled %s, %s, %s\n",
                    cdv.get(0), cdv.get(1), cdv.get(2));

            if (winnings > 0) {
                System.out.printf("%s won %d, balance now %d\n\n",
                        player.getName(), winnings, player.getBalance());
                break;
            } else {
                System.out.printf("%s lost, balance now %d\n\n",
                        player.getName(), player.getBalance());
            }
        }
    }

    public void testGameEndsAtLimit() {
        System.out.println("Start Testing: Test Game Ends When Reached Limit");
        Player player = new Player("Fred", 10);
        player.setLimit(0);
        int bet = 5;
        System.out.println(player.getName() + "'s pre-set balance: " + player.getBalance());
        System.out.println(player.getName() + "'s pre-set limit: " + player.getLimit() + "\n");

        while (player.balanceExceedsLimitBy(bet)) {
            //setup
            Dice d1 = new Dice();
            Dice d2 = new Dice();
            Dice d3 = new Dice();
            Game game = new Game(d1, d2, d3);
            List<DiceValue> cdv = game.getDiceValues();
            DiceValue pick = DiceValue.getRandom();

            //run game
            int winnings = game.playRound(player, pick, bet);

            System.out.printf("Rolled %s, %s, %s\n",
                    cdv.get(0), cdv.get(1), cdv.get(2));

            if (winnings > 0) {
                System.out.printf("%s won %d, balance now %d\n\n",
                        player.getName(), winnings, player.getBalance());
            } else {
                System.out.printf("%s lost, balance now %d\n\n",
                        player.getName(), player.getBalance());
            }
        }
    }
}
