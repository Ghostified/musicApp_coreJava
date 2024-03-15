import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album (String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album () {
    }
    //method to add song
    public Song findSong (String title){
        //loop into the list to check if the song is existing
        for (Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null; //if there is no song
    }
    public boolean addSong (String title, double duration) {
        //check if song already exists in our album
        if (findSong(title) == null){
            songs.add(new Song(title, duration));
       //    System.out.println( title +  " successfully added to the list");
            return true;
        }
        else {
          //  System.out.println("Song with name " + title+ " already exists in the list ");
            return false;
        }
    }

    //fUnction to add song to the play list that must be already existing on the album
    //this would need  a linked list to show the previous and next song
    public boolean addToPlayList (int trackNumber, LinkedList<Song> Playlist) {
        int index = trackNumber -1 ;// the index of the song
        if(index > 0 && index <= this.songs.size ()){
            Playlist.add(this.songs.get(index));
            return true;
        }
        //System.out.println("this album does not have song with trackNumber " + trackNumber);
        return false;
    }

    //Takes string as a parameter and Linked List where to add to the playlist
    //if the song is already on the album, simply add to the play list
    public boolean addToPlayList (String title, LinkedList<Song> Playlist) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                Playlist.add(checkedSong);
                return true;
            }
        }
       // System.out.println(title + "There is no such song in the album");
        return false;
    }
}
