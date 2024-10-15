interface VideoLecture {
    void getInfo();
    void play();
}
class RealVideoLecture implements VideoLecture {
    private final String title;

    public RealVideoLecture(String title) {
        this.title = title;
        loadVideo();
    }
    private void loadVideo() {
        System.out.println("Loading video: " + title);
    }
    @Override
    public void getInfo() {
        System.out.println("Video Title: " + title);
    }
    @Override
    public void play() {
        System.out.println("Playing video: " + title);
    }
}
class ProxyVideoLecture implements VideoLecture {
    private RealVideoLecture realVideoLecture;
    private final String title;

    public ProxyVideoLecture(String title) {
        this.title = title;
    }
    @Override
    public void getInfo() {
        if (realVideoLecture == null) {
            realVideoLecture = new RealVideoLecture(title);
        }
        realVideoLecture.getInfo();
    }
    @Override
    public void play() {
        if (realVideoLecture == null) {
            realVideoLecture = new RealVideoLecture(title);
        }
        realVideoLecture.play();
    }
}
public class LearningPlatformApp {
    public static void main(String[] args) {
        VideoLecture video1 = new ProxyVideoLecture("Design Patterns");
        video1.getInfo();
        video1.play();
    }
}
