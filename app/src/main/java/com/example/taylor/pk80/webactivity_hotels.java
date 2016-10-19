package com.example.taylor.pk80;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by Taylor on 10/16/2016.
 */

public class webactivity_hotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webactivity_hotel);

        WebView hotelViewer = (WebView) findViewById(R.id.hotelViewer);
        hotelViewer.loadUrl("https://uo-online.maps.arcgis.com/apps/View/index.html?appid=2ae9d63e340a448bbff90fb693c8e91f");
    }


}
