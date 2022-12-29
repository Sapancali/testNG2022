package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // Bu class configuration.properties file/dosyadaki bilgileri okumak içindir

    //Properties object oluşturduk
    private static Properties properties;

    static {
        //properties file path'i
        String path= "configuration.properties";

        try {
            // file/dosyayı ac
            FileInputStream fileInputStream=new FileInputStream(path);
            // properties objecti aktif et/ calıstir
            properties=new Properties();

            //dosyayı yükle
            properties.load(fileInputStream);
            //dosyayı kapat
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //getProperti(key)== value
    public static String getProperty(String key){
        String value = properties.getProperty(key);
        return value;

//        return properties.getProperty(key);
    }
}
