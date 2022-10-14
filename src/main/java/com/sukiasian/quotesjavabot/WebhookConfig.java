package com.sukiasian.quotesjavabot;

import com.sukiasian.quotesjavabot.properties.WebhookProperties;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

import java.io.IOException;

public class WebhookConfig extends SetWebhook {
    WebhookProperties webhookProperties = new WebhookProperties("webhook.properties");

    {
        super.setIpAddress(webhookProperties.getIp());
        super.setSecretToken(webhookProperties.getSecretToken());
    }

    public WebhookConfig() throws IOException {
    }
}
