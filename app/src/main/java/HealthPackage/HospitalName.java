package HealthPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.FourthFragment;
import com.example.unionservice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import HospitalNameList.ApplelyHospital;
import HospitalNameList.BangladeshDiabatic;
import HospitalNameList.BusurHuttCity;
import HospitalNameList.BusurHuttMaa;
import HospitalNameList.BusurHuttNursinHome;
import HospitalNameList.BusurHuttPrivate;
import HospitalNameList.BusurhuttDiagonosticcenter;
import HospitalNameList.CompanigongUnited;
import HospitalNameList.NewIbnasina;
import HospitalNameList.NewOposum;
import HospitalNameList.NewPopular;
import HospitalNameList.NewSquer;
import HospitalNameList.YeaminDantel;
import ItemLayout.DetailsUnion;

public class HospitalName extends AppCompatActivity {

    RecyclerView doctorListRecyclerGridView;


    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hospital_name2);
        doctorListRecyclerGridView = findViewById(R.id.doctorListRecyclerGridView);
        toolbar = findViewById(R.id.toolbar);


        UnionDetailsTable();
        DoctorListGirdAdapter doctorListGirdAdapter  = new DoctorListGirdAdapter();
        doctorListRecyclerGridView.setAdapter(doctorListGirdAdapter);
        doctorListRecyclerGridView.setLayoutManager(new GridLayoutManager(HospitalName.this,2));



    }

    private class DoctorListGirdAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
            TextView dcListTextTv;
            ImageView dcListImage;
            CardView dcListCard;


            public readHolder(@NonNull View itemView) {
                super(itemView);
                dcListTextTv = itemView.findViewById(R.id.dcListTextTv);
                dcListImage = itemView.findViewById(R.id.dcListImage);
                dcListCard = itemView.findViewById(R.id.dcListCard);



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

            View view = layoutInflater.inflate(R.layout.dc_hslist, parent, false);
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
            String hsName  = hashMap.get("hsName");
            String hsImage = hashMap.get("hsImage");



            readHolder.dcListCard.startAnimation(AnimationUtils.loadAnimation(readHolder.dcListCard.getContext(),R.anim.recycler_anim02));
            Picasso.get().load(hsImage).placeholder(R.drawable.doctor).into(readHolder.dcListImage);
            readHolder.dcListTextTv.setText(hsName);


            readHolder.dcListCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (position==0){
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, BusurHuttCity.class);
                        startActivity(intent);
                    }
                    else if (position==1) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, BusurHuttMaa.class);
                        startActivity(intent);
                    }
                    else if (position==2) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, YeaminDantel.class);
                        startActivity(intent);
                    }
                    else if (position ==3) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, BusurhuttDiagonosticcenter.class);
                        startActivity(intent);

                    }
                    else if (position==4) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, ApplelyHospital.class);
                        startActivity(intent);
                    }
                    else if (position == 5) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, NewPopular.class);
                        startActivity(intent);
                    }
                    else if (position == 6) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, NewOposum.class);
                        startActivity(intent);
                    }
                    else if (position == 7) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, CompanigongUnited.class);
                        startActivity(intent);
                    }
                    else if (position == 8) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, NewSquer.class);
                        startActivity(intent);
                    }
                    else if (position == 9) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, NewIbnasina.class);
                        startActivity(intent);
                    }
                    else if (position == 10) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, BusurHuttPrivate.class);
                        startActivity(intent);

                    }
                    else if (position == 11) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, BusurHuttNursinHome.class);
                        startActivity(intent);

                    }
                    else if (position == 12) {
                        Toast.makeText(HospitalName.this, ""+hsName, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HospitalName.this, BangladeshDiabatic.class);
                        startActivity(intent);

                    }


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
        hashMap.put("hsName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("hsName","বসুরহাট মা ও শিশু হাসপাতাল");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hsName","ইয়াসমিন ডেন্টাল কেয়ার");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hsName","বসুরহাট ডায়াগনষ্টিক সেন্টার");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hsName","অ্যাপোলো হসপিটাল");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hsName","নিউ পপুলার হসপিটাল");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hsName","নিউ উপশম হসপিটাল");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("hsName","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("hsName","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("hsName","নিউ ইবনে সিনা ডায়াগনস্টিক সেন্টার এন্ড হসপিটাল");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("hsName","বসুরহাট প্রাইভেট হাসপাতাল ইউনিট");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("hsName","বসুরহাট নার্সিংহোম");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("hsName","বাংলাদেশ ডায়াবেটিক্স জেনারেল হাসপাতাল");
        hashMap.put("hsImage","https://cdn-icons-png.flaticon.com/128/11404/11404937.png");
        arrayList.add(hashMap);










    }
}