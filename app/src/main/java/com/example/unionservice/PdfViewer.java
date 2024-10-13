package com.example.unionservice;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PdfViewer extends AppCompatActivity {

    //PDFView pdfView;

    private WebView webView;
    Toolbar toolbar;
    public static String pdfUrl = "";

    public static String assetsName = "";
    LottieAnimationView myLottie;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.pdfviewer);
        //pdfView  = findViewById(R.id.pdfView);
        toolbar  = findViewById(R.id.toolbar);
        webView = findViewById(R.id.pdfWebView);
        myLottie = findViewById(R.id.myLottie);

        webView.setVisibility(View.INVISIBLE);
        myLottie.setVisibility(View.VISIBLE);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(webViewActivity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        if (networkInfo!=null && networkInfo.isConnected()){
            webView.setVisibility(View.VISIBLE);
            myLottie.setVisibility(View.GONE);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(pdfUrl);


        }else {
            myLottie.setVisibility(View.GONE);
            //dialog.ShowDialogBox();
            ShowDialogBox();

        }




//            pdfView.fromAsset(assetsName)
//                    .onLoad(new OnLoadCompleteListener() {
//                        @Override
//                        public void loadComplete(int nbPages) {
//                            pdfView.setVisibility(View.VISIBLE);
//                            myLottie.setVisibility(View.GONE);
//                        }
//                    })
//                    .load();
        }

    public void ShowDialogBox(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(PdfViewer.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_item, null);
        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(false);

        mView.findViewById(R.id.chancelBTN).setOnClickListener(v -> {
            Toast.makeText(PdfViewer.this,"Cancel", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();
        });

        mView.findViewById(R.id.okBTN).setOnClickListener(v -> {
            Toast.makeText(PdfViewer.this,"Back", Toast.LENGTH_SHORT).show();
            onBackPressed();
            finish();
            alertDialog.dismiss();
        });

        alertDialog.show();
    }

    }


