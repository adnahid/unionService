package HealthPackage;

import static android.app.ProgressDialog.show;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;
import com.example.unionservice.UnionHomePage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AmbulanceList extends AppCompatActivity {

    RecyclerView AmbulanceRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";

    //ArrayList<HashMap<String,String>> finalArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambulance_list);
        toolbar  = findViewById(R.id.toolbar);
        AmbulanceRecyclerView  = findViewById(R.id.AmbulanceRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        AmbulanceAdapter ambulanceAdapter = new AmbulanceAdapter();
        AmbulanceRecyclerView.setAdapter(ambulanceAdapter);
        AmbulanceRecyclerView.setLayoutManager(new LinearLayoutManager(AmbulanceList.this));

    }

    private class AmbulanceAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
            TextView dTitle,dName,shortDetails;
            ImageView diverImage,AmbmeassageImage,AmbCallImage;
            CardView ambCardview;

            public readHolder(@NonNull View itemView) {
                super(itemView);
                dTitle = itemView.findViewById(R.id.dTitle);
                dName = itemView.findViewById(R.id.dName);
                shortDetails = itemView.findViewById(R.id.shortDetails);
                AmbmeassageImage = itemView.findViewById(R.id.AmbmeassageImage);
                AmbCallImage = itemView.findViewById(R.id.AmbCallImage);
                diverImage = itemView.findViewById(R.id.diverImage);
                ambCardview = itemView.findViewById(R.id.ambCardview);


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


            View view = layoutInflater.inflate(R.layout.ambulance_item, parent, false);
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
                String titleTv  = hashMap.get("title");
                String diver_name = hashMap.get("name");
                String shortTitleTv  = hashMap.get("shortTitle");
                String phoneNumber = hashMap.get("phone");

            readHolder.ambCardview.startAnimation(AnimationUtils.loadAnimation(readHolder.ambCardview.getContext(),R.anim.recycler_anim02));

                readHolder.dTitle.setText(titleTv);
                readHolder.dName.setText(diver_name);
                readHolder.shortDetails.setText(shortTitleTv);
                //Picasso.get().load("").into(readHolder.diverImage);
                readHolder.AmbCallImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:"+phoneNumber));
                        startActivity(intent);
                    }
                });

                readHolder.AmbmeassageImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(Intent.ACTION_SEND);
//                        intent = Intent.createChooser(intent,"sms:"+phoneNumber);
//                        startActivity(intent);

                        Uri uri = Uri.parse("smsto:" + phoneNumber);

                        Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
                        // add the message at the sms_body extra field
                        smsSIntent.putExtra("sms_body", body);
                        try{
                            startActivity(smsSIntent);
                        } catch (Exception ex) {
                            Toast.makeText(AmbulanceList.this, "Your sms has failed...",
                                    Toast.LENGTH_LONG).show();
                            ex.printStackTrace();
                        }


                    }
                });




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
//    private void finalArrayListTable(){
//
//        finalArrayList = new ArrayList<>();
//
//        for ( int x=0; x<arrayList.size(); x++){
//
//            if ( x>1 && x%30==0){
//                hashMap = new HashMap<>();
//                hashMap.put("itemType","NativeAd");
//                finalArrayList.add(hashMap);
//            }
//
//            hashMap = arrayList.get(x);
//            finalArrayList.add(hashMap);
//        }
//
//    }


    public void DetailsTable(){

        arrayList = new ArrayList<>();
        hashMap = new HashMap<>();
        hashMap.put("title","Dr.Alli Hasan\nMbbs bsc dhaka Medical");
        hashMap.put("name","Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("shortTitle",  "batRog,jor etc");
        hashMap.put("image",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title","Dr.Alli Hasan\nMbbs bsc dhaka Medical");
        hashMap.put("name","Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("shortTitle",  "batRog,jor etc");
        hashMap.put("image",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title","Dr.Alli Hasan\nMbbs bsc dhaka Medical");
        hashMap.put("name","Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("shortTitle",  "batRog,jor etc");
        hashMap.put("image",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title","Dr.Alli Hasan\nMbbs bsc dhaka Medical");
        hashMap.put("name","Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("shortTitle",  "batRog,jor etc");
        hashMap.put("image",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title","Dr.Alli Hasan\nMbbs bsc dhaka Medical");
        hashMap.put("name","Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("shortTitle",  "batRog,jor etc");
        hashMap.put("image",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);

    }



}

