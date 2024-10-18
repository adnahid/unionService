package ItemLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import HealthPackage.AmbulanceList;
import Upzila.AminalOfficer;
import Upzila.UpzilaPersonProfile;

public class ThanaPolicy extends AppCompatActivity {

    RecyclerView policeRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thana_policy);
        toolbar  = findViewById(R.id.toolbar);
        policeRecyclerView = findViewById(R.id.policeRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        PoliceAdapter policeAdapter = new PoliceAdapter();
        policeRecyclerView.setAdapter(policeAdapter);
        //GridLayoutManager layoutManager = new GridLayoutManager(ThanaPolicy.this,3);

        policeRecyclerView.setLayoutManager(new LinearLayoutManager(ThanaPolicy.this));



    }

    private class PoliceAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
            TextView policeName,policeQulafication;
            ImageView policeImage;
            CardView policeCardView;
            Button policeDail;

            public readHolder(@NonNull View itemView) {
                super(itemView);
                policeName = itemView.findViewById(R.id.policeName);
                policeQulafication = itemView.findViewById(R.id.policeQulafication);
                policeImage = itemView.findViewById(R.id.policeImage);
                policeDail = itemView.findViewById(R.id.policeDail);
                policeCardView = itemView.findViewById(R.id.policeCardView);


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

            View view = layoutInflater.inflate(R.layout.police_item, parent, false);
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
            String degisnation = hashMap.get("degisnation");
            String phone  = hashMap.get("phone");
            String image = hashMap.get("image");
            String email = hashMap.get("email");
            String upTimeTitle = hashMap.get("upTimeTitle");
            String upTime = hashMap.get("upTime");
            String upBatchNo = hashMap.get("upBatchNo");
            String upBatch = hashMap.get("upBatch");
            String sectorName = hashMap.get("sectorName");




            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            readHolder.policeDail.setBackgroundColor(color);

            readHolder.policeCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.policeCardView.getContext(),R.anim.recycler_anim02));
            Picasso.get().load(image).placeholder(R.drawable.person).into(readHolder.policeImage);


            toolbar.setTitle(sectorName);
            readHolder.policeName.setText(name);
            readHolder.policeQulafication.setText(degisnation);



            readHolder.policeCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ThanaPolicy.this, UpzilaPersonProfile.class);
                    UpzilaPersonProfile.UPGmail = email;
                    UpzilaPersonProfile.UPName = name;
                    UpzilaPersonProfile.UPLevel = degisnation;
                    UpzilaPersonProfile.UPPhone = phone;
                    UpzilaPersonProfile.UPJoinTimeTitle = upTimeTitle;
                    UpzilaPersonProfile.UPJoinTime = upTime;
                    UpzilaPersonProfile.UPBscBatch = upBatch;
                    UpzilaPersonProfile.UPBscBatchNo = upBatchNo;
                    UpzilaPersonProfile.ToolTv = sectorName;

                    Bitmap bitmap = ( (BitmapDrawable) readHolder.policeImage.getDrawable() ).getBitmap();
                    UpzilaPersonProfile.ImageBitmap = bitmap;

                    startActivity(intent);
                }
            });



//            readHolder.policeDail.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_DIAL);
//                    intent.setData(Uri.parse("tel:"+phone));
//                    startActivity(intent);
//                }
//            });

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
        hashMap.put("name","মোহাম্মদ সাদিকুর রহমান");
        hashMap.put("degisnation","অফিসার ইনচার্জ");
        hashMap.put("phone", "০১৩২০১১১০৮৫");
        hashMap.put("image","https://i.postimg.cc/tCw1wFHb/police-1.jpg");
        hashMap.put("email","companiganjps@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "০৯ আগষ্ট ২০২২");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","মোঃ শফিকুল ইসলাম রাজা");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৭১৪-৪৭৮৮৫৮,+৮৮০ ১৭১৪-৪৭৮৮৫৮");
        hashMap.put("email","এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","এস.এম মিজানুর রহমান");
        hashMap.put("degisnation","পুলিশ পরিদর্শক (তদন্ত)");
        hashMap.put("phone", "০১৩২০১১১০৮৬,০১৩২০১১১০৮৬");
        hashMap.put("image","https://i.postimg.cc/x87CrVh5/police-3.jpg");
        hashMap.put("email","companiganjps@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "২৯ নভেম্বর ২০২১");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","পুষ্প বরন চাকমা");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "০১৭০৭-০৭৪৪০৪,০১৭০৭-০৭৪৪০৪");
        hashMap.put("image","https://i.postimg.cc/HsqxBHQs/police-4.jpg");
        hashMap.put("email","baranchakmabaran@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "১১ মার্চ ২০২১");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ফেরদৌসী বেগম");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "০১৭১৬-১২৯১৬২");
        hashMap.put("image","https://i.postimg.cc/pTLXpdtk/police-5.jpg");
        hashMap.put("email","companiganjps@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","মোঃ সোহেল মাহমুদ");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৮২৭-৫৬৭৩৭০,+৮৮০ ১৮২৭-৫৬৭৩৭০");
        hashMap.put("email","companiganjps@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", " ০১ ডিসেম্বর ২০২১");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","মোঃ মিদন মিয়া");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৮৬৮-১৮০৩৫২");
        hashMap.put("image","https://i.postimg.cc/MHc6mrHQ/police-7.jpg");
        hashMap.put("email","companiganjps@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","মোঃ আব্দুল মোমেন");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৭১৫-৭৫৫৯৮২");
        hashMap.put("email","এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","সাইফুর রহমান খাঁন");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৭৬৭-৯৪৮১৩৩");
        hashMap.put("image","https://i.postimg.cc/66S5pwbL/police-9.jpg");
        hashMap.put("email","companiganjps@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","এম. আশরাফুল ইসলাম");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৭২৫-৭৪৭৪৩৬");
        hashMap.put("image","https://i.postimg.cc/sDhfB8tF/police-10.jpg");
        hashMap.put("email"," companiganjps@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","মোঃ বিল্লাল হোসেন");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৯২৫-৬৯৩৩০৫");
        hashMap.put("image","https://i.postimg.cc/kgNnsSJf/police-11.jpg");
        hashMap.put("email","companiganjps@gmail.com");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","মোঃ রতন মিয়া");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৭১৬-৩০৮৭৫৭");
        hashMap.put("image","https://i.postimg.cc/DfW4gxt6/police-12.jpg");
        hashMap.put("email","এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","মোঃ মাহফুজুর রহমান");
        hashMap.put("degisnation","সাব-ইন্সপেক্টর");
        hashMap.put("phone", "+৮৮০ ১৭২২-৭৬৯৪৬৭");
        hashMap.put("image","https://i.postimg.cc/MKVMkvZj/police-13.jpg");
        hashMap.put("email","এই মর্মে জানা যায়নি");
        hashMap.put("upTimeTitle","যোগদানের তারিখ");
        hashMap.put("upTime", "এই মর্মে জানা যায়নি");
        hashMap.put("upBatchNo","ব্যাচ (বিসিএস)");
        hashMap.put("upBatch", "এই মর্মে জানা যায়নি");
        hashMap.put("sectorName", "উপজেলা পুলিশ কর্মকর্তাবৃন্দ");
        arrayList.add(hashMap);













    }
}