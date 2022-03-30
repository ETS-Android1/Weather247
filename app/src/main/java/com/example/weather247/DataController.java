package com.example.weather247;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataController {

    private static String realTime;
    private static String currentTemperature = "30";
    private static String currentCondition = "Sunny";
    private static String currentIcon = "http://cdn.weatherapi.com/weather/64x64/day/113.png";
    private static String currentHumidity = "70";
    private static String currentRealFeel = "25";
    private static String currentPressure = "1007";
    private static String currentChanceOfRain = "50";
    private static String currentWindSpeed = "11";
    private static String currentWindDir = "West";
    private static String currentUVIndex = "1";
    private static String currentPM2_5 = "32";
    private static String currentPM10 = "53";
    private static String currentSO = "3";
    private static String currentNO = "13";
    private static String currentO = "25";
    private static String currentCO = "660";
    private static String time1 = "00:00";
    private static String time2 = "00:00";
    private static String time3 = "00:00";
    private static String time4 = "00:00";
    private static String icon1 = "http://cdn.weatherapi.com/weather/64x64/day/113.png";
    private static String icon2 = "http://cdn.weatherapi.com/weather/64x64/day/113.png";
    private static String icon3 = "http://cdn.weatherapi.com/weather/64x64/day/113.png";
    private static String icon4 = "http://cdn.weatherapi.com/weather/64x64/day/113.png";
    private static String temp1 = "25";
    private static String temp2 = "25";
    private static String temp3 = "25";
    private static String temp4 = "25";

    public static void parseCurrentInformation(JSONObject urlResponseJson) {

        try {
            currentTemperature = urlResponseJson.getJSONObject("current").getString("temp_c");
            currentIcon = urlResponseJson.getJSONObject("current").getJSONObject("condition").getString("icon");
            currentIcon = "http:"+currentIcon;

            currentHumidity = urlResponseJson.getJSONObject("current").getString("humidity") + "%";
            currentRealFeel = urlResponseJson.getJSONObject("current").getString("feelslike_c") + "°C";
            currentPressure = urlResponseJson.getJSONObject("current").getString("pressure_mb") + "mb";

            JSONArray jsonArray1 = urlResponseJson.getJSONObject("forecast").getJSONArray("forecastday");
            currentChanceOfRain = jsonArray1.getJSONObject(0).getJSONObject("day").getString("daily_chance_of_rain") + "%";

            currentWindSpeed = urlResponseJson.getJSONObject("current").getString("wind_kph") + "kph";
            currentWindDir = urlResponseJson.getJSONObject("current").getString("wind_dir");
            currentUVIndex = urlResponseJson.getJSONObject("current").getString("uv");

            currentPM2_5 = urlResponseJson.getJSONObject("current").getJSONObject("air_quality").getString("pm2_5");
            currentPM10 = urlResponseJson.getJSONObject("current").getJSONObject("air_quality").getString("pm10");
            currentSO = urlResponseJson.getJSONObject("current").getJSONObject("air_quality").getString("so2");
            currentNO = urlResponseJson.getJSONObject("current").getJSONObject("air_quality").getString("no2");
            currentO = urlResponseJson.getJSONObject("current").getJSONObject("air_quality").getString("o3");
            currentCO = urlResponseJson.getJSONObject("current").getJSONObject("air_quality").getString("co");


            //hourly temperatures
            Date date = new Date();
            SimpleDateFormat dateFormat;
            dateFormat = new SimpleDateFormat("kk:mm");
            realTime = (String) dateFormat.format(date);
            int realTimeInt = getTimeInInteger(realTime);

            //00:00 to 03:00 hourly weather
            if(realTimeInt >= 0 && realTimeInt < 240){

                time1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(0).getString("time");
                time2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(1).getString("time");
                time3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(2).getString("time");
                time4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(3).getString("time");

                temp1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(0).getString("temp_c");
                temp2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(1).getString("temp_c");
                temp3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(2).getString("temp_c");
                temp4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(3).getString("temp_c");

                icon1 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(0).getJSONObject("condition").getString("icon");
                icon2 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(1).getJSONObject("condition").getString("icon");
                icon3 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(2).getJSONObject("condition").getString("icon");
                icon4 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(3).getJSONObject("condition").getString("icon");

            }

            //04:00 to 07:00 hourly weather
            if(realTimeInt >= 240 && realTimeInt < 480){

                time1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(4).getString("time");
                time2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(5).getString("time");
                time3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(6).getString("time");
                time4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(7).getString("time");

                temp1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(4).getString("temp_c");
                temp2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(5).getString("temp_c");
                temp3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(6).getString("temp_c");
                temp4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(7).getString("temp_c");

                icon1 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(4).getJSONObject("condition").getString("icon");
                icon2 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(5).getJSONObject("condition").getString("icon");
                icon3 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(6).getJSONObject("condition").getString("icon");
                icon4 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(7).getJSONObject("condition").getString("icon");

            }

            //08:00 to 11:00 hourly weather
            if(realTimeInt >= 480 && realTimeInt < 720){

                time1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(8).getString("time");
                time2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(9).getString("time");
                time3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(10).getString("time");
                time4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(11).getString("time");

                temp1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(8).getString("temp_c");
                temp2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(9).getString("temp_c");
                temp3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(10).getString("temp_c");
                temp4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(11).getString("temp_c");

                icon1 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(8).getJSONObject("condition").getString("icon");
                icon2 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(9).getJSONObject("condition").getString("icon");
                icon3 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(10).getJSONObject("condition").getString("icon");
                icon4 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(11).getJSONObject("condition").getString("icon");

            }

            //12:00 to 15:00 hourly weather
            if(realTimeInt >= 720 && realTimeInt < 960){

                time1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(12).getString("time");
                time2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(13).getString("time");
                time3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(14).getString("time");
                time4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(15).getString("time");

                temp1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(12).getString("temp_c");
                temp2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(13).getString("temp_c");
                temp3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(14).getString("temp_c");
                temp4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(15).getString("temp_c");

                icon1 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(12).getJSONObject("condition").getString("icon");
                icon2 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(13).getJSONObject("condition").getString("icon");
                icon3 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(14).getJSONObject("condition").getString("icon");
                icon4 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(15).getJSONObject("condition").getString("icon");

            }

            //16:00 to 19:00 hourly weather
            if(realTimeInt >= 960 && realTimeInt < 1200){

                time1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(16).getString("time");
                time2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(17).getString("time");
                time3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(18).getString("time");
                time4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(19).getString("time");

                temp1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(16).getString("temp_c");
                temp2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(17).getString("temp_c");
                temp3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(18).getString("temp_c");
                temp4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(19).getString("temp_c");

                icon1 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(16).getJSONObject("condition").getString("icon");
                icon2 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(17).getJSONObject("condition").getString("icon");
                icon3 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(18).getJSONObject("condition").getString("icon");
                icon4 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(19).getJSONObject("condition").getString("icon");

            }

            //20:00 to 23:00 hourly weather
            if(realTimeInt >= 1200 && realTimeInt < 1380){

                time1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(20).getString("time");
                time2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(21).getString("time");
                time3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(22).getString("time");
                time4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(23).getString("time");

                temp1 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(20).getString("temp_c");
                temp2 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(21).getString("temp_c");
                temp3 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(22).getString("temp_c");
                temp4 = jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(23).getString("temp_c");

                icon1 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(20).getJSONObject("condition").getString("icon");
                icon2 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(21).getJSONObject("condition").getString("icon");
                icon3 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(22).getJSONObject("condition").getString("icon");
                icon4 = "http:" + jsonArray1.getJSONObject(0).getJSONArray("hour").getJSONObject(23).getJSONObject("condition").getString("icon");


            }

            setCurrentTemperature(currentTemperature);
            setCurrentIcon(currentIcon);
            setCurrentHumidity(currentHumidity);
            setCurrentRealFeel(currentRealFeel);
            setCurrentPressure(currentPressure);
            setCurrentChanceOfRain(currentChanceOfRain);
            setCurrentWindSpeed(currentWindSpeed);
            setCurrentWindDir(currentWindDir);
            setCurrentUVIndex(currentUVIndex);
            setCurrentPM2_5(currentPM2_5);
            setCurrentPM10(currentPM10);
            setCurrentSO(currentSO);
            setCurrentNO(currentNO);
            setCurrentO(currentO);
            setCurrentCO(currentCO);

            setTime1(time1);
            setTime2(time2);
            setTime3(time3);
            setTime4(time4);

            setTemp1(temp1);
            setTemp2(temp2);
            setTemp3(temp3);
            setTemp4(temp4);

            setIcon1(icon1);
            setIcon2(icon2);
            setIcon3(icon3);
            setIcon4(icon4);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private static int getTimeInInteger(String time){

        String[] timeParts = time.split(":");

        int timeInt = (Integer.parseInt(timeParts[0]) * 60) + Integer.parseInt(timeParts[1]);

        return  timeInt;

    }


    public static void parseBasicInformation(JSONObject urlResponseJson) {

        try {
            currentTemperature = urlResponseJson.getJSONObject("current").getString("temp_c");
            currentCondition = urlResponseJson.getJSONObject("current").getJSONObject("condition").getString("text");
            currentIcon = urlResponseJson.getJSONObject("current").getJSONObject("condition").getString("icon");
            currentIcon = "http:"+currentIcon;

            setCurrentTemperature(currentTemperature);
            setCurrentCondition(currentCondition);
            setCurrentIcon(currentIcon);



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static String getIcon1() {
        return icon1;
    }

    public static void setIcon1(String icon1) {
        DataController.icon1 = icon1;
    }

    public static String getIcon2() {
        return icon2;
    }

    public static void setIcon2(String icon2) {
        DataController.icon2 = icon2;
    }

    public static String getIcon3() {
        return icon3;
    }

    public static void setIcon3(String icon3) {
        DataController.icon3 = icon3;
    }

    public static String getIcon4() {
        return icon4;
    }

    public static void setIcon4(String icon4) {
        DataController.icon4 = icon4;
    }

    public static String getTemp1() {
        return temp1;
    }

    public static void setTemp1(String temp1) {
        DataController.temp1 = temp1;
    }

    public static String getTemp2() {
        return temp2;
    }

    public static void setTemp2(String temp2) {
        DataController.temp2 = temp2;
    }

    public static String getTemp3() {
        return temp3;
    }

    public static void setTemp3(String temp3) {
        DataController.temp3 = temp3;
    }

    public static String getTemp4() {
        return temp4;
    }

    public static void setTemp4(String temp4) {
        DataController.temp4 = temp4;
    }

    public static String getTime1() {
        return time1;
    }

    public static void setTime1(String time1) {
        DataController.time1 = time1;
    }

    public static String getTime2() {
        return time2;
    }

    public static void setTime2(String time2) {
        DataController.time2 = time2;
    }

    public static String getTime3() {
        return time3;
    }

    public static void setTime3(String time3) {
        DataController.time3 = time3;
    }

    public static String getTime4() {
        return time4;
    }

    public static void setTime4(String time4) {
        DataController.time4 = time4;
    }

    public static String getCurrentHumidity() {
        return currentHumidity;
    }

    public static void setCurrentHumidity(String currentHumidity) {
        DataController.currentHumidity = currentHumidity;
    }

    public static String getCurrentRealFeel() {
        return currentRealFeel;
    }

    public static void setCurrentRealFeel(String currentRealFeel) {
        DataController.currentRealFeel = currentRealFeel;
    }

    public static String getCurrentPressure() {
        return currentPressure;
    }

    public static void setCurrentPressure(String currentPressure) {
        DataController.currentPressure = currentPressure;
    }

    public static String getCurrentChanceOfRain() {
        return currentChanceOfRain;
    }

    public static void setCurrentChanceOfRain(String currentChanceOfRain) {
        DataController.currentChanceOfRain = currentChanceOfRain;
    }

    public static String getCurrentWindSpeed() {
        return currentWindSpeed;
    }

    public static void setCurrentWindSpeed(String currentWindSpeed) {
        DataController.currentWindSpeed = currentWindSpeed;
    }

    public static String getCurrentWindDir() {
        return currentWindDir;
    }

    public static void setCurrentWindDir(String currentWindDir) {
        DataController.currentWindDir = currentWindDir;
    }

    public static String getCurrentUVIndex() {
        return currentUVIndex;
    }

    public static void setCurrentUVIndex(String currentUVIndex) {
        DataController.currentUVIndex = currentUVIndex;
    }

    public static String getCurrentPM2_5() {
        return currentPM2_5;
    }

    public static void setCurrentPM2_5(String currentPM2_5) {
        DataController.currentPM2_5 = currentPM2_5;
    }

    public static String getCurrentPM10() {
        return currentPM10;
    }

    public static void setCurrentPM10(String currentPM10) {
        DataController.currentPM10 = currentPM10;
    }

    public static String getCurrentSO() {
        return currentSO;
    }

    public static void setCurrentSO(String currentSO) {
        DataController.currentSO = currentSO;
    }

    public static String getCurrentNO() {
        return currentNO;
    }

    public static void setCurrentNO(String currentNO) {
        DataController.currentNO = currentNO;
    }

    public static String getCurrentO() {
        return currentO;
    }

    public static void setCurrentO(String currentO) {
        DataController.currentO = currentO;
    }

    public static String getCurrentCO() {
        return currentCO;
    }

    public static void setCurrentCO(String currentCO) {
        DataController.currentCO = currentCO;
    }

    public static String getCurrentTemperature() {
        return currentTemperature;
    }

    public static void setCurrentTemperature(String currentTemperature) {
        DataController.currentTemperature = currentTemperature;
    }

    public static String getCurrentCondition() {
        return currentCondition;
    }

    public static void setCurrentCondition(String currentCondition) {
        DataController.currentCondition = currentCondition;
    }

    public static String getCurrentIcon() {
        return currentIcon;
    }

    public static void setCurrentIcon(String currentIcon) {
        DataController.currentIcon = currentIcon;
    }

}
