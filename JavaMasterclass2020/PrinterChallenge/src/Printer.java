

public class Printer {

    private double tonerLevel = 100;
    private int numberOfPagesPrinted = 0;
    private boolean isDuplexPrinter;

    public Printer(boolean isDuplexPrinter) {
        this.isDuplexPrinter = isDuplexPrinter;
    }

    public void addToner(double tonerAmount) {

        double tmp = tonerAmount;

        if(tonerAmount <= 0) {
            System.out.println("Invalid Amount");
        }
        if(tonerLevel < 100) {
            tonerLevel += tonerAmount;
            if(tonerLevel > 100) {
                tonerAmount = tonerLevel - 100.0;
                tonerLevel = 100;
                System.out.println("You are trying to fill in " + tonerAmount + " % more than need");
            }
            System.out.println("Toner filled up by " + (tmp - tonerAmount) + "%. Its now " + tonerLevel + "% full. ");
        } else {
            System.out.println("still full");
        }
    }

    public int printPages(int pagesToPrint) {

        if(isDuplexPrinter) {
            pagesToPrint = (pagesToPrint / 2) + (pagesToPrint % 2);
            System.out.println("Printing in Duplex Mode");
        }
        int i = 0;
        while(pagesToPrint > 0) {
            if(tonerLevel <= 0) {
                System.out.println("No Toner left");
                return i;
            }
            numberOfPagesPrinted++;
            i++;
            pagesToPrint--;
            tonerLevel--;
        }
        System.out.println("Print complete");
        System.out.println("\t*****");
        return i;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public boolean isDuplexPrinter() {
        return isDuplexPrinter;
    }
}
