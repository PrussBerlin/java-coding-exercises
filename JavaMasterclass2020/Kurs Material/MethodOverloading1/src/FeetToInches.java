public class FeetToInches {
    public static void main(String[] args) {

        System.out.println(calcFeetAndInchesToCentimeters(157));
        System.out.println(calcFeetAndInchesToCentimeters(13, 1));

    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if(feet >= 0 && inches >= 0 && inches <= 12) {
            double inchesTotal = ((feet*12) + inches);
            double cm = inchesTotal * 2.54;
            return cm;
        } else {
            return -1;
        }
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if(inches >= 0) {
            int feet = (int) (inches / 12);
            double inchesNew = inches % 12;
            double cm = calcFeetAndInchesToCentimeters(feet, inchesNew);
            return cm;
        } else {
            return -1;
        }
    }
}
