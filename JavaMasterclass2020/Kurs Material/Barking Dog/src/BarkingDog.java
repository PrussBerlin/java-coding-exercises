public class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if(barking && (hourOfDay > -1 && hourOfDay < 24 && (hourOfDay < 8 || hourOfDay > 22)))
        {
            return true;
        } else {
            return false;
        }
    }
}
