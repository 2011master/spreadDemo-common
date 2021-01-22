package pattern.visitor;

public class FADepartment implements  Department {
    @Override
    public void visit(FullTimeEmployee fullTimeEmployee) {
        System.out.println("正式员工："+fullTimeEmployee.getName()+"工资为："+fullTimeEmployee.getWeeklyWage());
    }

    @Override
    public void visit(PartTimeEmployee partTimeEmployee) {
        System.out.println("兼职员工："+partTimeEmployee.getName()+"工资为："+partTimeEmployee.getHourWage());
    }
}
