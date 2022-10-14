package com.sukiasian.quotesjavabot.server.handlers;

import com.sun.net.httpserver.HttpExchange;

public class RequestHandler {
    private static String  getQueryParam(HttpExchange httpExchange, String queryParam) {
        String query = httpExchange.getRequestURI().getQuery(); // name=hello&surname=world

        if (query != null) {
            for (String part : query.split("&")) { // { name=hello, surname=world }
                String[] keyThenValue = part.split("="); // { name, hello }

                if (keyThenValue.length > 1 && keyThenValue[0].equals(queryParam)) {
                    return keyThenValue[1];
                }
            }
        }

        return null;
    }
}
