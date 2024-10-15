class Light {
    public void turnOn() {
        System.out.println("Lights are ON");
    }
    public void turnOff() {
        System.out.println("Lights are OFF");
    }
}
class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Temperature set to: " + temperature + "°C");
    }
}
class SecuritySystem {
    public void activate() {
        System.out.println("Security system activated.");
    }
    public void deactivate() {
        System.out.println("Security system deactivated.");
    }
}
class EntertainmentSystem {
    public void startMovie() {
        System.out.println("Movie mode activated.");
    }
}
class SmartHomeFacade {
    private final Light light;
    private final Thermostat thermostat;
    private final SecuritySystem securitySystem;
    private final EntertainmentSystem entertainmentSystem;
    public SmartHomeFacade() {
        light = new Light();
        thermostat = new Thermostat();
        securitySystem = new SecuritySystem();
        entertainmentSystem = new EntertainmentSystem();
    }
    public void leaveHome() {
        light.turnOff();
        securitySystem.activate();
        System.out.println("Leaving home");
    }
    public void arriveHome() {
        light.turnOn();
        securitySystem.deactivate();
        System.out.println("Arriving home");
    }
    public void nightMode() {
        light.turnOff();
        thermostat.setTemperature(18);
        System.out.println("Night mode activated");
    }
    public void movieMode() {
        light.turnOff();
        entertainmentSystem.startMovie();
        System.out.println("Movie mode activated");
    }
}
public class SmartHomeApp {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();
        smartHome.arriveHome();
        smartHome.nightMode();
        smartHome.movieMode();
        smartHome.leaveHome();
    }
}
