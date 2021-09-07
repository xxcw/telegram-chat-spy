package bot.util;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static final String RESULT_NODE = "result";

    static {
        objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    public static List<Update> getUpdates(String json) {
        List<Update> updates = new ArrayList<>();

        try {
            Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
            String results = objectMapper.writeValueAsString(map.get(RESULT_NODE));
            updates = objectMapper.readValue(results, new TypeReference<List<Update>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updates;
    }
}