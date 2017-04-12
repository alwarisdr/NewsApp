package com.risplay.androidnewsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

import static com.risplay.androidnewsapp.R.id.publicdate;
import static com.risplay.androidnewsapp.R.id.publictime;

/**
 * Created by alwaris on 4/10/17.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String DATE_SEPARATOR = "T";
    private static final String TIME_END = "Z";

    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = getItem(position);

        //--1 Find the TextView in the list_item.xml layout with the ID sectionname
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.sectionname);
        // Get the section name from the current news object
        String sectionName = currentNews.getSectionName();
        // set this text on the  section TextView
        sectionTextView.setText(sectionName);

        //--2 Find the TextView in the list_item.xml layout with the ID title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        // Get the web title from the current news object
        String webtitle = currentNews.getWebTitle();
        // set this text on the  title TextView
        titleTextView.setText(webtitle);

        //--3
        // Get the publice date from the current news object
        String originaldate = currentNews.getPublicdate();
        String publicationdate;
        String publicationtime;

        if (originaldate.contains(DATE_SEPARATOR)){
            String[] parts = originaldate.split(DATE_SEPARATOR);
            publicationdate = parts[0];
            publicationtime = parts[1];
            if(publicationtime.contains(TIME_END)){
                String[] time = publicationtime.split(TIME_END);
                publicationtime = time[0];
            }
        }else {
            publicationdate = originaldate;
            publicationtime = originaldate;
        }

        // Find the TextView in the list_item.xml layout with the ID publicdate
        TextView dateTextView = (TextView) listItemView.findViewById(publicdate);
        // set this text on the  date TextView
        //dateTextView.setText(publicationdate);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        String newDateString;
        try {
            startDate = df.parse(publicationdate);
            newDateString = formatDate(startDate);
            dateTextView.setText(newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Find the TextView in the list_item.xml layout with the ID publicdate
        TextView timeTextView = (TextView) listItemView.findViewById(publictime);
        // set this text on the  date TextView
        timeTextView.setText(publicationtime);


        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }


     // Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }


    //Return the formatted date string (i.e. "4:30 PM") from a Date object.
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
