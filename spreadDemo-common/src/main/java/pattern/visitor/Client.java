package pattern.visitor;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class Client {

    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        Employee fte1, fte2, fte3, pte1, pte2;
        fte1 = new FullTimeEmployee("张无忌", new BigDecimal(25000), 40);
        fte2 = new FullTimeEmployee("杨过", new BigDecimal(20000), 41);
        fte3 = new FullTimeEmployee("段誉", new BigDecimal(23000), 42);
        pte1 = new PartTimeEmployee("洪七公", new BigDecimal(100), 4);
        pte2 = new PartTimeEmployee("周伯通", new BigDecimal(80), 2);

        employeeList.addEmployee(fte1);
        employeeList.addEmployee(fte2);
        employeeList.addEmployee(fte3);
        employeeList.addEmployee(pte1);
        employeeList.addEmployee(pte2);

        Department department;

        Properties properties = new Properties();
        try(InputStream resourceAsStream = Client.class.getResourceAsStream("department.properties");
        ) {
            properties.load(resourceAsStream);
            department = (Department) Class.forName(properties.getProperty("className")).newInstance();
            employeeList.accept(department);

        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
