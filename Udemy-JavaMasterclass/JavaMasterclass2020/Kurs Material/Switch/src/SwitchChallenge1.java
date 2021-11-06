public class SwitchChallenge1 {

    public static void main(String[] args) {


        char c = 'A';
        switch (c){
            case 'A':
                System.out.println("A was found");
                break;
            case 'B':
                System.out.println("B was found");
                break;
            default:
                System.out.println("Not found");
                break;
        }

        String month = "JanUary";
        switch (month.toLowerCase()) {
            case "january":
                System.out.println("January");
                break;
            default:
                System.out.println("no month");
                break;
        }

    }

}
