package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    public static Properties init_prop() {
        Properties environmentProps = new Properties();
        
        // auto-closing the stream
        try (FileInputStream fileStream = new FileInputStream("src/test/resources/config/config.properties")) {
            environmentProps.load(fileStream);
        } catch (IOException ex) {
            System.err.println("FATAL: Configuration file is missing or unreadable!");
            ex.printStackTrace();
        }
        
        return environmentProps;
    }
}