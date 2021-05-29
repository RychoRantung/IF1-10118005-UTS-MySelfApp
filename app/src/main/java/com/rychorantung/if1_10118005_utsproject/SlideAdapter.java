package com.rychorantung.if1_10118005_utsproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter  {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    //arrays
    public int [] slide_images = {
            R.drawable.profile_icon,
            R.drawable.reading_icon,
            R.drawable.letsgo_icon
    };

    // heading Array
    public String[] slide_headings ={
            "Welcome",
            "Get to Know Him Better",
            "Let's Get Started"
    };

    // description Array
    public String[] slide_descs ={
            "Segala yang ingin anda ketahui tentang Rycho Rantung, ada di sini",
            "Mulai dari aktivitas sehari-harinya, cita-citanya, bahkan selera musiknya",
            "Mari berkenalan"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,  Object object) {
        container.removeView((RelativeLayout)object);
    }
}
