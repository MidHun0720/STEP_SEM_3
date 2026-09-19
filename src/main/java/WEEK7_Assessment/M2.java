package WEEK7_Assessment;

class Playlist {
    private String[] songs;
    private int count;

    Playlist(int n) {
        songs = new String[n];
        count = 0;
    }

    void addSong(String s) {
        if (count < songs.length) {
            songs[count] = s;
            count = count + 1;
        }
    }

    String[] getSongs() {
        String[] c = new String[count];
        for (int i = 0; i < count; i++) {
            c[i] = songs[i];
        }
        return c;
    }

    int getSongCount() {
        return count;
    }
}

public class M2 {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println(p.getSongs()[0]);
        System.out.println(p.getSongCount());
    }
}
