package HealthPackage;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.unionservice.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;

import javaClass.BloodPage;

public class BloodGrouphList extends AppCompatActivity {

    //public static boolean BloodGroup = true;

    //FrameLayout bloodFrameLayout;
    Toolbar toolbar;

    CardView aPositive,aNagitive,bPositive,bNegitive,oPositive,oNegitive,abPositive,abNagitive;



//    ViewPager BloodViewPager;
//    TabLayout BloodTabLayout;
//
//    TabItem bloodAPos,bloodANeg,bloodBPos,bloodBNeg,bloodOPos,bloodONeg,bloodAbPos,bloodAbNeg;
//    BloodPage bloodPage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blood_grouph_list);
        toolbar = findViewById(R.id.toolbar);
        aPositive = findViewById(R.id.aPositive);
        aNagitive = findViewById(R.id.aNagitive);
        bPositive = findViewById(R.id.bPositive);
        bNegitive = findViewById(R.id.bNegitive);
        oPositive = findViewById(R.id.oPositive);
        oNegitive = findViewById(R.id.oNegitive);
        abPositive = findViewById(R.id.abPositive);
        abNagitive = findViewById(R.id.abNagitive);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bloodFrameLayout, new ABpositive());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.bloodFrameLayout, new BNegitive());
//        fragmentTransaction.commit();



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
//
//        toolbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//                finish();
//            }
//        });


//        drawerLayout = findViewById(R.id.drawerLayout);
//        materialToolbar = findViewById(R.id.materialToolbar);
//        navigationView = findViewById(R.id.navigationView);



        aPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bloodFrameLayout, new FragmentApositive());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });

        aNagitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bloodFrameLayout, new ABNegitive());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


        bPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bloodFrameLayout, new Bpositive());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


        bNegitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bloodFrameLayout, new BNegitive());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });




        oPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bloodFrameLayout, new Opositive());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        oNegitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bloodFrameLayout, new ONegitive());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });


        abPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bloodFrameLayout, new ABpositive());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });




        abNagitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.bloodFrameLayout, new ABNegitive());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });






    }


}