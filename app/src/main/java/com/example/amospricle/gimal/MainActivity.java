package com.example.amospricle.gimal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ImageView avatarProfile;
    private BitmapDrawable drawable;
    private Bitmap bitmap;
    private RoundedAvatarDrawable tmpRoundedAvatarDrawable;
    private ImageView profile;
    private ImageButton ib;
    private TextView nick;
    private TextView push;
    ListviewAdapter adapter;
    int initial =0;
    int pushnum=0;
    final int REQ_CODE_SELECT_IMAGE = 100;
    final int REQ_WRITE_NEW_ASSIGNMENT = 123;
    final int REQ_SPECIFIC = 125;
    private TextView dnick;
    private ArrayList<ListviewItem> l_data=new ArrayList<ListviewItem>();
    ListView listView;
    ListviewItem dog;
    ListviewItem lion;
    String number;
    String nickName;




    private ImageView pls;
    public void bind(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        avatarProfile = (ImageView)findViewById(R.id.main_profile);
        nick = (TextView)findViewById(R.id.main_nickname);
        dnick =(TextView)findViewById(R.id.drawer_nick);
        drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.empty_profile);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        profile = (ImageView) findViewById(R.id.profile);
        ib = (ImageButton) findViewById(R.id.imageButton2);
        push =(TextView)findViewById(R.id.pushnumber);
        listView=(ListView)findViewById(R.id.mypage_listview);



        pls =(ImageView)findViewById(R.id.logogo);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        setSupportActionBar(toolbar);


        adapter=new ListviewAdapter(this,R.layout.mypage_item,l_data);
        listView.setAdapter(adapter);



        Intent i = getIntent();
        number = i.getStringExtra("number");
        nickName = i.getStringExtra("nickName");


        if(initial ==0) {
            nick.setText(nickName);
            dnick.setText(nickName);
            initial++;
        }
        if(pushnum!=0) {
            push.setVisibility(View.VISIBLE);
            String s = String.valueOf(pushnum);
            s = " "+ s +" ";
            push.setText(s);
        }
        else{
            push.setVisibility(View.INVISIBLE);

        }

        if(bitmap==null) {
            bitmap = drawable.getBitmap();
        }
        tmpRoundedAvatarDrawable = new RoundedAvatarDrawable(bitmap);
        avatarProfile.setImageDrawable(tmpRoundedAvatarDrawable);
        profile.setImageDrawable(tmpRoundedAvatarDrawable);
        //drawer setonclick

        ib.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, SosActivity.class);
                mainIntent.putExtra("nickName", nickName);
                mainIntent.putExtra("number", number);
                startActivityForResult(mainIntent,REQ_WRITE_NEW_ASSIGNMENT);
            }
        });


        avatarProfile.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
            }
        });


        //        mainFragment = (MainFragment) manager.findFragmentById(R.id.fragment);
        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_heart);
        ab.setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);
        listView.setOnItemClickListener(listener);



        ab.setTitle(nickName);

    }
    AdapterView.OnItemClickListener listener= new AdapterView.OnItemClickListener() {

        //ListView의 아이템 중 하나가 클릭될 때 호출되는 메소드
        //첫번째 파라미터 : 클릭된 아이템을 보여주고 있는 AdapterView 객체(여기서는 ListView객체)
        //두번째 파라미터 : 클릭된 아이템 뷰
        //세번째 파라미터 : 클릭된 아이템의 위치(ListView이 첫번째 아이템(가장위쪽)부터 차례대로 0,1,2,3.....)
        //네번재 파리미터 : 클릭된 아이템의 아이디(특별한 설정이 없다면 세번째 파라이터인 position과 같은 값)
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // TODO Auto-generated method stub

            //클릭된 아이템의 위치를 이용하여 데이터인 문자열을 Toast로 출력
            Intent mainIntent = new Intent(MainActivity.this, ItemSpecificActivity.class);


            mainIntent.putExtra("name", l_data.get(position).getName());
            mainIntent.putExtra("number", l_data.get(position).getnumber());
            mainIntent.putExtra("helper", l_data.get(position).getHelper());
            mainIntent.putExtra("profile", l_data.get(position).getProfile());
            mainIntent.putExtra("prof", l_data.get(position).getProf());
            mainIntent.putExtra("sub", l_data.get(position).getSubject());
            mainIntent.putExtra("assign", l_data.get(position).getAssignment());
            mainIntent.putExtra("icon", l_data.get(position).getIcon());

            startActivity(mainIntent);
//            Toast.makeText(MainActivity.this, data.get(position).getName(), Toast.LENGTH_SHORT).show();
        }
    };



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQ_WRITE_NEW_ASSIGNMENT) {
            if (resultCode == Activity.RESULT_OK) {

                    pushnum++;
                    final String prof = data.getStringExtra("prof");
                    final String sub = data.getStringExtra("sub");
                    final String assign = data.getStringExtra("assign");
                    final int icon = data.getIntExtra("icon", 1);

                    dog=new ListviewItem(icon,nickName,sub,prof,assign,number,R.drawable.empty_profile, R.drawable.profile);
                    l_data.add(dog);
                    adapter.notifyDataSetChanged() ;

                    if(pushnum!=0) {
                        push.setVisibility(View.VISIBLE);
                        String s = String.valueOf(pushnum);
                        s = " "+ s +" ";
                        push.setText(s);
                    }
            }
        }








        if(requestCode == REQ_CODE_SELECT_IMAGE)
        {
            if(resultCode== Activity.RESULT_OK)
            {

                try {
                    //Uri에서 이미지 이름을 얻어온다.
                    //String name_Str = getImageNameToUri(data.getData());
                    //이미지 데이터를 비트맵으로 받아온다.
                    bitmap	= MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    tmpRoundedAvatarDrawable = new RoundedAvatarDrawable(bitmap);
                    avatarProfile.setImageDrawable(tmpRoundedAvatarDrawable);
                    profile.setImageDrawable(tmpRoundedAvatarDrawable);
                    //Toast.makeText(getBaseContext(), "name_Str : "+name_Str , Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }





    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {


        Fragment fragment = null;
        int position = 1;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                Intent mainIntent = new Intent(MainActivity.this, MainListActivity.class);
                startActivity(mainIntent);

                break;
            case R.id.nav_second_fragment:

                break;

        }
                mDrawer.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

//입력변수에 fragment한개 추가하고 바로 애니메이터 실행


}