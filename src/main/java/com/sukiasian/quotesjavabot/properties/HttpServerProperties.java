package com.sukiasian.quotesjavabot.properties;

import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Setter
@Getter
public class HttpServerProperties extends PropertyRetriever {
    private String address;
    private int port;
    private HttpServerProperties serverConfigProperties;

    public HttpServerProperties() throws FileNotFoundException, IOException {
        super("http-server.properties");

        Properties property = super.getProperty();

        this.port = Integer.parseInt(property.getProperty("port"));
        this.address = property.getProperty("address");
    }
}
