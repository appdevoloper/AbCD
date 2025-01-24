package com.example.myapplication;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


     TextView textView,tpingTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        tpingTextView = findViewById(R.id.tpingTextView);

        String typing = "Hello My friend";



        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,typing.length());

        valueAnimator.setDuration(1000);
        valueAnimator.setStartDelay(300);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {

              int inedx = (int) valueAnimator.getAnimatedValue();
              tpingTextView.setText(typing.substring(0,inedx));


            }
        });



        ValueAnimator clrAnio = ValueAnimator.ofArgb(Color.BLUE,Color.BLUE);
         clrAnio.setDuration(1000);

         clrAnio.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                 int index = (int) clrAnio.getAnimatedValue();

                 tpingTextView.setTextColor(index);

             }
         });

         clrAnio.start();
        valueAnimator.start();



















        String clrString = "Hi, I am Color string You Try This";

        SpannableString spannableString = new SpannableString(clrString);


        spannableString.setSpan(new ForegroundColorSpan(Color.RED),
                0,2,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new UnderlineSpan(),
                10,25,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new StrikethroughSpan(), 5,10,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                Toast.makeText(MainActivity.this, "Hi I am toast", Toast.LENGTH_SHORT).show();


            }
        },3,5,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());








    }




}