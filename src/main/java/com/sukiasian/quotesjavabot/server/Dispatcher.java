package com.sukiasian.quotesjavabot.server;

import com.sukiasian.quotesjavabot.server.handlers.QuotesHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.Getter;

import java.io.IOException;
import java.io.OutputStream;

@Getter
public class Dispatcher  implements HttpHandler {
    private boolean areGetRequests(String method) {
        return method.equals("GET");
    }

    private boolean arePostRequests(String method) {
        return method.equals("POST");
    }

    private void processBytesThenWriteResponseAndClose(HttpExchange exchange, String data) throws IOException {
        exchange.sendResponseHeaders(200, data.length());

        byte[] resBytes = data.getBytes();

        OutputStream os = exchange.getResponseBody();

        os.write(resBytes);
        os.close();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
    // GET handlers
    System.out.println(exchange.getRequestURI().getPath() + Paths.QUOTE_PATH + exchange.getRequestURI().getPath().contains(Paths.QUOTE_PATH));
        if(areGetRequests(exchange.getRequestMethod())) {
            if(exchange.getRequestURI().getPath().contains(Paths.QUOTE_PATH)) {
                processBytesThenWriteResponseAndClose(exchange, QuotesHandler.getQuote());
            }
        }

        // POST handlers
        if(arePostRequests(exchange.getRequestMethod())) {
            if(Paths.QUOTE_PATH.equals(exchange.getRequestURI())) {

            }
        }
    }
}
