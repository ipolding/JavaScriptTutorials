package ipolding.co.uk.domain;

/**
 * Created by ian.polding on 15/05/2014.
 */
public class WorldHeritageSite {

    private String name;
    private String description;
    private double longitude;
    private double latitude;

    @Override
    public String toString() {

        return this.getName() + " "
                + this.getDescription() + " "
                + this.getLongitude() + " "
                + this.getLatitude() + " ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
