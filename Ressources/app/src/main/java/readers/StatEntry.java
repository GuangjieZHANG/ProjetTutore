package readers;

import java.sql.Timestamp;

/**
 * Created by richa on 15/03/2018.
 */

public class StatEntry {

    enum Resource {GPS, MobileData, Wifi, SMS, Contacts};

    private Timestamp timestamp;
    private String app_name;
    private Resource resource;
    private Detail details;

    public StatEntry(Timestamp timestamp, String app_name, Resource resource, Detail details) {
        this.timestamp = timestamp;
        this.app_name = app_name;
        this.resource = resource;
        this.details = details;
    }

    public static Resource readResourceFromString(String string) {
        StatEntry.Resource resource=null;
        return resource;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getApp_name() {
        return app_name;
    }

    public Resource getResource() {
        return resource;
    }

    public Detail getDetails() {
        return details;
    }

    public String toString() {
        return timestamp.toString() + ": " + app_name + " accessed " + resource.toString() + "(" + details.toString() + ")";
    }
}
