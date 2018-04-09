package readers;

import java.sql.Timestamp;

/**
 * Created by richa on 15/03/2018.
 */

public class StatEntry {

    enum Resource {GPS, MobileData, Wifi, SMS, Contacts};

    public static Resource readResourceFromString(String string) {
        StatEntry.Resource resource=null;
        return resource;
    }

    private Timestamp timestamp;
    private String app_name;
    private Resource resource;
    private Detail details;
}
