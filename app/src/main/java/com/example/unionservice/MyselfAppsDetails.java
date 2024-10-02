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

public class MyselfAppsDetails extends AppCompatActivity {

    CircleImageView phone,gmail,facebook;

    String fb = "https://www.facebook.com/profile.php?id=100052377380714&mibextid=ZbWKwL";

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
                intent.setData(Uri.parse("tel:"+MainActivity.phone));
                startActivity(intent);

            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"+MainActivity.gmail));
                //Only email apps should handle this
//                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject of the email");
//                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body of the email");
//                Check if there is an email client available to handle the intent
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                } else {
                    // Handle the case when no email client is available
                    Toast.makeText(MyselfAppsDetails.this, "No email client installed!", Toast.LENGTH_SHORT).show();
                }


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