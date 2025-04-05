/**
 * 컴퓨터학부 글로벌소프트웨어융합전공
 * 2024003159 황부연
 * 2025년 4월 3일
 * 과제04 - Employee
 */

public class Engineer extends Employee {
    private int overtimeDay;

    public void setOvertimeDay(int day) {
        overtimeDay = day;
    }

    public int getOvertimePay() {
        return overtimeDay * 3;
    }

    public int getAnnualSalary() {
        return (getSalary() + getOvertimePay()) * 12;
    }

    @Override
    public void printEmployee() {
        System.out.printf("%16s %4d %16s %16d %8d %16d\n", getName(), getAge(), getPosition(), getOvertimePay(), getSalary(), getAnnualSalary());
    }
}
