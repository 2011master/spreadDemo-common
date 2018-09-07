package pattern.prototype.senior;

public class FAR implements OfficialDocument {

    @Override
    public FAR clone() {

        try {
            return (FAR) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void display() {
        System.out.println("可行性报告分析");
    }
}
