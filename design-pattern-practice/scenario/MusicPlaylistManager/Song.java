package scenario.MusicPlaylistManager;

import java.util.Objects;

public class Song {
	private int id;
	private String title;
	private String artist;
	public Song(int id, String title, String artist) {
		this.id = id;
		this.title = title;
		this.artist = artist;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Song)) return false;
		Song other = (Song) obj;
		return this.id == other.id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return "Song{ID: " + id + " Title: " + title  + " Artist: " + artist + "}";
	}
}
