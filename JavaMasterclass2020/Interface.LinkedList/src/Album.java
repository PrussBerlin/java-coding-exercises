import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    private String artist;
    private SongList songs;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.addSong(title, duration);
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(trackNumber);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This Album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public String getAlbumName() {
        return this.albumName;
    }
    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }
        public boolean addSong(String title, double duration) {
            if(findSong(title) == null) {
                Song song = new Song(title, duration);
                this.songs.add(song);
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
        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if(index >= 0 && index < this.songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}
