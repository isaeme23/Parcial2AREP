package eci.arep;

import java.util.HashMap;

import static eci.arep.LucasSequence.calculateSequence;
import static spark.Spark.*;
public class MathService {

    public static void main(String[] args) {
        port(getPort());
        get("/lucasseq", (req,res) -> setResponse(getSequence(Integer.parseInt(req.queryParams("value"))), Integer.parseInt(req.queryParams("value"))));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35001;
    }

    private static String getSequence(int number) {
        String sequence = "";
        int i = 0;
        while (i <= number) {
            sequence = sequence + "," + String.valueOf(calculateSequence(i));
            i++;
        }
        return sequence;
    }

    private static String setResponse(String sequence, int number){
        String response = "";
        return "{\n \"operation\":\"Secuencia de Lucas\", \n \"input\": \""+number+"\" \n \"output\": \""+sequence+"\"\n }";
    }
}
