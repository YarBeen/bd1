package tec.bd.weather.storage;

import tec.bd.weather.model.Report;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InMemoryWeatherReportStorage implements WeatherReportStorage {

    private Map<String, Report> db;

    public InMemoryWeatherReportStorage() {
        this.db = new LinkedHashMap<>();
    }

    /*
     * Esto tiene que ser implementado
     *
     */

    @Override
    public void save(Report report,String key) {
        db.put(key, report);
    }

    @Override
    public void remove(String reportKey) {
        this.db.remove(reportKey);
    }

    @Override
    public void update(String key, Report newReport) {
        this.db.remove(key);
        this.db.put(key, newReport);
    }

    @Override
    public Report find(String reportKey) {
        
            return db.get(reportKey);
        
    }

    @Override
    public List<Report> find() {
        return null;
    }
    @Override
    public String generateKey(String cityOrZip) {
        var now = java.time.LocalDate.now(); StringBuilder builder = new StringBuilder();
        builder.append(now.toString()).append("^").append(cityOrZip);
        return builder.toString();
        
    }

   
}
