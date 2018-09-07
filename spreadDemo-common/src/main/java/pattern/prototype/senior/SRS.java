package pattern.prototype.senior;

public class SRS implements OfficialDocument {

    @Override
    public SRS clone() {

        try {
            return (SRS) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void display() {
        System.out.println("软件需求说明");
    }
}
