package Yandexweather;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static okhttp3.RequestBody.*;

public class YandexWeatherTestDrive {

        public static void main(String[] args) throws IOException {
            /*GET https://api.weather.yandex.ru/v2/forecast?
  lat=<54.70739>
 & lon=<20.507307>
 & [lang=<"ru_RU">]
 & [limit=<7>]
 & [hours=<«true»>]
 & [extra=<«true»>]

X-Yandex-API-Key: <a653e609-ef9b-4cb8-b198-a04108bceafb>*/

            OkHttpClient okHttpClient = new OkHttpClient();

            String requestBody = "GET https://api.weather.yandex.ru/v2/informers?lat=54.70739&lon=20.507307&extra=true" +
                    " & [lang=<\"ru_RU\">]\n" +
                    " & [limit=<7>]\n" +
                    " & [hours=<«true»>]\n" +
                    " & [extra=<«true»>]\n" +
                    "\n" +
                    "X-Yandex-API-Key: <a653e609-ef9b-4cb8-b198-a04108bceafb>";

            MediaType JSON = MediaType.parse("JSON");
            RequestBody requestBodyWeather = RequestBody.create(requestBody, JSON);
            Request request = new Request.Builder()
                    .url("https://api.weather.yandex.ru/v2/forecast?")
                    .post(requestBodyWeather)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String body = response.body().string();
            System.out.println(response.body().string());

        }
}
