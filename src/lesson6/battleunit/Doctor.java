package lesson6.battleunit;

public class Doctor extends BattleUnit implements ISpeakUnit{
    public Doctor(int health, int attackScore) {
        super(health, attackScore);
    }

    @Override
    public void attack(BattleUnit unit) {
        unit.health += attackScore;
    }

    @Override
    public void say(String text) {

    }

    @Override
    public void sing(String song) {

    }
}





