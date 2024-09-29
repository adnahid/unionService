package ItemLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.unionservice.R;

public class DetailsUnion extends AppCompatActivity {

    Toolbar toolbar;

    public static String DESTV  = "";
    public static String SIZETV = "";
    public static String SizeDes = "";
    public static String PeopleTv = "";
    public static String PeopleDesTv = "";
    public static String StayTv = "";
    public static String StayDesTv = "";
    public static String AdministrativeTv = "";
    public static String AdministrativeDesTv = "";
    public static String StudiesTv = "";
    public static String StudiesDesTv = "";
    public static String EducationalInstitutionsTv = "";
    public static String EducationalInstitutionsDesTv = "";
    public static String CommunicationTv = "";
    public static String CommunicationDesTv = "";
    public static String RiverTv = "";
    public static String RiverListTv = "";
    public static String RiverDesTv = "";
    public static String BazerTv = "";
    public static String BazerListTv = "";
    public static String BazerListDesTv = "";
    public static String RepresentativeTv = "";
    //public static Bitmap ImageBitmap = null;
    TextView desFirst,sizeTv,sizeDesTv,peopleTv,peopleDesTv,stayTv,stayDesTv,administrativeTv,administrativeDesTv,
    studiesTv,studiesDesTv,educationalInstitutionsTv,educationalInstitutionsDesTv,communicationTv,communicationDesTv,
            riverTv,riverListTv,riverDesTv,bazerTv,bazerListTv,bazerListDesTv,representativeTv;

    ImageView representativeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_union);
        desFirst = findViewById(R.id.desFirst);
        sizeTv = findViewById(R.id.sizeTv);
        sizeDesTv = findViewById(R.id.sizeDesTv);
        peopleTv = findViewById(R.id.peopleTv);
        peopleDesTv = findViewById(R.id.peopleDesTv);
        stayTv = findViewById(R.id.stayTv);
        stayDesTv = findViewById(R.id.stayDesTv);
        administrativeTv = findViewById(R.id.administrativeTv);
        administrativeDesTv = findViewById(R.id.administrativeDesTv);
        studiesTv = findViewById(R.id.studiesTv);
        studiesDesTv = findViewById(R.id.studiesDesTv);
        educationalInstitutionsTv = findViewById(R.id.educationalInstitutionsTv);
        educationalInstitutionsDesTv = findViewById(R.id.educationalInstitutionsDesTv);
        communicationTv = findViewById(R.id.communicationTv);
        communicationDesTv = findViewById(R.id.communicationDesTv);
        riverTv = findViewById(R.id.riverTv);
        riverListTv = findViewById(R.id.riverListTv);
        riverDesTv = findViewById(R.id.riverDesTv);
        bazerTv = findViewById(R.id.bazerTv);
        bazerListTv = findViewById(R.id.bazerListTv);
        bazerListDesTv = findViewById(R.id.bazerListDesTv);
        representativeTv = findViewById(R.id.representativeTv);
        representativeImage = findViewById(R.id.representativeImage);
        toolbar = findViewById(R.id.toolbar);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

//        if (ImageBitmap!=null){
//            representativeImage.setImageBitmap(ImageBitmap);
//        }

        desFirst.setText(DESTV);
        sizeTv.setText(SIZETV);
        sizeDesTv.setText(SizeDes);
        peopleTv.setText(PeopleTv);
        peopleDesTv.setText(PeopleDesTv);
        stayTv.setText(StayTv);
        stayDesTv.setText(StayDesTv);
        administrativeTv.setText(AdministrativeTv);
        administrativeDesTv.setText(AdministrativeDesTv);
        studiesTv.setText(StudiesTv);
        studiesDesTv.setText(StudiesDesTv);
        educationalInstitutionsTv.setText(EducationalInstitutionsTv);
        educationalInstitutionsDesTv.setText(EducationalInstitutionsDesTv);
        communicationTv.setText(CommunicationTv);
        communicationDesTv.setText(CommunicationDesTv);
        riverTv.setText(RiverTv);
        riverListTv.setText(RiverListTv);
        riverDesTv.setText(RiverDesTv);
        bazerTv.setText(BazerTv);
        bazerListTv.setText(BazerListTv);
        bazerListDesTv.setText(BazerListDesTv);
        representativeTv.setText(RepresentativeTv);




    }
}