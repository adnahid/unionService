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

public class VumiOfficer extends AppCompatActivity {

    RecyclerView vumiOfficerRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vumi_officer);
        toolbar  = findViewById(R.id.toolbar);
        vumiOfficerRecyclerView = findViewById(R.id.vumiOfficerRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        VumiAdapter vumiAdapter = new VumiAdapter();
        vumiOfficerRecyclerView.setAdapter(vumiAdapter);
        vumiOfficerRecyclerView.setLayoutManager(new LinearLayoutManager(VumiOfficer.this));


    }
    private class VumiAdapter extends RecyclerView.Adapter{

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

            readHolder.upItemCard.startAnimation(AnimationUtils.loadAnimation(readHolder.upItemCard.getContext(),R.anim.recycler_anim02));
            Picasso.get().load(upImage).placeholder(R.drawable.person).into(readHolder.uPImage);



            readHolder.upName.setText(upName);
            readHolder.upBatchNo.setText(upBatch);
            readHolder.upDegree.setText(upLevel);
            readHolder.upGmail.setText(upGmail);




            readHolder.upItemCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(VumiOfficer.this, UpzilaPersonProfile.class);

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
        hashMap.put("upName", "মোঃ হাবেল উদ্দিন");
        hashMap.put("upLevel", "সহকারী কমিশনার (ভূমি)");
        hashMap.put("upNumber", "০১৭০৫৪০১১১৫");
        hashMap.put("upImage", "https://i.postimg.cc/NMQjNqxK/comissonar-1.jpg");
        hashMap.put("upGmail", "acl.cmp2021@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৩ মে ২০২৪");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৮");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "এ.এইচ.এম. মোস্তফা কামাল");
        hashMap.put("upLevel", "সার্ভেয়ার ( উপজেলা ভূমি অফিস )");
        hashMap.put("upNumber", "০১৮৫০০১০১০২, ০১৮৫০০১০১০২");
        hashMap.put("upImage", "https://i.postimg.cc/xjx1PZNd/comissonar-2.jpg");
        hashMap.put("upGmail", "kmostafa2023@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ জুন ২০২০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ নিজাম উদ্দিন");
        hashMap.put("upLevel", "নাজির কাম-ক্যাশিয়ার ( উপজেলা ভূমি অফিস )");
        hashMap.put("upNumber", "০১৮৬০৪১৫৯৬৯, ০১৮৬০৪১৫৯৬৯");
        hashMap.put("upImage", "https://i.postimg.cc/Pr0fg84s/comissonar-3.jpg");
        hashMap.put("upGmail", "nejamkpm@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১২ সেপ্টেম্বর ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "আবুল বাসার");
        hashMap.put("upLevel", "সার্টিফিকেট সহকারী ( উপজেলা ভূমি অফিস )");
        hashMap.put("upNumber", "০১৮২৩৯৭৭৮৬০");
        hashMap.put("upImage", "https://i.postimg.cc/hG1SQZqc/comissonar-4.jpg");
        hashMap.put("upGmail", "abulbasarjuel@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১২ সেপ্টেম্বর ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মোহাম্মদ জামিল হোসেন");
        hashMap.put("upLevel", "ক্রেডিট চেকিং-কাম সায়রাত সহকারী ( উপজেলা ভূমি অফিস )");
        hashMap.put("upNumber", "০১৭১৯৪১৫৬৮২");
        hashMap.put("upImage", "https://i.postimg.cc/nrCZ5H9h/comissonar-5.jpg");
        hashMap.put("upGmail", "jamil.hossen56@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১২ সেপ্টেম্বর ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ হাবিবুর রহমান");
        hashMap.put("upLevel", "সার্টিফিকেট পেশকার ( উপজেলা ভূমি অফিস )");
        hashMap.put("upNumber", "০১৮১৮০৭০৬০৩");
        hashMap.put("upImage", "https://i.postimg.cc/HncDzBFJ/6.jpg");
        hashMap.put("upGmail", "habibfaruk03@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১২ সেপ্টেম্বর ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ সাইফুল ইসলাম");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি সহকারী কর্মকর্তা ");
        hashMap.put("upNumber", "০১৮১৮৭৬২৩৯০");
        hashMap.put("upImage", "https://i.postimg.cc/52qcsHKm/commissonasr-7.jpg");
        hashMap.put("upGmail", "mdsaiful762390@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২২ মার্চ ২০১৯");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ কামাল উদ্দিন");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি সহকারী কর্মকর্তা ");
        hashMap.put("upNumber", "০১৮১৮৭৪০২৬৯");
        hashMap.put("upImage", "https://i.postimg.cc/Jn097prT/comissonar-8.jpg");
        hashMap.put("upGmail", "kamalland1271@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ অক্টোবর ২০২০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "হাফেজ আহাম্মদ");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি সহকারী কর্মকর্তা (চরফকিরা ইউনিয়ন ভূমি অফিস)");
        hashMap.put("upNumber", "০১৭৭০৩৭০৭৬৫");
        hashMap.put("upImage", "https://i.postimg.cc/fknFKZxF/comissonar-9.jpg");
        hashMap.put("upGmail", "hafezahamed765@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০৯ সেপ্টেম্বর ২০১৯");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "হাসান ফারুক");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি সহকারী কর্মকর্তা (বামনী ইউনিয়ন ভূমি অফিস)");
        hashMap.put("upNumber", "০১৭১২১২৯৭৯৭");
        hashMap.put("upImage", "https://i.postimg.cc/Vk1ssP3D/comissonar-10.jpg");
        hashMap.put("upGmail", "ulaohasanfaruk@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০৯ সেপ্টেম্বর ২০১৯");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ জয়নাল আবদীন");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি সহকারী কর্মকর্তা (মুসাপুর ইউনিয়ন ভূমি অফিস)");
        hashMap.put("upNumber", "০১৮১৪০৭৩৮১২");
        hashMap.put("upImage", "https://i.postimg.cc/DZWnpvXy/comissonar-11.jpg");
        hashMap.put("upGmail", "UlaoJoynalabdin@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০৯ সেপ্টেম্বর ২০২০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "কামরুল ইসলাম");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি উপ-সহকারী কর্মকর্তা (চরফকিরা ইউনিয়ন ভূমি অফিস)");
        hashMap.put("upNumber", "০১৮১৩১২৩৩৪৫");
        hashMap.put("upImage", "https://i.postimg.cc/g2S999dw/comissonar-12.png");
        hashMap.put("upGmail", "kamrul25@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "লিখি মজুমদার");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি উপ-সহকারী কর্মকর্তা (বামনী ইউনিয়ন ভূমি অফিস)");
        hashMap.put("upNumber", "০১৮১৬১৫৯৮৫৪");
        hashMap.put("upImage", "https://i.postimg.cc/3NC6nVnx/comissonar-13.png");
        hashMap.put("upGmail", "likhi452@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ সাহাদাত হোসেন");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি উপ-সহকারী কর্মকর্তা ( বসুরহাট পৌর ভূমি অফিস)");
        hashMap.put("upNumber", "০১৬৭৬৮৪৯৫২৯");
        hashMap.put("upImage", "https://i.postimg.cc/DZGRb8Gs/comissonar-14.jpg");
        hashMap.put("upGmail", "sahadath.ulsao@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২০ জুলাই ২০১৮");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "গিয়াস উদ্দিন");
        hashMap.put("upLevel", "ইউনিয়ন ভূমি উপ-সহকারী কর্মকর্তা (মুসাপুর ইউনিয়ন ভূমি অফিস)");
        hashMap.put("upNumber", "০১৮১১৮৪৩১৮৩");
        hashMap.put("upImage", "https://i.postimg.cc/rFj3W6Dh/comissonar-154.png");
        hashMap.put("upGmail", "mojibulao@yahoo.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০৫ এপ্রিল ২০১৫");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ নজরুল ইসলাম");
        hashMap.put("upLevel", "জারী কারক (উপজেলা ভূমি অফিস)");
        hashMap.put("upNumber", "০১৮২৪৮২০২০৯");
        hashMap.put("upImage", "https://i.postimg.cc/4xF0LzbV/comissonar-16.jpg");
        hashMap.put("upGmail", "inazrul4499@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৭ নভেম্বর ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ আমির হোসেন");
        hashMap.put("upLevel", "অফিস সহায়ক ( উপজেলা ভূমি অফিস )");
        hashMap.put("upNumber", "০১৯৩৯৪০২৭১৪");
        hashMap.put("upImage", "https://i.postimg.cc/4xnL9Ykd/comissonar-17.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১৫ নভেম্বর ২০২৩");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "মোঃ আবদুস শহীদ");
        hashMap.put("upLevel", "অফিস সহায়ক ( উপজেলা ভূমি অফিস )");
        hashMap.put("upNumber", "০১৮১৬০৪৫০৬৬");
        hashMap.put("upImage", "https://i.postimg.cc/Sx5Z7mkG/comissonar-18.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১৫ নভেম্বর ২০১৯");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName",  "মোঃ মহিউদ্দিন");
        hashMap.put("upLevel", "অফিস সহায়ক ( পৌর ভূমি অফিস )");
        hashMap.put("upNumber", "০১৭২৯৬৬৭৮৩৯");
        hashMap.put("upImage", "https://i.postimg.cc/0NwVVhN1/comissonar-19.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২২ মার্চ ২০১৯");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: আবদুল মালেক খাঁন");
        hashMap.put("upLevel", "অফিস সহায়ক ( পৌর ভূমি অফিস )");
        hashMap.put("upNumber", "০১৮১৫৬৫১৭৬৯");
        hashMap.put("upImage", "https://i.postimg.cc/Y9BbZ84G/comissonar-20.png");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: নুর নবী");
        hashMap.put("upLevel", "অফিস সহায়ক ( চর কাঁকড়া ইউনিয়ন ভূমি অফিস )");
        hashMap.put("upNumber", "০১৮১৩৩৮১৫৪০");
        hashMap.put("upImage", "এই মর্মে জানা যায়নি");
        hashMap.put("upGmail", "https://i.postimg.cc/28STs15w/comissonar-21.png");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা ভূমি অফিস");
        arrayList.add(hashMap);











    }
}