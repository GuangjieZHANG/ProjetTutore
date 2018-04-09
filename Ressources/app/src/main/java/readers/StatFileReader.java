package readers;

import java.util.ArrayList;

/**
 * Created by richa on 15/03/2018.
 */

public interface StatFileReader {
    ArrayList<StatEntry> readFile(String path);
}
