package tec.bd.weather.service;

import tec.bd.weather.model.Report;
import tec.bd.weather.storage.WeatherReportStorage;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.util.Date;

public class WeatherServiceImpl implements WeatherService {

    private final WeatherService remoteWeatherProvider;

    private final WeatherReportStorage weatherReportStorage;

    public WeatherServiceImpl(WeatherService remoteWeatherProvider,
                              WeatherReportStorage weatherReportStorage) {

        this.remoteWeatherProvider = remoteWeatherProvider;
        this.weatherReportStorage = weatherReportStorage;
    }
    @Override
    public Report ByCity(String city){
        return null;
    }
    @Override
    public Report getByZipCode(String zipCode) {
        

        // 1. Solicitar el dato a el almacenamiento local. Se envia el zipCode y
        // el almacenamiento deberá de resolver si hay datos
        String key = this.weatherReportStorage.generateKey(zipCode);
        
        System.out.print(key);
        var report = this.weatherReportStorage.find(key);

        if (report != null) {
            return report;
        }

        // 2. Solicitar el reporte del clima de forma remota
        var weatheProviderReport = this.remoteWeatherProvider.getByZipCode(zipCode);

        // 3. Guardar el reporte obtenido de forma remota localmente
        weatherReportStorage.save(weatheProviderReport,key);

        return weatheProviderReport;
    }

    @Override
    public Report getByCity(String city) {
         // 1. Solicitar el dato a el almacenamiento local. Se envia el zipCode y
        // el almacenamiento deberá de resolver si hay datos
        String key = this.weatherReportStorage.generateKey(city);
        
        System.out.print(key);
        var report = this.weatherReportStorage.find(key);

        if (report != null) {
            return report;
        }

        // 2. Solicitar el reporte del clima de forma remota
        var weatheProviderReport = this.remoteWeatherProvider.getByCity(city);

        // 3. Guardar el reporte obtenido de forma remota localmente
        weatherReportStorage.save(weatheProviderReport,key);

        return weatheProviderReport;
    }

}
