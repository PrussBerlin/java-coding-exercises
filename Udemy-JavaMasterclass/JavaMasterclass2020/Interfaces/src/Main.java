public class Main {

    public static void main(String[] args) {
        ITelephone timsPhone;
        timsPhone = new DeskPhone(12234);
        timsPhone.powerOn();
        timsPhone.callPhone(12234);
        timsPhone.answer();


        timsPhone = new MobilePhone(12244534);
        timsPhone.powerOn();
        timsPhone.callPhone(12244534);
        timsPhone.answer();
    }
}
