package ipolding.co.uk.database;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by Ian on 15/05/14.
 */
public interface WhsSiteDao {

    @SqlUpdate("create table sites (id int primary key, name varchar(100), description varchar(800), latitude Double precision, longitude Double precision")
    void createSiteTable();

    @SqlUpdate("insert into sites (id, name, description, longitude, latitude) values (:id, :name, :description, :latitude, :longitude)")
    void insert(@Bind("id") int id, @Bind("name") String name, @Bind("description") String description, @Bind("latitude") Double latitude, @Bind("longitude") Double longitude);

    @SqlQuery("select site from sites where id = :id")
    String findNameById(@Bind("id") int id);

    /**
     * close with no args is used to close the connection
     */
    void close();
}
