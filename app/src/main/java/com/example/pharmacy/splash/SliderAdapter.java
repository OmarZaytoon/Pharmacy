package com.example.pharmacy.splash;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.pharmacy.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    int images[]={
            R.drawable.onboarding_one,
            R.drawable.onboarding_two,
            R.drawable.onboarding_three
    };
    String headings[] = {
            "Choose your wash program via the app","The wash starts","Wash your car as often you like!"
    };

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view =layoutInflater.inflate(R.layout.slides_layout,container,false);
        ImageView imageView = view.findViewById(R.id.slide_layout_img);
        TextView textView = view.findViewById(R.id.slide_layout_head);

        imageView.setImageResource(images[position]);
        textView.setText(headings[position]);

        container.addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(RelativeLayout)object;
    }
}
