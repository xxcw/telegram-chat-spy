package bot.service;

import bot.api.Bot;
import bot.api.Url;
import bot.util.HttpUtil;

public class BotService {

    public static void sendMessage(String userId, String text) {
        if (Bot.SG_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendMessage(Bot.SG_BOT_TOKEN, Url.TO_CHAT_ID, text));
        }
        if (Bot.VD_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendMessage(Bot.VD_BOT_TOKEN, Url.TO_CHAT_ID, text));
        }
        if (Bot.DD_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendMessage(Bot.DD_BOT_TOKEN, Url.TO_CHAT_ID, text));
        }
        if (Bot.SS_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendMessage(Bot.SS_BOT_TOKEN, Url.TO_CHAT_ID, text));
        }
        if (Bot.VP_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendMessage(Bot.VP_BOT_TOKEN, Url.TO_CHAT_ID, text));
        }
    }

    public static void sendSticker(String userId, String fileId) {
        if (Bot.SG_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendSticker(Bot.SG_BOT_TOKEN, Url.TO_CHAT_ID, fileId));
        }
        if (Bot.VD_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendSticker(Bot.VD_BOT_TOKEN, Url.TO_CHAT_ID, fileId));
        }
        if (Bot.DD_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendSticker(Bot.DD_BOT_TOKEN, Url.TO_CHAT_ID, fileId));
        }
        if (Bot.SS_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendSticker(Bot.SS_BOT_TOKEN, Url.TO_CHAT_ID, fileId));
        }
        if (Bot.VP_USER_ID.equals(userId)) {
            HttpUtil.getResponseData(Url.sendSticker(Bot.VP_BOT_TOKEN, Url.TO_CHAT_ID, fileId));
        }
    }
}