package application;
import java.util.Comparator;
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
	public Song(String song,String artist,String album,int year) {
		this.artist = artist;
		this.album = album;
		this.song = song;
		this.year = year;
	}
	public Song(String song,String artist) {
		this(song, artist, "NULL", 0);
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
	@Override
	public String toString() {
		return song+" "+artist+" "+album+" "+year;
	}
	public static Comparator<Song>
	nameComparator = new Comparator<Song>() {

		@Override
		public int compare(Song o1, Song o2) {
			String string = o1.getSong();
			String string2 = o2.getSong();
			String string3 = o1.getArtist();
			String string4 = o2.getArtist();
			if(string.compareTo(string2)==0) return string3.compareTo(string4);
			return string.compareTo(string2);
		}
	};
}
