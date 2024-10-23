package HealthPackage;

import android.content.Intent;
import android.net.Uri;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class PharmecyList extends AppCompatActivity {

    RecyclerView pharmecyRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pharmecy_list);
        toolbar = findViewById(R.id.toolbar);
        pharmecyRecyclerView  = findViewById(R.id.pharmecyRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        PharmecyAdapter pharmecyAdapter = new PharmecyAdapter();
        pharmecyRecyclerView.setAdapter(pharmecyAdapter);
        pharmecyRecyclerView.setLayoutManager(new LinearLayoutManager(PharmecyList.this));


    }

    private class PharmecyAdapter extends RecyclerView.Adapter{
        int Native = 0;
        int Read = 1;
        private class readHolder extends RecyclerView.ViewHolder{
            TextView amDiverName,amDiverNicName,amItemTitle1,amItemTitle2,amItemTitle3,amPlaceAddress;
            CircleImageView diverImage;
            CardView ambCardview,amDiverPhone,amDiverMessage;

            public readHolder(@NonNull View itemView) {
                super(itemView);
                amDiverName = itemView.findViewById(R.id.amDiverName);
                amDiverNicName = itemView.findViewById(R.id.amDiverNicName);
                amItemTitle1 = itemView.findViewById(R.id.amItemTitle1);
                amItemTitle2 = itemView.findViewById(R.id.amItemTitle2);
                amItemTitle3 = itemView.findViewById(R.id.amItemTitle3);
                amPlaceAddress = itemView.findViewById(R.id.amPlaceAddress);
                diverImage = itemView.findViewById(R.id.diverImage);
                ambCardview = itemView.findViewById(R.id.ambCardview);
                amDiverPhone = itemView.findViewById(R.id.amDiverPhone);
                amDiverMessage = itemView.findViewById(R.id.amDiverMessage);


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
            String name  = hashMap.get("name");
            String nicName = hashMap.get("nicName");
            String image  = hashMap.get("image");
            String phone = hashMap.get("phone");
            String title1  = hashMap.get("title1");
            String title2 = hashMap.get("title2");
            String title3  = hashMap.get("title3");
            String address = hashMap.get("address");



            readHolder.ambCardview.startAnimation(AnimationUtils.loadAnimation(readHolder.ambCardview.getContext(),R.anim.recycler_anim02));

            readHolder.amDiverName.setText(name);
            readHolder.amDiverNicName.setText(nicName);
            readHolder.amItemTitle1.setText(title1);
            readHolder.amItemTitle2.setText(title2);
            readHolder.amItemTitle3.setText(title3);
            readHolder.amPlaceAddress.setText(address);

            Picasso.get().load(image).placeholder(R.drawable.person).into(readHolder.diverImage);


            readHolder.amDiverPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+phone));
                    startActivity(intent);

                }
            });


            readHolder.amDiverMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("smsto:" +phone);
                    Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
                    smsSIntent.putExtra("sms_body", body);
                    try{
                        startActivity(smsSIntent);
                    } catch (Exception ex) {
                        Toast.makeText(PharmecyList.this, "Your sms has failed...",
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
        hashMap.put("name","ফার্মেসী");
        hashMap.put("nicName","মোঃ আবদুল হাকিম মোহন\n"+"রবি আহমেদ স্বরণ");
        hashMap.put("image","https://cdn-icons-png.flaticon.com/128/9069/9069004.png");
        hashMap.put("phone","০১৮৬১-১১৭৭১১,০১৮২৯-৮৮২৩৫১");
        hashMap.put("title1","জনপ্রিয় ফার্মেসী");
        hashMap.put("title3","সকল প্রকার দেশী-বিদেশী ঔষধ পাইকারী ও খুচরা বিক্রয় করা হয়।");
        hashMap.put("address","ডি.বি রোড, কানকিরহাট, সেনবাগ, নোয়াখালী।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ফার্মেসী");
        hashMap.put("nicName","মোঃ আবদুল হাকিম মোহন\n"+"রবি আহমেদ স্বরণ");
        hashMap.put("image","https://cdn-icons-png.flaticon.com/128/9069/9069004.png");
        hashMap.put("phone","০১৮৬১-১১৭৭১১,০১৮২৯-৮৮২৩৫১");
        hashMap.put("title1","জনপ্রিয় ফার্মেসী");
        hashMap.put("title3","সকল প্রকার দেশী-বিদেশী ঔষধ পাইকারী ও খুচরা বিক্রয় করা হয়।");
        hashMap.put("address","ডি.বি রোড, কানকিরহাট, সেনবাগ, নোয়াখালী।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ফার্মেসী");
        hashMap.put("nicName","মোঃ আবদুল হাকিম মোহন\n"+"রবি আহমেদ স্বরণ");
        hashMap.put("image","https://cdn-icons-png.flaticon.com/128/9069/9069004.png");
        hashMap.put("phone","০১৮৬১-১১৭৭১১,০১৮২৯-৮৮২৩৫১");
        hashMap.put("title1","জনপ্রিয় ফার্মেসী");
        hashMap.put("title3","সকল প্রকার দেশী-বিদেশী ঔষধ পাইকারী ও খুচরা বিক্রয় করা হয়।");
        hashMap.put("address","ডি.বি রোড, কানকিরহাট, সেনবাগ, নোয়াখালী।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ফার্মেসী");
        hashMap.put("nicName","মোঃ আবদুল হাকিম মোহন\n"+"রবি আহমেদ স্বরণ");
        hashMap.put("image","https://cdn-icons-png.flaticon.com/128/9069/9069004.png");
        hashMap.put("phone","০১৮৬১-১১৭৭১১,০১৮২৯-৮৮২৩৫১");
        hashMap.put("title1","জনপ্রিয় ফার্মেসী");
        hashMap.put("title3","সকল প্রকার দেশী-বিদেশী ঔষধ পাইকারী ও খুচরা বিক্রয় করা হয়।");
        hashMap.put("address","ডি.বি রোড, কানকিরহাট, সেনবাগ, নোয়াখালী।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ফার্মেসী");
        hashMap.put("nicName","মোঃ আবদুল হাকিম মোহন\n"+"রবি আহমেদ স্বরণ");
        hashMap.put("image","https://cdn-icons-png.flaticon.com/128/9069/9069004.png");
        hashMap.put("phone","০১৮৬১-১১৭৭১১,০১৮২৯-৮৮২৩৫১");
        hashMap.put("title1","জনপ্রিয় ফার্মেসী");
        hashMap.put("title3","সকল প্রকার দেশী-বিদেশী ঔষধ পাইকারী ও খুচরা বিক্রয় করা হয়।");
        hashMap.put("address","ডি.বি রোড, কানকিরহাট, সেনবাগ, নোয়াখালী।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ফার্মেসী");
        hashMap.put("nicName","মোঃ আবদুল হাকিম মোহন\n"+"রবি আহমেদ স্বরণ");
        hashMap.put("image","https://cdn-icons-png.flaticon.com/128/9069/9069004.png");
        hashMap.put("phone","০১৮৬১-১১৭৭১১,০১৮২৯-৮৮২৩৫১");
        hashMap.put("title1","জনপ্রিয় ফার্মেসী");
        hashMap.put("title3","সকল প্রকার দেশী-বিদেশী ঔষধ পাইকারী ও খুচরা বিক্রয় করা হয়।");
        hashMap.put("address","ডি.বি রোড, কানকিরহাট, সেনবাগ, নোয়াখালী।");
        arrayList.add(hashMap);





    }
}



