/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 4월 3일
 * 과제04 - Employee
 */

public class Staff extends Employee {
    public int getAnnualSalary() {
        return getSalary() * 12;
    }

    @Override
    public void printEmployee() {
        System.out.printf("%16s %4d %16s %8d %16d\n", getName(), getAge(), getPosition(), getSalary(), getAnnualSalary());
    }
}
