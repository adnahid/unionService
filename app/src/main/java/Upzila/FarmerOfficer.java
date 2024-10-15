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

public class FarmerOfficer extends AppCompatActivity {

    RecyclerView FarmerOfficerRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_farmer_officer);
        toolbar  = findViewById(R.id.toolbar);
        FarmerOfficerRecyclerView = findViewById(R.id.FarmerOfficerRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        FermarOfficeAdapter fermarOfficeAdapter = new FermarOfficeAdapter();
        FarmerOfficerRecyclerView.setAdapter(fermarOfficeAdapter);
        FarmerOfficerRecyclerView.setLayoutManager(new LinearLayoutManager(FarmerOfficer.this));




    }

    private class FermarOfficeAdapter extends RecyclerView.Adapter{

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
            String sectorName = hashMap.get("sectorName");

            readHolder.upItemCard.startAnimation(AnimationUtils.loadAnimation(readHolder.upItemCard.getContext(),R.anim.recycler_anim03));
            Picasso.get().load(upImage).placeholder(R.drawable.person).into(readHolder.uPImage);



            toolbar.setTitle(sectorName);
            readHolder.upName.setText(upName);
            readHolder.upBatchNo.setText(upBatch);
            readHolder.upDegree.setText(upLevel);
            readHolder.upGmail.setText(upGmail);




            readHolder.upItemCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FarmerOfficer.this, UpzilaPersonProfile.class);

                    UpzilaPersonProfile.UPGmail = upGmail;
                    UpzilaPersonProfile.UPName = upName;
                    UpzilaPersonProfile.UPLevel = upLevel;
                    UpzilaPersonProfile.UPPhone = upNumber;
                    UpzilaPersonProfile.UPJoinTimeTitle = upTimeTitle;
                    UpzilaPersonProfile.UPJoinTime = upTime;
                    UpzilaPersonProfile.UPBscBatch = upBatch;
                    UpzilaPersonProfile.UPBscBatchNo = upBatchNo;
                    UpzilaPersonProfile.ToolTv = sectorName;

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
        hashMap.put("upName", "মোঃ বেলাল হোসেন");
        hashMap.put("upLevel", "উপজেলা কৃষি অফিসার");
        hashMap.put("upNumber", "০১৭৩১২৯১৪৩৮");
        hashMap.put("upImage", "https://i.postimg.cc/7ZCJhfX9/kisi-1.png");
        hashMap.put("upGmail", "belaltara.bd@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১০ ফেব্রুয়ারী ২০২০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৪");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: জাহাঙ্গীর আলম");
        hashMap.put("upLevel", "কৃষি সম্প্রসারণ অফিসার");
        hashMap.put("upNumber", "০১৮৩৩৭৪৬২৮৯");
        hashMap.put("upImage", "https://i.postimg.cc/g0VJLRhV/kisi-2.jpg");
        hashMap.put("upGmail", "jahangiralam0493@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৯ এপ্রিল ২০২৪");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৪১");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ নুরুল আলম ভূঁইয়া");
        hashMap.put("upLevel", "সহকারী কৃষি সম্প্রসারণ কর্মকর্তা");
        hashMap.put("upNumber", "০১৮১৭৫০৭৮৯০");
        hashMap.put("upImage", "https://i.postimg.cc/V64kD8D5/kisi-3.jpg");
        hashMap.put("upGmail", "nurulalambhuiyan473@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১০ ফেব্রুয়ারী ২০২০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "আকরাম উদ্দিন");
        hashMap.put("upLevel", "উপ-সহকারী উদ্ভিদ সংরক্ষণ কর্মকর্তা");
        hashMap.put("upNumber", "০১৭১৬৬১৩২১৬");
        hashMap.put("upImage", "https://i.postimg.cc/qq5MHGfT/kisi-4.png");
        hashMap.put("upGmail", "akramuddindidar73@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২০ ফেব্রুয়ারী ২০২০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: সাইফ উল্যাহ");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮১৯০৮৯৯১৩");
        hashMap.put("upImage", "https://i.postimg.cc/TP62xwsp/kisi-5.jpg");
        hashMap.put("upGmail", "abc@ymail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১৪ সেপ্টেম্বর ২০০৫");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "হাসান মোঃ মোরশেদ");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৯৩৮৮১৯৫৯৮");
        hashMap.put("upImage", "https://i.postimg.cc/V67zXFkC/kisi-6.png");
        hashMap.put("upGmail", "hmmorshed20@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১৫ ফেব্রুয়ারী ২০১৬");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ আজিজুল হক");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮১৪২৫৭৯৭৮");
        hashMap.put("upImage", "https://i.postimg.cc/90KVnFTX/kisi-7.png");
        hashMap.put("upGmail", "azizulhoquedae@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১৬ সেপ্টেম্বর ২০১৮");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "কনক চন্দ্র মজুমদার");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৭১১৭১০৯৩৩");
        hashMap.put("upImage", "https://i.postimg.cc/RZr41h4X/kisi-8.jpg");
        hashMap.put("upGmail", "hhkan@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৪ মার্চ ২০০৮");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মো:বোরহান উদ্দিন");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮২০০১৮৪৯৮");
        hashMap.put("upImage", "https://i.postimg.cc/g2vdgp0d/kisi-9.jpg");
        hashMap.put("upGmail", "cc@ymail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২০ জুন ২০১০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "শেখ রৌশন আরা");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৬৮৩২৮২৬৮৭");
        hashMap.put("upImage", "https://i.postimg.cc/MTr8nK90/kisi-10.jpg");
        hashMap.put("upGmail", "hhnu@ymail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২০ জুন ২০১০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "রিয়েল মজুমদার");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮৪২৫৪৬২৮৩");
        hashMap.put("upImage", "https://i.postimg.cc/XqG6dSPR/kisi-11.png");
        hashMap.put("upGmail", "majumderreal@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৬ এপ্রিল ২০১৭");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ মাহবুবুর রহমান");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৬৪২৭৪৭২৭৪");
        hashMap.put("upImage", "https://i.postimg.cc/Mpb2yYsp/kisi-12.png");
        hashMap.put("upGmail", "mahbuburrahmanraja7@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৭ অক্টোবর ২০১৫");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "বিধান চন্দ্র শীল");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮১৪৮২৯০০০");
        hashMap.put("upImage", "https://i.postimg.cc/ydxMCC7D/kisi-13.jpg");
        hashMap.put("upGmail", "senbidhan999@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৬ এপ্রিল ২০২০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ তাজউদ্দিন সম্রাট");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮২২২৮৩৭৫৬");
        hashMap.put("upImage", "https://i.postimg.cc/ydGwVpNv/kisi-14.png");
        hashMap.put("upGmail", "somratn89@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৬ এপ্রিল ২০১৭");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ এয়াছিন আলী");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮৪৩৯৭১২৪৯");
        hashMap.put("upImage", "https://i.postimg.cc/ncqcPBd6/kisi-15.jpg");
        hashMap.put("upGmail", "yeasin.arafad1249@gmail,com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৬ সেপ্টেম্বর ২০২১");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ ফরহাদ আলী");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮২৩১৬৬০৪৩");
        hashMap.put("upImage", "https://i.postimg.cc/C53KFTSs/kisi-17.jpg");
        hashMap.put("upGmail", "mdforhadctg6043@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৬ সেপ্টেম্বর ২০২১");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "সামসুল হুদা");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮২৫৭৪৪৫৭৬");
        hashMap.put("upImage", "https://i.postimg.cc/wTNvwvQf/kisi-18.jpg");
        hashMap.put("upGmail", "saao2042017@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "শোভন চৌধুরী");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৮৪০২৫০৭৪৪");
        hashMap.put("upImage", "https://i.postimg.cc/tTfq5QZG/kisi-19.jpg");
        hashMap.put("upGmail", "chyshovon9393@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৬ সেপ্টেম্বর ২০২১");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ জাফর");
        hashMap.put("upLevel", "উপ-সহকারী কৃষি কর্মকর্তা");
        hashMap.put("upNumber", "০১৭৫২১২৮৭০৯");
        hashMap.put("upImage", "https://i.postimg.cc/V5PzxqW7/kisi-21.jpg");
        hashMap.put("upGmail", "mdjafor0097@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৬ সেপ্টেম্বর ২০২১");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা কৃষি অফিসার");
        arrayList.add(hashMap);









    }
}