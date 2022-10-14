package com.sukiasian.quotesjavabot.server;

import com.sukiasian.quotesjavabot.properties.HttpServerProperties;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Server {
    private static HttpServerProperties properties;

    static {
        try {
            properties = new HttpServerProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connect() throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(properties.getAddress(), properties.getPort()), 0);

        // нужен handler
        server.createContext("*", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                exchange.getRequestMethod();
            }
        });
    }
}
