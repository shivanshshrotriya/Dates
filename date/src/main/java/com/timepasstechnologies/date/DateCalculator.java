package com.timepasstechnologies.date;

import android.text.format.DateFormat;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalculator {

    public int getDaysInMonth(int month,int year) {

        boolean isLeap = false;
        int return_value=0;

        if (month<=0 || month>12 || year<=0)
        {
            return_value = 0;
        }
        else {
            if(year % 4 == 0)
            {
                if( year % 100 == 0)
                {
                    if ( year % 400 == 0)
                        isLeap = true;
                    else
                        isLeap = false;
                }
                else
                    isLeap = true;
            }
            else {
                isLeap = false;
            }

            if (isLeap==true && month==2)

            {
                return_value=29;
            }

            else if(isLeap==false && month==2)
            {
                return_value=28;
            }

            else if (month==4 || month==6 || month==9 || month==11)
            {
                return_value=30;
            }

            else {
                return_value=31;
            }

        }
        return return_value;
    }


    public String getTimeBetweenDates(String start_at, String end_at)
    {
        Date start_d=null,end_d=null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        try {
            start_d = sdf.parse(start_at);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        try {
            end_d = sdf.parse(end_at);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        int diff = (int) (end_d.getTime()- start_d.getTime());

        int timeInSeconds = diff / 1000;
        int hours, minutes, seconds;
        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        timeInSeconds = timeInSeconds - (minutes * 60);
        seconds = timeInSeconds;

        return hours+":"+minutes+":"+seconds;
    }

    public String addTime( String Duration_1, String Duration_2)
    {
        Date start_d=null,end_d=null;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            start_d = sdf.parse(Duration_1);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        try {
            end_d = sdf.parse(Duration_2);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        int s_hh = Integer.parseInt((String) DateFormat.format("HH", start_d)) ;
        int s_mm = Integer.parseInt((String) DateFormat.format("mm", start_d));
        int s_ss = Integer.parseInt((String) DateFormat.format("ss", start_d)) ;

        int e_hh = Integer.parseInt((String) DateFormat.format("HH", end_d)) ;
        int e_mm = Integer.parseInt((String) DateFormat.format("mm", end_d));
        int e_ss = Integer.parseInt((String) DateFormat.format("ss", end_d)) ;


        int timeInSeconds =  ((e_hh+s_hh)*3600)+((e_mm+s_mm)*60) +(e_ss+s_ss);

        int hours, minutes, seconds;
        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        timeInSeconds = timeInSeconds - (minutes * 60);
        seconds = timeInSeconds;

        return hours+":"+minutes+":"+seconds;
    }

    public String subtractTime(String Duration_1, String Duration_2)
    {

        Date start_d=null,end_d=null;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            start_d = sdf.parse(Duration_1);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        try {
            end_d = sdf.parse(Duration_2);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }


        int s_hh = Integer.parseInt((String) DateFormat.format("HH", start_d)) ;
        int s_mm = Integer.parseInt((String) DateFormat.format("mm", start_d));
        int s_ss = Integer.parseInt((String) DateFormat.format("ss", start_d)) ;

        int e_hh = Integer.parseInt((String) DateFormat.format("HH", end_d)) ;
        int e_mm = Integer.parseInt((String) DateFormat.format("mm", end_d));
        int e_ss = Integer.parseInt((String) DateFormat.format("ss", end_d)) ;


        int timeInSeconds =  ((s_hh-e_hh)*3600)+((s_mm-e_mm)*60) +(s_ss-e_ss);

        int hours, minutes, seconds;
        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        timeInSeconds = timeInSeconds - (minutes * 60);
        seconds = timeInSeconds;

        return hours+":"+minutes+":"+seconds;

    }

    public int getYear( String DateTime)
    {
        Date date=null;
        String pattern;
        if(DateTime.length()>10)
        {
            pattern = "yyyy:MM:dd HH:mm:ss";
        }
        else {
            pattern = "yyyy:MM:dd";
        }


        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(DateTime);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        return Integer.parseInt(""+DateFormat.format("yyyy",date));
    }

    public int getMonth(String DateTime)
    {
        Date date=null;
        String pattern;
        if(DateTime.length()>10)
        {
            pattern = "yyyy:MM:dd HH:mm:ss";
        }
        else {
            pattern = "yyyy:MM:dd";
        }


        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(DateTime);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        return Integer.parseInt(""+DateFormat.format("MM",date));
    }


    public int getDay(String DateTime)
    {
        Date date=null;
        String pattern;
        if(DateTime.length()>10)
        {
            pattern = "yyyy:MM:dd HH:mm:ss";
        }
        else {
            pattern = "yyyy:MM:dd";
        }


        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(DateTime);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        return Integer.parseInt(""+DateFormat.format("dd",date));
    }


    public int getHour(String DateTime)
    {
        Date date=null;
        String pattern;

        if(DateTime.length()>10)
        {
            pattern = "yyyy:MM:dd HH:mm:ss";
        }
        else {
            pattern = "HH:mm:ss";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(DateTime);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        return Integer.parseInt(""+DateFormat.format("HH",date));
    }


    public int getMinutes(String DateTime)
    {
        Date date=null;
        String pattern;
        if(DateTime.length()>10)
        {
            pattern = "yyyy:MM:dd HH:mm:ss";
        }
        else {
            pattern = "HH:mm:ss";
        }


        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(DateTime);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        return Integer.parseInt(""+DateFormat.format("mm",date));
    }

    public int getSeconds(String DateTime)
    {
        Date date=null;
        String pattern;
        if(DateTime.length()>10)
        {
            pattern = "yyyy:MM:dd HH:mm:ss";
        }
        else {
            pattern = "HH:mm:ss";
        }


        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            date = sdf.parse(DateTime);
        } catch (ParseException ex) {
            Log.v("Exception", ex.getLocalizedMessage());
        }

        return Integer.parseInt(""+DateFormat.format("ss",date));

    }

}
