package readers;

import android.util.JsonReader;

import java.util.ArrayList;

/**
 * Created by richa on 09/04/2018.
 */

public class JsonTest {
    public static void main(String [ ] args) {
        JsonFileReader reader = new JsonFileReader();
        ArrayList<StatEntry> statEntries = reader.readFile("./input.json");
        for (int i = 0; i < statEntries.size(); i++) {
            System.out.println(statEntries.get(i).toString());
        }
    }
}
