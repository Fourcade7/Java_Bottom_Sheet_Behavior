package com.pr7.java_bottom_sheet_behavior;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout linearLayoutBSheet;
    ImageView imageView;
    boolean isChecked=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       linearLayoutBSheet = findViewById(R.id.bottomsheet);
       imageView=findViewById(R.id.imageview1);
        bottomSheetBehavior = BottomSheetBehavior.from(linearLayoutBSheet);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChecked){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    isChecked=false;
                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    isChecked=true;
                }
            }
        });


        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View view, int newState) {
                if(newState == BottomSheetBehavior.STATE_EXPANDED){
                    imageView.setImageResource(R.drawable.ic_round_keyboard_arrow_down_24);
                }else if(newState == BottomSheetBehavior.STATE_COLLAPSED){
                    imageView.setImageResource(R.drawable.ic_round_keyboard_arrow_up_24);
                }
            }

            @Override
            public void onSlide(View view, float v) {

            }
        });
    }
}