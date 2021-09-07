package bot.api;

public class Url {

    public static final String BOT_API_URL = "https://api.telegram.org/bot";

    // methods

    public static final String GET_UPDATES_COMMAND = "/getUpdates";
    public static final String SEND_MESSAGE_COMMAND = "/sendMessage";
    public static final String SEND_STICKER_COMMAND = "/sendSticker";
    public static final String FORWARD_MESSAGE_COMMAND = "/forwardMessage";

    // parameters

    public static final String CHAT_ID_PARAMETER = "chat_id=";
    public static final String TEXT_PARAMETER = "text=";
    public static final String STICKER_PARAMETER = "sticker=";
    public static final String FROM_CHAT_ID_PARAMETER = "from_chat_id=";
    public static final String MESSAGE_ID_PARAMETER = "message_id=";
    public static final String OFFSET_PARAMETER = "offset=";

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

    public static String forwardMessage(String botToken, String fromChatId, String toChatId, String messageId) {
        return BOT_API_URL + botToken +
                FORWARD_MESSAGE_COMMAND + PARAMETERS_START_SYMBOL +
                CHAT_ID_PARAMETER + toChatId +
                PARAMETERS_CONNECTOR_SYMBOL +
                FROM_CHAT_ID_PARAMETER + fromChatId +
                PARAMETERS_CONNECTOR_SYMBOL +
                MESSAGE_ID_PARAMETER + messageId;
    }

    public static String offset(String botToken, String updateId) {
        return BOT_API_URL + botToken +
                GET_UPDATES_COMMAND + PARAMETERS_START_SYMBOL +
                OFFSET_PARAMETER + updateId;
    }
}
