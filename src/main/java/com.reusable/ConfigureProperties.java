package com.reusable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureProperties {
    //Singleton instance which holds all configuration

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(IOException exp) {
            exp.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

}
