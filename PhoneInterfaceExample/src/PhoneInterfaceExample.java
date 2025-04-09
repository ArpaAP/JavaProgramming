public class PhoneInterfaceExample {
    public static void main(String[] args) {
        FeaturePhone phone = new FeaturePhone();

        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
    }
}