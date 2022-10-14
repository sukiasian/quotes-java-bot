package com.sukiasian.quotesjavabot;

import com.sukiasian.quotesjavabot.server.Server;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException, TelegramApiException {
    Server.connect();

    Webhook webhook = new Webhook();
    Bot bot = new Bot();


    BotCommand bc = new BotCommand();

    bc.setCommand("hello world");

    bot.setWebhook(webhook);


  }
}
