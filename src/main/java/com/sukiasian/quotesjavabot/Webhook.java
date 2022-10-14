package com.sukiasian.quotesjavabot;

import com.sukiasian.quotesjavabot.properties.WebhookProperties;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

import java.io.IOException;

public class Webhook extends SetWebhook {
    WebhookProperties webhookProperties = new WebhookProperties("webhook.properties");

    {
        super.setIpAddress(webhookProperties.getIp());
        super.setSecretToken(webhookProperties.getSecretToken());
    }

    public Webhook() throws IOException {
    }
}
