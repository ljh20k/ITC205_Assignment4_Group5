import java.util.List;

public class Test {

    Player player = new Player("Fred", 100);

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

}
