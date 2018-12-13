package lesson12;

import java.util.HashMap;
import java.util.Map;

public class Task {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("al", 100);
        map.put("ad", 500);
        map.put("am", 700);
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            if (entry.getValue() < 200){
                map.remove(entry.getKey());
            }
            System.out.println(map);
        }
    }
}
