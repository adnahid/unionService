package Upzila;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.unionservice.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpzilaPersonProfile extends AppCompatActivity {

    public static String UPGmail = "";
    public static String UPName = "";
    public static String UPLevel = "";
    public static String UPPhone = "";
    public static String UPJoinTimeTitle = "";
    public static String UPJoinTime = "";
    public static String UPBscBatch = "";
    public static String UPBscBatchNo = "";
    public static Bitmap ImageBitmap = null;
    String body = "Hi there";

    TextView nameUp,titleUp,textTvHeadLine1st,textTvHeadLine2nd,textTvHeadLine3rd,textTvHeadLine4th;
    CardView gmCardUp,callCardUp,meassagesUp;
    CircleImageView imageUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upzila_person_profile);
        gmCardUp = findViewById(R.id.gmCardUp);
        nameUp = findViewById(R.id.nameUp);
        titleUp = findViewById(R.id.titleUp);
        textTvHeadLine1st = findViewById(R.id.textTvHeadLine1st);
        textTvHeadLine2nd = findViewById(R.id.textTvHeadLine2nd);
        textTvHeadLine3rd = findViewById(R.id.textTvHeadLine3rd);
        textTvHeadLine4th = findViewById(R.id.textTvHeadLine4th);
        callCardUp = findViewById(R.id.callCardUp);
        meassagesUp = findViewById(R.id.meassagesUp);
        imageUp = findViewById(R.id.imageUp);


        nameUp.setText(UPName);
        titleUp.setText(UPLevel);
        textTvHeadLine1st.setText(UPJoinTimeTitle);
        textTvHeadLine2nd.setText(UPJoinTime);
        textTvHeadLine3rd.setText(UPBscBatch);
        textTvHeadLine4th.setText(UPBscBatchNo);

        callCardUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+UPPhone));
                startActivity(intent);
            }
        });

        meassagesUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" +UPPhone);
                Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsSIntent.putExtra("sms_body", body);
                try{
                    startActivity(smsSIntent);
                } catch (Exception ex) {
                    Toast.makeText(UpzilaPersonProfile.this, "Your sms has failed...",
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }

            }
        });



        gmCardUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"+UPGmail)); // Only email apps should handle this
//                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject of the email");
//                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body of the email");

// Check if there is an email client available to handle the intent
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                } else {
                    // Handle the case when no email client is available
                    Toast.makeText(UpzilaPersonProfile.this, "No email client installed!", Toast.LENGTH_SHORT).show();
                }

            }
        });



        if (ImageBitmap!=null){
            imageUp.setImageBitmap(ImageBitmap);
        }


    }
}