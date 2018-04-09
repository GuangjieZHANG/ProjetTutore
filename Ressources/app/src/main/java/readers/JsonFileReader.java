package readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import android.util.JsonReader;

/**
 * Created by richa on 15/03/2018.
 */

public class JsonFileReader implements StatFileReader {

    public ArrayList<StatEntry> readFile(String path) {
        File file = new File(path);
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
            return readEntryArray(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidEntryException e) {
            e.display();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private ArrayList<StatEntry> readEntryArray(JsonReader reader) throws IOException, InvalidEntryException {
        ArrayList<StatEntry> statEntries = new ArrayList<StatEntry>();
        reader.beginArray();
        while (reader.hasNext()) {
            statEntries.add(readEntry(reader));
        }
        reader.endArray();
        return statEntries;
    }

    private StatEntry readEntry(JsonReader reader) throws IOException, InvalidEntryException {
        Timestamp timestamp = null;
        String app_name = null;
        StatEntry.Resource resource = null;
        Detail detail = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("timestamp")) {
                timestamp = new Timestamp(reader.nextLong());
            } else if (name.equals("app")) {
                app_name = reader.nextString();
            } else if (name.equals("resource")) {
                resource = StatEntry.readResourceFromString(reader.nextString());
            } else if (name.equals("detail")) {
                readDetail(reader);
            } else {
                throw new InvalidEntryException();
            }
        }
        reader.endObject();
        return new StatEntry(timestamp, app_name, resource, detail);
    }

    private Detail readDetail(JsonReader reader) throws IOException {
        reader.skipValue();
        return null;
    }
}
