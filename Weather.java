import java.util.ArrayList;
import java.util.List;

interface WeatherDisplay {
    void update(double temperature, double humidity, double pressure);
}

class WeatherStation {
    private List<WeatherDisplay> observers = new ArrayList<>();
    private double temperature;
    private double humidity;
    private double pressure;

    public void addObserver(WeatherDisplay observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherDisplay observer) {
        observers.remove(observer);
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherDisplay observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

class CurrentConditionsDisplay implements WeatherDisplay {
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}

class StatisticsDisplay implements WeatherDisplay {
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Statistics: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}

class ForecastDisplay implements WeatherDisplay {
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Forecast: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}

public class Weather {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        station.addObserver(currentDisplay);
        station.addObserver(statisticsDisplay);
        station.addObserver(forecastDisplay);

        station.setMeasurements(80, 65, 30.4);
        station.setMeasurements(82, 70, 29.2);
    }
}
