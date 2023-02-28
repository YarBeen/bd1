package tec.bd.weather;

public class Report {

    private float temperature;
    private float humidity;
    private float pressure;
    private float maxTemperature;
     private float minTemperature;
    private float feelsLike;

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(float maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(float minTemperature) {
        this.minTemperature = minTemperature;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }
   






    public Report() {

    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    public String stringReport(){
        return "FeelsLike " + this.feelsLike +"\nHumidity " +this.humidity+"\nPressure "+ this.pressure +"\n Temperature "+ this.temperature+"\nMaxTemp "+ this.maxTemperature+"\nMiTemp "+ this.minTemperature;
    }
}
