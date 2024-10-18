package HealthPackage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import Upzila.AminalOfficer;
import Upzila.UpzilaPersonProfile;
import de.hdodenhof.circleimageview.CircleImageView;

public class UpZilaDoctorList extends AppCompatActivity {

    RecyclerView UpzilaDoctorRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_up_zila_doctor_list);
        UpzilaDoctorRecyclerView = findViewById(R.id.UpzilaDoctorRecyclerView);
        toolbar  = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        DetailsTable();
        UpzilaDocAdapter upzilaDocAdapter = new UpzilaDocAdapter();
        UpzilaDoctorRecyclerView.setAdapter(upzilaDocAdapter);
        UpzilaDoctorRecyclerView.setLayoutManager(new LinearLayoutManager(UpZilaDoctorList.this));

    }

    private class UpzilaDocAdapter extends RecyclerView.Adapter{

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

            readHolder.upItemCard.startAnimation(AnimationUtils.loadAnimation(readHolder.upItemCard.getContext(),R.anim.recycler_anim01));
            Picasso.get().load(upImage).placeholder(R.drawable.person).into(readHolder.uPImage);



            toolbar.setTitle(sectorName);
            readHolder.upName.setText(upName);
            readHolder.upBatchNo.setText(upBatch);
            readHolder.upDegree.setText(upLevel);
            readHolder.upGmail.setText(upGmail);




            readHolder.upItemCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UpZilaDoctorList.this, UpzilaPersonProfile.class);

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

    public void DetailsTable(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা: মোহাম্মদ সেলিম");
        hashMap.put("upLevel", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        hashMap.put("upNumber", "০১৮১৮৭১৮৭৫২,০১৭৩০-৩২৪৮৬২");
        hashMap.put("upImage", "https://i.postimg.cc/d3JPNH51/family-1.jpg");
        hashMap.put("upGmail", "companiganj@uhfpo.dghs.gov.bd");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ২২");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. তৃষা ভট্টাচার্য");
        hashMap.put("upLevel", "মেডিকেল অফিসার");
        hashMap.put("upNumber", "০১৬২১৩৭২৩৮৬");
        hashMap.put("upImage", "https://i.postimg.cc/rm8QvB2v/family-2.png");
        hashMap.put("upGmail", " doctortrisha33@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "ডাঃ আবদুল আহাদ");
        hashMap.put("upLevel", "মেডিকেল অফিসার");
        hashMap.put("upNumber", "০১৭৪১৩৯৭৪৫৭");
        hashMap.put("upImage", "https://i.postimg.cc/DZyPC1qh/family-3.jpg");
        hashMap.put("upGmail", "muhammad.a.ahad@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "২২ ফেব্রুয়ারী ২০২১");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৮");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. মোহাম্মদ জুবায়ের");
        hashMap.put("upLevel", "আবাসিক মেডিকেল অফিসার ( দায়িত্বপ্রাপ্ত)");
        hashMap.put("upNumber", "০১৭৫৪৩৬৬২৭৭");
        hashMap.put("upImage", "https://i.postimg.cc/FF6VZd1t/family-4.png");
        hashMap.put("upGmail", "drmzubair71@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. সামিয়া কামাল");
        hashMap.put("upLevel", "সহকারী সার্জন");
        hashMap.put("upNumber", "০১৮৩০০৩৯৪৯৮");
        hashMap.put("upImage", "https://i.postimg.cc/P5sbggm2/family-5.png");
        hashMap.put("upGmail", "golpobashri@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "০১ ফেব্রুয়ারী ২০২২");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. এম এন জায়েদ বাশরী");
        hashMap.put("upLevel", "ইমারজেন্সি মেডিকেল অফিসার");
        hashMap.put("upNumber", "০১৮১৯৬২৩৬৩০");
        hashMap.put("upImage", "https://i.postimg.cc/g2HMNzfv/family-6.png");
        hashMap.put("upGmail", "golpobashri@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. উম্মে হাবিবা নিতু");
        hashMap.put("upLevel", "সহকারী সার্জন");
        hashMap.put("upNumber", "০১৮৭০৮৫৫১৬৮");
        hashMap.put("upImage", "https://i.postimg.cc/SNWVxQQw/family-7.png");
        hashMap.put("upGmail", "nitutuni66@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৯");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. সাজেদা আক্তার");
        hashMap.put("upLevel", "মেডিকেল অফিসার");
        hashMap.put("upNumber", "০১৮৪২৫৯৪৯৩০");
        hashMap.put("upImage", "https://i.postimg.cc/q77Gw8cT/family-8.png");
        hashMap.put("upGmail", "Sajadapolycmc51@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৯");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. ফারিহা নাজ মাহমুদ");
        hashMap.put("upLevel", "মেডিকেল অফিসার");
        hashMap.put("upNumber", "০১৬৮২১৩২৯২৯");
        hashMap.put("upImage", "https://i.postimg.cc/L4P3x4Pn/family-9.png");
        hashMap.put("upGmail", "farihamahmud1992@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৯");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. রবিন চৌধুরী");
        hashMap.put("upLevel", "মেডিকেল অফিসার");
        hashMap.put("upNumber", "০১৬৮৭৯২৫৯১৮");
        hashMap.put("upImage", "https://i.postimg.cc/7LcSNjY3/family-10.png");
        hashMap.put("upGmail", " raktim24.rc@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৯");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. মোঃ আল আমিন");
        hashMap.put("upLevel", "মেডিকেল অফিসার");
        hashMap.put("upNumber", "০১৯৯৮০৫৫৮০৫");
        hashMap.put("upImage", "https://i.postimg.cc/fRRXQMV7/family-11.png");
        hashMap.put("upGmail", "mdalamin326@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৯");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. ফখরুল ইসলাম ইমরান");
        hashMap.put("upLevel", "মেডিকেল অফিসার (তথ্য প্রযুক্তি)");
        hashMap.put("upNumber", "০১৭১৭৫০২৮৭৮");
        hashMap.put("upImage", "https://i.postimg.cc/hjTQ1jYn/family-12.png");
        hashMap.put("upGmail", "imran.fakhrulislam@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : ৩৯");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা: শওকত আল ইমরান");
        hashMap.put("upLevel", "মেডিকেল অফিসার");
        hashMap.put("upNumber", "০১৭১১৩৫৯০৬৯");
        hashMap.put("upImage", "https://i.postimg.cc/MKWf1zmk/family-13.jpg");
        hashMap.put("upGmail", "so34@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. তাপস চক্রবর্তী");
        hashMap.put("upLevel", "জুনিয়র কনসালটেন্ট (চলতি দায়িত্ব)");
        hashMap.put("upNumber", "০১৭১৭৮৫৬৪১৪");
        hashMap.put("upImage", "https://i.postimg.cc/dVPxCq6c/family-14.png");
        hashMap.put("upGmail", "tapas09@yahoo.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "ব্যাচ (বিসিএস) : -১");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা: মোরশেদা ইয়াছমিন");
        hashMap.put("upLevel", "সহকারী সার্জন ( ডেন্টাল )");
        hashMap.put("upNumber", "০১৭১১০৪৫৬০৭");
        hashMap.put("upImage", "https://i.postimg.cc/pr31qxt8/family-15.jpg");
        hashMap.put("upGmail", "morshid34@ymail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা. মাকসুদা সুলতানা");
        hashMap.put("upLevel", "সহকারী সার্জন");
        hashMap.put("upNumber", "০১৮১৫২৫৭৬৪৪");
        hashMap.put("upImage", "https://i.postimg.cc/j55gTCxP/family-16.png");
        hashMap.put("upGmail", "surovimaksuda@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("upName", "ডা: ফাহাদ আহম্মদ");
        hashMap.put("upLevel", "মেডিকেল অফিসার (এমসিএইচ-এফপি)");
        hashMap.put("upNumber", "০১৬৭৫৭৭২৬৮২,০৩২২৩৫৬২৫১");
        hashMap.put("upImage", "https://i.postimg.cc/6TsYC0df/family-17.jpg");
        hashMap.put("upGmail", "fahadahmedameo@gamil.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "০৯ এপ্রিল ২০২৩");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("upName", "আবদুল্লাহ আল মাহমুদ");
        hashMap.put("upLevel", "উপজেলা পরিবার পরিকল্পনা কর্মকর্তা");
        hashMap.put("upNumber", "০১৬৭০৮৩৫৩৫৩,০৩২২৩৫৬২৫১");
        hashMap.put("upImage", "https://i.postimg.cc/FF24PXpD/family-18.png");
        hashMap.put("upGmail", "ufpocompaniganj@gmail.com");
        hashMap.put("upTimeTitle", "যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo", "ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা স্বাস্থ্য ও পরিবার পরিকল্পনা কর্মকর্তা");
        arrayList.add(hashMap);






    }
}