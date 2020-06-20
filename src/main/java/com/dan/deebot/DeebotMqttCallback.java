package com.dan.deebot;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import static com.dan.deebot.PropsLoader.isWindows;
import static com.dan.deebot.PropsLoader.sucksLibPath;

import java.io.IOException;

public class DeebotMqttCallback implements MqttCallback {
    @Override
    public void connectionLost(Throwable throwable) {
        //Called when the client lost the connection to the broker
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws IOException {
        String value = new String(mqttMessage.getPayload());
        System.out.println(topic + ": " + value);
        try {
            Integer cleanDuration = new Integer(value);
            handleCommand("sucks clean " + cleanDuration);
        } catch (NumberFormatException e){
            if ("charge".equalsIgnoreCase(value)) {
                handleCommand("sucks charge");
            } else {
                handleCommand("sucks stop");
            }
        }
    }

    private void handleCommand(String command) throws IOException{
        if (!sucksLibPath.isEmpty()){
            command = sucksLibPath + command;
        }
        String[] exec;
        if (isWindows) {
            exec = new String[] {"cmd", "/c", command};
        } else {
            exec = new String[]{"/bin/bash", "-c", command};
        }
        Runtime.getRuntime().exec(exec);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        //Called when a outgoing publish is complete
    }
}
