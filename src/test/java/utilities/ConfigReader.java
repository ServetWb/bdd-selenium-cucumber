package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
        This class has two main responsibilities:

        1- Read the key-value pairs from the configuration.properties file.
           To ensure this reading happens as soon as the class is used,
           we place the reading operation inside a static block.

           When the static block is executed,
           it reads all the key-value pairs from the configuration.properties file
           and loads them into the class-level "properties" object.

        2- Once all the key-value pairs are loaded into the properties object,
           the getProperty(String key) method is used to fetch
           the value corresponding to a given key
           and return it to the calling test method.
     */

    static Properties properties; // As soon as the class is loaded,
    // all key-value pairs from configuration.properties are loaded

    static {
        String filePath = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis); // Loads all data read by fis into the properties object
        } catch (IOException e) {
            System.out.println("Could not read the properties file");
        }
    }

    // Returns the value corresponding to the given key from the properties object
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}