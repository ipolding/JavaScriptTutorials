package uk.co.ipolding.whsmapper.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.skife.jdbi.v2.sqlobject.Bind;

public class WorldHeritageSite implements WhsDao {

    private int id;
    private String name;
    private String description;
    private double longitude;
    private double latitude;

    public WorldHeritageSite(int id, String name, String description, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    @Override
    public String toString() {

        return this.getName() + "\n"
                + this.getDescription() + "\n"
                + this.getLongitude() + "\n "
                + this.getLatitude() + "\n";
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public void createSiteTable() {

    }

    @Override
    public void insert(@Bind("id") int id, @Bind("name") String name, @Bind("description") String description, @Bind("latitude") Double latitude, @Bind("longitude") Double longitude) {

    }

    @Override
    public String findNameById(@Bind("id") int id) {
        return null;
    }

    @Override
    public void close() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
