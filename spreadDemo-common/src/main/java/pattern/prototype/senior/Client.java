package pattern.prototype.senior;


public class Client {

    public static void main(String[] args) {
        PrototypeManager manager = PrototypeManager.getManager();

        OfficialDocument doc1, doc2, doc3, doc4;
        doc1 = manager.getDoc("FAR");
        doc2 = manager.getDoc("FAR");
        System.out.println("doc1 == doc2 : " + (doc1 == doc2));

        doc3 = manager.getDoc("SRS");
        doc4 = manager.getDoc("SRS");
        System.out.println("doc4 == doc3 : " + (doc3 == doc4));
    }
}






















