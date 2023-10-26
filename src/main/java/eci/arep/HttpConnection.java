package eci.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpConnection {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String SERVER_1 = "http://ec2-52-90-12-71.compute-1.amazonaws.com:35001/lucasseq?value=";
    private static final String SERVER_2 = "http://localhost:35002/lucasseq?value=";

    private static int server = 0;

    public static StringBuffer connection(int value) throws IOException {
        String GET_URL = null;
        if (server == 1){
            GET_URL = SERVER_2+value;
            server = 2;
        } else if (server == 2 || server == 0){
            GET_URL = SERVER_1+value;
            server = 1;
        }

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response;

            // print result
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return null;
    }

}
