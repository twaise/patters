import java.util.ArrayList;
import java.util.List;

interface Iterator {
    boolean hasNext();
    Object next();
}

class Song {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Playlist {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public Iterator iterator() {
        return new PlaylistIterator();
    }

    private class PlaylistIterator implements Iterator {
        private int index;

        public boolean hasNext() {
            return index < songs.size();
        }

        public Object next() {
            return songs.get(index++);
        }
    }
}

public class PlaylistManagment {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Song 1"));
        playlist.addSong(new Song("Song 2"));
        playlist.addSong(new Song("Song 3"));

        Iterator iterator = playlist.iterator();
        while (iterator.hasNext()) {
            System.out.println(((Song) iterator.next()).getTitle());
        }
    }
}
