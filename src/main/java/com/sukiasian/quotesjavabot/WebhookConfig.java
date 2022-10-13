package com.sukiasian.quotesjavabot;

import com.sukiasian.quotesjavabot.properties.HttpServerProperties;
import com.sukiasian.quotesjavabot.properties.WebhookProperties;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class WebhookConfig extends SetWebhook {
    WebhookProperties webhookProperties = new WebhookProperties("webhook.properties");

    {
        super.setIpAddress(webhookProperties.getIp());
        super.setSecretToken(webhookProperties.getSecretToken());
    }

    public WebhookConfig() throws IOException {
    }

    public static class HttpServer {
        private static HttpServerProperties properties;

        static {
            try {
                properties = new HttpServerProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void connect() throws IOException{
            ServerSocket serverSocket = null;
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;

            try {
                serverSocket = new ServerSocket(properties.getPort(), 1, InetAddress.getByName(properties.getAddress()));

                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
