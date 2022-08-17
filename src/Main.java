


public class Main {
        static int id = 1;
    public static void main(String[] args) {
        Employee[] employees = {
        new Employee("Constantin","Constatinovich", "Const",2,35000,id),
        new Employee("Anna","Dmitrievna", "Bolein",3,40000,id),
        new Employee("Vasily","Vasilievich", "Afonasiev",4,45000,id),
        new Employee("Alexey","Alekseevich", "Smirnov",5,55000,id),
        new Employee("Julia","Aristarhovna", "Arsenieva",1,25000,id),
        new Employee("Monica","Aleksandrovna", "Belova",2,37000,id),
        new Employee("Petr","Petrovich", "Popov",3,32000,id),
        new Employee("Saladin","Miroslavovich", "Gogov",4,31000,id),
        new Employee("Nikolay","Vsevolodovich", "Volin",5,41000,id),
        new Employee("Victor","Victorovich", "Vicon",1,30000,id)};
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployees(employees);// записали список сотрудников в приватный массив

        //проверяем работу необходимых методов, описанных выше
        employeeBook.employeeState(); //выводит всех сотрудников компании
        System.out.println("Ежемесячные затраты на заработную плату сотрудникам: "+ employeeBook.getSumSalary(employeeBook.getListEmployee()));
        System.out.println("Минимальная заработная плата у сотрудиков: "+employeeBook.minSalary(employeeBook.getListEmployee())); //минимальную заработную плату в компании
        System.out.println("Максимальная заработная плата у сотрудников: "+employeeBook.maxSalary(employeeBook.getListEmployee()));//максимальную заработную плату в компании
        System.out.println("Среднаяя заработная плата у сотрудников: "+employeeBook.middleSalary(employeeBook.getListEmployee()));//средную заработную плату в компании
        employeeBook.FIO(employeeBook.getListEmployee());//ФИО сотрудников компании
        System.out.println("Заработная плата до индексации - "+employeeBook.getSumSalary(employeeBook.getListEmployee()));
        employeeBook.index(employeeBook.getListEmployee(),30);//после индексации на необходимый процент
        System.out.println("Заработная плата после индексации - "+employeeBook.getSumSalary(employeeBook.getListEmployee()));
        employeeBook.getminDepartmentSalary(employeeBook.getListEmployee(),2);//минимальную заработную плату в отделе
        employeeBook.getmaxDepartmentSalary(employeeBook.getListEmployee(),3);//максимальную заработную плату в отделе
        employeeBook.getMiddleSalaryDepartment(employeeBook.getListEmployee(),4);//сумму затрат на заработную плату в указанном отделе
        employeeBook.getSumSalaryDepartment(employeeBook.getListEmployee(),1);//средную заработную плату в указанном отделе
        employeeBook.employeeState(employeeBook.departmentEmployee(employeeBook.getListEmployee(),2));//до индексации отдельному озбранному отделу
        employeeBook.getIndexSalaryDepartment(employeeBook.getListEmployee(),2,20);//заработную плату после индексации на указанный процент в определенном отделе
        employeeBook.employeeState(employeeBook.departmentEmployee(employeeBook.getListEmployee(),2));// после индексации избранному отделу
        employeeBook.printEmployeeDepartment(employeeBook.getListEmployee(),4);//ФИО сотрудников указанного отдела их заработную плату и id
        employeeBook.printMoreSalary(employeeBook.getListEmployee(),32000);//ФИО сотруников у которых заработная плата выше указанного размера
        employeeBook.printLessSalary(employeeBook.getListEmployee(),32000);//ФИО сотруников у которых заработная плата ниже указанного размера
        System.out.println("===============");
        employeeBook.employeeState();
        employeeBook.deleteEmployeeToList(employeeBook.getListEmployee(), "Monica","Aleksandrovna","Belova");
        employeeBook.employeeState();
        employeeBook.addEmployeeToList(employeeBook.getListEmployee());
        employeeBook.employeeState();
        employeeBook.setEmployeeSalary(employeeBook.getListEmployee(), "Vladimir","Ivanovich","Krotov", 40000);
        employeeBook.employeeState();
        employeeBook.setEmployeeID(employeeBook.getListEmployee(),"Vladimir","Ivanovich","Krotov",4);
        employeeBook.employeeState();
        System.out.println("===============");
        employeeBook.printEmployeeList(employeeBook.getListEmployee());
    }
    // эти методы перенесены в EmployeeBook
    // метод выводит всех сотрудников компании
//    static void employeeState (Employee [] state){
//            for (Employee emp:state)
//        System.out.println(emp.toString());
//    }
//    // метод возвращает затраты на заработную плату всех сотрудников компании
//    static int getSumSalary (Employee [] state){
//        int sumSalary = 0;
//        for (Employee emp: state) {
//            sumSalary += emp.getSalary();
//        }
//        return sumSalary;
//    }
//    // метод возвращает минимальную заработную плату в компании
//    static int minSalary (Employee [] state){
//        int min = state[0].getSalary();
//        for (Employee emp: state){
//            if (min > emp.getSalary())
//                min = emp.getSalary();
//        }
//        return min;
//    }
//    // метод возвращает максимальную заработную плату в компании
//    static int maxSalary (Employee [] state){
//        int max = state[0].getSalary();
//        for (Employee emp: state){
//            if (max < emp.getSalary())
//                max = emp.getSalary();
//        }
//        return max;
//    }
//    // метод возвращает средную заработную плату в компании
//    static int middleSalary (Employee [] state){
//        return getSumSalary(state)/ state.length;
//    }
//    // метод выводит ФИО сотрудников компании
//    static void FIO (Employee [] state){
//        for (Employee emp: state){
//            System.out.println(emp.getLastName()+" "+emp.getFirstName()+" "+emp.getMiddleName());
//        }
//    }
//    // метод выводит заработную плату после индексации на необходимый процент
//    static void index (Employee[] state, int index){
//        for (Employee emp: state){
//            emp.setSalary((emp.getSalary()/100*index)+ emp.getSalary());
//        }
//    }
//    // метод возвращает массив с сотрудниками необходимого нам отдела
//    // он является промежуточным методом для определения в дальнейшем нужных нам параметров по отделам
//    static Employee[] departmentEmployee(Employee[] state, int department){
//        ArrayList<Employee> list = new ArrayList<>();
//        for (Employee emp:state){
//            if (emp.getDepartment() == department)
//                list.add(emp);
//        }
//        Employee[] emp = list.toArray(new Employee[list.size()]);
//        return emp;
//    }
//    // метод выводит минимальную заработную плату в отделе
//    static void getminDepartmentSalary (Employee[] state, int department){
//        System.out.println("Минимальная заработная плата в отделе №"+department+" равна - "+minSalary(departmentEmployee(state, department)));
//    }
//    // метод выводит максимальную заработную плату в отделе
//    static void getmaxDepartmentSalary (Employee[] state, int department){
//        System.out.println("Максимальная заработная плата в отделе №"+department+" равна - "+maxSalary(departmentEmployee(state,department)));
//    }
//    // метод выводит сумму затрат на заработную плату в указанном отделе
//    static void getSumSalaryDepartment (Employee[] state, int department){
//        System.out.println("Сумма затрат на заработную плату в отделе №"+department+" равна - "+ getSumSalary(departmentEmployee(state,department)));
//    }
//    // метод выводит средную заработную плату в указанном отделе
//    static void getMiddleSalaryDepartment (Employee[] state, int department){
//        System.out.println("Средняя заработная плата по отделу №"+department+" равна - "+ middleSalary(departmentEmployee(state,department)));
//    }
//    // метод выводит заработную плату после индексации на указанный процент в определенном отделе
//    static void getIndexSalaryDepartment (Employee[]state, int department, int index){
//        index(departmentEmployee(state,department),index);
//    }
//    // метод выводит ФИО сотрудников указанного отдела их заработную плату и id
//    static void printEmployeeDepartment(Employee[] state, int department){
//        Employee [] emp = departmentEmployee(state,department);
//        for (Employee employee:emp){
//            System.out.println(employee.getLastName()+" "+employee.getFirstName()+" "+employee.getMiddleName()+" "+employee.getSalary()+" "+employee.getId());
//        }
//    }
//    // метод выводит ФИО сотруников у которых заработная плата выше указанного размера
//    static void printMoreSalary (Employee[] state, int number){
//        for (Employee emp:state){
//            if (emp.getSalary()>=number){
//                System.out.println(emp.getLastName()+" "+emp.getFirstName()+" "+emp.getMiddleName()+" "+emp.getDepartment()+" "+emp.getId());
//            }
//        }
//    }
//    // метод выводит ФИО сотруников у которых заработная плата ниже указанного размера
//    static void printLessSalary (Employee[] state, int number){
//        for (Employee emp:state){
//            if (emp.getSalary()<number){
//                System.out.println(emp.getLastName()+" "+emp.getFirstName()+" "+emp.getMiddleName()+" "+emp.getDepartment()+" "+emp.getId());
//            }
//        }
//    }
}
