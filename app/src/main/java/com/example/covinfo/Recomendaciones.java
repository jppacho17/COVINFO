package com.example.covinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Recomendaciones extends AppCompatActivity {

    WebView miVisorWeb;
    String url = "https://www.who.int/es/emergencies/diseases/novel-coronavirus-2019/advice-for-public";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendaciones);

        miVisorWeb = (WebView) findViewById(R.id.visorWeb2);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(url);


    }
}