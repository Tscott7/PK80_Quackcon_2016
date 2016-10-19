package com.example.taylor.pk80;

import android.app.ListActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import java.io.*;
import java.net.URLEncoder;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class activity_feed extends AppCompatActivity implements View.OnClickListener{
//    public ListView twitterView;
//    ArrayAdapter<Tweet> tweetAdapter;
//    Twitter tweets = new Twitter();
    private Button newsButton;
    private Button teamButton;
    private Button modaButton;
    private Button linksButton;
    private Button scheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        newsButton= (Button) findViewById(R.id.newsBtn);
        newsButton.setOnClickListener(this);

        teamButton = (Button) findViewById(R.id.teamBtn);
        teamButton.setOnClickListener(this);

        modaButton = (Button) findViewById(R.id.modaBtn);
        modaButton.setOnClickListener(this);

        linksButton = (Button) findViewById(R.id.linksBtn);
        linksButton.setOnClickListener(this);

        scheduleButton = (Button) findViewById(R.id.scheduleBtn);
        scheduleButton.setOnClickListener(this);

//        twitterView = (ListView) findViewById(android.R.id.list);
//        tweetAdapter = new ArrayAdapter<Tweet>(this,android.R.layout.simple_list_item_1, tweets);
//        twitterView.setAdapter(tweetAdapter);
//
//        TwitterHashtagFeed twitter = new TwitterHashtagFeed();
//        twitter.downloadTweets("GODUCKS", this);

    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.newsBtn) {
            View newsView = findViewById(R.id.activity_feed);
            newsView.setBackgroundResource(R.drawable.twitter_news);
        }
        else if(arg0.getId() == R.id.teamBtn){
            View teamView = findViewById(R.id.activity_feed);
            teamView.setBackgroundResource(R.drawable.twitter_team);
        }
        else if(arg0.getId() == R.id.modaBtn){
            Intent stadiumIntent = new Intent(this, activity_stadium.class);
            this.startActivity(stadiumIntent);
        }
        else if(arg0.getId() == R.id.linksBtn){
            Intent linkIntent = new Intent(this, activity_links.class);
            this.startActivity(linkIntent);
        }
        else if(arg0.getId() == R.id.scheduleBtn)
        {
            Intent scheduleIntent = new Intent(this, activity_schedule.class);
            this.startActivity(scheduleIntent);
        }
    }

//    public void updateWithTweets(Twitter tweets){
//        Log.i("update", "updated");
////         send the tweets to the adapter for rendering
//        this.tweets = tweets;
//        tweetAdapter.notifyDataSetChanged();
//
//    }
/*
    private class UsersAdapter extends ArrayAdapter<User> {
        public UsersAdapter(Context context, ArrayList<User> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Tweet tweet = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
            }
            // Lookup view for data population
            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
            // Populate the data into the template view using the data object
            tvName.setText(tweet.getText());
            tvHome.setText(tweet.getId());
            // Return the completed view to render on screen
            return convertView;
        }
    }*/

}
