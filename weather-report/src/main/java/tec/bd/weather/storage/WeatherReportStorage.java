package tec.bd.weather.storage;

import tec.bd.weather.model.Report;

import java.util.List;

public interface WeatherReportStorage {

    void save(Report report,String key);

    void remove(String reportKey);

    void update(String key, Report newReport);

    Report find(String reportKey);

    List<Report> find();
    String generateKey(String cityOrZip);
}
