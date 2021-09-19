public class Song {

    private String songTitle;
    private double songDuration;

    public Song(String songTitle, double songDuration) {
        this.songTitle = songTitle;
        this.songDuration = songDuration;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public String getSongTitle() {
        return songTitle;
    }

    @Override
    public String toString() {
        return this.songTitle + ": " + this.songDuration;
    }
}
