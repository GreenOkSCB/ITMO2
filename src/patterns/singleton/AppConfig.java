package patterns.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private static final File CONFIG = new File("app.properties");
    private static AppConfig instance;
    private final Properties properties;

    private AppConfig(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream(CONFIG));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static AppConfig getConfig(){  // метод, который будет возвращать объекты
        if (instance == null){  // данный if сработает один раз
            instance = new AppConfig();  // создание единственного экземпляра
        }
        return instance;    // возвращаем объект instance
    }

    public String getParam(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        AppConfig config = AppConfig.getConfig();
        System.out.println(config.getParam("db.login"));
    }
}
