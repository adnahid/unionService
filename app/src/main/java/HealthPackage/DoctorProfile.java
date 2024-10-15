package HealthPackage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.unionservice.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorProfile extends AppCompatActivity {
//
//    ViewPager BloodViewPager;
//    TabLayout BloodTabLayout;
//
//    TabItem bloodAPos,bloodANeg,bloodBPos,bloodBNeg,bloodOPos,bloodONeg,bloodAbPos,bloodAbNeg;
//    BloodPage bloodPage;

    public static String ToolText = "";
    public static String DCNAME = "";
    public static String DCTITLE = "";
    public static String DCSP = "";
    public static String DCED = "";
    public static String DCCHAMBER = "";
    public static String DCTIME = "";
    public static String DCNUMBRE = "";
    public static Bitmap ImageBitmap = null;


    CircleImageView doctorImage;
    CardView dcDail;
    TextView doctorName,dcTitle,dcSp,dcEd,dcChamber,doctorTime;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.doctor_profile);
//        BloodViewPager = findViewById(R.id.BloodViewPager);
//        BloodTabLayout = findViewById(R.id.BloodTabLayout);
//        bloodAPos = findViewById(R.id.bloodAPos);
//        bloodANeg = findViewById(R.id.bloodANeg);
//        bloodBPos = findViewById(R.id.bloodBPos);
//        bloodBNeg = findViewById(R.id.bloodBNeg);
//        bloodOPos = findViewById(R.id.bloodOPos);
//        bloodONeg = findViewById(R.id.bloodONeg);
//        bloodAbPos = findViewById(R.id.bloodAbPos);
//        bloodAbNeg = findViewById(R.id.bloodAbNeg);


        doctorImage = findViewById(R.id.doctorImage);
        doctorName = findViewById(R.id.doctorName);
        dcTitle = findViewById(R.id.dcTitle);
        dcDail = findViewById(R.id.dcDail);
        dcSp = findViewById(R.id.dcSp);
        dcEd = findViewById(R.id.dcEd);
        dcChamber = findViewById(R.id.dcChamber);
        doctorTime = findViewById(R.id.doctorTime);
        toolbar = findViewById(R.id.toolbar);




        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        doctorName.setText(DCNAME);
        dcTitle.setText(DCTITLE);
        dcSp.setText(DCSP);
        dcChamber.setText(DCCHAMBER);
        doctorTime.setText(DCTIME);
        dcEd.setText(DCED);
        toolbar.setTitle(ToolText);

        dcDail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                       intent.setData(Uri.parse("tel:"+DCNUMBRE));
                        startActivity(intent);
            }
        });

        if (ImageBitmap!=null){
            doctorImage.setImageBitmap(ImageBitmap);
        }

//        bloodPage = new BloodPage(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,BloodTabLayout.getTabCount());
//        BloodViewPager.setAdapter(bloodPage);
//
//
//        BloodTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                BloodViewPager.setCurrentItem(tab.getPosition());
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//        BloodViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(BloodTabLayout));

    }
}