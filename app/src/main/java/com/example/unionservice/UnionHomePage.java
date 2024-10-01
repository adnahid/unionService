package com.example.unionservice;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import HealthPackage.AmbulanceList;
import HealthPackage.BloodDonet;
import HealthPackage.HospitalMenu;
import ItemLayout.DetailsUnion;
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


public class UnionHomePage extends Fragment {

CardView Oyaris,FamilySonod,Carikthik,Unmarried,Married,DeadSonod,Prothoon,
        NewHoldding,BumihinSonod,BumiBavohar,EmarotBuldding,postOffice,
        ambulance,donet,hospital,emergencyNumber,police,upzilaNews,bdJobs,freedomFiter,
        poll,pastTeam,fireOfficer,educationOPfficer,animalOfficer,farmerOfficer,foodOfficer,
        subRegister,electionOffice,fresherOfficer,vumiOfficer;








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


       View view = inflater.inflate(R.layout.fragment_union_home_page, container, false);
        ImageSlider image_slider = view.findViewById(R.id.image_slider);

        //cardView
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



        Oyaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webViewActivity.url= "http://step-dte.gov.bd/";
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
                PdfViewer.assetsName = "companyganj.pdf";
                Intent intent = new Intent(getActivity(), PdfViewer.class);
                startActivity(intent);
            }
        });

        pastTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PdfViewer.assetsName = "past.pdf";
                Intent intent = new Intent(getActivity(), PdfViewer.class);
                startActivity(intent);
            }
        });


        postOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PdfViewer.assetsName = "post_office.pdf";
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