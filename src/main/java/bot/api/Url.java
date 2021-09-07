package bot.api;

public class Url {

    // chat ids

    public static final String FROM_CHAT_ID = System.getenv("FROM_CHAT_ID");
    public static final String TO_CHAT_ID = System.getenv("TO_CHAT_ID");

    // root url

    public static final String BOT_API_URL = "https://api.telegram.org/bot";

    // methods

    public static final String GET_UPDATES_COMMAND = "/getUpdates";
    public static final String SEND_MESSAGE_COMMAND = "/sendMessage";
    public static final String SEND_STICKER_COMMAND = "/sendSticker";

    // parameters

    public static final String CHAT_ID_PARAMETER = "chat_id=";
    public static final String TEXT_PARAMETER = "text=";
    public static final String STICKER_PARAMETER = "sticker=";

    public static final String PARAMETERS_START_SYMBOL = "?";
    public static final String PARAMETERS_CONNECTOR_SYMBOL = "&";

    // urls

    public static String getUpdates(String botToken) {
        return BOT_API_URL + botToken + GET_UPDATES_COMMAND;
    }

    public static String sendMessage(String botToken, String chatId, String text) {
        return BOT_API_URL + botToken +
                SEND_MESSAGE_COMMAND + PARAMETERS_START_SYMBOL +
                CHAT_ID_PARAMETER + chatId +
                PARAMETERS_CONNECTOR_SYMBOL +
                TEXT_PARAMETER + text;
    }

    public static String sendSticker(String botToken, String chatId, String fileId) {
        return BOT_API_URL + botToken +
                SEND_STICKER_COMMAND + PARAMETERS_START_SYMBOL +
                CHAT_ID_PARAMETER + chatId +
                PARAMETERS_CONNECTOR_SYMBOL +
                STICKER_PARAMETER + fileId;
    }
}
