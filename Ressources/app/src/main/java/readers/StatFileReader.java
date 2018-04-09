package readers;

import java.util.ArrayList;

/**
 * Created by richa on 15/03/2018.
 */

public interface StatFileReader {
    enum Resource {GPS, MobileData, Wifi, SMS, Contacts}
    ArrayList<StatEntry> readFile(String path);
}
