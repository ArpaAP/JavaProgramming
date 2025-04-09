public class FeaturePhone implements PhoneInterface {
    @Override
    public void sendCall() {
        System.out.println("전화 발신");
    }

    @Override
    public void receiveCall() {
        System.out.println("전화가 왔습니다.");
    }

    public void flash() {
        System.out.println("플래시가 켜졌습니다.");
    }
}
