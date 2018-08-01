package com.freshchat.file;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {

    public Properties loadproperty()
    {
        Properties prop = new Properties();
        try{
            //prop.load(getClass().getClassLoader().getResourceAsStream("NewrelicProperties.properties"));
            prop.load(new FileInputStream("./NewrelicProperties.properties"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
         return prop;
    }
}
