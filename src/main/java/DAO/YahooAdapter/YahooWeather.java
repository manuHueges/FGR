package DAO.YahooAdapter;

import DAO.IDaoAdapter.ObjectsForDAO;
import YahooObjects.Channel;
import YahooObjects.Forecast;
import com.company.Weather;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public class YahooWeather {

    public Channel selectChannelForCityName (String cityName, String stateAbr) {

//        String query = "select item from weather.forecast where woeid in (select woeid from geo.places(1) where text='"++"') and u='c'";


        try {
            String city = URLEncoder.encode(cityName+", "+stateAbr, "UTF-8");
            String encodedQuery = "select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+city+"%22)";
//            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            HttpURLConnection connection = ConnectionSingletonHTTP.getInstance().getConnection(encodedQuery);

//            URL obj = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22cordoba%2C%20cba%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
//            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//            connection.setRequestMethod("GET");


            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(connection.getInputStream());
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);
            xsr.nextTag();
            while(!xsr.getLocalName().equals("channel")) {
                xsr.nextTag();
            }

            JAXBContext jc = JAXBContext.newInstance(Channel.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<Channel> jb = unmarshaller.unmarshal(xsr, Channel.class);
            Channel channel = jb.getValue();
            xsr.close();
            connection.disconnect();
            return channel;
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return null;
     }



//        try {
//            String query = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(466861)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
//
//
//            JAXBContext jaxbContext = JAXBContext.newInstance(YahooObjects.Weather.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            URL obj = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22cordoba%2C%20cba%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
//
//            YahooObjects.Query w = (YahooObjects.Query) jaxbUnmarshaller.unmarshal(obj);
//
//            System.out.println(w);
//
//
//        } catch (Exception e) {
//            System.err.println("wuops! ");
//            System.err.println(e.getMessage());
//        }

        /*


        String lst = new String();
        try {
                       
            URL obj = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22cordoba%2C%20cba%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(con.getInputStream());
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);
            xsr.nextTag();
            while(!xsr.getLocalName().equals("channel")) {
                xsr.nextTag();
            }

            JAXBContext jc = JAXBContext.newInstance(Channel.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<Channel> jb = unmarshaller.unmarshal(xsr, Channel.class);
            Channel channel = jb.getValue();

            System.out.println("Direccion Viento: " + channel.getWind().getDirection());
            System.out.println("Presion: " + channel.getAtmosphere().getPressure());
            System.out.println("temp: " + channel.getItem().getCondition().getTemp());
            for(Forecast f : channel.getItem().getForecasts()) {
                System.out.println(f.getDate() + " min: " + f.getLow());
            }

            xsr.close();

            //in.close();
            con.disconnect();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
    }
*/

}
