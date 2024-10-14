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

import ItemLayout.LRDWProfileActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class AminalOfficer extends AppCompatActivity {
    RecyclerView AnimalOfficerRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aminal_officer);
        toolbar  = findViewById(R.id.toolbar);
        AnimalOfficerRecyclerView = findViewById(R.id.AnimalOfficerRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        AminalOfficerAdapter aminalOfficerAdapter = new AminalOfficerAdapter();
        AnimalOfficerRecyclerView.setAdapter(aminalOfficerAdapter);
        AnimalOfficerRecyclerView.setLayoutManager(new LinearLayoutManager(AminalOfficer.this));

    }

    private class AminalOfficerAdapter extends RecyclerView.Adapter{

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

            readHolder.upItemCard.startAnimation(AnimationUtils.loadAnimation(readHolder.upItemCard.getContext(),R.anim.recycler_anim04));
            Picasso.get().load(upImage).into(readHolder.uPImage);


            readHolder.upName.setText(upName);
            readHolder.upBatchNo.setText(upBatch);
            readHolder.upDegree.setText(upLevel);
            readHolder.upGmail.setText(upGmail);




            readHolder.upItemCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AminalOfficer.this, UpzilaPersonProfile.class);

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
        hashMap.put("upName", "ডাঃ তাসলীমা ফেরদৌসী");
        hashMap.put("upLevel", "উপজেলা প্রাণিসম্পদ কর্মকর্তা");
        hashMap.put("upNumber", "০১৭১৮৪৫৮৪৪৬");
        hashMap.put("upImage", "https://i.postimg.cc/Vs2s0CbG/Animal-Resource-1.jpg");
        hashMap.put("upGmail", "linahasan01718@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ ফেব্রুয়ারী ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩১");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা: মো: নুরুল কাওছার খান");
        hashMap.put("upLevel", "ভেটেরিনারি সার্জন");
        hashMap.put("upNumber", "০১৩২৪২৯০৯১২");
        hashMap.put("upImage", "https://i.postimg.cc/MpmzL33N/Animal-Resource-2.jpg");
        hashMap.put("upGmail", "nurulkawsar7@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১১ ডিসেম্বর ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৪০");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "ডাঃ আসাদুজ্জামান সওকী");
        hashMap.put("upLevel", "প্রাণিসম্পদ সম্প্রসারণ কর্মকর্তা");
        hashMap.put("upNumber", "০১৮৯১৯৯৬৮৪৫");
        hashMap.put("upImage", "https://i.postimg.cc/PqfdnbBx/Animal-Resource-3.jpg");
        hashMap.put("upGmail", "sowky2585@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মুহাম্মদ আলমগীর");
        hashMap.put("upLevel", "উপসহকারী প্রাণিসম্পদ কর্মকর্তা (প্রাণিস্বাস্থ্য)");
        hashMap.put("upNumber", "০১৮৭৯৩৭২০৮");
        hashMap.put("upImage", "https://i.postimg.cc/02gxy1Lh/Animal-Resource-4.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১৭ ডিসেম্বর ২০১২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: নিজাম উদ্দিন");
        hashMap.put("upLevel", "উপ-সহকারী প্রাণিসম্পদ কর্মকর্তা ( কৃত্রিম প্রজনন)");
        hashMap.put("upNumber", "০১৮১৯১৯৮০৮৮");
        hashMap.put("upImage", "https://i.postimg.cc/QxpDBnDC/Animal-Resource-5.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১৩ এপ্রিল ২০১৭");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "বাপ্পি সাহা");
        hashMap.put("upLevel", "ভেটেরিনারি ফিল্ড এসিস্ট্যান্ট");
        hashMap.put("upNumber", "০১৯১৩২৯০০৪৭");
        hashMap.put("upImage", "https://i.postimg.cc/y8jzjgkz/Animal-Resource-6.jpg");
        hashMap.put("upGmail", "bappisahacvc@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৮ আগষ্ট ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মাহবুবা খাতুন");
        hashMap.put("upLevel", "ভেটেরিনারি ফিল্ড এসিস্ট্যান্ট");
        hashMap.put("upNumber", "০১৬৩৯১৭০৮৮০");
        hashMap.put("upImage", "https://i.postimg.cc/cHgydFTs/Animal-Resource-7.jpg");
        hashMap.put("upGmail", "mahbubak643@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২৯ আগষ্ট ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "নয়ন মজুমদার");
        hashMap.put("upLevel", "ভেটেরিনারি ফিল্ড এসিস্ট্যান্ট");
        hashMap.put("upNumber", "০১৭৯০৩৪১৫৩৪");
        hashMap.put("upImage", "https://i.postimg.cc/qRPfq2Z2/Animal-Resource-8.jpg");
        hashMap.put("upGmail", "nayanmozumder1994@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১১ অক্টোবর ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "মো: শিহাব মুবিন");
        hashMap.put("upLevel", "অফিস সহায়ক");
        hashMap.put("upNumber", "০১৮২৯৭৭৭১৯৭");
        hashMap.put("upImage", "https://i.postimg.cc/bYncMFsg/Animal-Resource-9.jpg");
        hashMap.put("upGmail", "এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "১৯ অক্টোবর ২০২০");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        arrayList.add(hashMap);





    }
}