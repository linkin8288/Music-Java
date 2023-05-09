package music.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){

    }
    // If you don't find the song, return null
    public Song findSong(String title){
        for(Song checkedSong: songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    // This is a part of a method that adds a new song to a list of songs if it does not already exist in the list.

    public boolean addSong(String title, double duration) {
        // check if song exists or not
        // create findSong method
        // null means does not exist
        // creates a new Song object with the given title and duration values and adds it to the songs list.
        // Finally, the method returns true to indicate that the song was successfully added to the list.
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            System.out.println(title + "successfully added to the list");
            return true;
        }
        else {
            System.out.println("Song with name " + title + " already exist in the list");
            return false;
        }
    }
    // This returns false to indicate that the song was not added to the playlist.
    // index starts 0
    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have song with tracknumber" + trackNumber);
        return false;
    }
    // If a match is found, it adds the corresponding Song object to the PlayList and returns true.
    // it means "for each Song object in the ArrayList called songs, assign the Song object to the variable checkedSong".
    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title + "there is no such song in album");
        return false;
    }
}
