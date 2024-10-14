package com.example.unionservice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import javaClass.gmailClass;

public class MyselfAppsDetails extends AppCompatActivity {

    CircleImageView phone,gmail,facebook;

    gmailClass gmailClass;

    String Gmail = "myselfabout432@gmail.com";
    String Phone = "+8801648529374";

    String fb = "https://www.facebook.com/profile.php?id=100052377380714";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_myself_apps_details);
        phone = findViewById(R.id.phone);
        gmail = findViewById(R.id.gmail);
        facebook = findViewById(R.id.facebook);

        Picasso.get().load("https://cdn-icons-png.flaticon.com/128/5968/5968764.png").placeholder(R.color.white).into(facebook);
        Picasso.get().load("https://cdn-icons-png.flaticon.com/128/5968/5968534.png").placeholder(R.color.white).into(gmail);
        Picasso.get().load("https://cdn-icons-png.flaticon.com/128/3616/3616215.png").placeholder(R.color.white).into(phone);


        phone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+Phone));
                startActivity(intent);

            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_TEXT, "Text you want to share");
                startActivity(Intent.createChooser(intent, ""+Gmail));

                //gmailClass.gmailMethod();


            }
        });



        facebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Test Subject");
                shareIntent.putExtra(Intent.EXTRA_TITLE, "Test Title");
                shareIntent.putExtra(Intent.EXTRA_TEXT, fb);
                startActivity(Intent.createChooser(shareIntent, "Test Intent"));

            }
        });

    }
}