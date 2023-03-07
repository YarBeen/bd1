package tec.bd.cli;

import picocli.CommandLine;
import tec.bd.ApplicationContext;
import tec.bd.weather.model.Report;

@CommandLine.Command(name = "city", description = "Get weather forecast for city")
public class WeatherByCityCommand implements Runnable {

    private static ApplicationContext APP_CONTEXT = ApplicationContext.init();

    @CommandLine.Parameters(paramLabel = "<city name>", description = "city name to be resolved")
    private String cityName;

    @Override
    public void run() {

//
        var weatherService = APP_CONTEXT.getWeatherService();
        Report report = weatherService.getByCity(cityName);
        System.out.println("2");
       
        System.out.println(report);
    }
}
