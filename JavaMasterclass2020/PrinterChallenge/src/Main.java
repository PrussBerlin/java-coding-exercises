public class Main {

    public static void main(String[] args) {

        Printer duplexPrinter = new Printer(true);
        Printer normalPrinter = new Printer(false);

        System.out.println("initial page count = " + duplexPrinter.getNumberOfPagesPrinted());
        int pagesPrinted = duplexPrinter.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " new total print count = " + duplexPrinter.getNumberOfPagesPrinted());
        pagesPrinted = duplexPrinter.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted + " new total print count = " + duplexPrinter.getNumberOfPagesPrinted());
//        duplexPrinter.printPages(7);
//        duplexPrinter.getNumberOfPagesPrinted();
//        duplexPrinter.addToner(20);
//        duplexPrinter.printPages(6);


    }
}
