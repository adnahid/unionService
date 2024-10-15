package NagorikSheba;

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

import HealthPackage.PharmecyList;

public class InternetProvider extends AppCompatActivity {

    RecyclerView internetRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_internet_provider);
        toolbar = findViewById(R.id.toolbar);
        internetRecyclerView = findViewById(R.id.internetRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        InternetAdapter internetAdapter = new InternetAdapter();
        internetRecyclerView.setAdapter(internetAdapter);
        internetRecyclerView.setLayoutManager(new LinearLayoutManager(InternetProvider.this));


    }

    private class InternetAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
            TextView pharmacyTitle,pharmacyName,pharmacyAddress,pharmacySameLineTv;
            ImageView pharmacyImage;
            CardView pharmacyCardView,pharmacyDail,pharmacyMessage;

            public readHolder(@NonNull View itemView) {
                super(itemView);
                pharmacyTitle = itemView.findViewById(R.id.pharmacyTitle);
                pharmacyName = itemView.findViewById(R.id.pharmacyName);
                pharmacyAddress = itemView.findViewById(R.id.pharmacyAddress);
                pharmacySameLineTv = itemView.findViewById(R.id.pharmacySameLineTv);
                pharmacyImage = itemView.findViewById(R.id.pharmacyImage);
                pharmacyCardView = itemView.findViewById(R.id.pharmacyCardView);
                pharmacyDail = itemView.findViewById(R.id.pharmacyDail);
                pharmacyMessage = itemView.findViewById(R.id.pharmacyMessage);


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


            View view = layoutInflater.inflate(R.layout.pharmacy_item, parent, false);
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
            String pharmacyTitle  = hashMap.get("pharmacyTitle");
            String pharmacyName = hashMap.get("pharmacyName");
            String pharmacyAddress  = hashMap.get("pharmacyAddress");
            String pharmacyImage = hashMap.get("pharmacyImage");
            String pharmacySameLineTv  = hashMap.get("pharmacySameLineTv");
            String phone = hashMap.get("phone");


            readHolder.pharmacyCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.pharmacyCardView.getContext(),R.anim.recycler_anim03));
            Picasso.get().load(pharmacyImage).placeholder(R.drawable.person).into(readHolder.pharmacyImage);


            readHolder.pharmacyTitle.setText(pharmacyTitle);
            readHolder.pharmacyName.setText(pharmacyName);
            readHolder.pharmacyAddress.setText(pharmacyAddress);
            readHolder.pharmacySameLineTv.setText(pharmacySameLineTv);




            readHolder.pharmacyDail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+phone));
                    startActivity(intent);
                }
            });

            readHolder.pharmacyMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                        Intent intent = new Intent(Intent.ACTION_SEND);
//                        intent = Intent.createChooser(intent,"sms:"+phoneNumber);
//                        startActivity(intent);

                    Uri uri = Uri.parse("smsto:" + phone);

                    Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
                    // add the message at the sms_body extra field
                    smsSIntent.putExtra("sms_body", body);
                    try{
                        startActivity(smsSIntent);
                    } catch (Exception ex) {
                        Toast.makeText(InternetProvider.this, "Your sms has failed...",
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


    public void DetailsTable(){

        arrayList = new ArrayList<>();
        hashMap = new HashMap<>();
        hashMap.put("pharmacyTitle","Maa Medical Hol");
        hashMap.put("pharmacyName","Dr.Alli Hasan Mbbs bsc dhaka Medical");
        hashMap.put("pharmacyAddress",  "Sirajpur,Companigongetc");
        hashMap.put("pharmacyImage",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("pharmacySameLineTv",  "pharmecy Relative same lines");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("pharmacyTitle","Maa Medical Hol");
        hashMap.put("pharmacyName","Dr.Alli Hasan Mbbs bsc dhaka Medical");
        hashMap.put("pharmacyAddress",  "Sirajpur,Companigongetc");
        hashMap.put("pharmacyImage",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("pharmacySameLineTv",  "pharmecy Relative same lines");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("pharmacyTitle","Maa Medical Hol");
        hashMap.put("pharmacyName","Dr.Alli Hasan Mbbs bsc dhaka Medical");
        hashMap.put("pharmacyAddress",  "Sirajpur,Companigongetc");
        hashMap.put("pharmacyImage",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("pharmacySameLineTv",  "pharmecy Relative same lines");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("pharmacyTitle","Maa Medical Hol");
        hashMap.put("pharmacyName","Dr.Alli Hasan Mbbs bsc dhaka Medical");
        hashMap.put("pharmacyAddress",  "Sirajpur,Companigongetc");
        hashMap.put("pharmacyImage",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("pharmacySameLineTv",  "pharmecy Relative same lines");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("pharmacyTitle","Maa Medical Hol");
        hashMap.put("pharmacyName","Dr.Alli Hasan Mbbs bsc dhaka Medical");
        hashMap.put("pharmacyAddress",  "Sirajpur,Companigongetc");
        hashMap.put("pharmacyImage",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("pharmacySameLineTv",  "pharmecy Relative same lines");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("pharmacyTitle","Maa Medical Hol");
        hashMap.put("pharmacyName","Dr.Alli Hasan Mbbs bsc dhaka Medical");
        hashMap.put("pharmacyAddress",  "Sirajpur,Companigongetc");
        hashMap.put("pharmacyImage",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        hashMap.put("pharmacySameLineTv",  "pharmecy Relative same lines");
        hashMap.put("phone",  "01632-243524");
        arrayList.add(hashMap);





    }
}