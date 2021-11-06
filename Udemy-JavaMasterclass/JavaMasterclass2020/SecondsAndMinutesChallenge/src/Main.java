public class Main {

    public static void getDurationString(int minutes, int seconds) {

        int totalSeconds = (minutes * 60) + seconds;
        getDurationString(totalSeconds);
    }

    public static void getDurationString(int seconds) {
        if(seconds > 0) {
            seconds %= 86400;
            int hours = seconds / 3600;
            seconds %= 3600;
            int minutes = seconds / 60;
            seconds %= 60;
            System.out.printf("%02dh %02dm %02ds\n", hours, minutes, seconds);

        } else {
            System.out.println("Invalid Value");
        }
    }

    public static void main(String[] args) {
        getDurationString(86405);
       
    }
}
