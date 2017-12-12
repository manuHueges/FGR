package YahooObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlElement(name="condition", namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
    private Condition condition;
    @XmlElement(name="forecast", namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
    private List<Forecast> forecasts;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
