import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String albumName;
    private String artist;
    private List<Song> songs;

//    public Album(String albumName, ArrayList<Song> songs) {
//        this.albumName = albumName;
//        this.songs = new ArrayList<>(songs);
//    }

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for(Song checkedSong : this.songs) {
            if(checkedSong.getSongTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, List<Song> playList) {
        int index = trackNumber - 1;
        if(index >= 0 && index < this.songs.size()) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This Album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getAlbumName() {
        return this.albumName;
    }
}
