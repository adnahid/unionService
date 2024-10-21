package com.example.unionservice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import HealthPackage.AmbulanceList;
import HealthPackage.BloodDonet;
import HealthPackage.HospitalMenu;
import ItemLayout.AdvocateActivity;
import ItemLayout.DecoumtWritter;
import ItemLayout.DetailsUnion;
import ItemLayout.LRDWProfileActivity;
import ItemLayout.PollyBs;
import ItemLayout.ThanaPolicy;
import NagorikSheba.EmergencyNumber;
import NagorikSheba.InternetProvider;
import NagorikSheba.Reporter;
import Upzila.AminalOfficer;
import Upzila.EducationOfficer;
import Upzila.ElectionActivity;
import Upzila.FarmerOfficer;
import Upzila.FireService;
import Upzila.FoodOfficer;
import Upzila.FresherOfficer;
import Upzila.SubRegisterActivity;
import Upzila.VumiOfficer;
import Vatha.VathaThalika;


public class UnionHomePage extends Fragment {

CardView Oyaris,FamilySonod,Carikthik,Unmarried,Married,DeadSonod,Prothoon,
        NewHoldding,BumihinSonod,BumiBavohar,EmarotBuldding,postOffice,
        ambulance,donet,hospital,emergencyNumber,police,upzilaNews,bdJobs,freedomFiter,
        poll,pastTeam,fireOfficer,educationOPfficer,animalOfficer,farmerOfficer,foodOfficer,
        subRegister,electionOffice,fresherOfficer,vumiOfficer,advocate,decumentWritter,vathaThalika,
        meassageItem,mapItem,repoter,internet;








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


       View view = inflater.inflate(R.layout.fragment_union_home_page, container, false);
        ImageSlider image_slider = view.findViewById(R.id.image_slider);

        //cardView

        meassageItem = view.findViewById(R.id.meassageItem);
        mapItem = view.findViewById(R.id.mapItem);
        hospital = view.findViewById(R.id.hospital);
        Oyaris = view.findViewById(R.id.Oyaris);
        FamilySonod = view.findViewById(R.id.FamilySonod);
        Carikthik = view.findViewById(R.id.Carikthik);
        Unmarried = view.findViewById(R.id.Unmarried);
        Married = view.findViewById(R.id.Married);
        DeadSonod = view.findViewById(R.id.DeadSonod);
        Prothoon = view.findViewById(R.id.Prothoon);
        NewHoldding = view.findViewById(R.id.NewHoldding);
        BumihinSonod = view.findViewById(R.id.BumihinSonod);
        BumiBavohar = view.findViewById(R.id.BumiBavohar);
        EmarotBuldding = view.findViewById(R.id.EmarotBuldding);
        postOffice = view.findViewById(R.id.postOffice);
        ambulance = view.findViewById(R.id.ambulance);
        donet = view.findViewById(R.id.donet);
        emergencyNumber = view.findViewById(R.id.emergencyNumber);
        police = view.findViewById(R.id.police);
        upzilaNews = view.findViewById(R.id.upzilaNews);
        bdJobs = view.findViewById(R.id.bdJobs);
        freedomFiter = view.findViewById(R.id.freedomFiter);
        poll = view.findViewById(R.id.poll);
        pastTeam = view.findViewById(R.id.pastTeam);
        repoter = view.findViewById(R.id.repoter);
        internet = view.findViewById(R.id.internet);

        fireOfficer = view.findViewById(R.id.fireOfficer);
        educationOPfficer = view.findViewById(R.id.educationOPfficer);
        animalOfficer = view.findViewById(R.id.animalOfficer);
        foodOfficer = view.findViewById(R.id.foodOfficer);
        subRegister = view.findViewById(R.id.subRegister);
        electionOffice = view.findViewById(R.id.electionOffice);
        fresherOfficer = view.findViewById(R.id.fresherOfficer);
        farmerOfficer = view.findViewById(R.id.farmerOfficer);
        vumiOfficer = view.findViewById(R.id.vumiOfficer);
        advocate = view.findViewById(R.id.advocate);
        decumentWritter = view.findViewById(R.id.decumentWritter);
        vathaThalika = view.findViewById(R.id.vathaThalika);





