//package com.example.taylor.pk80;
//
//import android.app.Activity;
//import android.app.ListActivity;
//import android.content.Context;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Base64;
//import android.util.Log;
//import android.widget.ArrayAdapter;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpRequestBase;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.params.BasicHttpParams;
//
//import android.os.Bundle;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.Type;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//
///**
// * Created by Taylor on 10/15/2016.
// */
//
///**
// * Demonstrates how to use a twitter application keys to access a user's timeline
// */
//public class TwitterHashtagFeed{
//
//    private static final String LOG_TAG = "DownloadTwitterTask";
//    private activity_feed activity;
//    private String hashtag = "GODUCKS";
//
//    private Twitter tweets;
//
//    public Twitter getTweets(){
//        return tweets;
//    }
//
//    public void setTweets(Twitter t) {
//        tweets = t;
//        Log.i("tweets", t.toString());
//        activity.updateWithTweets(t);
//    }
//
//    public void downloadTweets(String hashtag, activity_feed activity) {
//        this.hashtag = hashtag;
//        this.activity = activity;
//        // download twitter timeline after first checking to see if there is a network connection
//        ConnectivityManager connMgr = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//
//        if (networkInfo != null && networkInfo.isConnected()) {
//            new DownloadTwitterTask().execute(hashtag);
//            //String stream = getTwitterStream(hashtag);
//            //Twitter twits = jsonToTwitter(stream);
//            //return twits;
//
//        } else {
//            Log.v(LOG_TAG, "No network connection available.");
//        }
//    }
//
//    // Uses an AsyncTask to download a Twitter user's timeline
//    private class DownloadTwitterTask extends AsyncTask<String, Void, String> {
//        final static String CONSUMER_KEY = "qMNwdnD5o7x3Up0F3NCLmhnyT";//TODO I think these are wrong idk what else it is
//        final static String CONSUMER_SECRET = "vRWBLR8EqKNJndamjczzT0BiUWfxsNAQnviPH29SWnRgrIuj7k";
//        final static String TwitterTokenURL = "https://api.twitter.com/oauth2/token";
//        final static String TwitterStreamURL = "https://api.twitter.com/1.1/search/tweets.json?q=%23";
//
//
//        @Override
//        protected String doInBackground(String... screenNames) {
//            String result = null;
//
//            if (screenNames.length > 0) {
//                result = getTwitterStream(screenNames[0]);
//            }
//            return result;
//        }
//
//        // onPostExecute convert the JSON results into a Twitter object (which is an Array list of tweets
//        @Override
//        protected void onPostExecute(String result) {
//            //Log.i("result 2", result);
//            Twitter twits = jsonToTwitter(result);
//
//
//            // lets write the results to the console as well
//            //for (Tweet tweet : twits) {
//            //    Log.i(LOG_TAG, tweet.getText());
//            //}
//
//            setTweets(twits);
//
//            // send the tweets to the adapter for rendering
//            //ArrayAdapter<Tweet> adapter = new ArrayAdapter<Tweet>(activity, android.R.layout.simple_list_item_1, twits);
//            //setListAdapter(adapter);
//        }
//
//        private class Statuses {
//            Twitter statuses;
//        }
//
//        // converts a string of JSON data into a Twitter object
//        private Twitter jsonToTwitter(String result) {
//            //Twitter tweetList = null;
//            Twitter twits = null;
//            if (result != null && result.length() > 0) {
//                try {
//                    Gson gson = new Gson();
//                    Statuses statuses = gson.fromJson(result, Statuses.class);
//                    twits = statuses.statuses;
//                    //Type collectionType = new TypeToken<Collection<Tweet>>(){}.getType();
//                    //tweetList = gson.fromJson(result, collectionType);
//                } catch (IllegalStateException ex) {
//                    // just eat the exception
//                    Log.i("json error", ex.getMessage());
//                }
//            }
//            Log.i("tweetList", twits.toString());
//            //twits = new ArrayList<Tweet>(tweetList);
//            return twits;
//        }
//
//        // convert a JSON authentication object into an Authenticated object
//        private Authenticated jsonToAuthenticated(String rawAuthorization) {
//            Authenticated auth = null;
//            if (rawAuthorization != null && rawAuthorization.length() > 0) {
//                try {
//                    Gson gson = new Gson();
//                    Log.i("gson? ",rawAuthorization);
//                    auth = gson.fromJson(rawAuthorization, Authenticated.class);
//                } catch (IllegalStateException ex) {
//                    // just eat the exception
//                }
//            }
//            return auth;
//        }
//
//        private String getResponseBody(HttpRequestBase request) {
//            StringBuilder sb = new StringBuilder();
//            try {
//
//                DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
//                HttpResponse response = httpClient.execute(request);
//                int statusCode = response.getStatusLine().getStatusCode();
//                String reason = response.getStatusLine().getReasonPhrase();
//
//                if (statusCode == 200) {
//
//                    HttpEntity entity = response.getEntity();
//                    InputStream inputStream = entity.getContent();
//
//                    BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
//                    String line = null;
//                    while ((line = bReader.readLine()) != null) {
//                        sb.append(line);
//                    }
//                } else {
//                    sb.append(statusCode + " " + reason);
//                }
//            } catch (UnsupportedEncodingException ex) {
//            } catch (ClientProtocolException ex1) {
//            } catch (IOException ex2) {
//            }
//            return sb.toString();
//        }
//
//        private String getTwitterStream(String screenName) {
//            String results = null;
//
//            // Step 1: Encode consumer key and secret
//            try {
//                // URL encode the consumer key and secret
//                String urlApiKey = URLEncoder.encode(CONSUMER_KEY, "UTF-8");
//                String urlApiSecret = URLEncoder.encode(CONSUMER_SECRET, "UTF-8");
//
//                // Concatenate the encoded consumer key, a colon character, and the
//                // encoded consumer secret
//                String combined = urlApiKey + ":" + urlApiSecret;
//
//                // Base64 encode the string
//                String base64Encoded = Base64.encodeToString(combined.getBytes(), Base64.NO_WRAP);
//
//                // Step 2: Obtain a bearer token
//                HttpPost httpPost = new HttpPost(TwitterTokenURL);
//                httpPost.setHeader("Authorization", "Basic " + base64Encoded);
//                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//                httpPost.setEntity(new StringEntity("grant_type=client_credentials"));
//                String rawAuthorization = getResponseBody(httpPost);
//                Authenticated auth = jsonToAuthenticated(rawAuthorization);
//
//                // Applications should verify that the value associated with the
//                // token_type key of the returned object is bearer
//                if (auth != null && auth.token_type.equals("bearer")) {
//
//                    // Step 3: Authenticate API requests with bearer token
//                    HttpGet httpGet = new HttpGet(TwitterStreamURL + screenName);
//
//                    // construct a normal HTTPS request and include an Authorization
//                    // header with the value of Bearer <>
//                    httpGet.setHeader("Authorization", "Bearer " + auth.access_token);
//                    httpGet.setHeader("Content-Type", "application/json");
//                    // update the results with the body of the response
//                    results = getResponseBody(httpGet);
//                    Log.i("results", results);
//                }
//            } catch (UnsupportedEncodingException ex) {
//            } catch (IllegalStateException ex1) {
//            }
//            return results;
//        }
//    }
//}
