package YahooObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="channel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {

    private String title;

    private String description;

    private Item item;
    @XmlElement(name="atmosphere", namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
    private Atmosphere atmosphere;
    @XmlElement(name="wind", namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
    private Wind wind;
    @XmlElement(name="location", namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
