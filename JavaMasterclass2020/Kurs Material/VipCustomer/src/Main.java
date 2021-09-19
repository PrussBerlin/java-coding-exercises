public class Main {

    public static void main(String[] args) {

       VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());

        VipCustomer person2 = new VipCustomer("Tim", 1000.00, "Tim@gmail.com");
        System.out.println("name "+ person2.getName() + " mail: " + person2.getEmailAddress() +
                " credit limit: " + person2.getCreditLimit());

        VipCustomer person3 = new VipCustomer("Bob", 25000.00);
        System.out.println(person3.getName());

    }
}
