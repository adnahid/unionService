package javaClass;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.unionservice.FourthFragment;
import com.example.unionservice.SecondFragment;
import com.example.unionservice.ThirdFragment;
import com.example.unionservice.UnionHomePage;

public class pageAdapter extends FragmentPagerAdapter {


    private int tabsNumber;
    public pageAdapter(FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new UnionHomePage();
            case 1:
                return new SecondFragment();
            case 2:
                return new FourthFragment();

            default: return null;
        }



    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
