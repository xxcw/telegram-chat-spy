package bot;

import bot.api.Bot;
import bot.api.Url;
import bot.service.ChatService;
import bot.util.HttpUtil;
import bot.util.JsonUtil;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class Launcher {

    public static void launch() {

        try {
            String json = HttpUtil.getResponseData(Url.getUpdates(Bot.SPY_VW_BOT_TOKEN));
            List<Update> updates = JsonUtil.getUpdates(json);

            ChatService.updateChat(updates);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}