package lesson5.battleunit;

public class BattleUnit {
    protected int health;
    protected int attackScore;

    public BattleUnit(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

    public boolean isAllive(){
        return health > 0;
    }

    protected void attack(BattleUnit enemy){
        enemy.health -= this.attackScore;
    }

}
