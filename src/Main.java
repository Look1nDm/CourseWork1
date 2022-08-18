


public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployees(new Employee("Constantin", "Constatinovich", "Const", 2, 35000));
        employeeBook.addEmployees(new Employee("Vasily", "Vasilievich", "Afonasiev", 4, 45000));
        employeeBook.addEmployees(new Employee("Anna", "Dmitrievna", "Bolein", 3, 40000));
        employeeBook.addEmployees(new Employee("Alexey", "Alekseevich", "Smirnov", 5, 55000));
        employeeBook.addEmployees(new Employee("Julia", "Aristarhovna", "Arsenieva", 1, 25000));
        employeeBook.addEmployees(new Employee("Monica", "Aleksandrovna", "Belova", 2, 37000));
        employeeBook.addEmployees(new Employee("Petr", "Petrovich", "Popov", 3, 32000));
        employeeBook.addEmployees(new Employee("Saladin", "Miroslavovich", "Gogov", 4, 31000));
        employeeBook.addEmployees(new Employee("Nikolay", "Vsevolodovich", "Volin", 5, 41000));
        employeeBook.addEmployees(new Employee("Victor", "Victorovich", "Vicon", 1, 30000));
    }
}
