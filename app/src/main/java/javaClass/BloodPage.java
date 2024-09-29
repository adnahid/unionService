package javaClass;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.unionservice.FourthFragment;
import com.example.unionservice.SecondFragment;
import com.example.unionservice.ThirdFragment;
import com.example.unionservice.UnionHomePage;

import HealthPackage.ABNegitive;
import HealthPackage.ABpositive;
import HealthPackage.ANegitive;
import HealthPackage.BNegitive;
import HealthPackage.Bpositive;
import HealthPackage.FragmentApositive;
import HealthPackage.ONegitive;
import HealthPackage.Opositive;

public class BloodPage extends FragmentPagerAdapter{

    private int BloodTabsNumber;
    public BloodPage(FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.BloodTabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FragmentApositive();
            case 1:
                return new ANegitive();
            case 2:
                return new Bpositive();
            case 3:
                return new BNegitive();
            case 4:
                return new Opositive();
            case 5:
                return new ONegitive();
            case 6:
                return new ABpositive();
            case 7:
                return new ABNegitive();



            default: return null;
        }



    }

    @Override
    public int getCount() {
        return BloodTabsNumber;
    }
}
