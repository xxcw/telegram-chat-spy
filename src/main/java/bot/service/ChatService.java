package bot.service;

import bot.api.Url;
import bot.util.HttpUtil;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatService {

    public static Set<Integer> updateIds = new HashSet<>();

    public static void updateChat(List<Update> updates) throws UnsupportedEncodingException {

        for (Update update : updates) {
            int updateId = update.getUpdateId();

            // view only once
            if (updateIds.contains(updateId)) {
                continue;
            }
            updateIds.add(update.getUpdateId());

            // must have message
            if (!update.hasMessage()) {
                continue;
            }
            Message message = update.getMessage();

            // only from source chat
            if (!Url.FROM_CHAT_ID.equals(Long.toString(message.getChatId()))) {
                continue;
            }
            sendMessage(message);
            sendSticker(message);
        }
    }

    public static void sendMessage(Message message) throws UnsupportedEncodingException {
        long userId = message.getFrom().getId();
        if (message.hasText()) {
            BotService.sendMessage(Long.toString(userId), HttpUtil.getEncodedValue(message.getText()));
        }
    }

    public static void sendSticker(Message message) {
        long userId = message.getFrom().getId();
        if (message.hasSticker()) {
            BotService.sendSticker(Long.toString(userId), message.getSticker().getFileId());
        }
    }
}