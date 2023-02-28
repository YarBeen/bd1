package tec.bd.weather.service;

import retrofit2.Call;

import java.util.Map;
import tec.bd.weather.Report;

public class OpenWeatherService implements WeatherService {

    private final static String API_KEY = "c559e941a0da745aa0139aef272bf16c";

    private final OpenWeatherResource openWeatherResource;

    public OpenWeatherService(OpenWeatherResource openWeatherResource) {
        this.openWeatherResource = openWeatherResource;
    }

//    @Override
//    public float getTemperature(int zipCode) {
//        try {
//            var options = queryStringZipOptions(String.valueOf(zipCode));
//            Call<OpenWeatherReport> openWeatherReportCall = this.openWeatherResource.get(options);
//            OpenWeatherReport openWeatherReport = openWeatherReportCall.execute().body();
//            return openWeatherReport.getMain().getTemp();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException("Error when calling open weather remote API");
//        }
//    }

    private Map<String, String> queryStringZipOptions(String zipCode) {
        return Map.of("zip", zipCode, "appId", API_KEY);
    }

    @Override
    public Report byZipCode(int zipCode) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      try {
            var options = queryStringZipOptions(String.valueOf(zipCode));
            Call<OpenWeatherReport> openWeatherReportCall = this.openWeatherResource.get(options);
            OpenWeatherReport openWeatherReport = openWeatherReportCall.execute().body();
            var system = openWeatherReport.getMain();
            Report report = new Report();
            report.setTemperature(system.getTemp());
            // por el resto de gets
            return report;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error when calling open weather remote API");
        }
      
    }
    private Map<String, String> queryStringCityOptions(String city) {
        return Map.of("q", city, "appId", API_KEY);
    }

    @Override
    public Report byCity(String city) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      return new Report();
    }
}
