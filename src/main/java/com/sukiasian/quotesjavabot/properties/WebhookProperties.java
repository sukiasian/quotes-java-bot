package com.sukiasian.quotesjavabot.properties;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Properties;

@Setter
@Getter
public class WebhookProperties extends PropertyRetriever {
    private String ip;
    private String secretToken;

    public WebhookProperties() throws IOException {
        super("webhook.properties");

        Properties property = super.getProperty();

        this.ip = property.getProperty("ip");
        this.secretToken = property.getProperty("secret_token");
    }
}
