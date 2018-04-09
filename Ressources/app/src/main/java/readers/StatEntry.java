package readers;

import java.sql.Timestamp;

/**
 * Created by richa on 15/03/2018.
 */

public class StatEntry {
    private Timestamp timestamp;
    private String app_name;
    private StatFileReader.Resource resource;
    private Detail details;
}
