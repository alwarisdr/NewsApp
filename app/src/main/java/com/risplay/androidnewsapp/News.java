package com.risplay.androidnewsapp;

/**
 * Created by alwaris on 4/10/17.
 */

public class News {

    // Section News
    private String mSectionName;

    // News headlines
    private String mWebTitle;

    /** Date public */
    private String mPublicdate;

    /** News website url */
    private String mUrl;


    /*
    * Create a new News object.
    *
    * @param mSectionName is a Type of news.
    * @param mWebtitle is the News headlines.
    * @param mPublicdate is  date public.
    * @param url is the news website URL to find more details about news.
    * */

    public News(String sectionName, String webTitle, String publicdate, String url)
    {
        mSectionName = sectionName;
        mWebTitle = webTitle;
        mPublicdate = publicdate;
        mUrl = url;
    }

    /**
     * Get section name
     */
    public String getSectionName() {
        return mSectionName;
    }

    /**
     * Get web title
     */
    public String getWebTitle() {
        return mWebTitle;
    }

    /**
     * Get publication date
     */
    public String getPublicdate() {
        return mPublicdate;
    }

    /**
     * Get news url
     */
    public String getUrl() {
        return mUrl;
    }
}
