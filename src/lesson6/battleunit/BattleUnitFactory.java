package lesson6.battleunit;

public class BattleUnitFactory {
    public BattleUnit create(String userChoise) {
        if (userChoise.equals("Knight")) {
           return new Knight(100, 20);
        }
        if (userChoise.equals("sprmn")) {
             return new Spearman(70, 40);
        }
            return new Doctor(50, 10);

    }
}