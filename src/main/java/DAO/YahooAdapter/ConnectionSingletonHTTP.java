package DAO.YahooAdapter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class ConnectionSingletonHTTP {

    private static ConnectionSingletonHTTP connectionSingleton = null;
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36";

    private ConnectionSingletonHTTP(){};


    public static ConnectionSingletonHTTP getInstance(){
        if (connectionSingleton == null ){
            connectionSingleton = new ConnectionSingletonHTTP();
        }
        return connectionSingleton;
    }

    public HttpURLConnection getConnection(String query){
        HttpURLConnection con = null;
        try {
            String locationUrl = "https://query.yahooapis.com/v1/public/yql?q=" + query + "%20and%20u=%27c%27&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
            URL obj = new URL(locationUrl);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
//            con.setRequestProperty("User-Agent", USER_AGENT);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

}
