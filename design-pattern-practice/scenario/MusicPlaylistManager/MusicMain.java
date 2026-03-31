package scenario.MusicPlaylistManager;

public class MusicMain {

	public static void main(String[] args) {
		PlayListManager manager = new PlayListManager();

		try {
			manager.addSong(new Song(1, "Kesariya", "Arijit Singh"));
			manager.addSong(new Song(2, "Believer", "Imagine Dragons"));
			manager.addSong(new Song(3, "Naatu Naatu", "RRR"));

			manager.addSong(new Song(2, "Believer", "Imagine Dragons")); // duplicate -> exception
		} catch (SongAlreadyExistsException e) {
			System.out.println("Exception : " + e.getMessage());
		}
		
		manager.showPlayList();
		
		System.out.println("\nPlaying Next: " + manager.playNext());
        System.out.println("Playing Song ID 3: " + manager.playSongById(3));

        manager.showPlayList();
        manager.showRecentlyPlayed();
	}
}
