package application;
import java.util.jar.Attributes.Name;
import javax.management.loading.PrivateClassLoader;
public class Song {
	private String artist;
	private String song;
	private String album;
	private int year;
	public Song() {
		this.artist = "NULL";
		this.song = "NULL";
		this.album = "NULL";
		this.year = 0;
	}
	public Song(String artist,String song,String album,int year) {
		this.artist = artist;
		this.album = album;
		this.song = song;
		this.year = year;
	}
	public Song(String artist,String song) {
		this(artist, song, "", 0);
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
