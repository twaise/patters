interface AudioPlayer {
    void play(String audioType, String fileName);
}
class MP3Player implements AudioPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            System.out.println("Invalid media type for MP3Player");
        }
    }
}
interface WAVPlayer {
    void playWAV(String fileName);
}
interface AACPlayer {
    void playAAC(String fileName);
}
class AdvancedAudioPlayer implements WAVPlayer, AACPlayer {
    @Override
    public void playWAV(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }
    @Override
    public void playAAC(String fileName) {
        System.out.println("Playing AAC file: " + fileName);
    }
}
class AudioAdapter implements AudioPlayer {
    private final AdvancedAudioPlayer advancedAudioPlayer;

    public AudioAdapter() {
        advancedAudioPlayer = new AdvancedAudioPlayer();
    }
    @Override
    public void play(String audioType, String fileName) {
        switch (audioType.toLowerCase()) {
            case "wav":
                advancedAudioPlayer.playWAV(fileName);
                break;
            case "aac":
                advancedAudioPlayer.playAAC(fileName);
                break;
            default:
                System.out.println("Invalid media type");
        }
    }
}
public class MusicPlayerApp {
    public static void main(String[] args) {
        AudioPlayer mp3Player = new MP3Player();
        AudioPlayer audioAdapter = new AudioAdapter();
        mp3Player.play("mp3", "song.mp3");
        audioAdapter.play("wav", "track.wav");
        audioAdapter.play("aac", "audio.aac");
    }
}
