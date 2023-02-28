/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.weather.service;

import tec.bd.weather.Report;

/**
 *
 * @author yarman
 */
public class IMNProvider implements WeatherService {

    @Override
    public Report byZipCode(int zipCode) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       var report = new Report();
       report.setMaxTemperature(10);
       report.setMinTemperature(-40);
       report.setHumidity(45);
       report.setPressure(5);
       report.setTemperature(7);
       return report;
    }

    @Override
    public Report byCity(String city) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  var report = new Report();
       report.setMaxTemperature(10);
       report.setMinTemperature(-40);
       report.setHumidity(45);
       report.setPressure(5);
       report.setTemperature(7);
       return report;
    }
    
}
