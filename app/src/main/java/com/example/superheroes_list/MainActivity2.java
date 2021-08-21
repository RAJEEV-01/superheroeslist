package com.example.superheroes_list;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.superheroes_list.MainActivity.EXTRA_FIRSTAPPEARANCE;
import static com.example.superheroes_list.MainActivity.EXTRA_GENDER;
import static com.example.superheroes_list.MainActivity.EXTRA_HEIGHT;
import static com.example.superheroes_list.MainActivity.EXTRA_ID;
import static com.example.superheroes_list.MainActivity.EXTRA_INTELLI;
import static com.example.superheroes_list.MainActivity.EXTRA_NAME;
import static com.example.superheroes_list.MainActivity.EXTRA_OCCU;
import static com.example.superheroes_list.MainActivity.EXTRA_POWER;
import static com.example.superheroes_list.MainActivity.EXTRA_RACE;
import static com.example.superheroes_list.MainActivity.EXTRA_SPEED;
import static com.example.superheroes_list.MainActivity.EXTRA_STRENGTH;
import static com.example.superheroes_list.MainActivity.EXTRA_URL;
import static com.example.superheroes_list.MainActivity.EXTRA_WEIGHT;

public class MainActivity2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        Intent intent=getIntent();
        //getting details from intents
        int heroid =intent.getIntExtra(EXTRA_ID,0);
        String imageurl=intent.getStringExtra(EXTRA_URL);
        String name = intent.getStringExtra(EXTRA_NAME);
        String herogender=intent.getStringExtra(EXTRA_GENDER);
        String herorace = intent.getStringExtra(EXTRA_RACE);
        String occu = intent.getStringExtra(EXTRA_OCCU);
        int intelli = intent.getIntExtra(EXTRA_INTELLI,0);
        int str = intent.getIntExtra(EXTRA_STRENGTH,0);
        int spd = intent.getIntExtra(EXTRA_SPEED,0);
        int pow = intent.getIntExtra(EXTRA_POWER,0);
        String heroheight=intent.getStringExtra(EXTRA_HEIGHT);
       String heroweight = intent.getStringExtra(EXTRA_WEIGHT);
       String firstapp = intent.getStringExtra(EXTRA_FIRSTAPPEARANCE);
        //dedclarations
        TextView id=findViewById(R.id.textViewdetails);
        ImageView imageView=findViewById(R.id.imageview);
        TextView names=findViewById(R.id.textView);
        TextView gender = findViewById(R.id.textView2);
        TextView race = findViewById(R.id.textView3);
        TextView height = findViewById(R.id.textView4);
        TextView weight = findViewById(R.id.textView5);
        TextView intelligence = findViewById(R.id.textView6);
        TextView strength = findViewById(R.id.textView7);
        TextView speed = findViewById(R.id.textView8);
        TextView power = findViewById(R.id.textView9);
        TextView firstappearance = findViewById(R.id.textView10);
        TextView occupation = findViewById(R.id.textView11);
        Picasso.with(this).load(imageurl).fit().centerInside().into(imageView);
        id.setText("Id: "+heroid);
        names.setText("Name: " + name);
        gender.setText("Gender: " + herogender);
        race.setText("Race: " + herorace);
        height.setText("Height: " + heroheight);
        weight.setText("weight: " + heroweight);
        occupation.setText("Occupation: " + occu);
        intelligence.setText("Intelligence: " + intelli);
        strength.setText("Strength: " + str);
        speed.setText("Speed: " + spd);
        power.setText("Power: " + pow);
        firstappearance.setText("First Appearance: " + firstapp);
    }
}