package com.mink.springtest.thymeleaf.test04.domain;

import java.time.LocalDate;

public class Weatherhistory {
    private LocalDate date;
    private  String weather;
    private double temperatures;
    private double precipitation;
    private  String microDust;
    private double windSpeed;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(double temperatures) {
        this.temperatures = temperatures;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public String getMicroDust() {
        return microDust;
    }

    public void setMicroDust(String microDust) {
        this.microDust = microDust;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
