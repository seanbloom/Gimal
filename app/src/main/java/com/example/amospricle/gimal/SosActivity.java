package com.example.amospricle.gimal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by amospricle on 15. 8. 3..
 */


public class SosActivity extends AppCompatActivity {



    private ImageView mc;
    private ImageView donkin;
    private ImageView domino;
    private ImageView burger;
    private ImageView jaws;
    private ImageView star;
    private ImageView bean;
    private ImageView tom;
    private EditText profEdt;
    private EditText subjectEdt;
    private EditText assignmentEdt;
    int icon;
    int toggle = 0;


    private Button confirm;
            String prof;
            String subject;
            String assignment;


    public void bind(){
        confirm =(Button)findViewById(R.id.sos_confirm);
        mc =(ImageView)findViewById(R.id.sos_mc);
        donkin =(ImageView)findViewById(R.id.sos_donkin);
        domino =(ImageView)findViewById(R.id.sos_domino);
        burger =(ImageView)findViewById(R.id.sos_burger);
        jaws =(ImageView)findViewById(R.id.sos_jaws);
        star =(ImageView)findViewById(R.id.sos_star);
        bean =(ImageView)findViewById(R.id.sos_coffeebean);
        tom =(ImageView)findViewById(R.id.sos_tom);

        profEdt = (EditText)findViewById(R.id.sos_prof);
        subjectEdt = (EditText)findViewById(R.id.sos_subject);
        assignmentEdt = (EditText)findViewById(R.id.sos_assignment);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sos);
        bind();

        Intent i = getIntent();
        final String number = i.getStringExtra("number");
        final String nickName = i.getStringExtra("nickName");

        ListView listView=(ListView)findViewById(R.id.mainpage_listview);
        ArrayList<ListviewItem> data=new ArrayList<ListviewItem>();






