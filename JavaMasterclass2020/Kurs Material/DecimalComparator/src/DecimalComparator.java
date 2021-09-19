public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
        int c = (int) (a * Math.pow(10, 3));
        int d = (int) (b * Math.pow(10, 3));
        if(c == d) {
            return true;
        } else {
            return false;
        }
    }
}