        //Image Slider
        String url = "https://i.postimg.cc/L4PhmPbL/Yellow-White-Minimalist-Quote-Reminder-Facebook-Post.png";
        String url1st = "https://i.pinimg.com/originals/29/0f/1b/290f1bd21caf451f479d1d5748abb536.jpg";
        String url2nd = "https://i.pinimg.com/736x/2f/cb/80/2fcb80c870189aea42860cd966f79a30.jpg";
        String url3rd = "https://i.pinimg.com/originals/f5/a6/96/f5a696841c554f2272e5cf394a5054a9.jpg";
        String url4th = "https://i.pinimg.com/originals/d5/ac/0a/d5ac0a5c97b318e70dc4416a8e0ccdae.jpg";
        String url5th = "https://th.bing.com/th/id/R.891c9d9b03f1a9e0a6357edd4a3fb84e?rik=Lr7dJ4MwTA86lg&pid=ImgRaw&r=0";
        String url6th = "https://i.pinimg.com/736x/bb/b8/af/bbb8aff784130f9a32516910f301535d.jpg";
        String url7th = "https://th.bing.com/th/id/OIP.PhAFtFOEudjCUrpj1PfnEwAAAA?rs=1&pid=ImgDetMain";

        List<SlideModel> list = new ArrayList<>();
        list.add(new SlideModel(url, ScaleTypes.FIT));
        list.add(new SlideModel(url1st, ScaleTypes.FIT));
        list.add(new SlideModel(url2nd, ScaleTypes.FIT));
        list.add(new SlideModel(url3rd, ScaleTypes.FIT));
        list.add(new SlideModel(url4th, ScaleTypes.FIT));

        list.add(new SlideModel(url5th, ScaleTypes.FIT));
        list.add(new SlideModel(url6th, ScaleTypes.FIT));
        list.add(new SlideModel(url7th, ScaleTypes.FIT));
        image_slider.setImageList(list);














        //Activity

        meassageItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), DistricAdministrator.class);
                DistricAdministrator.adph = "01678478335";
                DistricAdministrator.adgm = "mdkarim@gmail.com";
                DistricAdministrator.DetailsTv = "মাননীয় প্রধানমন্ত্রীর কার্যালয়ে বাসত্মবায়নাধীন সাপোর্ট টু ডিজিটাল বাংলাদেশ (এটুআই) প্রোগ্রাম কর্তৃক জাতীয় পোর্টাল ফ্রেমওয়ার্কের আওতায় জনগণের দোরগোড়ায় বিভিন্ন ই-সেবা নিশ্চিত করার লক্ষে কোম্পানীগঞ্জ উপজেলা ওয়েব পোর্টাল প্রস্ত্তত করা হয়েছে। দিন বদলের সনদ বাস্তবায়নে মাননীয় প্রধানমন্ত্রীর ডিজিটাল বাংলাদেশ গড়ার প্রত্যয়ে তথ্য প্রযুক্তির মাধ্যমে জনগণের দোরগোড়ায় সহজে সেবা ও তথ্য পৌঁছে দেয়ার নিমিত্ত প্রস্ত্ততকৃত কোম্পানীগঞ্জ উপজেলা ওয়েব পোর্টাল জনগণের প্রভূত কল্যান বয়ে আনবে মর্মে আমরা বিশ্বাস করি। কোম্পানীগঞ্জ উপজেলা ওয়েব পোর্টালকে আরো তথ্য বহুল করার লক্ষে সকলের সার্বিক সহযোগিতা কামনা করছি।";
                DistricAdministrator.DetailsTv2 = "উপজেলা নির্বাহী অফিসার \n কোম্পানীগঞ্জ, নোয়াখালী।";
                DistricAdministrator.url = "https://file-chittagong.portal.gov.bd/uploads/ad417e95-ec3f-4963-898b-2c409d9a631d//65e/56b/37c/65e56b37c87a3188449437.jpg";
                startActivity(intent);

            }
        });


        vathaThalika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VathaThalika.class);
                startActivity(intent);

            }
        });

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InternetProvider.class);
                startActivity(intent);

            }
        });

        repoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reporter.class);
                startActivity(intent);

            }
        });


        advocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdvocateActivity.class);
                startActivity(intent);
            }
        });



        decumentWritter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DecoumtWritter.class);
                startActivity(intent);
            }
        });

        educationOPfficer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EducationOfficer.class);
                startActivity(intent);
            }
        });

        animalOfficer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AminalOfficer.class);
                startActivity(intent);
            }
        });

        farmerOfficer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FarmerOfficer.class);
                startActivity(intent);
            }
        });


        foodOfficer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FoodOfficer.class);
                startActivity(intent);
            }
        });

        subRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SubRegisterActivity.class);
                startActivity(intent);
            }
        });

        electionOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ElectionActivity.class);
                startActivity(intent);
            }
        });

        fresherOfficer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FresherOfficer.class);
                startActivity(intent);
            }
        });

        vumiOfficer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VumiOfficer.class);
                startActivity(intent);
            }
        });


        //urlActivity



        mapItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewActivity.ToolBarText = "মানচিত্র-কোম্পানীগঞ্জ";
                webViewActivity.url= "http://www.companiganj.noakhali.gov.bd/bn/site/page/7fZt-মানচিত্র-কোম্পানীগঞ্জ";
                Intent intent = new Intent(getActivity(),webViewActivity.class);
                startActivity(intent);

            }
        });


        DeadSonod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewActivity.ToolBarText ="মৃত্যু সনদ";
                webViewActivity.url= "https://bdris.gov.bd/dr/application";
                Intent intent = new Intent(getActivity(),webViewActivity.class);
                startActivity(intent);

            }
        });



        Oyaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webViewActivity.url= "https://www.savarup.com/successor_apps";
                Intent intent = new Intent(getActivity(),webViewActivity.class);
                startActivity(intent);
            }
        });




     hospital.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent intent = new Intent(getActivity(), HospitalMenu.class);
          startActivity(intent);
      }
     });

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AmbulanceList.class);
                startActivity(intent);
            }
        });

        emergencyNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EmergencyNumber.class);
                startActivity(intent);
            }
        });

        donet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BloodDonet.class);
                startActivity(intent);
            }
        });

        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ThanaPolicy.class);
                startActivity(intent);
            }
        });

        poll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PollyBs.class);
                startActivity(intent);
            }
        });

        fireOfficer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FireService.class);
                startActivity(intent);
            }
        });


        upzilaNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailsUnion.class);
                DetailsUnion.DetailsText = "কোম্পানীগঞ্জ উপজেলা বাংলাদেশের \n" +
                        "নোয়াখালী জেলার অন্তর্গত একটি প্রশাসনিক এলাকা।\n" +
                        "\n" +
                        "অবস্থান ও আয়তন\n" +
                        "কোম্পানীগঞ্জ নোয়াখালী জেলার দক্ষিণাঞ্চলে অবস্থিত একটি উপজেলা। এ উপজেলার উত্তরে সেনবাগ উপজেলা ও ফেনী জেলার দাগনভূঞা উপজেলা, দক্ষিণে নোয়াখালী সদর উপজেলা, সুবর্ণচর উপজেলা ও চট্টগ্রাম জেলার সন্দ্বীপ উপজেলা, পূর্বে ফেনী জেলার সোনাগাজী উপজেলা ও চট্টগ্রাম জেলার মীরসরাই উপজেলা ও সন্দ্বীপ উপজেলা, পশ্চিমে নোয়াখালী সদর উপজেলা ও কবিরহাট উপজেলা।\n" +
                        "\n" +
                        "প্রশাসনিক এলাকা\n" +
                        "কোম্পানীগঞ্জ উপজেলায় বর্তমানে ১টি পৌরসভা ও ৮টি ইউনিয়ন রয়েছে। সম্পূর্ণ উপজেলার প্রশাসনিক কার্যক্রম কোম্পানীগঞ্জ  থানার আওতাধীন।\n" +
                        "\n" +
                        "বসুরহাট পৌরসভা \n" +
                        "বাংলাদেশের নোয়াখালী জেলার অন্তর্গত একটি পৌরসভা। জেলা শহর মাইজদী থেকে এটি ২৫ কিলোমিটার দূরে অবস্থিত\n" +
                        "\n" +
                        "আয়তন\n" +
                        "বসুরহাট পৌরসভার আয়তন ৬.৫০ বর্গ কিলোমিটার।\n" +
                        "\n" +
                        "জনসংখ্যা\n" +
                        "২০১১ সালের আদমশুমারি অনুযায়ী বসুরহাট পৌরসভার জনসংখ্যা ২৯,৮৭৭ জন।\n" +
                        "\n" +
                        "অবস্থান ও সীমানা\n" +
                        "কোম্পানীগঞ্জ উপজেলার উত্তরাংশে বসুরহাট পৌরসভার অবস্থান। এ পৌরসভার উত্তরে ও পশ্চিমে সিরাজপুর ইউনিয়ন, দক্ষিণে চর কাঁকড়া ইউনিয়ন, পূর্বে চর হাজারী ইউনিয়ন এবং উত্তর-পূর্বে চর পার্বতী ইউনিয়ন অবস্থিত।\n" +
                        "\n" +
                        "ইতিহাস\n" +
                        "বর্তমান সিরাজপুর ইউনিয়নের যুগিদিয়ায় সুলতানী আমলে সমুদ্র বন্দর ছিল বলে ধারণা করা হয় । একই স্থানে পরে নবাবদের আমলে ফরাসিদের কুঠি ছিল । নাম থেকেই বোঝা যায় যে, উপজেলার বেশির ভাগ এলাকা পূর্বে চরাঞ্চল ছিল । মেঘনার মোহনায় সমুদ্র আর বামনী নদীর ভাঙ্গাগড়ায় কোম্পানীগঞ্জ ও সন্দ্বীপ উপজেলার মানচিত্র কয়েক বছর আগেও পরিবর্তিত হয়েছে । ব্রিটিশ আমলে এই এলাকায় বামনী থানা ছিল (রামপুর ইউনিয়নে)। বামনী ও মুছাপুর নামে সন্দ্বীপেও গ্রাম আছে, সন্দ্বীপ থেকেই নদী ভাঙ্গার কারণে এই দুই এলাকার মানুষ এসেছেন বলে জানা যায়। কোম্পানীগঞ্জ ও সন্দ্বীপের এই দুই অঞ্চলে এমনকি বিংশ শতকের ষাটের দশক পর্যন্তও ঘনিষ্ঠ যোগাযোগ ছিল । সন্দ্বীপের মুছাপুরে জন্ম নেয়া কমরেড মুজফ্ফর আহমদ বামনী মাদ্রাসায় কিছুদিন পড়ালেখা করেছেন । বামনী তথা রামপুর এবং মুছাপুরে এখনো সন্দ্বীপের স্থানীয় অধিবাসী এবং জনৈক বামনীর (ব্রাহ্মণ নারীর) বংশধর হওয়ার দাবিদার গোষ্ঠীর শ্রেণীগত দ্বন্দ্ব্ব বিষয়ক কিংবদন্তি শোনা যায় । এই উত্তরাধিকারের প্রভাবে এখনো ওই এলাকায় সোন্দোবি বা সন্দ্বীপীদের সাংস্কৃতিকভাবে আলাদা ভাবা হয় । অবশিষ্ট ইউনিয়নগুলো ভাঙ্গাগড়ার নানা ধাপে চরাঞ্চল থেকে ধীরে ধীরে মূল ভূমিতে পরিণত হয় । তাই রামপুর, মুছাপুর ও সিরাজপুরের মত একশত বছরের বেশি পুরনো ইতিহাস পাওয়া এই ইউনিয়নগুলোর ক্ষেত্রে দুস্কর । ১৯৭১ সালে কোম্পানীগঞ্জে হানাদার বাহিনী প্রবেশ করতে না পারলেও রাজাকার বাহিনীর সঙ্গে মুক্তিযোদ্ধাদের তুমুল লড়াই হয় । বামনীর মৌলভী মিন্নাত আলীর বেশ কয়েকজন নাতির নেতৃত্বে সারা উপজেলায় রাজাকার বাহিনী গঠিত হয় । এদের আরেক ভাই রাফিউদ্দিন ছিলেন আলবদর বাহিনীর কেন্দ্রীয় নেতা। এই বাহিনীর বিরুদ্ধে মুক্তিবাহিনীর কোম্পানীগঞ্জ কমান্ড যুদ্ধ করে । সাথে ছিল বি এল এফ । পার্শবর্তী চাপরাশীর হাটে ঘাঁটি করে মুক্তিযোদ্ধারা চরফকিরা ইউনিয়ন মুক্ত করতে গেলে শহীদ আব্দুর রব, রাজাকারদের অতর্কিত আক্রমণে শহীদ সালেহ আহমেদ সহ কয়েকজন, শেষের দিকে বামনী মুক্ত করতে গিয়ে শহীদ অহিদুর রহমান অদুদ এবং আরও অনেকে এই উপজেলার যুদ্ধে শহীদ হন।\n" +
                        "জনসংখ্যার উপাত্ত\n" +
                        "শিক্ষা\n" +
                        "এখানকার শিক্ষা প্রতিষ্টানগুলোর মধ্যে রয়েছে ৫টি কলেজ, ৭টি উচ্চ বিদ্যালয়, ৯টি মাদ্রাসা ও অসংখ্য প্রথমিক বিদ্যালয় রয়েছে যাদের মধ্যে প্রধান শিক্ষা প্রতিষ্ঠানগুলো হলো: সরকারি মুজিব কলেজ, বসুরহাট, এ এইচ সি সরকারি উচ্চ বিদ্যালয়, মাকসুদাহ সরকারি বালিকা উচ্চ বিদ্যালয়, বামনী ডিগ্রি কলেজ, বামনী উচ্চ বিদ্যালয়, চৌধুরী হাট কলেজ, কবি জসিমউদ্দিন উচ্চ বিদ্যালয়, জেতুন নাহার কাদের মহিলা কলেজ প্রভৃতি। এছাড়া নাজিরহাট এ মালেক সরকারি প্রাথমিক বিদ্যালয় ও পেশকার হাট উচ্চ বিদ্যালয়, চরকাঁকড়া একাডেমী উচ্চ বিদ্যালয় নামে নামকরা বিদ্যাপিঠের অবস্থান রয়েছে\n" +
                        "অর্থনীতি\n" +
                        "ব্যবসা\n" +
                        "কোম্পানীগঞ্জ বর্তমানে ব্যবসার জন্য অনুকূল স্থান হিসেবে বিবেচ্য। এই অঞ্চলের ব্যবসার মূল কেন্দ্র হচ্ছে বসুরহাট শহর। এখানে প্রায় সব ধরনের প্রতিষ্ঠান গড়ে উঠেছে। কম্পিউটার বণিজ্য, ব্যাংকিং, বিমা, আবাসন খাত দ্রুত বর্ধনশীল। এই এলাকার মানুষগণ অর্থনৈতিকভাবে অনেক সচ্ছল। তাই এটি বিনিয়োগের জন্য আকর্ষনীয়।\n" +
                        "ব্যাংকিং\n" +
                        "এখানে ইসলামী ব্যাংক, ডাচ-বাংলা ব্যাংক সহ ২২টির মত ব্যাংক আছে। দেশের শীর্ষস্থানীয় অনেক বিমা প্রতিষ্ঠান আছে। বিনিয়োগকারিরা এখানে বিনয়োগের উৎসাহ পাচ্ছেন।\n" +
                        "উল্লেখযোগ্য ব্যক্তিত্ব\n" +
                        "•মৌলভী আমিন উল্লাহ্ খান বাহাদুর সাহেব - তৎকালীন অবিভক্ত বাংলার এমএলএ;\n" +
                        "•মওদুদ আহমেদ - সাবেক উপরাষ্ট্রপতি ও প্রধানমন্ত্রী;\n" +
                        "•ওবায়দুল কাদের (রাজনীতিবিদ) - যোগাযোগ মন্ত্রী;\n" +
                        "•আবু নাছের মোহাম্মদ আব্দুজ জাহের - ইসলামী ব্যাংকের কয়েকবারের চেয়ারম্যান\n" +
                        "আবু নাচের চৌধুর, সাবেক এম পি";
                DetailsUnion.UnionToolTex = "কোম্পানীগঞ্জ উপজেলা";
                startActivity(intent);
            }
        });








        //pdfViewer

        freedomFiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PdfViewer.assetsName = "companyganj.pdf";
                PdfViewer.ToolText = "বীর মুক্তিযোদ্ধা তালিকা";
                PdfViewer.pdfUrl = "https://drive.google.com/file/d/1H4zvG3T3brlwY6e9fTENX1hNEk8xrITH/view?usp=sharing";
                Intent intent = new Intent(getActivity(), PdfViewer.class);
                startActivity(intent);
            }
        });

        pastTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PdfViewer.assetsName = "past.pdf";
                PdfViewer.ToolText = "প্রাক্তন পরিষদ";
                PdfViewer.pdfUrl = "https://drive.google.com/file/d/1IWpkcih2mvBlZyNF-kIAco5RGljMhw2t/view?usp=sharing";
                Intent intent = new Intent(getActivity(), PdfViewer.class);
                startActivity(intent);
            }
        });


        postOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PdfViewer.assetsName = "post_office.pdf";
                PdfViewer.ToolText = "পোস্ট অফিস সমূহ";
                PdfViewer.pdfUrl = "https://drive.google.com/file/d/1ZDav267ydhifRZELhuAoI-vpV4rX2UcF/view?usp=sharing";
                Intent intent = new Intent(getActivity(), PdfViewer.class);
                startActivity(intent);
            }
        });





        //webView page Activity

        bdJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webViewActivity.url = "https://www.bdjobs.com/";
                Intent intent = new Intent(getActivity(), webViewActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }
}