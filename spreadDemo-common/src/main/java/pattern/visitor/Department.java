package pattern.visitor;

public interface Department {

    void visit(FullTimeEmployee fullTimeEmployee);

    void visit(PartTimeEmployee partTimeEmployee);


}
