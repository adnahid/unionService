package com.example.unionservice;

import static java.security.AccessController.getContext;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

import com.airbnb.lottie.LottieAnimationView;

import javaClass.dialog;

public class webViewActivity extends AppCompatActivity {

    WebView webView;

    LottieAnimationView Lottie;

    ProgressBar progressBar;
    public static String url = "";

    //dialog dialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);
        Lottie = findViewById(R.id.Lottie);
        progressBar.setVisibility(View.VISIBLE);


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(webViewActivity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        webView.setVisibility(View.GONE);
        Lottie.setVisibility(View.VISIBLE);


        if (networkInfo!=null && networkInfo.isConnected()){
            webView.setVisibility(View.VISIBLE);
            Lottie.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
        }else {
            //Lottie.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            //dialog.ShowDialogBox();
            ShowDialogBox();


//            new AlertDialog.Builder(webViewActivity.this)
//                    .setTitle("No Internet")
//                    .setMessage("Please Connect Your Internet")
//                    .setIcon(R.drawable.no_wifi)
//                    .show();
        }

    }
    public void ShowDialogBox(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(webViewActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_item, null);
        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(false);

        mView.findViewById(R.id.chancelBTN).setOnClickListener(v -> {
            Toast.makeText(webViewActivity.this,"Cancel", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();
        });

        mView.findViewById(R.id.okBTN).setOnClickListener(v -> {
            Toast.makeText(webViewActivity.this,"Back", Toast.LENGTH_SHORT).show();
            onBackPressed();
            finish();
            alertDialog.dismiss();
        });

        alertDialog.show();
    }
}