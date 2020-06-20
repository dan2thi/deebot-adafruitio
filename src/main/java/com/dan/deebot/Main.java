package com.dan.deebot;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import static com.dan.deebot.PropsLoader.mqttServerUrl;
import static com.dan.deebot.PropsLoader.mqttUserName;
import static com.dan.deebot.PropsLoader.mqttPassword;
import static com.dan.deebot.PropsLoader.mqttFeedName;

public class Main {

    public static void main(String[] args){
        try {
            PropsLoader.init();
            MqttClient client = new MqttClient(mqttServerUrl, MqttClient.generateClientId(), new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(mqttUserName);
            options.setPassword(mqttPassword.toCharArray());
            client.setCallback(new DeebotMqttCallback());
            client.connect(options);
            System.out.println("Connected : " + client.isConnected());
            client.subscribe(mqttFeedName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
