import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeBook {
    private Employee[] listEmployee = new Employee[10];

    public void addEmployees(Employee[] employee) {
        for (int i = 0; i < listEmployee.length; i++) {
            listEmployee[i] = employee[i];
        }
    }

    public Employee[] getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(Employee[] listEmployee) {
        this.listEmployee = listEmployee;
    }

    public void printEmployeeList(Employee[] employee) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Сотрудники отдела №" + i);
            for (Employee emp : employee) {
                if (emp.getDepartment() == i){
                    System.out.println(emp.getFirstName()+" "+emp.getMiddleName()+" "+emp.getLastName());
                }
            }
        }
    }


    // метод создает нового сотрудника с ID и возвращает его
    public Employee createNewEmployee(int result) {
        return new Employee("Vladimir", "Ivanovich", "Krotov", 2, 34000, result);
    }

    // метод находит пустую ячейку и передает ее индекс в метод по созданию работника, возвращает новый массив
    public Employee[] addEmployeeToList(Employee[] employee) {
//        if (isEmptyNull(employee)) {
        for (int i = 1; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = createNewEmployee(i);
                break;
            }
        }
//        }
        return employee;
    }

    public Employee[] setEmployeeID(Employee[] employee, String firstName, String middleName, String lastName, int id) {
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getFirstName().equals(firstName) && employee[i].getMiddleName().equals(middleName) && employee[i].getLastName().equals(lastName)) {
                employee[i].setId(id);
                break;
            }
        }
        return employee;
    }

    // метод изменяет зарплату сотрудника
    public Employee[] setEmployeeSalary(Employee[] employee, String firstName, String middleName, String lastName, int salary) {
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getFirstName().equals(firstName) && employee[i].getMiddleName().equals(middleName) && employee[i].getLastName().equals(lastName)) {
                employee[i].setSalary(salary);
                break;
            }
        }
        return employee;
    }

    // метод удаляет сотрудника по ФИО
    public Employee[] deleteEmployeeToList(Employee[] employee, String firstName, String middleName, String lastName) {
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getFirstName().equals(firstName) && employee[i].getMiddleName().equals(middleName) && employee[i].getLastName().equals(lastName)) {
                employee[i] = null;
                break;
            }
        }
        return employee;
    }

    // метод выводит всех сотрудников компании
    void employeeState() {
        for (Employee emp : listEmployee)
            if (emp == null) {
                System.out.println("null");
            } else
                System.out.println(emp.toString());//+++++++++++++++++++++++++
    }

    // заоверлоадил метод выше
    void employeeState(Employee[] listEmployee) {
        for (Employee emp : listEmployee)
            if (emp == null) {
                System.out.println("null");
            } else
                System.out.println(emp.toString());//+++++++++++++++++++++++++
    }

    // метод возвращает затраты на заработную плату всех сотрудников компании
    int getSumSalary(Employee[] employee) {
        int sumSalary = 0;
        for (Employee emp : employee) {
            sumSalary += emp.getSalary();
        }
        return sumSalary;//+++++++++++++++++++++++++++++++++++++
    }

    // метод возвращает минимальную заработную плату в компании
    int minSalary(Employee[] employee) {
        int min = employee[0].getSalary();
        for (Employee emp : employee) {
            if (min > emp.getSalary())
                min = emp.getSalary();
        }
        return min;//++++++++++++++++++++++++++++++++++++++++
    }

    // метод возвращает максимальную заработную плату в компании
    int maxSalary(Employee[] employee) {
        int max = employee[0].getSalary();
        for (Employee emp : employee) {
            if (max < emp.getSalary())
                max = emp.getSalary();
        }
        return max;//+++++++++++++++++++++++++++++++++++++++
    }

    // метод возвращает средную заработную плату в компании
    int middleSalary(Employee[] employee) {
        return getSumSalary(employee) / employee.length;//+++++++++++++++++++++++++
    }

    // метод выводит ФИО сотрудников компании
    void FIO(Employee[] employee) {
        for (Employee emp : employee) {
            System.out.println(emp.getLastName() + " " + emp.getFirstName() + " " + emp.getMiddleName());//+++++++++++++++++++++++++
        }
    }

    // метод выводит заработную плату после индексации на необходимый процент
    void index(Employee[] employee, int index) {
        for (Employee emp : employee) {
            emp.setSalary((emp.getSalary() / 100 * index) + emp.getSalary());//+++++++++++++++++++++++++
        }
    }

    // метод возвращает массив с сотрудниками необходимого нам отдела
    // он является промежуточным методом для определения в дальнейшем нужных нам параметров по отделам
    Employee[] departmentEmployee(Employee[] employee, int department) {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee emp : employee) {
            if (emp.getDepartment() == department)
                list.add(emp);
        }
        Employee[] employees = list.toArray(new Employee[0]);
        return employees;
    }

    // метод выводит минимальную заработную плату в отделе
    void getminDepartmentSalary(Employee[] employee, int department) {
        System.out.println("Минимальная заработная плата в отделе №" + department + " равна - " + minSalary(departmentEmployee(employee, department)));
    }

    // метод выводит максимальную заработную плату в отделе
    void getmaxDepartmentSalary(Employee[] employee, int department) {
        System.out.println("Максимальная заработная плата в отделе №" + department + " равна - " + maxSalary(departmentEmployee(employee, department)));
    }

    // метод выводит сумму затрат на заработную плату в указанном отделе
    void getSumSalaryDepartment(Employee[] employee, int department) {
        System.out.println("Сумма затрат на заработную плату в отделе №" + department + " равна - " + getSumSalary(departmentEmployee(employee, department)));
    }

    // метод выводит средную заработную плату в указанном отделе
    void getMiddleSalaryDepartment(Employee[] employee, int department) {
        System.out.println("Средняя заработная плата по отделу №" + department + " равна - " + middleSalary(departmentEmployee(employee, department)));
    }

    // метод выводит заработную плату после индексации на указанный процент в определенном отделе
    void getIndexSalaryDepartment(Employee[] employee, int department, int index) {
        index(departmentEmployee(employee, department), index);
    }

    // метод выводит ФИО сотрудников указанного отдела их заработную плату и id
    void printEmployeeDepartment(Employee[] employee, int department) {
        Employee[] employees = departmentEmployee(employee, department);
        for (Employee emp : employees) {
            System.out.println("У сотрудника " + emp.getLastName() + " " + emp.getFirstName() + " " + emp.getMiddleName() + ", заработная плата составляет: " + emp.getSalary() + ", его ID: " + emp.getId());
        }
    }

    // метод выводит ФИО сотруников у которых заработная плата выше указанного размера
    void printMoreSalary(Employee[] employee, int number) {
        for (Employee emp : employee) {
            if (emp.getSalary() >= number) {
                System.out.println("У " + emp.getLastName() + " " + emp.getFirstName() + " " + emp.getMiddleName() + ", работающего в отделе № " + emp.getDepartment() + ", с ID " + emp.getId() + ", заработная плата меньше " + number);
            }
        }
    }

    // метод выводит ФИО сотруников у которых заработная плата ниже указанного размера
    void printLessSalary(Employee[] employee, int number) {
        for (Employee emp : employee) {
            if (emp.getSalary() < number) {
                System.out.println("У " + emp.getLastName() + " " + emp.getFirstName() + " " + emp.getMiddleName() + ", работающего в отделе № " + emp.getDepartment() + ", с ID " + emp.getId() + ", заработная плата меньше " + number);
            }
        }
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "listEmployee=" + Arrays.toString(listEmployee) +
                '}';
    }
}
