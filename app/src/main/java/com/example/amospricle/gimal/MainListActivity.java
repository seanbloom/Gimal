package com.example.amospricle.gimal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by amospricle on 15. 8. 3..
 */


public class MainListActivity extends AppCompatActivity {



    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    private FragmentManager manager;
    private ImageView avatarProfile;
    private BitmapDrawable drawable;
    private Bitmap bitmap;

    private RoundedAvatarDrawable tmpRoundedAvatarDrawable;
    private ImageView profile;
    private ImageButton ib;

    ListviewAdapter adapter;

    int r =R.drawable.profile;
    final int REQ_HELPER = 129;

    ListView listView;
    ArrayList<ListviewItem> data;

    public void bind(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        avatarProfile = (ImageView)findViewById(R.id.profile);
        drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.profile);
        manager  = getSupportFragmentManager();
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        profile = (ImageView) findViewById(R.id.profile);
        ib = (ImageButton) findViewById(R.id.imageButton2);
    }






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_listview);
        bind();
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.mainpage_listview);
        data = new ArrayList<ListviewItem>();




/*sample*/

        ListviewItem tiger=new ListviewItem(R.drawable.coffeebean,"hani","위 아래에 대하여","hani","노래부르기","11",R.drawable.empty_profile,R.drawable.profile_hani);
        ListviewItem dog=new ListviewItem(R.drawable.burgerking,"captian_park","축구와 족구","park-ji-sung","리프팅","12",R.drawable.empty_profile,R.drawable.profile_park);
        ListviewItem d1=new ListviewItem(R.drawable.domino,"HYUN-A","아 ","hani","노래부르기","11",R.drawable.empty_profile,R.drawable.profile_hani);
        ListviewItem d2=new ListviewItem(R.drawable.starbucks,"호날두","축구와 족구","park-ji-sung","리프팅","12",R.drawable.empty_profile,R.drawable.profile_park);
        ListviewItem d3=new ListviewItem(R.drawable.jaws,"LE","앱 개발","hani","3d","09",R.drawable.empty_profile,R.drawable.profile_hani);
        ListviewItem d4=new ListviewItem(R.drawable.mcdonald,"MESSI","프리메라리그","park-ji-sung","호날두사인","12",R.drawable.empty_profile,R.drawable.profile_park);
        ListviewItem d5=new ListviewItem(R.drawable.tomntoms,"hani","위 아래에 대하여","hani","노래부르기","14",R.drawable.empty_profile,R.drawable.profile_hani);
        ListviewItem d6=new ListviewItem(R.drawable.donkin,"HOBINHO","프리미어리그","park-ji-sung","족구","07",R.drawable.empty_profile,R.drawable.profile_park);
/*sample*/


        data.add(tiger);
        data.add(dog);
        data.add(d1);
        data.add(d2);
        data.add(d3);
        data.add(d4);
        data.add(d5);
        data.add(d6);

        adapter=new ListviewAdapter(this,R.layout.mypage_item,data);
        listView.setAdapter(adapter);


        bitmap = drawable.getBitmap();
        tmpRoundedAvatarDrawable = new RoundedAvatarDrawable(bitmap);
        avatarProfile.setImageDrawable(tmpRoundedAvatarDrawable);




        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_heart);
        ab.setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);



        listView.setOnItemClickListener(listener);



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
            Intent mainIntent = new Intent(MainListActivity.this, ItemSpecificActivity.class);


            mainIntent.putExtra("name", data.get(position).getName());
            mainIntent.putExtra("number", data.get(position).getnumber());
            mainIntent.putExtra("helper", data.get(position).getHelper());
            mainIntent.putExtra("profile", data.get(position).getProfile());
            mainIntent.putExtra("prof", data.get(position).getProf());
            mainIntent.putExtra("sub", data.get(position).getSubject());
            mainIntent.putExtra("assign", data.get(position).getAssignment());
            mainIntent.putExtra("icon", data.get(position).getIcon());
            mainIntent.putExtra("position",position);

            startActivityForResult(mainIntent, REQ_HELPER);
//            Toast.makeText(MainActivity.this, data.get(position).getName(), Toast.LENGTH_SHORT).show();
        }
    };


    protected void onActivityResult(int requestCode, int resultCode, Intent i_data) {

        if (requestCode == REQ_HELPER) {
            if (resultCode == Activity.RESULT_OK) {
                int position = i_data.getIntExtra("position",0);

                data.get(position).setHelper(r);
                adapter.notifyDataSetChanged() ;

                Toast.makeText(getBaseContext(), "요청자에게 알림문자를 보냈습니다.", Toast.LENGTH_LONG).show();



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

                break;
            case R.id.nav_second_fragment:

                MainListActivity.this.finish();
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


}