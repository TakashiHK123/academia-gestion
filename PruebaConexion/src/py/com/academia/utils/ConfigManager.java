/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.academia.utils;

/**
 *
 * @author takashi
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    public static void main(String[] args) {
        String username = new ConfigManager().getPropValues("db_alumnos");
        System.out.println("KeyConfig:" + username);
    }

    private static Properties prop;

    private void init() throws IOException {
        prop = new Properties();
        String propFileName = System.getProperty("user.dir")
                .concat(File.separator)
                .concat("config.properties");
        
        try (InputStream inputStream =
                     new FileInputStream(propFileName)){
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            // get the property value and print it out
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public String getPropValues(String key) {
        try {
            if (prop == null) {
                init();
            }
            return prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
