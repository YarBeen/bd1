/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.cli;

import picocli.CommandLine;
import tec.bd.ApplicationContext;
import tec.bd.weather.WeatherReport;

/**
 *
 * @author yarman
 */
@CommandLine.Command(name = "imn-zip", description = "Get weather forecast by zip code")
public class IMNZipCodeCommand implements Runnable {

    private static ApplicationContext APP_CONTEXT = ApplicationContext.init();

    @CommandLine.Parameters(paramLabel = "<city-name>", description = "city to be resolved")
    private int zipCode;

    @Override
    public void run() {
        var openWeatherService = APP_CONTEXT.openIMNProvider;
        var weatherReport = new WeatherReport(openWeatherService);
        var report = weatherReport.getByZipCode(Integer.valueOf(zipCode));
        System.out.println(report.stringReport());
    }

}

