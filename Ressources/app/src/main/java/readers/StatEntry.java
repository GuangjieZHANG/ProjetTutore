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
        if(string.equals("GPS")) {
            resource = Resource.GPS;
        } else if (string.equals("MobileData")) {
            resource = Resource.MobileData;
        } else if (string.equals("Wifi")) {
            resource = Resource.Wifi;
        } else if (string.equals("SMS")) {
            resource = Resource.SMS;
        } else if (string.equals("Contacts")) {
            resource = Resource.Contacts;
        }
        return resource;
    }

    public String toString() {
        return timestamp.toString() + ": " + app_name + " accessed " + resource.toString() + "(" + details.toString() + ")";
    }
}
