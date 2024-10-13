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
        meassageItem,mapItem;








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
                webViewActivity.url= "http://www.companiganj.noakhali.gov.bd/bn/site/page/7fZt-মানচিত্র-কোম্পানীগঞ্জ";
                Intent intent = new Intent(getActivity(),webViewActivity.class);
                startActivity(intent);

            }
        });


        DeadSonod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewActivity.url= "https://bdris.gov.bd/dr/application";
                Intent intent = new Intent(getActivity(),webViewActivity.class);
                startActivity(intent);

            }
        });



        Oyaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webViewActivity.url= "https://prottoyon.gov.bd/application/additional-information/create/PVHnLY8ctOL20170419110045";
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
                DetailsUnion.DESTV = "কোম্পানীগঞ্জ উপজেলা বাংলাদেশের নোয়াখালী";
                DetailsUnion.SIZETV = "কোম্পানীগঞ্জ";
                startActivity(intent);
            }
        });








        //pdfViewer

        freedomFiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PdfViewer.assetsName = "companyganj.pdf";
                PdfViewer.pdfUrl = "https://drive.google.com/file/d/1H4zvG3T3brlwY6e9fTENX1hNEk8xrITH/view?usp=sharing";
                Intent intent = new Intent(getActivity(), PdfViewer.class);
                startActivity(intent);
            }
        });

        pastTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PdfViewer.assetsName = "past.pdf";
                PdfViewer.pdfUrl = "https://drive.google.com/file/d/1IWpkcih2mvBlZyNF-kIAco5RGljMhw2t/view?usp=sharing";
                Intent intent = new Intent(getActivity(), PdfViewer.class);
                startActivity(intent);
            }
        });


        postOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PdfViewer.assetsName = "post_office.pdf";
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