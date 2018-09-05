package pattern.factory.simple.service;

public class PieChart implements Chart {
    @Override
    public void display() {
        System.out.println("this is PieChart");
    }

    public void selfFuction() {
        System.out.println("my self function!");
    }
}
