package bot.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HttpUtil {

    public static String getEncodedValue(String text) throws UnsupportedEncodingException {
        return URLEncoder.encode(text, StandardCharsets.UTF_8.name());
    }

    public static String getResponseData(String url) {
        StringBuffer content = null;
        final int TIMEOUT = 15000;  // 15 sec

        try {
            URL urlAddress = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) urlAddress.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);

            System.out.println("Http response code : " + connection.getResponseCode());

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            content = new StringBuffer();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(content);
    }
}