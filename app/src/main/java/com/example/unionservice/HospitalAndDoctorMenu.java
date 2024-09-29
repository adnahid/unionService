package com.example.unionservice;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import HealthPackage.DoctorList;
import ItemLayout.DetailsUnion;

public class HospitalAndDoctorMenu extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView hospitalAndDoctorRecyclerView;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.hospital_and_doctor_menu);
        toolbar = findViewById(R.id.toolbar);
        hospitalAndDoctorRecyclerView = findViewById(R.id.hospitalAndDoctorRecyclerView);



        UnionDetailsTable();
        HospitalDoctorAdapter hospitalDoctorAdapter  = new HospitalDoctorAdapter();
        hospitalAndDoctorRecyclerView.setAdapter(hospitalDoctorAdapter);
        hospitalAndDoctorRecyclerView.setLayoutManager(new GridLayoutManager(HospitalAndDoctorMenu.this,3));

    }

    private class HospitalDoctorAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
            TextView hospitalName,hospitalDoctorList;
            ImageView doctor_hospitalImage;
            CardView hospitalItemCardView;

            public readHolder(@NonNull View itemView) {
                super(itemView);
                hospitalName = itemView.findViewById(R.id.hospitalName);
                hospitalDoctorList = itemView.findViewById(R.id.hospitalDoctorList);
                doctor_hospitalImage = itemView.findViewById(R.id.doctor_hospitalImage);
                hospitalItemCardView = itemView.findViewById(R.id.hospitalItemCardView);



            }
        }

//        private class nativeHolder extends RecyclerView.ViewHolder{
//            TemplateView my_template;
//
//            public nativeHolder(@NonNull View itemView) {
//                super(itemView);
//                my_template = itemView.findViewById(R.id.my_template);
//            }
//        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();

            View view = layoutInflater.inflate(R.layout.hospital_doctor_item, parent, false);
            return new readHolder(view);
//            if (viewType == Read) {
//                View view = layoutInflater.inflate(R.layout.ambulance_item, parent, false);
//                return new readHolder(view);
//
//            }

//            View view = layoutInflater.inflate(R.layout.native_item, parent, false);
//            return new nativeHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            //if (getItemViewType(position)==Read){
            readHolder readHolder = (readHolder) holder;
            hashMap = arrayList.get(position);
            //hashMap = finalArrayList.get(position);
            String hospitalName  = hashMap.get("hospitalName");
            String hospitalImage = hashMap.get("hospitalImage");






            readHolder.hospitalItemCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.hospitalItemCardView.getContext(),R.anim.recycler_anim02));
            Picasso.get().load(hospitalImage).placeholder(R.drawable.doctor).into(readHolder.doctor_hospitalImage);
            readHolder.hospitalName.setText(hospitalName);


            readHolder.hospitalItemCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HospitalAndDoctorMenu.this, DoctorList.class);
                    startActivity(intent);

                }
            });

//            readHolder.AmbmeassageImage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                        Intent intent = new Intent(Intent.ACTION_SEND);
////                        intent = Intent.createChooser(intent,"sms:"+phoneNumber);
////                        startActivity(intent);
//
//                    Uri uri = Uri.parse("smsto:" + phoneNumber);
//
//                    Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
//                    // add the message at the sms_body extra field
//                    smsSIntent.putExtra("sms_body", body);
//                    try{
//                        startActivity(smsSIntent);
//                    } catch (Exception ex) {
//                        Toast.makeText(AmbulanceList.this, "Your sms has failed...",
//                                Toast.LENGTH_LONG).show();
//                        ex.printStackTrace();
//                    }
//
//
//                }
//            });




            //}

//            else {
//                nativeHolder nativeHolder = (nativeHolder) holder;
//
//                AdLoader adLoader = new AdLoader.Builder(SadActivity.this, "ca-app-pub-8411075266548653/2415594861")
//                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
//                            @Override
//                            public void onNativeAdLoaded(NativeAd nativeAd) {
//                                nativeHolder.my_template.setNativeAd(nativeAd);
//                            }
//                        })
//                        .build();
//
//                adLoader.loadAd(new AdRequest.Builder().build());
//            }


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
            //return finalArrayList.size();
        }


//        @Override
//        public int getItemViewType(int position) {
//
//          //  hashMap = finalArrayList.get(position);
//            hashMap = arrayList.get(position);
//            String itemType = hashMap.get("itemType");
//            if (itemType.contains("read")) return Read;
//            else
//                return Native;
//
//        }

    }


    public void UnionDetailsTable(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("hospitalName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("hospitalImage","https://cdn-icons-png.flaticon.com/128/4320/4320371.png");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("hospitalName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("hospitalImage","https://cdn-icons-png.flaticon.com/128/4320/4320371.png");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("hospitalName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("hospitalImage","https://cdn-icons-png.flaticon.com/128/4320/4320371.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hospitalName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("hospitalImage","https://cdn-icons-png.flaticon.com/128/4320/4320371.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hospitalName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("hospitalImage","https://cdn-icons-png.flaticon.com/128/4320/4320371.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hospitalName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("hospitalImage","https://cdn-icons-png.flaticon.com/128/4320/4320371.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hospitalName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("hospitalImage","https://cdn-icons-png.flaticon.com/128/4320/4320371.png");
        arrayList.add(hashMap);




    }
}