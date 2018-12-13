package patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency  {
    private List<Listener> listeners = new ArrayList<>(); // хранение списка слушателей

    public void addListener(Listener listener){  // метод добавляет подписчиков
        listeners.add(listener);
    }

    public void deleteListener(Listener listener){  // метод удаления подписчиков
        listeners.remove(listener);
    }

    public void newMessage(String mess){  // сообщение,которое должны получить подписчики
        System.out.println("Message " + mess);
        notifyListeners(mess);
    }
    private void notifyListeners(String mess){
        for (Listener listener: listeners){
            listener.publish(mess);  // у каждого слушателя вызывается publish в который передается сообщение
        }
    }

    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        newsAgency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("listener 1:" + str);
            }
        });

        newsAgency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("listener 2:" + str);
            }
        });

        newsAgency.newMessage("some changes");

    }

}
