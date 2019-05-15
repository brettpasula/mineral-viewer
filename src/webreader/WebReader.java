// code modified from CPSC 210 - Software Construction P10: Design Patterns and the Web

package webreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.*;
import java.net.URL;

public class WebReader {

        public void readWeb() throws IOException {

            BufferedReader br = null;

            try {
                String apikey = "5a2416b9c8353bd4fa5e9c21db935051";
                String vancouverweatherquery = "https://api.openweathermap.org/data/2.5/weather?id=6173331&APPID=";
                String theURL=vancouverweatherquery+apikey;
                URL url = new URL(theURL);
                br = new BufferedReader(new InputStreamReader(url.openStream()));

                String line;

                StringBuilder sb = new StringBuilder();

                while ((line = br.readLine()) != null) {

                    sb.append(line);
                    sb.append(System.lineSeparator());
                }

                System.out.println(sb);

            } finally {

                if (br != null) {
                    br.close();
                }
            }
        }

        public void parseWeb(String toParse) throws JSONException {

            JSONObject json = new JSONObject(toParse);

            String mainWeather = json.getString("main");
            String weatherDescription = json.getString("description");
            double temp = (json.getDouble("temp") - 273.15);

            System.out.println(mainWeather + "(" + weatherDescription + ") and " + temp + "degrees.");
        }
    }
