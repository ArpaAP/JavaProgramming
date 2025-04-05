/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 4월 3일
 * 과제04 - Employee
 */

public class Employee {
    private String fullName;
    private int age;
    private int salary;
    private String position;

    public void setName(String firstname, String lastname) {
        fullName = firstname + " " + lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void printEmployee() {
        System.out.printf("%16s %4s %16s\n", fullName, age, position);
    }

    public String getName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }
}
