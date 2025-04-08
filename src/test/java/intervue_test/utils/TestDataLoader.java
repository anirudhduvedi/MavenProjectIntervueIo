package intervue_test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataLoader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/testData.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
