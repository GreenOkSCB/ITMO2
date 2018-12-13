package lesson6.battleunit;

public interface ISpeakUnit {

    void say(String text);
    void sing(String song);

    default void greeting(){
        System.out.println("Hello");
    }


}
