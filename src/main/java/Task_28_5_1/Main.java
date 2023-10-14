package Task_28_5_1;

public class Main {
    public static void main(String[] args) {
        Department department = new Department();
        department.setId("s342");
        department.setName("Sales");

        Employee employee = new Employee();
        employee.setId("k526");
        employee.setLastName("Bobby");
        employee.setDepartment(department);

//        EmployeeMapper mapper = new EmployeeMapperImp() {
//        }

    }
}
