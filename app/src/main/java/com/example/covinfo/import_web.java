package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class import_web extends AppCompatActivity {

    WebView miVisorWeb;
    String url = "https://google.com/covid19-map/?hl=es-ES&mid=/m/0j799";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_web);

        miVisorWeb = (WebView) findViewById(R.id.visorWeb);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(url);


    }
}