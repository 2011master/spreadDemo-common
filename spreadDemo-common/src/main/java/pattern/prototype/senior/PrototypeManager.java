package pattern.prototype.senior;

import java.util.Hashtable;

public class PrototypeManager {

    private Hashtable<String, OfficialDocument> ht = new Hashtable<>();
    private static PrototypeManager prototypeManager = new PrototypeManager();

    private PrototypeManager() {
        ht.put("FAR", new FAR());
        ht.put("SRS", new SRS());
    }

    public void addDoc(String key,OfficialDocument doc) {
        ht.put(key, doc);
    }

    public OfficialDocument getDoc(String key) {
        OfficialDocument document = ht.get(key).clone();
        return document;
    }

    public static PrototypeManager getManager() {

        return prototypeManager;
    }
}
