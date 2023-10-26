package eci.arep;

import java.util.ArrayList;

import static spark.Spark.*;
import static eci.arep.HttpConnection.connection;
public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("/", (req,res) -> getForm());
        get("/lucasseq", (req,res) -> connection(Integer.parseInt(req.queryParams("value"))));

    }
    // object.setMember("operation", " Secuencia de Lucas");
    //        object.setMember("input", String.valueOf(req.queryParams("value")));
    //        object.setMember("output", sequence);

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }

    private static String getForm(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Form Example</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Form with GET</h1>\n" +
                "<form action=\"/hello\">\n" +
                "    <label for=\"number\">Enter number for Lucas Sequence:</label><br>\n" +
                "    <input type=\"text\" id=\"number\" name=\"number\" value=\"13\"><br><br>\n" +
                "    <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "</form>\n" +
                "<div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "<script>\n" +
                "            function loadGetMsg() {\n" +
                "                let numberVar = document.getElementById(\"number\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/lucasseq?value=\"+numberVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n"+
                "</html>";
    }
}
