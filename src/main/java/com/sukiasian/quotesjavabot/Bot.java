package com.sukiasian.quotesjavabot;

import com.sukiasian.quotesjavabot.properties.WebhookProperties;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.WebhookBot;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class Bot implements WebhookBot {
    private WebhookProperties webhookProperties;

    {
        try {
            this.webhookProperties = new WebhookProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @SneakyThrows
    @Override
    public void setWebhook(SetWebhook setWebhook) throws TelegramApiException {
        // нужно отправить запрос на https://api.telegram.org/bot{token}/setWebhook

        // для этого скорее всего нужно вынести хуки в отдельную логику
        HttpURLConnection connection = null;

        try {
        URL url = new URL(String.format("https://api.telegram.org/bot/%s/setWebhook", webhookProperties.getSecretToken()));

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("Content-Language", "en-US");
        connection.setRequestProperty("User-Agent", "Telegram Bot SDK - (https://github.com/irazasyed/telegram-bot-sdk)");

        connection.setUseCaches(false);
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();

        String jsonInputString = "{\"url\": \"\", \"job\": \"Programmer\"}";

        } catch(Exception e) {}
    }

    @Override
    public String getBotPath() {
        return null;
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }
}