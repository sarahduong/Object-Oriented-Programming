package sd7myfinalproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class QuotesModel
{
    private static HttpURLConnection connection;

    public String getQuote()
    {
        BufferedReader reader;
        String line;
        StringBuilder response = new StringBuilder();
        String quote = "";

        try {
            URL url = new URL("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");

            try {
                connection = (HttpURLConnection) url.openConnection();
                //Request setup
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(15000);
                connection.setReadTimeout(15000);

                int status = connection.getResponseCode();
                if (status > 299) {

                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    if ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    if ((line = reader.readLine()) != null) {
                        //System.out.println(line);
                        response.append(line);
                    }
                    reader.close();

                }

                int startPos = response.indexOf(":\"");
                int endPos = response.indexOf(", \"quoteAuthor\":");
                quote = response.substring(startPos + 2, endPos - 2);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    return quote;
    }
}