package Upzila;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodOfficer extends AppCompatActivity {

    RecyclerView foodOfficerRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food_officer);
        toolbar  = findViewById(R.id.toolbar);
        foodOfficerRecyclerView = findViewById(R.id.foodOfficerRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        FoodOfficeAdapter foodOfficeAdapter = new FoodOfficeAdapter();
        foodOfficerRecyclerView.setAdapter(foodOfficeAdapter);
        foodOfficerRecyclerView.setLayoutManager(new LinearLayoutManager(FoodOfficer.this));



    }

    private class FoodOfficeAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
            TextView upName,upBatchNo,upDegree,upGmail;
            CircleImageView uPImage;
            CardView upItemCard;


            public readHolder(@NonNull View itemView) {
                super(itemView);
                upName = itemView.findViewById(R.id.upName);
                upBatchNo = itemView.findViewById(R.id.upBatchNo);
                upDegree = itemView.findViewById(R.id.upDegree);
                upGmail = itemView.findViewById(R.id.upGmail);
                uPImage = itemView.findViewById(R.id.uPImage);
                upItemCard = itemView.findViewById(R.id.upItemCard);



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

            View view = layoutInflater.inflate(R.layout.up_item, parent, false);
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
            String upName  = hashMap.get("upName");
            String upLevel = hashMap.get("upLevel");
            String upNumber  = hashMap.get("upNumber");
            String upImage = hashMap.get("upImage");
            String upGmail = hashMap.get("upGmail");
            String upTime = hashMap.get("upTime");
            String upBatch = hashMap.get("upBatch");
            String upTimeTitle = hashMap.get("upTimeTitle");
            String upBatchNo = hashMap.get("upBatchNo");

            readHolder.upItemCard.startAnimation(AnimationUtils.loadAnimation(readHolder.upItemCard.getContext(),R.anim.recycler_anim02));
            Picasso.get().load(upImage).into(readHolder.uPImage);


            readHolder.upName.setText(upName);
            readHolder.upBatchNo.setText(upTime);
            readHolder.upDegree.setText(upLevel);
            readHolder.upGmail.setText(upGmail);




            readHolder.upItemCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FoodOfficer.this, UpzilaPersonProfile.class);

                    UpzilaPersonProfile.UPGmail = upGmail;
                    UpzilaPersonProfile.UPName = upName;
                    UpzilaPersonProfile.UPLevel = upLevel;
                    UpzilaPersonProfile.UPPhone = upNumber;
                    UpzilaPersonProfile.UPJoinTimeTitle = upTimeTitle;
                    UpzilaPersonProfile.UPJoinTime = upTime;
                    UpzilaPersonProfile.UPBscBatch = upBatch;
                    UpzilaPersonProfile.UPBscBatchNo = upBatchNo;

                    Bitmap bitmap = ( (BitmapDrawable) readHolder.uPImage.getDrawable() ).getBitmap();
                    UpzilaPersonProfile.ImageBitmap = bitmap;


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
        hashMap.put("upName", "অরবিন্দু ভৌমিক");
        hashMap.put("upLevel", "উপজেলা খাদ্য নিয়ন্ত্রক প্রহরী");
        hashMap.put("upNumber", "০১৮৫১৬৪৯২৮১");
        hashMap.put("upImage", "https://i.postimg.cc/LXdRYkrm/khaddo-1.png");
        hashMap.put("upGmail", "ucf.compa.noa456@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২২ জানুয়ারি ২০১৩");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মো:আবদুল্লাহ আল মামুন");
        hashMap.put("upLevel", "নিরাপত্তা প্রহরী");
        hashMap.put("upNumber", "০৩২২৩-৫৬৩৬০");
        hashMap.put("upImage", "https://i.postimg.cc/ZYxZndjh/khaddo-2.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "শাহাদাত হোসেন পারভেজ");
        hashMap.put("upLevel", "সাইলো অপারেটিভ");
        hashMap.put("upNumber", "০৩২২৩-৫৬৩৬০");
        hashMap.put("upImage", "https://i.postimg.cc/CLvgHpWP/khaddo-3.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মো:ওবায়দুল হক");
        hashMap.put("upLevel", "নিরাপত্তা প্রহরী");
        hashMap.put("upNumber", "০৩২২৩-৫৬৩৬০");
        hashMap.put("upImage", "https://i.postimg.cc/B6G9QSK6/khadddo-4.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: আলমগীর হোসেন");
        hashMap.put("upLevel", "নিরাপত্তা প্রহরী");
        hashMap.put("upNumber", "০৩২২৩-৫৬৩৬০");
        hashMap.put("upImage", "https://i.postimg.cc/50qcXhBm/khaddo-5.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মুহাম্মদ জহিরুল ইসলাম");
        hashMap.put("upLevel", "সহকারী উপখাদ্য পরিদর্শক");
        hashMap.put("upNumber", "০১৬২২১৬৫১২৮");
        hashMap.put("upImage", "https://i.postimg.cc/J01fZpKC/khaddo-6.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "উত্তম কুমার চক্রবর্ত্তী");
        hashMap.put("upLevel", "খাদ্য পরিদর্শক ভারপ্রাত্ত কর্মকর্তা ");
        hashMap.put("upNumber", "০১৬২২১৬৫১২৮");
        hashMap.put("upImage", "https://i.postimg.cc/m2rxr6tQ/khaddo-7.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "আনিছুর রহমান");
        hashMap.put("upLevel", "খাদ্য পরিদর্শক");
        hashMap.put("upNumber", "০১৬২২১৬৫১২৮");
        hashMap.put("upImage", "https://i.postimg.cc/nh6N0FTk/khaddo-8.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "নাহিদা সুলতানা");
        hashMap.put("upLevel", "নিরাপত্তা প্রহরী");
        hashMap.put("upNumber", "০১৬২২১৬৫১২৮");
        hashMap.put("upImage", "https://i.postimg.cc/JnQgrb86/khaddo-9.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: আবদুর রহিম");
        hashMap.put("upLevel", "নিরাপত্তা প্রহরী");
        hashMap.put("upNumber", "০১৬২২১৬৫১২৮");
        hashMap.put("upImage", "https://i.postimg.cc/mZ8qKN8h/khaddo-10.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "পলাশ চন্দ্র মজুমদার");
        hashMap.put("upLevel", "নিরাপত্তা প্রহরী");
        hashMap.put("upNumber", "০১৬২২১৬৫১২৮");
        hashMap.put("upImage", "https://i.postimg.cc/FHJBdtmJ/khaddo11.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জানুয়ারি ১৯৭০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: আবু জাফর");
        hashMap.put("upLevel", "নিরাপত্তা প্রহরী");
        hashMap.put("upNumber", "০১৬২২১৬৫১২৮");
        hashMap.put("upImage", "https://i.postimg.cc/ZRJ7MCNr/khaddo-12.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);









    }
}