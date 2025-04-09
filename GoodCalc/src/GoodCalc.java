public class GoodCalc extends Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public double average(int[] a) {
        double sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum / a.length;
    }

    public static void main(String[] args) {
        GoodCalc calc = new GoodCalc();

        System.out.println(calc.add(2, 3));
        System.out.println(calc.subtract(2, 3));
        System.out.println(calc.average(new int[]{1, 2, 3, 4, 5}));
    }
}