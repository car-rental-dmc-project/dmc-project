package com.sunbeam.app1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sunbeam.app1.fragments.HomeFragment;
import com.sunbeam.app1.fragments.HostFragment;
import com.sunbeam.app1.fragments.MyBookingFragment;
import com.sunbeam.app1.fragments.ProfileFragment;

public class FragmentAdapter extends FragmentStateAdapter
{
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 : return new HomeFragment();
            case 1 : return new MyBookingFragment();
            case 2 : return new ProfileFragment();
            case 3 : return new HostFragment();
        }
        return null;
    }
    @Override
    public int getItemCount() {
        return 4;
    }
}
