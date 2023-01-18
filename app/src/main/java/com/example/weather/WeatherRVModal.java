package com.example.weather;

public class WeatherRVModal {
    private String time;
    private String tempreture;
    private String windspeed;
    private String icon;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTempreture() {
        return tempreture;
    }

    public void setTempreture(String tempreture) {
        this.tempreture = tempreture;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public WeatherRVModal(String time, String tempreture, String windspeed, String icon) {
        this.time = time;
        this.tempreture = tempreture;
        this.windspeed = windspeed;
        this.icon = icon;
    }
}
