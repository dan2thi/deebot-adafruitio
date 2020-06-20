package com.dan.deebot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsLoader {

    static String mqttServerUrl;
    static String mqttUserName;
    static String mqttPassword;
    static String mqttFeedName;
    static String sucksLibPath;
    static boolean isWindows;


    public static void init() throws IOException {
        Properties properties = new Properties();
        InputStream in = PropsLoader.class.getClassLoader().getResourceAsStream("deebot.properties");
        properties.load(in);
        in.close();
        mqttServerUrl = properties.getProperty("mqtt.server.url");
        mqttUserName = properties.getProperty("mqtt.username");
        mqttPassword = properties.getProperty("mqtt.password");
        mqttFeedName = properties.getProperty("mqtt.feed.name");
        sucksLibPath = properties.getProperty("sucks.lib.path");
        isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    }
}
