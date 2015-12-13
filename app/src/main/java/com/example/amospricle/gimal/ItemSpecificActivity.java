package com.example.amospricle.gimal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by amospricle on 15. 8. 3..
 */


public class ItemSpecificActivity extends AppCompatActivity {

    String number;
    String nickName;
    int helper;
    int icon;
    int profile;
    String sub;
    String assign;
    String prof;


    TextView subT;
    TextView profT;
    TextView assignT;
    TextView numT;
    TextView nickT;
    ImageView iconV;
    ImageView profileV;
    int position;



    private BitmapDrawable drawable;
    private Bitmap bitmap;
    private RoundedAvatarDrawable tmpRoundedAvatarDrawable;
    private Button confirm;
    private Button back;


    public void bind(){
        subT=(TextView)findViewById(R.id.spe_sub);
        profT=(TextView)findViewById(R.id.spe_prof);
        assignT=(TextView)findViewById(R.id.spe_assign);
        numT=(TextView)findViewById(R.id.spe_num);
        nickT=(TextView)findViewById(R.id.spe_nick);
        iconV=(ImageView)findViewById(R.id.spe_icon);
        profileV=(ImageView)findViewById(R.id.spe_profile);
        confirm =(Button)findViewById(R.id.spe_okay);
        confirm =(Button)findViewById(R.id.spe_okay);

        back =(Button)findViewById(R.id.spe_back);
    }





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_specific);
        bind();

        Intent i = getIntent();
        number = i.getStringExtra("number");
        nickName = i.getStringExtra("name");
        helper = i.getIntExtra("helper", 1);
        icon = i.getIntExtra("icon", 1);
        profile = i.getIntExtra("profile", 1);
        sub =i.getStringExtra("sub");
        assign =i.getStringExtra("assign");
        prof =i.getStringExtra("prof");
        position = i.getIntExtra("position", 0);

        subT.setText(sub);
        profT.setText(prof);
        assignT.setText(assign);
        numT.setText(number);
        nickT.setText(nickName);
        iconV.setImageDrawable(getResources().getDrawable(icon));


        drawable = (BitmapDrawable) getResources().getDrawable(profile);

        bitmap = drawable.getBitmap();
        tmpRoundedAvatarDrawable = new RoundedAvatarDrawable(bitmap);
        profileV.setImageDrawable(tmpRoundedAvatarDrawable);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ItemSpecificActivity.this, MainListActivity.class);

                i.putExtra("position", position);

                setResult(RESULT_OK, i);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }
}