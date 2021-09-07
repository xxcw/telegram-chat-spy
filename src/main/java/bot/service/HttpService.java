package bot.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpService {

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