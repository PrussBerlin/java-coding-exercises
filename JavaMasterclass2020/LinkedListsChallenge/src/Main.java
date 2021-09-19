import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("love", 4.1);
        album.addSong("holy man", 4.22);
        album.addSong("hold on", 4.3);
        album.addSong("lady double dealer", 5.6);
        album.addSong("you cant do it right", 3.21);
        album.addSong("High Ball shooter", 3.21);
        album.addSong("The gypsy", 4.27);
        album.addSong("Solder of Fortune", 3.13);

        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those", 5.44);
        album.addSong("Finder", 5.3);
        album.addSong("Bring me on", 2.44);
        album.addSong("Wtf", 1.44);
        album.addSong("Chose", 4.44);
        album.addSong("to me", 2.44);
        album.addSong("whatever", 6.54);
        album.addSong("bla", 9.44);
        album.addSong("ups", 7.44);


        albums.add(album);

        List<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("The gypsy", playList);
        albums.get(0).addToPlayList("love", playList);
        albums.get(0).addToPlayList("test", playList); //does not exist

        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList); //does not exist

        play(playList);



    }

    private static void play(List<Song> playList) {

        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.isEmpty()) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("\nNow playing: " + listIterator.next().toString() + "\n");
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Playlist finished playing");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("Playlist finished playing");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(!playList.isEmpty()) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    } else {
                        System.out.println("No Songs in playlist");
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("======================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("======================");
    }






        //create Songs + Albums

//        ArrayList<Song> songs = new ArrayList<>();
//
//        for(int i = 0; i < 20; i++) {
//            String songTitle = "Song #" + i;
//            songs.add(new Song(songTitle, 3.33));
//        }
//
//        Album album1 = new Album("White Album - Beatles", songs);
//        Album album2 = new Album("Black Album - Beatles", songs);
//        Album album3 = new Album("Red Album - Beatles", songs);
//        Album album4 = new Album("Yellow Album - Beatles", songs);
//
//        LinkedList<Album> albums = new LinkedList<>();
//        albums.add(album1);
//        albums.add(album2);
//        albums.add(album3);
//        albums.add(album4);
//        albums.add(album4);
//        for(int k = 0; k < albums.size(); k++) {
//            System.out.println("AlbumList contains: " + albums.get(k).getAlbumName());
//        }


        //create MusicPlayer

//        MusicPlayer player1 = new MusicPlayer(albums);
//
//        for(int j = 0; j < 5; j++) {
//            player1.addSongToPlayList(songs.get(j));
//        }
//
//        player1.showPlayList();
//        player1.removeSongFromPlayList(songs.get(0));
//        player1.showPlayList();
//
//    }
//
//    public static void menu() {
//        System.out.println("0 - Quit");
//        System.out.println("1 - Skip to the next song");
//        System.out.println("2 - skip backwards");
//        System.out.println("3 - Replay current Song");
//        System.out.println("4 - show PlayList");
//    }
}
