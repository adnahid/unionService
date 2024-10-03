package ItemLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.unionservice.MainActivity;
import com.example.unionservice.R;

import Upzila.UpzilaPersonProfile;

public class LRDWProfileActivity extends AppCompatActivity {


    public static String AdName = "";
    public static String AdTitle = "";
    public static String AdCh01 = "";
    public static String AdCh01Des = "";
    public static String AdCh02 = "";
    public static String AdCh02Des = "";
    public static String AdPh = "";
    public static String AdGm = "";

    public static Bitmap ImageBitmap = null;

    String body = "Hi there";
    ImageView advocateImage;
    TextView advocateName,advocateTitle,advocateCh01,advocateCh01des,advocateCh02,advocateCh02des;
    CardView advocatePhone,advocateGmail,advocateMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lrdwprofile);
        advocateImage = findViewById(R.id.advocateImage);
        advocateName = findViewById(R.id.advocateName);
        advocateTitle = findViewById(R.id.advocateTitle);
        advocateCh01 = findViewById(R.id.advocateCh01);
        advocateCh01des = findViewById(R.id.advocateCh01des);
        advocateCh02 = findViewById(R.id.advocateCh02);
        advocateCh02des = findViewById(R.id.advocateCh02des);
        advocatePhone = findViewById(R.id.advocatePhone);
        advocateGmail = findViewById(R.id.advocateGmail);
        advocateMessage = findViewById(R.id.advocateMessage);

        advocateName.setText(AdName);
        advocateTitle.setText(AdTitle);
        advocateCh01.setText(AdCh01);
        advocateCh01des.setText(AdCh01Des);
        advocateCh02.setText(AdCh02);
        advocateCh02des.setText(AdCh02Des);

        advocatePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+AdPh));
                startActivity(intent);

            }
        });

        advocateGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_TEXT, "Text you want to share");
                startActivity(Intent.createChooser(intent, ""+AdGm));

            }
        });


        advocateMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" +AdPh);
                Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsSIntent.putExtra("sms_body", body);
                try{
                    startActivity(smsSIntent);
                } catch (Exception ex) {
                    Toast.makeText(LRDWProfileActivity.this, "Your sms has failed...",
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }

            }
        });


        if (ImageBitmap!=null){
            advocateImage.setImageBitmap(ImageBitmap);
        }

    }
}