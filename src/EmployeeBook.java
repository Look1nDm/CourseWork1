import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeBook {
    private final Employee[] listEmployee = new Employee[10];
    private int counterEmployee = 0;

    public void addEmployees(Employee employee) {
        listEmployee[counterEmployee] = employee;
        counterEmployee++;
    }
    public void printEmployeeList() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Сотрудники отдела №" + i);
            for (Employee emp : listEmployee) {
                if (emp.getDepartment() == i) {
                    System.out.println(emp.toString());
                }
            }
        }
    }
    public void setEmployeeSalary(String firstName, String middleName, String lastName, int salary) {
        for (Employee emp : listEmployee) {
            if (emp.getFirstName().equals(firstName) && emp.getMiddleName().equals(middleName) && emp.getLastName().equals(lastName)) {
                emp.setSalary(salary);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "listEmployee=" + Arrays.toString(listEmployee) +
                '}';
    }
    public void addEmployeeToList(Employee employee) {
        for (int i = 1; i < listEmployee.length; i++) {
            if (listEmployee[i] == null) {
                addEmployees(employee);
                break;
            }
        }
    }
    // метод удаляет сотрудника по ФИО
    public void deleteEmployeeToList(String firstName, String middleName, String lastName) {
        for (int i = 1; i < listEmployee.length; i++) {
            if (listEmployee[i].getFirstName().equals(firstName) && listEmployee[i].getMiddleName().equals(middleName) && listEmployee[i].getLastName().equals(lastName)) {
                listEmployee[i] = null;
                break;
            }
        }
    }
    // метод выводит всех сотрудников компании
    public void employeeState() {
        for (Employee emp : listEmployee)
            if (emp != null) {
                System.out.println(emp.toString());
            }
    }
    // метод возвращает затраты на заработную плату всех сотрудников компании
    public int getSumSalary() {
        int sumSalary = 0;
        for (Employee emp : listEmployee) {
            sumSalary += emp.getSalary();
        }
        return sumSalary;
    }
    // метод возвращает минимальную заработную плату в компании
    public int minSalary() {
        int min = listEmployee[0].getSalary();
        for (Employee emp : listEmployee) {
            if (min > emp.getSalary()){
                min = emp.getSalary();}
        }
        return min;
    }
    // метод возвращает максимальную заработную плату в компании
    public int maxSalary() {
        int max = listEmployee[0].getSalary();
        for (Employee emp : listEmployee) {
            if (max < emp.getSalary()){
                max = emp.getSalary();}
        }
        return max;
    }
    // метод возвращает средную заработную плату в компании
    public double middleSalary() {
        return (double) getSumSalary() / listEmployee.length;
    }
    // метод выводит ФИО сотрудников компании
    public void FIO() {
        for (Employee emp : listEmployee) {
            System.out.println(emp.getLastName() + " " + emp.getFirstName() + " " + emp.getMiddleName());
        }
    }
    // метод выводит заработную плату после индексации на необходимый процент
    public void index(int index) {
        for (Employee emp : listEmployee) {
            emp.setSalary((emp.getSalary() / 100 * index) + emp.getSalary());
        }
    }
    // метод возвращает массив с сотрудниками необходимого нам отдела
    public Employee[] departmentEmployee(int department) {
        List<Employee> list = new ArrayList<>();
        for (Employee emp : listEmployee) {
            if (emp.getDepartment() == department){
                list.add(emp);}
        }
        Employee[] employees = list.toArray(new Employee[0]);
        return employees;
    }
    // метод выводит минимальную заработную плату в отделе
    public void getMinDepartmentSalary(int department) {
        Employee[] emp = departmentEmployee(department);
        int min = emp[0].getSalary();
        for (Employee emp1 : emp) {
            if (min > emp1.getSalary()){
                min = emp1.getSalary();}
        }
        System.out.println("Минимальная заработная плата в отделе №" + department + " равна - " + min);
    }
    // метод выводит максимальную заработную плату в отделе
    public void getMaxDepartmentSalary(int department) {
        Employee[] emp = departmentEmployee(department);
        int max = listEmployee[0].getSalary();
        for (Employee emp1 : emp) {
            if (max < emp1.getSalary()){
                max = emp1.getSalary();}
        }
        System.out.println("Максимальная заработная плата в отделе №" + department + " равна - " + max);
    }

    // метод выводит сумму затрат на заработную плату в указанном отделе
    public void getSumSalaryDepartment(int department) {
        Employee[] emp = departmentEmployee(department);
        int sumSalary = 0;
        for (Employee emp1 : emp) {
            sumSalary += emp1.getSalary();
        }
        System.out.println("Сумма затрат на заработную плату в отделе №" + department + " равна - " + sumSalary);
    }
    // метод выводит средную заработную плату в указанном отделе
    void getMiddleSalaryDepartment(int department) {
        Employee[] emp = departmentEmployee(department);
        double midSalary = (double) getSumSalary() / emp.length;
        System.out.println("Средняя заработная плата по отделу №" + department + " равна - " + midSalary);
    }

    // метод выводит заработную плату после индексации на указанный процент в определенном отделе
    public void getIndexSalaryDepartment(int department, int index) {
        Employee[] emp1 = departmentEmployee(department);
        for (Employee emp : emp1) {
            emp.setSalary((emp.getSalary() / 100 * index) + emp.getSalary());
        }
    }

    // метод выводит ФИО сотрудников указанного отдела их заработную плату и id
    public void printEmployeeDepartment(int department) {
        Employee[] employees = departmentEmployee(department);
        for (Employee emp : employees) {
            System.out.println("У сотрудника " + emp.getLastName() + " " + emp.getFirstName() + " " + emp.getMiddleName() + ", заработная плата составляет: " + emp.getSalary() + ", его ID: " + emp.getId());
        }
    }

    // метод выводит ФИО сотруников у которых заработная плата выше указанного размера
    public void printMoreSalary(int number) {
        for (Employee emp : listEmployee) {
            if (emp.getSalary() >= number) {
                System.out.println("У " + emp.getLastName() + " " + emp.getFirstName() + " " + emp.getMiddleName() + ", работающего в отделе № " + emp.getDepartment() + ", с ID " + emp.getId() + ", заработная плата меньше " + number);
            }
        }
    }

    // метод выводит ФИО сотруников у которых заработная плата ниже указанного размера
    public void printLessSalary(int number) {
        for (Employee emp : listEmployee) {
            if (emp.getSalary() < number) {
                System.out.println("У " + emp.getLastName() + " " + emp.getFirstName() + " " + emp.getMiddleName() + ", работающего в отделе № " + emp.getDepartment() + ", с ID " + emp.getId() + ", заработная плата меньше " + number);
            }
        }
    }
}

