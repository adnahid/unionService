package HealthPackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unionservice.R;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;


public class ONegitive extends Fragment {

    RecyclerView oNegRecyclerView;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body = "Hi there";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myview = inflater.inflate(R.layout.fragment_o_negitive, container, false);

        oNegRecyclerView = myview.findViewById(R.id.oNegRecyclerView);

        DetailsTable();
        OnegAdapter onegAdapter = new OnegAdapter();
        oNegRecyclerView.setAdapter(onegAdapter);
        oNegRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return myview;


    }
    private class OnegAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{


            TextView bloodName,bloodNumber,bloodDetails;
            CircleImageView bloodMan,bloodMessage,bloodCall;
            CardView bloodCardView;


            public readHolder(@NonNull View itemView) {
                super(itemView);
                bloodName = itemView.findViewById(R.id.bloodName);
                bloodNumber = itemView.findViewById(R.id.bloodNumber);
                bloodDetails = itemView.findViewById(R.id.bloodDetails);
                bloodMan = itemView.findViewById(R.id.bloodMan);
                bloodMessage = itemView.findViewById(R.id.bloodMessage);
                bloodCardView = itemView.findViewById(R.id.bloodCardView);
                bloodCall = itemView.findViewById(R.id.bloodCall);




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


            View view = layoutInflater.inflate(R.layout.blood_item, parent, false);
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
            String number = hashMap.get("number");
            String shortDes  = hashMap.get("shortDes");
            String imageBloodMan = hashMap.get("imageBloodMan");

            readHolder.bloodCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.bloodCardView.getContext(),R.anim.recycler_anim02));

            readHolder.bloodName.setText(name);
            readHolder.bloodDetails.setText(shortDes);
            String bloodPh = String.valueOf(number.toString());
            readHolder.bloodNumber.setText(bloodPh);

            //Picasso.get().load("").into(readHolder.diverImage);
            readHolder.bloodCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+bloodPh));
                    startActivity(intent);
                }
            });

            readHolder.bloodMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                        Intent intent = new Intent(Intent.ACTION_SEND);
//                        intent = Intent.createChooser(intent,"sms:"+phoneNumber);
//                        startActivity(intent);

                    Uri uri = Uri.parse("smsto:" +bloodPh);

                    Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
                    // add the message at the sms_body extra field
                    smsSIntent.putExtra("sms_body", body);
                    try{
                        startActivity(smsSIntent);
                    } catch (Exception ex) {
                        Toast.makeText(getActivity(), "Your sms has failed...",
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
        hashMap.put("name","Dr.Alli Hasan");
        hashMap.put("number","01632-243524");
        hashMap.put("shortDes",  "Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("imageBloodMan","https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Dr.Alli Hasan");
        hashMap.put("number","01632-243524");
        hashMap.put("shortDes",  "Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("imageBloodMan",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Dr.Alli Hasan");
        hashMap.put("number","01632-243524");
        hashMap.put("shortDes",  "Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("imageBloodMan",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Dr.Alli Hasan");
        hashMap.put("number","01632-243524");
        hashMap.put("shortDes",  "Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("imageBloodMan",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Dr.Alli Hasan");
        hashMap.put("number","01632-243524");
        hashMap.put("shortDes",  "Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("imageBloodMan",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Dr.Alli Hasan");
        hashMap.put("number","01632-243524");
        hashMap.put("shortDes",  "Dr.Alli Hasan Mbbs bsc dhaka Medical Mbbs bsc dhaka Medical");
        hashMap.put("imageBloodMan",  "https://cdn-icons-png.flaticon.com/128/16146/16146868.png");
        arrayList.add(hashMap);





    }
}