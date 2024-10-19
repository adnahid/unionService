package NagorikSheba;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.example.unionservice.UnionHomePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import HealthPackage.AmbulanceList;

public class EmergencyNumber extends AppCompatActivity {

    RecyclerView emrRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    //ArrayList<HashMap<String,String>> finalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emergency_number);
        toolbar  = findViewById(R.id.toolbar);
        emrRecyclerView = findViewById(R.id.emrRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
               finish();
            }
        });



        EmrAdapter emrAdapter = new EmrAdapter();
        emrRecyclerView.setAdapter(emrAdapter);
        emrRecyclerView.setLayoutManager(new LinearLayoutManager(EmergencyNumber.this));

    }


    private class EmrAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
           TextView emrTextTv,emrNumberTv;
           ImageView emrImage;
           CardView emrCardView;

            public readHolder(@NonNull View itemView) {
                super(itemView);
                emrTextTv = itemView.findViewById(R.id.emrTextTv);
                emrNumberTv = itemView.findViewById(R.id.emrNumberTv);
                emrImage = itemView.findViewById(R.id.emrImage);
                emrCardView = itemView.findViewById(R.id.emrCardView);

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


            View view = layoutInflater.inflate(R.layout.emer_number_item, parent, false);
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
                String numberName  = hashMap.get("numberName");
                String number = hashMap.get("number");



                readHolder.emrCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.emrCardView.getContext(),R.anim.recycler_anim04));

//                Random rnd = new Random();
//                int color = Color.argb(220, rnd.nextInt(220), rnd.nextInt(220), rnd.nextInt(220));
//                readHolder.btnMeassage.setBackgroundColor(color);


                readHolder.emrTextTv.setText(numberName);
                String ermph = String.valueOf(number.toString());
                readHolder.emrNumberTv.setText(ermph);

                //Picasso.get().load("").into(readHolder.diverImage);

                readHolder.emrImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel:"+ermph));
                            startActivity(intent);
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
        hashMap.put("numberName","ইউনিয়ন পরিষদ হট লাইন");
        hashMap.put("number","16256");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","ডিজিএম (ডেসকো)");
        hashMap.put("number","১৬১২০");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","বিদ্যুৎ উন্নয়ন বোর্ড (পিডিবি)");
        hashMap.put("number","১৬২০০");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","পাসপোর্ট সেবা");
        hashMap.put("number","০২৯২৩১৯৬৭");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","বিমানবন্দর তথ্য কেন্দ্র");
        hashMap.put("number","০২৮৯০১৫০০");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","রেলওয়ে স্টেশন (কমলাপুর)");
        hashMap.put("number","১৩১");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","ইউনিয়ন পরিষদ হট লাইন");
        hashMap.put("number","16256");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","ডেসকো");
        hashMap.put("number","16120");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","বিটিসিএল");
        hashMap.put("number","0103874-45114");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","বিটিসিএল");
        hashMap.put("number","16402");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","জাতীয় পরিচয় পত্র");
        hashMap.put("number","105");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","দুদক");
        hashMap.put("number","106");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("numberName","স্বাস্থ্য সেবা");
        hashMap.put("number","16430");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","সরকারি আইন সহায়তা");
        hashMap.put("number","16123");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","কৃষি কল সেন্টার");
        hashMap.put("number","16123");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","তিতাস গ্যাস");
        hashMap.put("number","১৬৪৯৬");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","দুর্যোগ ব্যবস্থাপনা");
        hashMap.put("number","১০৯০");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","পানি ও পয়ঃনিষ্কাশন");
        hashMap.put("number","১৬১৬২");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","বন ও পরিবেশ অধিদপ্তর");
        hashMap.put("number","০১৭১৩৩৭৩৩৩৭");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("numberName","র\u200D্যাব");
        hashMap.put("number","101");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("numberName","এম্বুলেন্স সেবা");
        hashMap.put("number","199");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","জাতীয় হেলথ কেয়ার সেন্টার");
        hashMap.put("number","16263");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("numberName","জাতীয় মানসিক স্বাস্থ্য সহায়তা");
        hashMap.put("number","16363");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","আইইডিসিআর");
        hashMap.put("number","10655");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("numberName","বেসামরিক বিমান চলাচল");
        hashMap.put("number","13606");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","বিআরটিএ");
        hashMap.put("number","9555555");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("numberName","গ্যাস অভিযোগ");
        hashMap.put("number","16512");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","ডিবি (ডিটেকটিভ ব্রাঞ্চ)");
        hashMap.put("number","01713-398412");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("numberName","পুলিশ কন্ট্রোল রুম");
        hashMap.put("number","01713-398311");
        arrayList.add(hashMap);







    }
}