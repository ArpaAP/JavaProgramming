public class SimpleGenericEx {
    public static void main(String[] args) {
        // String 타입으로 지정
        MyClass<String> m1 = new MyClass<String>();
        m1.set("Hello");
        System.out.println(m1.get());

        // Integer 타입으로 지정
        MyClass<Integer> m2 = new MyClass<Integer>();
        m2.set(100);
        System.out.println(m2.get());
    }
}
