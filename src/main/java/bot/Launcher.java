package bot;

import bot.api.Bot;
import bot.api.Url;
import bot.service.HttpService;
import bot.util.JsonParser;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class Launcher {

    public static void launch() {

        try {
            String json = HttpService.getResponseData(Url.getUpdates(Bot.SPY_VW_BOT_TOKEN));
            List<Update> updates = JsonParser.getUpdates(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}