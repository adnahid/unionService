package com.example.unionservice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import ItemLayout.DetailsUnion;
import ItemLayout.ThanaPolicy;
import ItemLayout.UpzilaHostory;



public class FourthFragment extends Fragment {


    RecyclerView recyclerViewUnionGridView;


    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        recyclerViewUnionGridView = view.findViewById(R.id.recyclerViewUnionGridView);


         UnionDetailsTable();
         GirdAdapter girdAdapter  = new GirdAdapter();
         recyclerViewUnionGridView.setAdapter(girdAdapter);
         recyclerViewUnionGridView.setLayoutManager(new GridLayoutManager(getActivity(),3));




        return view;
    }
    private class GirdAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
            TextView unionTextTv;
            ImageView unionImage;
            CardView unionCardView;


            public readHolder(@NonNull View itemView) {
                super(itemView);
                unionTextTv = itemView.findViewById(R.id.unionTextTv);
                unionImage = itemView.findViewById(R.id.unionImage);
                unionCardView = itemView.findViewById(R.id.unionCardView);



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

            View view = layoutInflater.inflate(R.layout.union_item, parent, false);
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
            String unionName  = hashMap.get("unionName");
            String image = hashMap.get("image");
            String desName  = hashMap.get("desName");
            String sizeTv = hashMap.get("sizeTv");
            String sizeDesTv = hashMap.get("sizeDesTv");
            String peopleTv = hashMap.get("peopleTv");
            String peopleDesTv = hashMap.get("peopleDesTv");
            String stayTv = hashMap.get("stayTv");
            String stayDesTv = hashMap.get("stayDesTv");
            String administrativeTv = hashMap.get("administrativeTv");
            String administrativeDesTv = hashMap.get("administrativeDesTv");
            String studiesTv = hashMap.get("studiesTv");
            String studiesDesTv = hashMap.get("studiesDesTv");
            String educationalInstitutionsTv = hashMap.get("educationalInstitutionsTv");
            String educationalInstitutionsDesTv = hashMap.get("educationalInstitutionsDesTv");
            String communicationTv = hashMap.get("communicationTv");
            String communicationDesTv = hashMap.get("communicationDesTv");
            String riverTv = hashMap.get("riverTv");
            String riverListTv = hashMap.get("riverListTv");
            String riverDesTv = hashMap.get("riverDesTv");
            String bazerTv = hashMap.get("bazerTv");
            String bazerListTv = hashMap.get("bazerListTv");
            String bazerListDesTv = hashMap.get("bazerListDesTv");
            String representativeTv = hashMap.get("representativeTv");
            String representativeImage = hashMap.get("representativeImage");




            readHolder.unionCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.unionCardView.getContext(),R.anim.recycler_anim02));
            Picasso.get().load(image).placeholder(R.drawable.doctor).into(readHolder.unionImage);
            readHolder.unionTextTv.setText(unionName);


            readHolder.unionCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),DetailsUnion.class);
                    DetailsUnion.DESTV = desName;
                    DetailsUnion.SIZETV = sizeTv;
                    DetailsUnion.SizeDes = sizeDesTv;
                    DetailsUnion.PeopleTv = peopleTv;

                    DetailsUnion.PeopleDesTv = peopleDesTv;
                    DetailsUnion.StayTv = stayTv;
                    DetailsUnion.StayDesTv = stayDesTv;
                    DetailsUnion.AdministrativeTv = administrativeTv;
                    DetailsUnion.AdministrativeDesTv = administrativeDesTv;
                    DetailsUnion.StudiesTv = studiesTv;
                    DetailsUnion.StudiesDesTv = studiesDesTv;
                    DetailsUnion.EducationalInstitutionsTv = educationalInstitutionsTv;
                    DetailsUnion.EducationalInstitutionsDesTv = educationalInstitutionsDesTv;
                    DetailsUnion.CommunicationTv = communicationTv;
                    DetailsUnion.CommunicationDesTv = communicationDesTv;
                    DetailsUnion.RiverTv = riverTv;
                    DetailsUnion.RiverListTv = riverListTv;
                    DetailsUnion.RiverDesTv = riverDesTv;
                    DetailsUnion.BazerTv = bazerTv;
                    DetailsUnion.BazerListTv = bazerListTv;
                    DetailsUnion.BazerListDesTv = bazerListDesTv;
                    DetailsUnion.RepresentativeTv = representativeTv;






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


    public void UnionDetailsTable(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("unionName","সিরাজপুর ইউনিয়ন");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("desName","সিরাজপুর বাংলাদেশের নোয়াখালী জেলার অন্তর্গত কোম্পানীগঞ্জ উপজেলার একটি ইউনিয়ন।");
        hashMap.put("sizeTv","আয়তনঃ");
        hashMap.put("sizeDesTv","সিরাজপুর ইউনিয়নের আয়তন ১৪.৬৩ বর্গ কিলোমিটার।");
        hashMap.put("peopleTv","জনসংখ্যাঃ");
        hashMap.put("peopleDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের জনসংখ্যা ২৯,৯৫৬ জন।");
        hashMap.put("stayTv","অবস্থান ও সীমানাঃ");
        hashMap.put("stayDesTv","কোম্পানীগঞ্জ উপজেলার উত্তর-পশ্চিমাংশে সিরাজপুর ইউনিয়নের অবস্থান। এ ইউনিয়নের দক্ষিণ-পূর্বে চর পার্বতী ইউনিয়ন, বসুরহাট পৌরসভা ও চর কাঁকড়া ইউনিয়ন; পশ্চিমে কবিরহাট উপজেলার ধানশালিক ইউনিয়ন ও বাটইয়া ইউনিয়ন এবং উত্তরে সেনবাগ উপজেলার নবীপুর ইউনিয়ন ও ফেনী জেলার দাগনভূঞা উপজেলার ইয়াকুবপুর ইউনিয়ন অবস্থিত।");
        hashMap.put("administrativeTv","প্রশাসনিক কাঠামোঃ");

        hashMap.put("administrativeDesTv","সিরাজপুর ইউনিয়ন কোম্পানীগঞ্জ উপজেলার আওতাধীন ১নং ইউনিয়ন পরিষদ। এ ইউনিয়নের প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ থানার আওতাধীন। এটি জাতীয় সংসদের ২৭২নং নির্বাচনী এলাকা নোয়াখালী-৫ এর অংশ। ইউনিয়ন চেয়ারম্যান: নাজিম উদ্দিন মিকন। এ ইউনিয়নের গ্রামগুলো হল:\n" +
                "•\tবড় রাজাপুর\n" +
                "•\tবিরাহিমপুর\n" +
                "•\tছোট রাজাপুর\n" +
                "•\tহাবিবপুর\n" +
                "•\tমোহাম্মদ নগর\n" +
                "•\tশাহজাদপুর\n" +
                "•\tসিরাজপুর\n" +
                "•\tউদরাজপুর\n" +
                "•\tউত্তর মুসাপুর\n");

        hashMap.put("studiesTv","শিক্ষা ব্যবস্থাঃ");
        hashMap.put("studiesDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের স্বাক্ষরতার হার ৫৮.৯%।[১] এ ইউনিয়নে ১১টি সরকারি প্রাথমিক বিদ্যালয় রয়েছে।");

        hashMap.put("educationalInstitutionsTv","শিক্ষা প্রতিষ্ঠানঃ");
        hashMap.put("educationalInstitutionsDesTv","•\tমানিকপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপূর্ব যোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tরাজাপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tহাবিবপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tশাহজাদপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া বালিকা বিদ্যালয় সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম সিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম মোহাম্মদনগর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tবিরাহিমপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম বিরাহিমপুর রেজিস্টার্ড বেসরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tসিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n");

        hashMap.put("communicationTv","যোগাযোগ ব্যবস্থাঃ");
        hashMap.put("communicationDesTv","কোম্পানীগঞ্জ উপজেলা গেইট থেকে সিএনজি অথবা রিক্সাযোগে আসলে ইউনিয়ন পরিষদ কমপ্লক্স দেখা যাবে।");
        hashMap.put("riverTv","খাল ও নদী");
        hashMap.put("riverListTv","খাল ও নদীর তালিকাঃ");

        hashMap.put("riverDesTv","•\tসিরাজপুর–শাহজাদপুর খাল\n" +
                "•\tসিরাজপুর–বিরাহিমপুর খাল\n" +
                "•\tহাবিবপুর–বিরাহিমপুর খাল\n" +
                "•\tকালীবাড়ি–দুধমূখা খাল\n");

        hashMap.put("bazerTv","হাট-বাজার");
        hashMap.put("bazerListTv","হাট-বাজারের তালিকাঃ");

        hashMap.put("bazerListDesTv","•\tপাটোয়ারী হাট\n" +
                "•\tকদমতলা বাজার\n" +
                "•\tহাজারী হাট\n" +
                "•\tশান্তির হাট\n" +
                "•\tপেশকার হাট\n" +
                "•\tচাপ্রাশির হাট (পূর্ব বাজার)\n" +
                "•\tতালেব মোহাম্মদ হাট\n" +
                "•\tরংমালা বাজার\n" +
                "•\tবাংলা বাজার\n" +
                "•\tমুছাপুর চৌধুরী হাট\n" +
                "•\tচর এলাহী বাজার\n" +
                "•\tগাংচিল বাজার\n" +
                "•\tসৈকত বাজার\n");

        hashMap.put("representativeTv","জনপ্রতিনিধিঃ");
        hashMap.put("representativeImage","http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("unionName","সিরাজপুর ইউনিয়ন");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("desName","সিরাজপুর বাংলাদেশের নোয়াখালী জেলার অন্তর্গত কোম্পানীগঞ্জ উপজেলার একটি ইউনিয়ন।");
        hashMap.put("sizeTv","আয়তনঃ");
        hashMap.put("sizeDesTv","সিরাজপুর ইউনিয়নের আয়তন ১৪.৬৩ বর্গ কিলোমিটার।");
        hashMap.put("peopleTv","জনসংখ্যাঃ");
        hashMap.put("peopleDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের জনসংখ্যা ২৯,৯৫৬ জন।");
        hashMap.put("stayTv","অবস্থান ও সীমানাঃ");
        hashMap.put("stayDesTv","কোম্পানীগঞ্জ উপজেলার উত্তর-পশ্চিমাংশে সিরাজপুর ইউনিয়নের অবস্থান। এ ইউনিয়নের দক্ষিণ-পূর্বে চর পার্বতী ইউনিয়ন, বসুরহাট পৌরসভা ও চর কাঁকড়া ইউনিয়ন; পশ্চিমে কবিরহাট উপজেলার ধানশালিক ইউনিয়ন ও বাটইয়া ইউনিয়ন এবং উত্তরে সেনবাগ উপজেলার নবীপুর ইউনিয়ন ও ফেনী জেলার দাগনভূঞা উপজেলার ইয়াকুবপুর ইউনিয়ন অবস্থিত।");
        hashMap.put("administrativeTv","প্রশাসনিক কাঠামোঃ");

        hashMap.put("administrativeDesTv","সিরাজপুর ইউনিয়ন কোম্পানীগঞ্জ উপজেলার আওতাধীন ১নং ইউনিয়ন পরিষদ। এ ইউনিয়নের প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ থানার আওতাধীন। এটি জাতীয় সংসদের ২৭২নং নির্বাচনী এলাকা নোয়াখালী-৫ এর অংশ। ইউনিয়ন চেয়ারম্যান: নাজিম উদ্দিন মিকন। এ ইউনিয়নের গ্রামগুলো হল:\n" +
                "•\tবড় রাজাপুর\n" +
                "•\tবিরাহিমপুর\n" +
                "•\tছোট রাজাপুর\n" +
                "•\tহাবিবপুর\n" +
                "•\tমোহাম্মদ নগর\n" +
                "•\tশাহজাদপুর\n" +
                "•\tসিরাজপুর\n" +
                "•\tউদরাজপুর\n" +
                "•\tউত্তর মুসাপুর\n");

        hashMap.put("studiesTv","শিক্ষা ব্যবস্থাঃ");
        hashMap.put("studiesDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের স্বাক্ষরতার হার ৫৮.৯%।[১] এ ইউনিয়নে ১১টি সরকারি প্রাথমিক বিদ্যালয় রয়েছে।");

        hashMap.put("educationalInstitutionsTv","শিক্ষা প্রতিষ্ঠানঃ");
        hashMap.put("educationalInstitutionsDesTv","•\tমানিকপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপূর্ব যোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tরাজাপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tহাবিবপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tশাহজাদপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া বালিকা বিদ্যালয় সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম সিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম মোহাম্মদনগর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tবিরাহিমপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম বিরাহিমপুর রেজিস্টার্ড বেসরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tসিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n");

        hashMap.put("communicationTv","যোগাযোগ ব্যবস্থাঃ");
        hashMap.put("communicationDesTv","কোম্পানীগঞ্জ উপজেলা গেইট থেকে সিএনজি অথবা রিক্সাযোগে আসলে ইউনিয়ন পরিষদ কমপ্লক্স দেখা যাবে।");
        hashMap.put("riverTv","খাল ও নদী");
        hashMap.put("riverListTv","খাল ও নদীর তালিকাঃ");

        hashMap.put("riverDesTv","•\tসিরাজপুর–শাহজাদপুর খাল\n" +
                "•\tসিরাজপুর–বিরাহিমপুর খাল\n" +
                "•\tহাবিবপুর–বিরাহিমপুর খাল\n" +
                "•\tকালীবাড়ি–দুধমূখা খাল\n");

        hashMap.put("bazerTv","হাট-বাজার");
        hashMap.put("bazerListTv","হাট-বাজারের তালিকাঃ");

        hashMap.put("bazerListDesTv","•\tপাটোয়ারী হাট\n" +
                "•\tকদমতলা বাজার\n" +
                "•\tহাজারী হাট\n" +
                "•\tশান্তির হাট\n" +
                "•\tপেশকার হাট\n" +
                "•\tচাপ্রাশির হাট (পূর্ব বাজার)\n" +
                "•\tতালেব মোহাম্মদ হাট\n" +
                "•\tরংমালা বাজার\n" +
                "•\tবাংলা বাজার\n" +
                "•\tমুছাপুর চৌধুরী হাট\n" +
                "•\tচর এলাহী বাজার\n" +
                "•\tগাংচিল বাজার\n" +
                "•\tসৈকত বাজার\n");

        hashMap.put("representativeTv","জনপ্রতিনিধিঃ");
        hashMap.put("representativeImage","http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("unionName","সিরাজপুর ইউনিয়ন");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("desName","সিরাজপুর বাংলাদেশের নোয়াখালী জেলার অন্তর্গত কোম্পানীগঞ্জ উপজেলার একটি ইউনিয়ন।");
        hashMap.put("sizeTv","আয়তনঃ");
        hashMap.put("sizeDesTv","সিরাজপুর ইউনিয়নের আয়তন ১৪.৬৩ বর্গ কিলোমিটার।");
        hashMap.put("peopleTv","জনসংখ্যাঃ");
        hashMap.put("peopleDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের জনসংখ্যা ২৯,৯৫৬ জন।");
        hashMap.put("stayTv","অবস্থান ও সীমানাঃ");
        hashMap.put("stayDesTv","কোম্পানীগঞ্জ উপজেলার উত্তর-পশ্চিমাংশে সিরাজপুর ইউনিয়নের অবস্থান। এ ইউনিয়নের দক্ষিণ-পূর্বে চর পার্বতী ইউনিয়ন, বসুরহাট পৌরসভা ও চর কাঁকড়া ইউনিয়ন; পশ্চিমে কবিরহাট উপজেলার ধানশালিক ইউনিয়ন ও বাটইয়া ইউনিয়ন এবং উত্তরে সেনবাগ উপজেলার নবীপুর ইউনিয়ন ও ফেনী জেলার দাগনভূঞা উপজেলার ইয়াকুবপুর ইউনিয়ন অবস্থিত।");
        hashMap.put("administrativeTv","প্রশাসনিক কাঠামোঃ");

        hashMap.put("administrativeDesTv","সিরাজপুর ইউনিয়ন কোম্পানীগঞ্জ উপজেলার আওতাধীন ১নং ইউনিয়ন পরিষদ। এ ইউনিয়নের প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ থানার আওতাধীন। এটি জাতীয় সংসদের ২৭২নং নির্বাচনী এলাকা নোয়াখালী-৫ এর অংশ। ইউনিয়ন চেয়ারম্যান: নাজিম উদ্দিন মিকন। এ ইউনিয়নের গ্রামগুলো হল:\n" +
                "•\tবড় রাজাপুর\n" +
                "•\tবিরাহিমপুর\n" +
                "•\tছোট রাজাপুর\n" +
                "•\tহাবিবপুর\n" +
                "•\tমোহাম্মদ নগর\n" +
                "•\tশাহজাদপুর\n" +
                "•\tসিরাজপুর\n" +
                "•\tউদরাজপুর\n" +
                "•\tউত্তর মুসাপুর\n");

        hashMap.put("studiesTv","শিক্ষা ব্যবস্থাঃ");
        hashMap.put("studiesDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের স্বাক্ষরতার হার ৫৮.৯%।[১] এ ইউনিয়নে ১১টি সরকারি প্রাথমিক বিদ্যালয় রয়েছে।");

        hashMap.put("educationalInstitutionsTv","শিক্ষা প্রতিষ্ঠানঃ");
        hashMap.put("educationalInstitutionsDesTv","•\tমানিকপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপূর্ব যোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tরাজাপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tহাবিবপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tশাহজাদপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া বালিকা বিদ্যালয় সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম সিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম মোহাম্মদনগর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tবিরাহিমপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম বিরাহিমপুর রেজিস্টার্ড বেসরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tসিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n");

        hashMap.put("communicationTv","যোগাযোগ ব্যবস্থাঃ");
        hashMap.put("communicationDesTv","কোম্পানীগঞ্জ উপজেলা গেইট থেকে সিএনজি অথবা রিক্সাযোগে আসলে ইউনিয়ন পরিষদ কমপ্লক্স দেখা যাবে।");
        hashMap.put("riverTv","খাল ও নদী");
        hashMap.put("riverListTv","খাল ও নদীর তালিকাঃ");

        hashMap.put("riverDesTv","•\tসিরাজপুর–শাহজাদপুর খাল\n" +
                "•\tসিরাজপুর–বিরাহিমপুর খাল\n" +
                "•\tহাবিবপুর–বিরাহিমপুর খাল\n" +
                "•\tকালীবাড়ি–দুধমূখা খাল\n");

        hashMap.put("bazerTv","হাট-বাজার");
        hashMap.put("bazerListTv","হাট-বাজারের তালিকাঃ");

        hashMap.put("bazerListDesTv","•\tপাটোয়ারী হাট\n" +
                "•\tকদমতলা বাজার\n" +
                "•\tহাজারী হাট\n" +
                "•\tশান্তির হাট\n" +
                "•\tপেশকার হাট\n" +
                "•\tচাপ্রাশির হাট (পূর্ব বাজার)\n" +
                "•\tতালেব মোহাম্মদ হাট\n" +
                "•\tরংমালা বাজার\n" +
                "•\tবাংলা বাজার\n" +
                "•\tমুছাপুর চৌধুরী হাট\n" +
                "•\tচর এলাহী বাজার\n" +
                "•\tগাংচিল বাজার\n" +
                "•\tসৈকত বাজার\n");

        hashMap.put("representativeTv","জনপ্রতিনিধিঃ");
        hashMap.put("representativeImage","http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("unionName","সিরাজপুর ইউনিয়ন");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("desName","সিরাজপুর বাংলাদেশের নোয়াখালী জেলার অন্তর্গত কোম্পানীগঞ্জ উপজেলার একটি ইউনিয়ন।");
        hashMap.put("sizeTv","আয়তনঃ");
        hashMap.put("sizeDesTv","সিরাজপুর ইউনিয়নের আয়তন ১৪.৬৩ বর্গ কিলোমিটার।");
        hashMap.put("peopleTv","জনসংখ্যাঃ");
        hashMap.put("peopleDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের জনসংখ্যা ২৯,৯৫৬ জন।");
        hashMap.put("stayTv","অবস্থান ও সীমানাঃ");
        hashMap.put("stayDesTv","কোম্পানীগঞ্জ উপজেলার উত্তর-পশ্চিমাংশে সিরাজপুর ইউনিয়নের অবস্থান। এ ইউনিয়নের দক্ষিণ-পূর্বে চর পার্বতী ইউনিয়ন, বসুরহাট পৌরসভা ও চর কাঁকড়া ইউনিয়ন; পশ্চিমে কবিরহাট উপজেলার ধানশালিক ইউনিয়ন ও বাটইয়া ইউনিয়ন এবং উত্তরে সেনবাগ উপজেলার নবীপুর ইউনিয়ন ও ফেনী জেলার দাগনভূঞা উপজেলার ইয়াকুবপুর ইউনিয়ন অবস্থিত।");
        hashMap.put("administrativeTv","প্রশাসনিক কাঠামোঃ");

        hashMap.put("administrativeDesTv","সিরাজপুর ইউনিয়ন কোম্পানীগঞ্জ উপজেলার আওতাধীন ১নং ইউনিয়ন পরিষদ। এ ইউনিয়নের প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ থানার আওতাধীন। এটি জাতীয় সংসদের ২৭২নং নির্বাচনী এলাকা নোয়াখালী-৫ এর অংশ। ইউনিয়ন চেয়ারম্যান: নাজিম উদ্দিন মিকন। এ ইউনিয়নের গ্রামগুলো হল:\n" +
                "•\tবড় রাজাপুর\n" +
                "•\tবিরাহিমপুর\n" +
                "•\tছোট রাজাপুর\n" +
                "•\tহাবিবপুর\n" +
                "•\tমোহাম্মদ নগর\n" +
                "•\tশাহজাদপুর\n" +
                "•\tসিরাজপুর\n" +
                "•\tউদরাজপুর\n" +
                "•\tউত্তর মুসাপুর\n");

        hashMap.put("studiesTv","শিক্ষা ব্যবস্থাঃ");
        hashMap.put("studiesDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের স্বাক্ষরতার হার ৫৮.৯%।[১] এ ইউনিয়নে ১১টি সরকারি প্রাথমিক বিদ্যালয় রয়েছে।");

        hashMap.put("educationalInstitutionsTv","শিক্ষা প্রতিষ্ঠানঃ");
        hashMap.put("educationalInstitutionsDesTv","•\tমানিকপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপূর্ব যোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tরাজাপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tহাবিবপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tশাহজাদপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া বালিকা বিদ্যালয় সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম সিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম মোহাম্মদনগর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tবিরাহিমপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম বিরাহিমপুর রেজিস্টার্ড বেসরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tসিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n");

        hashMap.put("communicationTv","যোগাযোগ ব্যবস্থাঃ");
        hashMap.put("communicationDesTv","কোম্পানীগঞ্জ উপজেলা গেইট থেকে সিএনজি অথবা রিক্সাযোগে আসলে ইউনিয়ন পরিষদ কমপ্লক্স দেখা যাবে।");
        hashMap.put("riverTv","খাল ও নদী");
        hashMap.put("riverListTv","খাল ও নদীর তালিকাঃ");

        hashMap.put("riverDesTv","•\tসিরাজপুর–শাহজাদপুর খাল\n" +
                "•\tসিরাজপুর–বিরাহিমপুর খাল\n" +
                "•\tহাবিবপুর–বিরাহিমপুর খাল\n" +
                "•\tকালীবাড়ি–দুধমূখা খাল\n");

        hashMap.put("bazerTv","হাট-বাজার");
        hashMap.put("bazerListTv","হাট-বাজারের তালিকাঃ");

        hashMap.put("bazerListDesTv","•\tপাটোয়ারী হাট\n" +
                "•\tকদমতলা বাজার\n" +
                "•\tহাজারী হাট\n" +
                "•\tশান্তির হাট\n" +
                "•\tপেশকার হাট\n" +
                "•\tচাপ্রাশির হাট (পূর্ব বাজার)\n" +
                "•\tতালেব মোহাম্মদ হাট\n" +
                "•\tরংমালা বাজার\n" +
                "•\tবাংলা বাজার\n" +
                "•\tমুছাপুর চৌধুরী হাট\n" +
                "•\tচর এলাহী বাজার\n" +
                "•\tগাংচিল বাজার\n" +
                "•\tসৈকত বাজার\n");

        hashMap.put("representativeTv","জনপ্রতিনিধিঃ");
        hashMap.put("representativeImage","http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("unionName","সিরাজপুর ইউনিয়ন");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("desName","সিরাজপুর বাংলাদেশের নোয়াখালী জেলার অন্তর্গত কোম্পানীগঞ্জ উপজেলার একটি ইউনিয়ন।");
        hashMap.put("sizeTv","আয়তনঃ");
        hashMap.put("sizeDesTv","সিরাজপুর ইউনিয়নের আয়তন ১৪.৬৩ বর্গ কিলোমিটার।");
        hashMap.put("peopleTv","জনসংখ্যাঃ");
        hashMap.put("peopleDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের জনসংখ্যা ২৯,৯৫৬ জন।");
        hashMap.put("stayTv","অবস্থান ও সীমানাঃ");
        hashMap.put("stayDesTv","কোম্পানীগঞ্জ উপজেলার উত্তর-পশ্চিমাংশে সিরাজপুর ইউনিয়নের অবস্থান। এ ইউনিয়নের দক্ষিণ-পূর্বে চর পার্বতী ইউনিয়ন, বসুরহাট পৌরসভা ও চর কাঁকড়া ইউনিয়ন; পশ্চিমে কবিরহাট উপজেলার ধানশালিক ইউনিয়ন ও বাটইয়া ইউনিয়ন এবং উত্তরে সেনবাগ উপজেলার নবীপুর ইউনিয়ন ও ফেনী জেলার দাগনভূঞা উপজেলার ইয়াকুবপুর ইউনিয়ন অবস্থিত।");
        hashMap.put("administrativeTv","প্রশাসনিক কাঠামোঃ");

        hashMap.put("administrativeDesTv","সিরাজপুর ইউনিয়ন কোম্পানীগঞ্জ উপজেলার আওতাধীন ১নং ইউনিয়ন পরিষদ। এ ইউনিয়নের প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ থানার আওতাধীন। এটি জাতীয় সংসদের ২৭২নং নির্বাচনী এলাকা নোয়াখালী-৫ এর অংশ। ইউনিয়ন চেয়ারম্যান: নাজিম উদ্দিন মিকন। এ ইউনিয়নের গ্রামগুলো হল:\n" +
                "•\tবড় রাজাপুর\n" +
                "•\tবিরাহিমপুর\n" +
                "•\tছোট রাজাপুর\n" +
                "•\tহাবিবপুর\n" +
                "•\tমোহাম্মদ নগর\n" +
                "•\tশাহজাদপুর\n" +
                "•\tসিরাজপুর\n" +
                "•\tউদরাজপুর\n" +
                "•\tউত্তর মুসাপুর\n");

        hashMap.put("studiesTv","শিক্ষা ব্যবস্থাঃ");
        hashMap.put("studiesDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের স্বাক্ষরতার হার ৫৮.৯%।[১] এ ইউনিয়নে ১১টি সরকারি প্রাথমিক বিদ্যালয় রয়েছে।");

        hashMap.put("educationalInstitutionsTv","শিক্ষা প্রতিষ্ঠানঃ");
        hashMap.put("educationalInstitutionsDesTv","•\tমানিকপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপূর্ব যোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tরাজাপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tহাবিবপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tশাহজাদপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া বালিকা বিদ্যালয় সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম সিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম মোহাম্মদনগর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tবিরাহিমপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম বিরাহিমপুর রেজিস্টার্ড বেসরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tসিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n");

        hashMap.put("communicationTv","যোগাযোগ ব্যবস্থাঃ");
        hashMap.put("communicationDesTv","কোম্পানীগঞ্জ উপজেলা গেইট থেকে সিএনজি অথবা রিক্সাযোগে আসলে ইউনিয়ন পরিষদ কমপ্লক্স দেখা যাবে।");
        hashMap.put("riverTv","খাল ও নদী");
        hashMap.put("riverListTv","খাল ও নদীর তালিকাঃ");

        hashMap.put("riverDesTv","•\tসিরাজপুর–শাহজাদপুর খাল\n" +
                "•\tসিরাজপুর–বিরাহিমপুর খাল\n" +
                "•\tহাবিবপুর–বিরাহিমপুর খাল\n" +
                "•\tকালীবাড়ি–দুধমূখা খাল\n");

        hashMap.put("bazerTv","হাট-বাজার");
        hashMap.put("bazerListTv","হাট-বাজারের তালিকাঃ");

        hashMap.put("bazerListDesTv","•\tপাটোয়ারী হাট\n" +
                "•\tকদমতলা বাজার\n" +
                "•\tহাজারী হাট\n" +
                "•\tশান্তির হাট\n" +
                "•\tপেশকার হাট\n" +
                "•\tচাপ্রাশির হাট (পূর্ব বাজার)\n" +
                "•\tতালেব মোহাম্মদ হাট\n" +
                "•\tরংমালা বাজার\n" +
                "•\tবাংলা বাজার\n" +
                "•\tমুছাপুর চৌধুরী হাট\n" +
                "•\tচর এলাহী বাজার\n" +
                "•\tগাংচিল বাজার\n" +
                "•\tসৈকত বাজার\n");

        hashMap.put("representativeTv","জনপ্রতিনিধিঃ");
        hashMap.put("representativeImage","http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("unionName","সিরাজপুর ইউনিয়ন");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("desName","সিরাজপুর বাংলাদেশের নোয়াখালী জেলার অন্তর্গত কোম্পানীগঞ্জ উপজেলার একটি ইউনিয়ন।");
        hashMap.put("sizeTv","আয়তনঃ");
        hashMap.put("sizeDesTv","সিরাজপুর ইউনিয়নের আয়তন ১৪.৬৩ বর্গ কিলোমিটার।");
        hashMap.put("peopleTv","জনসংখ্যাঃ");
        hashMap.put("peopleDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের জনসংখ্যা ২৯,৯৫৬ জন।");
        hashMap.put("stayTv","অবস্থান ও সীমানাঃ");
        hashMap.put("stayDesTv","কোম্পানীগঞ্জ উপজেলার উত্তর-পশ্চিমাংশে সিরাজপুর ইউনিয়নের অবস্থান। এ ইউনিয়নের দক্ষিণ-পূর্বে চর পার্বতী ইউনিয়ন, বসুরহাট পৌরসভা ও চর কাঁকড়া ইউনিয়ন; পশ্চিমে কবিরহাট উপজেলার ধানশালিক ইউনিয়ন ও বাটইয়া ইউনিয়ন এবং উত্তরে সেনবাগ উপজেলার নবীপুর ইউনিয়ন ও ফেনী জেলার দাগনভূঞা উপজেলার ইয়াকুবপুর ইউনিয়ন অবস্থিত।");
        hashMap.put("administrativeTv","প্রশাসনিক কাঠামোঃ");

        hashMap.put("administrativeDesTv","সিরাজপুর ইউনিয়ন কোম্পানীগঞ্জ উপজেলার আওতাধীন ১নং ইউনিয়ন পরিষদ। এ ইউনিয়নের প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ থানার আওতাধীন। এটি জাতীয় সংসদের ২৭২নং নির্বাচনী এলাকা নোয়াখালী-৫ এর অংশ। ইউনিয়ন চেয়ারম্যান: নাজিম উদ্দিন মিকন। এ ইউনিয়নের গ্রামগুলো হল:\n" +
                "•\tবড় রাজাপুর\n" +
                "•\tবিরাহিমপুর\n" +
                "•\tছোট রাজাপুর\n" +
                "•\tহাবিবপুর\n" +
                "•\tমোহাম্মদ নগর\n" +
                "•\tশাহজাদপুর\n" +
                "•\tসিরাজপুর\n" +
                "•\tউদরাজপুর\n" +
                "•\tউত্তর মুসাপুর\n");

        hashMap.put("studiesTv","শিক্ষা ব্যবস্থাঃ");
        hashMap.put("studiesDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের স্বাক্ষরতার হার ৫৮.৯%।[১] এ ইউনিয়নে ১১টি সরকারি প্রাথমিক বিদ্যালয় রয়েছে।");

        hashMap.put("educationalInstitutionsTv","শিক্ষা প্রতিষ্ঠানঃ");
        hashMap.put("educationalInstitutionsDesTv","•\tমানিকপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপূর্ব যোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tরাজাপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tহাবিবপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tশাহজাদপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া বালিকা বিদ্যালয় সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম সিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম মোহাম্মদনগর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tবিরাহিমপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম বিরাহিমপুর রেজিস্টার্ড বেসরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tসিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n");

        hashMap.put("communicationTv","যোগাযোগ ব্যবস্থাঃ");
        hashMap.put("communicationDesTv","কোম্পানীগঞ্জ উপজেলা গেইট থেকে সিএনজি অথবা রিক্সাযোগে আসলে ইউনিয়ন পরিষদ কমপ্লক্স দেখা যাবে।");
        hashMap.put("riverTv","খাল ও নদী");
        hashMap.put("riverListTv","খাল ও নদীর তালিকাঃ");

        hashMap.put("riverDesTv","•\tসিরাজপুর–শাহজাদপুর খাল\n" +
                "•\tসিরাজপুর–বিরাহিমপুর খাল\n" +
                "•\tহাবিবপুর–বিরাহিমপুর খাল\n" +
                "•\tকালীবাড়ি–দুধমূখা খাল\n");

        hashMap.put("bazerTv","হাট-বাজার");
        hashMap.put("bazerListTv","হাট-বাজারের তালিকাঃ");

        hashMap.put("bazerListDesTv","•\tপাটোয়ারী হাট\n" +
                "•\tকদমতলা বাজার\n" +
                "•\tহাজারী হাট\n" +
                "•\tশান্তির হাট\n" +
                "•\tপেশকার হাট\n" +
                "•\tচাপ্রাশির হাট (পূর্ব বাজার)\n" +
                "•\tতালেব মোহাম্মদ হাট\n" +
                "•\tরংমালা বাজার\n" +
                "•\tবাংলা বাজার\n" +
                "•\tমুছাপুর চৌধুরী হাট\n" +
                "•\tচর এলাহী বাজার\n" +
                "•\tগাংচিল বাজার\n" +
                "•\tসৈকত বাজার\n");

        hashMap.put("representativeTv","জনপ্রতিনিধিঃ");
        hashMap.put("representativeImage","http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("unionName","সিরাজপুর ইউনিয়ন");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("desName","সিরাজপুর বাংলাদেশের নোয়াখালী জেলার অন্তর্গত কোম্পানীগঞ্জ উপজেলার একটি ইউনিয়ন।");
        hashMap.put("sizeTv","আয়তনঃ");
        hashMap.put("sizeDesTv","সিরাজপুর ইউনিয়নের আয়তন ১৪.৬৩ বর্গ কিলোমিটার।");
        hashMap.put("peopleTv","জনসংখ্যাঃ");
        hashMap.put("peopleDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের জনসংখ্যা ২৯,৯৫৬ জন।");
        hashMap.put("stayTv","অবস্থান ও সীমানাঃ");
        hashMap.put("stayDesTv","কোম্পানীগঞ্জ উপজেলার উত্তর-পশ্চিমাংশে সিরাজপুর ইউনিয়নের অবস্থান। এ ইউনিয়নের দক্ষিণ-পূর্বে চর পার্বতী ইউনিয়ন, বসুরহাট পৌরসভা ও চর কাঁকড়া ইউনিয়ন; পশ্চিমে কবিরহাট উপজেলার ধানশালিক ইউনিয়ন ও বাটইয়া ইউনিয়ন এবং উত্তরে সেনবাগ উপজেলার নবীপুর ইউনিয়ন ও ফেনী জেলার দাগনভূঞা উপজেলার ইয়াকুবপুর ইউনিয়ন অবস্থিত।");
        hashMap.put("administrativeTv","প্রশাসনিক কাঠামোঃ");

        hashMap.put("administrativeDesTv","সিরাজপুর ইউনিয়ন কোম্পানীগঞ্জ উপজেলার আওতাধীন ১নং ইউনিয়ন পরিষদ। এ ইউনিয়নের প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ থানার আওতাধীন। এটি জাতীয় সংসদের ২৭২নং নির্বাচনী এলাকা নোয়াখালী-৫ এর অংশ। ইউনিয়ন চেয়ারম্যান: নাজিম উদ্দিন মিকন। এ ইউনিয়নের গ্রামগুলো হল:\n" +
                "•\tবড় রাজাপুর\n" +
                "•\tবিরাহিমপুর\n" +
                "•\tছোট রাজাপুর\n" +
                "•\tহাবিবপুর\n" +
                "•\tমোহাম্মদ নগর\n" +
                "•\tশাহজাদপুর\n" +
                "•\tসিরাজপুর\n" +
                "•\tউদরাজপুর\n" +
                "•\tউত্তর মুসাপুর\n");

        hashMap.put("studiesTv","শিক্ষা ব্যবস্থাঃ");
        hashMap.put("studiesDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের স্বাক্ষরতার হার ৫৮.৯%।[১] এ ইউনিয়নে ১১টি সরকারি প্রাথমিক বিদ্যালয় রয়েছে।");

        hashMap.put("educationalInstitutionsTv","শিক্ষা প্রতিষ্ঠানঃ");
        hashMap.put("educationalInstitutionsDesTv","•\tমানিকপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপূর্ব যোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tরাজাপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tহাবিবপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tশাহজাদপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া বালিকা বিদ্যালয় সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম সিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম মোহাম্মদনগর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tবিরাহিমপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম বিরাহিমপুর রেজিস্টার্ড বেসরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tসিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n");

        hashMap.put("communicationTv","যোগাযোগ ব্যবস্থাঃ");
        hashMap.put("communicationDesTv","কোম্পানীগঞ্জ উপজেলা গেইট থেকে সিএনজি অথবা রিক্সাযোগে আসলে ইউনিয়ন পরিষদ কমপ্লক্স দেখা যাবে।");
        hashMap.put("riverTv","খাল ও নদী");
        hashMap.put("riverListTv","খাল ও নদীর তালিকাঃ");

        hashMap.put("riverDesTv","•\tসিরাজপুর–শাহজাদপুর খাল\n" +
                "•\tসিরাজপুর–বিরাহিমপুর খাল\n" +
                "•\tহাবিবপুর–বিরাহিমপুর খাল\n" +
                "•\tকালীবাড়ি–দুধমূখা খাল\n");

        hashMap.put("bazerTv","হাট-বাজার");
        hashMap.put("bazerListTv","হাট-বাজারের তালিকাঃ");

        hashMap.put("bazerListDesTv","•\tপাটোয়ারী হাট\n" +
                "•\tকদমতলা বাজার\n" +
                "•\tহাজারী হাট\n" +
                "•\tশান্তির হাট\n" +
                "•\tপেশকার হাট\n" +
                "•\tচাপ্রাশির হাট (পূর্ব বাজার)\n" +
                "•\tতালেব মোহাম্মদ হাট\n" +
                "•\tরংমালা বাজার\n" +
                "•\tবাংলা বাজার\n" +
                "•\tমুছাপুর চৌধুরী হাট\n" +
                "•\tচর এলাহী বাজার\n" +
                "•\tগাংচিল বাজার\n" +
                "•\tসৈকত বাজার\n");

        hashMap.put("representativeTv","জনপ্রতিনিধিঃ");
        hashMap.put("representativeImage","http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("unionName","সিরাজপুর ইউনিয়ন");
        hashMap.put("image",  "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("desName","সিরাজপুর বাংলাদেশের নোয়াখালী জেলার অন্তর্গত কোম্পানীগঞ্জ উপজেলার একটি ইউনিয়ন।");
        hashMap.put("sizeTv","আয়তনঃ");
        hashMap.put("sizeDesTv","সিরাজপুর ইউনিয়নের আয়তন ১৪.৬৩ বর্গ কিলোমিটার।");
        hashMap.put("peopleTv","জনসংখ্যাঃ");
        hashMap.put("peopleDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের জনসংখ্যা ২৯,৯৫৬ জন।");
        hashMap.put("stayTv","অবস্থান ও সীমানাঃ");
        hashMap.put("stayDesTv","কোম্পানীগঞ্জ উপজেলার উত্তর-পশ্চিমাংশে সিরাজপুর ইউনিয়নের অবস্থান। এ ইউনিয়নের দক্ষিণ-পূর্বে চর পার্বতী ইউনিয়ন, বসুরহাট পৌরসভা ও চর কাঁকড়া ইউনিয়ন; পশ্চিমে কবিরহাট উপজেলার ধানশালিক ইউনিয়ন ও বাটইয়া ইউনিয়ন এবং উত্তরে সেনবাগ উপজেলার নবীপুর ইউনিয়ন ও ফেনী জেলার দাগনভূঞা উপজেলার ইয়াকুবপুর ইউনিয়ন অবস্থিত।");
        hashMap.put("administrativeTv","প্রশাসনিক কাঠামোঃ");

        hashMap.put("administrativeDesTv","সিরাজপুর ইউনিয়ন কোম্পানীগঞ্জ উপজেলার আওতাধীন ১নং ইউনিয়ন পরিষদ। এ ইউনিয়নের প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ থানার আওতাধীন। এটি জাতীয় সংসদের ২৭২নং নির্বাচনী এলাকা নোয়াখালী-৫ এর অংশ। ইউনিয়ন চেয়ারম্যান: নাজিম উদ্দিন মিকন। এ ইউনিয়নের গ্রামগুলো হল:\n" +
                "•\tবড় রাজাপুর\n" +
                "•\tবিরাহিমপুর\n" +
                "•\tছোট রাজাপুর\n" +
                "•\tহাবিবপুর\n" +
                "•\tমোহাম্মদ নগর\n" +
                "•\tশাহজাদপুর\n" +
                "•\tসিরাজপুর\n" +
                "•\tউদরাজপুর\n" +
                "•\tউত্তর মুসাপুর\n");

        hashMap.put("studiesTv","শিক্ষা ব্যবস্থাঃ");
        hashMap.put("studiesDesTv","২০১১ সালের আদমশুমারি অনুযায়ী সিরাজপুর ইউনিয়নের স্বাক্ষরতার হার ৫৮.৯%।[১] এ ইউনিয়নে ১১টি সরকারি প্রাথমিক বিদ্যালয় রয়েছে।");

        hashMap.put("educationalInstitutionsTv","শিক্ষা প্রতিষ্ঠানঃ");
        hashMap.put("educationalInstitutionsDesTv","•\tমানিকপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপূর্ব যোগিদিয়া সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tরাজাপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tহাবিবপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tশাহজাদপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tযোগিদিয়া বালিকা বিদ্যালয় সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম সিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম মোহাম্মদনগর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tবিরাহিমপুর সরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tপশ্চিম বিরাহিমপুর রেজিস্টার্ড বেসরকারি প্রাথমিক বিদ্যালয়\n" +
                "•\tসিরাজপুর সরকারি প্রাথমিক বিদ্যালয়\n");

        hashMap.put("communicationTv","যোগাযোগ ব্যবস্থাঃ");
        hashMap.put("communicationDesTv","কোম্পানীগঞ্জ উপজেলা গেইট থেকে সিএনজি অথবা রিক্সাযোগে আসলে ইউনিয়ন পরিষদ কমপ্লক্স দেখা যাবে।");
        hashMap.put("riverTv","খাল ও নদী");
        hashMap.put("riverListTv","খাল ও নদীর তালিকাঃ");

        hashMap.put("riverDesTv","•\tসিরাজপুর–শাহজাদপুর খাল\n" +
                "•\tসিরাজপুর–বিরাহিমপুর খাল\n" +
                "•\tহাবিবপুর–বিরাহিমপুর খাল\n" +
                "•\tকালীবাড়ি–দুধমূখা খাল\n");

        hashMap.put("bazerTv","হাট-বাজার");
        hashMap.put("bazerListTv","হাট-বাজারের তালিকাঃ");

        hashMap.put("bazerListDesTv","•\tপাটোয়ারী হাট\n" +
                "•\tকদমতলা বাজার\n" +
                "•\tহাজারী হাট\n" +
                "•\tশান্তির হাট\n" +
                "•\tপেশকার হাট\n" +
                "•\tচাপ্রাশির হাট (পূর্ব বাজার)\n" +
                "•\tতালেব মোহাম্মদ হাট\n" +
                "•\tরংমালা বাজার\n" +
                "•\tবাংলা বাজার\n" +
                "•\tমুছাপুর চৌধুরী হাট\n" +
                "•\tচর এলাহী বাজার\n" +
                "•\tগাংচিল বাজার\n" +
                "•\tসৈকত বাজার\n");

        hashMap.put("representativeTv","জনপ্রতিনিধিঃ");
        hashMap.put("representativeImage","http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        arrayList.add(hashMap);





    }


}