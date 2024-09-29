package ItemLayout;

import android.content.Intent;
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

import HealthPackage.AmbulanceList;

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
            TextView policeName,policeQulafication,joinTime,policeGmail;
            ImageView policeImage;
            CardView policeCardView;
            Button policeDail;

            public readHolder(@NonNull View itemView) {
                super(itemView);
                policeName = itemView.findViewById(R.id.policeName);
                policeQulafication = itemView.findViewById(R.id.policeQulafication);
                joinTime = itemView.findViewById(R.id.joinTime);
                policeGmail = itemView.findViewById(R.id.policeGmail);
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
            String joinTime = hashMap.get("joinTime");

            readHolder.policeCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.policeCardView.getContext(),R.anim.recycler_anim02));
            //Picasso.get().load(image).into(readHolder.policeImage);


            readHolder.policeName.setText(name);
            readHolder.policeQulafication.setText(degisnation);
            readHolder.policeGmail.setText(email);
            readHolder.joinTime.setText(joinTime);



            readHolder.policeDail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+phone));
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
        hashMap.put("name","মোহাম্মদ সাদিকুর রহমান");
        hashMap.put("degisnation","অফিসার ইনচার্জ");
        hashMap.put("phone",  "০১৩২০১১১০৮৫");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("email",  "companiganjps@gmail.com");
        hashMap.put("joinTime",  "বর্তমান কর্মস্থলে যোগদানের তারিখ : ০৯ আগষ্ট ২০২২");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","মোহাম্মদ সাদিকুর রহমান");
        hashMap.put("degisnation","অফিসার ইনচার্জ");
        hashMap.put("phone",  "০১৩২০১১১০৮৫");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("email",  "companiganjps@gmail.com");
        hashMap.put("joinTime",  "বর্তমান কর্মস্থলে যোগদানের তারিখ : ০৯ আগষ্ট ২০২২");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","মোহাম্মদ সাদিকুর রহমান");
        hashMap.put("degisnation","অফিসার ইনচার্জ");
        hashMap.put("phone",  "০১৩২০১১১০৮৫");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("email",  "companiganjps@gmail.com");
        hashMap.put("joinTime",  "বর্তমান কর্মস্থলে যোগদানের তারিখ : ০৯ আগষ্ট ২০২২");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","মোহাম্মদ সাদিকুর রহমান");
        hashMap.put("degisnation","অফিসার ইনচার্জ");
        hashMap.put("phone",  "০১৩২০১১১০৮৫");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("email",  "companiganjps@gmail.com");
        hashMap.put("joinTime",  "বর্তমান কর্মস্থলে যোগদানের তারিখ : ০৯ আগষ্ট ২০২২");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","মোহাম্মদ সাদিকুর রহমান");
        hashMap.put("degisnation","অফিসার ইনচার্জ");
        hashMap.put("phone",  "০১৩২০১১১০৮৫");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("email",  "companiganjps@gmail.com");
        hashMap.put("joinTime",  "বর্তমান কর্মস্থলে যোগদানের তারিখ : ০৯ আগষ্ট ২০২২");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","মোহাম্মদ সাদিকুর রহমান");
        hashMap.put("degisnation","অফিসার ইনচার্জ");
        hashMap.put("phone",  "০১৩২০১১১০৮৫");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("email",  "companiganjps@gmail.com");
        hashMap.put("joinTime",  "বর্তমান কর্মস্থলে যোগদানের তারিখ : ০৯ আগষ্ট ২০২২");
        arrayList.add(hashMap);

    }
}