package lesson6.battleunit;

public class Fight {
    BattleUnit unit1;
    BattleUnit unit2;

    public Fight(BattleUnit unit1, BattleUnit unit2){
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    public void fight(){
        while (unit1.isAllive() && unit2.isAllive()){
            unit1.attack(unit2);
            if (unit2.isAllive()){
                unit2.attack(unit1);
            }
        }
    }

    public String fightResult(){
        return "Health юнита 1 = " + unit1.getHealth() + " " +
                 "Health юнита 2 = " + unit2.getHealth();

    }


}
