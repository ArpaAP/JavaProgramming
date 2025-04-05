/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 4월 3일
 * 과제04 - Employee
 */

import java.util.Scanner;

public class EmployeeApp {
    static final int MAX_NUM = 4;

    /**
     * 메뉴 리스트 출력하는 함수
     */
    public static void printMenu() {
        System.out.println("=".repeat(56));
        System.out.println("1. Display all employees' information (Staff, Engineer)");
        System.out.println("2. Display all staffs' information");
        System.out.println("3. Display all engineers' information");
        System.out.println("4. Display all employees' name, salary, annual salary");
        System.out.println("5. Display all employees' name, position");
        System.out.println("0. Quit");
        System.out.println("=".repeat(56));
    }

    /**
     * 모든 직원 정보를 출력하는 함수
     */
    public static void displayEmployeeInfo(Staff[] staffs, Engineer[] engineers) {
        displayStaffInfo(staffs);
        displayEngineerInfo(engineers);
    }

    /**
     * 직원 정보를 출력하는 함수
     */
    public static void displayStaffInfo(Staff[] staffs) {
        System.out.println("[Staff]");
        System.out.printf("%16s %4s %16s %8s %16s\n", "Name", "Age", "Position", "Salary", "Annual Salary");
        System.out.println("-".repeat(64));
        for (Staff staff : staffs) {
            staff.printEmployee();
        }
        System.out.println("-".repeat(64));
    }

    /**
     * 엔지니어 정보를 출력하는 함수
     */
    public static void displayEngineerInfo(Engineer[] engineers) {
        System.out.println("[Engineer]");
        System.out.printf("%16s %4s %16s %16s %8s %16s\n", "Name", "Age", "Position", "Overtime Pay", "Salary", "Annual Salary");
        System.out.println("-".repeat(81));
        for (Engineer engineer : engineers) {
            engineer.printEmployee();
        }
        System.out.println("-".repeat(81));
    }

    /**
     * 이름, 월급, 연봉 출력하는 함수
     */
    public static void displayNameSalary(Staff[] staffs, Engineer[] engineers) {
        System.out.println("[Staff]");
        System.out.printf("%16s %8s %16s\n", "Name", "Salary", "Annual Salary");
        System.out.println("-".repeat(42));
        for (Staff staff : staffs) {
            System.out.printf("%16s %8d %16d\n", staff.getName(), staff.getSalary(), staff.getAnnualSalary());
        }
        System.out.println("-".repeat(42));

        System.out.println("[Engineer]");
        System.out.printf("%16s %8s %16s\n", "Name", "Salary", "Annual Salary");
        System.out.println("-".repeat(42));
        for (Engineer engineer : engineers) {
            System.out.printf("%16s %8d %16d\n", engineer.getName(), engineer.getSalary(), engineer.getAnnualSalary());
        }
        System.out.println("-".repeat(42));
    }

    /**
     * 이름, 직급 출력하는 함수
     */
    public static void displayNamePosition(Staff[] staffs, Engineer[] engineers) {
        System.out.println("[Staff]");
        System.out.printf("%16s %21s\n", "Name", "Position");
        System.out.println("-".repeat(38));
        for (Staff staff : staffs) {
            System.out.printf("%16s %21s\n", staff.getName(), staff.getPosition());
        }
        System.out.println("-".repeat(38));

        System.out.println("[Engineer]");
        System.out.printf("%16s %21s\n", "Name", "Position");
        System.out.println("-".repeat(38));
        for (Engineer engineer : engineers) {
            System.out.printf("%16s %21s\n", engineer.getName(), engineer.getPosition());
        }
        System.out.println("-".repeat(38));
    }

    /**
     * 직원 데이터 초기화하는 함수
     * @return 직원 데이터 배열
     */
    public static Staff[] initStaffData() {
        Staff[] staffs = new Staff[MAX_NUM];

        for (int i = 0; i < MAX_NUM; i++) {
            staffs[i] = new Staff();
        }

        staffs[0].setName("John", "Smith");
        staffs[0].setAge(25);
        staffs[0].setPosition("Associate");
        staffs[0].setSalary(300);

        staffs[1].setName("Sue", "Jones");
        staffs[1].setAge(38);
        staffs[1].setPosition("Manager");
        staffs[1].setSalary(450);

        staffs[2].setName("Larry", "Wall");
        staffs[2].setAge(42);
        staffs[2].setPosition("Senior Manager");
        staffs[2].setSalary(560);

        staffs[3].setName("Marry", "Anne");
        staffs[3].setAge(45);
        staffs[3].setPosition("Director");
        staffs[3].setSalary(600);

        return staffs;
    }

    /**
     * 엔지니어 데이터 초기화하는 함수
     * @return 엔지니어 데이터 배열
     */
    public static Engineer[] initEngineerData() {
        Engineer[] engineers = new Engineer[MAX_NUM];

        for (int i = 0; i < MAX_NUM; i++) {
            engineers[i] = new Engineer();
        }

        engineers[0].setName("Bob", "Lewis");
        engineers[0].setAge(28);
        engineers[0].setPosition("Junior Engineer");
        engineers[0].setSalary(350);
        engineers[0].setOvertimeDay(15);

        engineers[1].setName("Lisa", "Barnes");
        engineers[1].setAge(37);
        engineers[1].setPosition("Senior Engineer");
        engineers[1].setSalary(580);
        engineers[1].setOvertimeDay(18);

        engineers[2].setName("Dennis", "Richie");
        engineers[2].setAge(42);
        engineers[2].setPosition("Chief Engineer");
        engineers[2].setSalary(620);
        engineers[2].setOvertimeDay(20);

        engineers[3].setName("Richard", "Stallman");
        engineers[3].setAge(46);
        engineers[3].setPosition("Project Manager");
        engineers[3].setSalary(700);
        engineers[3].setOvertimeDay(10);

        return engineers;
    }

    public static void main(String[] args) {
        Staff[] staffs = initStaffData();
        Engineer[] engineers = initEngineerData();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();

            System.out.print("-> ");
            int num = scanner.nextInt();

            if (num == 0) {
                System.out.println("Bye!");
                break;
            }

            switch (num) {
                case 1 -> displayEmployeeInfo(staffs, engineers);
                case 2 -> displayStaffInfo(staffs);
                case 3 -> displayEngineerInfo(engineers);
                case 4 -> displayNameSalary(staffs, engineers);
                case 5 -> displayNamePosition(staffs, engineers);
                default -> System.out.println("Wrong Input. Try again!");
            }
        }

        scanner.close();
    }
}