package pattern.visitor;

public class HRDepartment implements Department {
    @Override
    public void visit(FullTimeEmployee fullTimeEmployee) {
        System.out.println("正式员工："+fullTimeEmployee.getName()+"工作时间："+fullTimeEmployee.getWorkTime());
    }

    @Override
    public void visit(PartTimeEmployee partTimeEmployee) {
        System.out.println("兼职员工："+partTimeEmployee.getName()+"工作时间："+partTimeEmployee.getWorkTime());
    }
}
