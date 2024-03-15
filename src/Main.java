import java.util.*;

public class Main {
    //Create an array List of Albums
    private static  ArrayList <Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        //create an object of the album
        Album album = new Album("Days Before Rodeo","Travis Scott" );
        album.addSong("Coordinate", 4.5);
        album.addSong("Rodeo", 3.5);
        album.addSong("Escape", 2.7);
        album.addSong("Fein", 3.8);
        album.addSong("Beibs in the trap", 4.5);
        album.addSong("Butterfly Effect", 4.5);

        //add the album Days Before Rodeo to the Albums
        albums.add(album);

        album = new Album("Recovery", "Eminem");
        album.addSong("Not Afraid", 3.8);
        album.addSong("Toy Soldiers", 4.0);
        album.addSong ("No Love", 4.5);
        album.addSong("Mocking Bird", 4.3);
        album.addSong("Slim Shady", 3.1);
        album.addSong("Stan", 6.0);
        album.addSong("Rap God", 7.2);
        //add Recovery to albums
        albums.add(album);

        //create a Linked List of PlayList  called hipHop that contains songs from the two Albums
        LinkedList<Song> hipHop= new LinkedList<>();

        //Access the albums
        albums.get(0).addToPlayList("Coordinate", hipHop);
        albums.get(1).addToPlayList("Escape", hipHop);
        albums.get(0).addToPlayList("Rap God",hipHop);

        //Create a Linked List of playlist called Trap that contains songs from the two albums

        LinkedList<Song> trapMode = new LinkedList<>();
        albums.get(1).addToPlayList("Butterfly Effect",trapMode);
        albums.get(1).addToPlayList("Beibs in the trap",trapMode);
        albums.get(1).addToPlayList("Fein",trapMode);
        albums.get(1).addToPlayList("Coordinate",trapMode);
        albums.get(1).addToPlayList("Rap God",trapMode);
        albums.get(1).addToPlayList("Slim Shady",trapMode);

        play(trapMode);
        play(hipHop);
    }
    //method to play all songs
    private static void play(LinkedList<Song>playList){
        Scanner sc = new Scanner (System.in);
        boolean quit = false;
        boolean forward = true;

        //create iterator for the playlist Song
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("Play List has No Song");
        } else {
            System.out.println("Now Playing " + listIterator.next());
            printMenu();
        }

        //check that the user has not quit
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action ) {
                case 0 :
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1 :
                    if (!forward ) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now Playing" + listIterator.next().toString());
                    } else {
                        System.out.println("End of playlist");
                        forward = false;
                    }
                    break;
                case 2 :
                    if (forward) {
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing" + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Playing" + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println(" Start of the the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing" + listIterator.next(). toString());
                            forward = true;
                        } else {
                            System.out.println(" The end of the Playlist");
                        }
                    } break;
                case 4 :
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now Playing" + listIterator.next().toString());
                            //forward = true;
                        }
                        else {
                            if(listIterator.hasPrevious())
                            System.out.println("now playing" + listIterator.previous().toString());
                        }
                    }
            }
        }

    }

    //Method to print the menu on all the available option
    private static void printMenu(){
        System.out.println("Available Options\n press");
        System.out.println("0   - to quit \n +" +
                "1 - to play next song\n +" +
                "2 - to play previous song \n +" +
                "3 - to replay the current song \n+ " +
                "4 -  list of all songs \n +" +
                "5 - print all available options \n +" +
                "6 - delete current song ");
    }
 //iterate through the Song
    private static void printList (LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("------------------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-----------------------------");
    }
}