        mc.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if(toggle == 0) {
                    donkin.setVisibility(View.INVISIBLE);
                    domino.setVisibility(View.INVISIBLE);
                    star.setVisibility(View.INVISIBLE);
                    jaws.setVisibility(View.INVISIBLE);
                    tom.setVisibility(View.INVISIBLE);
                    bean.setVisibility(View.INVISIBLE);
                    burger.setVisibility(View.INVISIBLE);
                    toggle =1;
                }
                else{

                    donkin.setVisibility(View.VISIBLE);
                    domino.setVisibility(View.VISIBLE);
                    star.setVisibility(View.VISIBLE);
                    jaws.setVisibility(View.VISIBLE);
                    tom.setVisibility(View.VISIBLE);
                    bean.setVisibility(View.VISIBLE);
                    burger.setVisibility(View.VISIBLE);
                    toggle =0;
                }
                icon = R.drawable.mcdonald;
            }
        });
        donkin.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if (toggle == 0) {
                    mc.setVisibility(View.INVISIBLE);
                    domino.setVisibility(View.INVISIBLE);
                    star.setVisibility(View.INVISIBLE);
                    jaws.setVisibility(View.INVISIBLE);
                    tom.setVisibility(View.INVISIBLE);
                    bean.setVisibility(View.INVISIBLE);
                    burger.setVisibility(View.INVISIBLE);
                    toggle = 1;
                } else {

                    mc.setVisibility(View.VISIBLE);
                    domino.setVisibility(View.VISIBLE);
                    star.setVisibility(View.VISIBLE);
                    jaws.setVisibility(View.VISIBLE);
                    tom.setVisibility(View.VISIBLE);
                    bean.setVisibility(View.VISIBLE);
                    burger.setVisibility(View.VISIBLE);
                    toggle = 0;
                }
                icon = R.drawable.donkin;
            }
        });
        domino.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if (toggle == 0) {
                    donkin.setVisibility(View.INVISIBLE);
                    mc.setVisibility(View.INVISIBLE);
                    star.setVisibility(View.INVISIBLE);
                    jaws.setVisibility(View.INVISIBLE);
                    tom.setVisibility(View.INVISIBLE);
                    bean.setVisibility(View.INVISIBLE);
                    burger.setVisibility(View.INVISIBLE);
                    toggle = 1;
                } else {

                    donkin.setVisibility(View.VISIBLE);
                    mc.setVisibility(View.VISIBLE);
                    star.setVisibility(View.VISIBLE);
                    jaws.setVisibility(View.VISIBLE);
                    tom.setVisibility(View.VISIBLE);
                    bean.setVisibility(View.VISIBLE);
                    burger.setVisibility(View.VISIBLE);
                    toggle = 0;
                }
                icon = R.drawable.domino;
            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if (toggle == 0) {
                    donkin.setVisibility(View.INVISIBLE);
                    domino.setVisibility(View.INVISIBLE);
                    mc.setVisibility(View.INVISIBLE);
                    jaws.setVisibility(View.INVISIBLE);
                    tom.setVisibility(View.INVISIBLE);
                    bean.setVisibility(View.INVISIBLE);
                    burger.setVisibility(View.INVISIBLE);
                    toggle = 1;
                } else {

                    donkin.setVisibility(View.VISIBLE);
                    domino.setVisibility(View.VISIBLE);
                    mc.setVisibility(View.VISIBLE);
                    jaws.setVisibility(View.VISIBLE);
                    tom.setVisibility(View.VISIBLE);
                    bean.setVisibility(View.VISIBLE);
                    burger.setVisibility(View.VISIBLE);
                    toggle = 0;
                }
                icon =R.drawable.starbucks;
            }
        });
        jaws.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if (toggle == 0) {
                    donkin.setVisibility(View.INVISIBLE);
                    domino.setVisibility(View.INVISIBLE);
                    star.setVisibility(View.INVISIBLE);
                    mc.setVisibility(View.INVISIBLE);
                    tom.setVisibility(View.INVISIBLE);
                    bean.setVisibility(View.INVISIBLE);
                    burger.setVisibility(View.INVISIBLE);
                    toggle = 1;
                } else {

                    donkin.setVisibility(View.VISIBLE);
                    domino.setVisibility(View.VISIBLE);
                    star.setVisibility(View.VISIBLE);
                    mc.setVisibility(View.VISIBLE);
                    tom.setVisibility(View.VISIBLE);
                    bean.setVisibility(View.VISIBLE);
                    burger.setVisibility(View.VISIBLE);
                    toggle = 0;
                }
                icon = R.drawable.jaws;
            }
        });
        tom.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if (toggle == 0) {
                    donkin.setVisibility(View.INVISIBLE);
                    domino.setVisibility(View.INVISIBLE);
                    star.setVisibility(View.INVISIBLE);
                    jaws.setVisibility(View.INVISIBLE);
                    mc.setVisibility(View.INVISIBLE);
                    bean.setVisibility(View.INVISIBLE);
                    burger.setVisibility(View.INVISIBLE);
                    toggle = 1;
                } else {

                    donkin.setVisibility(View.VISIBLE);
                    domino.setVisibility(View.VISIBLE);
                    star.setVisibility(View.VISIBLE);
                    jaws.setVisibility(View.VISIBLE);
                    mc.setVisibility(View.VISIBLE);
                    bean.setVisibility(View.VISIBLE);
                    burger.setVisibility(View.VISIBLE);
                    toggle = 0;
                }
                icon = R.drawable.tomntoms;
            }
        });
        bean.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if (toggle == 0) {
                    donkin.setVisibility(View.INVISIBLE);
                    domino.setVisibility(View.INVISIBLE);
                    star.setVisibility(View.INVISIBLE);
                    jaws.setVisibility(View.INVISIBLE);
                    tom.setVisibility(View.INVISIBLE);
                    mc.setVisibility(View.INVISIBLE);
                    burger.setVisibility(View.INVISIBLE);
                    toggle = 1;
                } else {

                    donkin.setVisibility(View.VISIBLE);
                    domino.setVisibility(View.VISIBLE);
                    star.setVisibility(View.VISIBLE);
                    jaws.setVisibility(View.VISIBLE);
                    tom.setVisibility(View.VISIBLE);
                    mc.setVisibility(View.VISIBLE);
                    burger.setVisibility(View.VISIBLE);
                    toggle = 0;
                }
                icon = R.drawable.coffeebean;
            }
        });
        burger.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if (toggle == 0) {
                    donkin.setVisibility(View.INVISIBLE);
                    domino.setVisibility(View.INVISIBLE);
                    star.setVisibility(View.INVISIBLE);
                    jaws.setVisibility(View.INVISIBLE);
                    tom.setVisibility(View.INVISIBLE);
                    bean.setVisibility(View.INVISIBLE);
                    mc.setVisibility(View.INVISIBLE);
                    toggle = 1;
                } else {

                    donkin.setVisibility(View.VISIBLE);
                    domino.setVisibility(View.VISIBLE);
                    star.setVisibility(View.VISIBLE);
                    jaws.setVisibility(View.VISIBLE);
                    tom.setVisibility(View.VISIBLE);
                    bean.setVisibility(View.VISIBLE);
                    mc.setVisibility(View.VISIBLE);
                    toggle = 0;
                }
                icon = R.drawable.burgerking;
            }
        });










        confirm.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                if(toggle ==1){
                Intent mainIntent = new Intent(SosActivity.this, MainActivity.class);
                prof = profEdt.getText().toString();
                subject = subjectEdt.getText().toString();
                assignment = assignmentEdt.getText().toString();
                mainIntent.putExtra("prof",prof);
                mainIntent.putExtra("sub",subject);
                mainIntent.putExtra("assign",assignment);
                mainIntent.putExtra("icon",icon);
                setResult(RESULT_OK, mainIntent);

                finish();
                }
                else{

                    Toast.makeText(SosActivity.this, "기프티콘을 골라주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }







}