package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.calculator.databinding.ActivitySplahBinding;

public class SplahActivity extends AppCompatActivity {
    private  ActivitySplahBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Animations

        //move top
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_top);
        binding.textViewWelcome.setAnimation(animation);
        //move right
        Animation animation1 =  AnimationUtils.loadAnimation(this, R.anim.move_right);
        binding.spPlus.setAnimation(animation1);
        binding.spMultiplied.setAnimation(animation1);
        //move left
        Animation animation2 =  AnimationUtils.loadAnimation(this, R.anim.move_left);
        binding.spMines.setAnimation(animation2);
        binding.spDivided.setAnimation(animation2);

        //Handler
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplahActivity.this, MainActivity.class));

                finish();}
        },6000);
    }
}