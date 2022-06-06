package com.example.mohartest1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class viewPagerAdapter extends FragmentStateAdapter {

    public final int mSetItemCount = 6;

    public viewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        switch(position){
            case 0 :
                productRecommendTabsFragment wax = new productRecommendTabsFragment();
                wax.category = 1;
                return wax;
            case 1 :
                productRecommendTabsFragment fomard = new productRecommendTabsFragment();
                fomard.category = 2;
                return fomard;
            case 2 :
                productRecommendTabsFragment curlcream = new productRecommendTabsFragment();
                curlcream.category = 3;
                return curlcream;
            case 3 :
                productRecommendTabsFragment spray = new productRecommendTabsFragment();
                spray.category = 4;
                return spray;
            case 4 :
                productRecommendTabsFragment shampoo = new productRecommendTabsFragment();
                shampoo.category = 5;
                return shampoo;
            case 5 :
                productRecommendTabsFragment dye = new productRecommendTabsFragment();
                dye.category = 6;
                return dye;
        }
        return new productRecommendTabsFragment();
    }

    public long getItemId(int position){
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mSetItemCount;
    }

    public int getRealPosition(int _iPosition){
        return _iPosition % mSetItemCount;
    }
}
