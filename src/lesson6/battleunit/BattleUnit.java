package lesson6.battleunit;

abstract public class BattleUnit implements ISpeakUnit{
    protected int health;
    protected int attackScore;

    public BattleUnit(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    public boolean isAllive(){
        return health > 0;
    }

    abstract public void attack(BattleUnit enemy);

}
