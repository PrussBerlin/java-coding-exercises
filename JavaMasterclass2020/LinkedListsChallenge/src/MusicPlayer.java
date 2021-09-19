import java.util.LinkedList;
import java.util.List;

public class MusicPlayer {

    private List<Album> albums;
    private List<String> albumNames;
//    private ListIterator<String> albumNamesListIterator = albumNames.listIterator();
    private List<Song> playList;

    //Constructor
    public MusicPlayer(LinkedList<Album> albums) {
        this.albumNames = new LinkedList<>();
        this.albums = new LinkedList<>();
        this.playList = new LinkedList<>();
        for(int j = 0; j < albums.size(); j++) {
            addAlbum(albums.get(j));
        }
    }
    /** adds an album, tests if it exists, not in alphabetical order yet*/
    public boolean addAlbum(Album newAlbum) {
        String albumName = newAlbum.getAlbumName();
        for(int i = 0; i < albums.size(); i++) {
            String existingAlbumName = albums.get(i).getAlbumName();

            if (albumName.equals(existingAlbumName)) {
                System.out.println(albumName + " already exists, not added");
                return false;
            }
        }
        albumNames.add(albumName);
        albums.add(newAlbum);
        System.out.println(albumName + " added");
        return true;
    }

    public boolean addSongToPlayList(Song song) {

        String songName = song.getSongTitle();
        double songDuration = song.getSongDuration();
        for(int i = 0; i < albums.size(); i++) {
            List<Song> songs = albums.get(i).getSongs();
            for(int j = 0; j < songs.size(); j++) {
                String existingSongTitle = songs.get(j).getSongTitle();
                double existingSongDuration = songs.get(j).getSongDuration();
                if(songName.equals(existingSongTitle) && (songDuration == existingSongDuration)) {
                    this.playList.add(song);
                    System.out.println(song.getSongTitle() + " added");
                    return true;
                }
            }
        }
        System.out.println(song.getSongTitle() + " does not exist in your albums");
        return false;
    }

    public boolean removeSongFromPlayList(Song song) {
        String songName = song.getSongTitle();
        double songDuration = song.getSongDuration();
        for(int i = 0; i < playList.size(); i++) {
            String existingSongName = playList.get(i).getSongTitle();
            double existingSongDuration = playList.get(i).getSongDuration();
            if(songName.equals(existingSongName) && songDuration == existingSongDuration) {
                playList.remove(i);
                System.out.println(existingSongName + " removed from Playlist");
                return true;
            }
        }
        System.out.println("Song does not exist");
        return false;
    }

    public void showPlayList() {
        System.out.println("\t --PLAYLIST--");
        for(int i = 0; i < playList.size(); i++) {
            System.out.println(i + ".: " + playList.get(i).getSongTitle() + " - " + playList.get(i).getSongDuration() + "min");
        }

    }
}
