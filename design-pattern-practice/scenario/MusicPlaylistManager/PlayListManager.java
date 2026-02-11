package scenario.MusicPlaylistManager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class PlayListManager {
	private LinkedList<Song> playList = new LinkedList<>();
	private Stack<Song> recentlyPlayed = new Stack<>();
	private HashSet<Song> uniqueSongs = new HashSet<>();
	
	// Add song
	public boolean addSong(Song song) throws SongAlreadyExistsException {
		
		if (uniqueSongs.contains(song)) {
			throw new SongAlreadyExistsException("Song already exists in playlist: " + song.getTitle());
		}
		playList.add(song);
		uniqueSongs.add(song);
		return true;
	}
	
	// Remove Song
	public boolean removeSongById(int songId) {
		Iterator<Song> it = playList.iterator();
		
		while (it.hasNext()) {
			Song s = it.next();
			if (s.getId() == songId) {
				it.remove();
				uniqueSongs.remove(s);
				return true;
			}
		}
		return false;
	}
	
	// Play next song
	public Song playNext() {
		
		if (playList.isEmpty()) {
			throw new NoSuchElementException("Playlist is empty!");
		}
		
		Song current = playList.removeFirst();
		recentlyPlayed.push(current);
		uniqueSongs.remove(current);
		return current;
	}
	
	// Play song by Id
	public Song playSongById(int songId) {
		
		for (int i = 0; i < playList.size(); i++) {
			Song s = playList.get(i);
			
			if (s.getId() == songId) {
				playList.remove(i);
				uniqueSongs.remove(s);
				recentlyPlayed.push(s);
				return s;
			}
		}
		throw new NoSuchElementException("Song not found with ID: " + songId);
	}
	
	// View playlist
	public List<Song> getPlayList() {
		return playList;
	}
	
	// View recently played
	public Stack<Song> getRecentlyPlayed() {
		return recentlyPlayed;
	}
	
	// Display
	public void showPlayList() {
		System.out.println("\n-------PlayList---------");
		for (Song s : playList) {
			System.out.println(s);
		}
	}
	
	// Show recently played
	public void showRecentlyPlayed() {
		System.out.println("\n-------Recently Played---------");
		for (int i = recentlyPlayed.size() - 1; i >= 0; i--) {
			System.out.println(recentlyPlayed.get(i));
		}
	}
}
