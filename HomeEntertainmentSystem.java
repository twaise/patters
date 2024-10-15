interface Device {
    void powerOn();
    void powerOff();
    void setChannel(int channel);
    void setVolume(int volume);
}
class TVDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("TV is now ON.");
    }
    @Override
    public void powerOff() {
        System.out.println("TV is now OFF.");
    }
    @Override
    public void setChannel(int channel) {
        System.out.println("TV channel set to: " + channel);
    }
    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to: " + volume);
    }
}
class DVDDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("DVD Player is now ON.");
    }
    @Override
    public void powerOff() {
        System.out.println("DVD Player is now OFF.");
    }
    @Override
    public void setChannel(int channel) {
        System.out.println("DVD Player does not support channels.");
    }
    @Override
    public void setVolume(int volume) {
        System.out.println("DVD Player volume set to: " + volume);
    }
}
abstract class RemoteControl {
    protected Device device;
    public RemoteControl(Device device) {
        this.device = device;
    }
    public abstract void powerOn();
    public abstract void powerOff();
}
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }
    @Override
    public void powerOn() {
        device.powerOn();
    }
    @Override
    public void powerOff() {
        device.powerOff();
    }
}
public class HomeEntertainmentSystem {
    public static void main(String[] args) {
        Device tv = new TVDevice();
        RemoteControl remote = new BasicRemote(tv);
        remote.powerOn();
        remote.powerOff();
        Device dvd = new DVDDevice();
        RemoteControl dvdRemote = new BasicRemote(dvd);
        dvdRemote.powerOn();
    }
}
