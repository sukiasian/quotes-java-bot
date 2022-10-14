package com.sukiasian.quotesjavabot;

import com.sukiasian.quotesjavabot.server.Server;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Server.connect();

    WebhookConfig webhookConfig = new WebhookConfig();
  }
}
