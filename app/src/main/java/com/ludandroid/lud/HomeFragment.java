package com.ludandroid.lud;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.toolbar_tabs);

        tabLayout.addTab(tabLayout.newTab().setText("Home").setIcon(R.drawable.r_44a));
        tabLayout.addTab(tabLayout.newTab().setText("Profile").setIcon(R.drawable.r_46));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this.getContext(), R.color.tab_text_color));

        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.home_viewPager);
        final HomePagerAdapter adapter = new HomePagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Set Bottom Toolbar OnClickListener
        ImageButton bottomButton1 = (ImageButton) v.findViewById(R.id.toolbar_bottom_button1);
        ImageButton bottomButton2 = (ImageButton) v.findViewById(R.id.toolbar_bottom_button2);
        ImageButton bottomButton3 = (ImageButton) v.findViewById(R.id.toolbar_bottom_button3);

        bottomButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Not Implemented",Toast.LENGTH_SHORT).show();
            }
        });

        bottomButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Not Implemented",Toast.LENGTH_SHORT).show();
            }
        });

        bottomButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Not Implemented",Toast.LENGTH_SHORT).show();
            }
        });


        // Inflate the layout for this fragment
        return v;
    }

}
