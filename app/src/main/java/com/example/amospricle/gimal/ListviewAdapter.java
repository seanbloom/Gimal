package com.example.amospricle.gimal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amospricle on 2015. 12. 4..
 */
public class ListviewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<ListviewItem> data;
    private int layout;

    public ListviewAdapter(Context context, int layout, ArrayList<ListviewItem> data){
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }

    @Override
    public int getCount(){return data.size();}
    @Override
    public String getItem(int position){return data.get(position).getName();}
    @Override
    public long getItemId(int position){return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }

        ListviewItem listviewitem=data.get(position);
        ImageView icon=(ImageView)convertView.findViewById(R.id.imageview);
        icon.setImageResource(listviewitem.getIcon());

        BitmapDrawable drawable = (BitmapDrawable) convertView.getResources().getDrawable(R.drawable.profile);

        Bitmap bitmap = drawable.getBitmap();
        RoundedAvatarDrawable tmpRoundedAvatarDrawable;
        ImageView avatarProfile;
        avatarProfile = (ImageView)convertView.findViewById(R.id.item_profile);
        tmpRoundedAvatarDrawable = new RoundedAvatarDrawable(bitmap);
        avatarProfile.setImageDrawable(tmpRoundedAvatarDrawable);

        TextView name=(TextView)convertView.findViewById(R.id.nicknametext);
        name.setText(listviewitem.getName());

        TextView subject=(TextView)convertView.findViewById(R.id.item_subject);
        subject.setText(listviewitem.getSubject());

        TextView prof=(TextView)convertView.findViewById(R.id.item_prof);
        prof.setText(listviewitem.getProf());

        TextView assignment=(TextView)convertView.findViewById(R.id.item_assign);
        assignment.setText(listviewitem.getAssignment());

        TextView number=(TextView)convertView.findViewById(R.id.item_num);
        number.setText(listviewitem.getnumber());

        BitmapDrawable drawable1 = (BitmapDrawable) convertView.getResources().getDrawable(listviewitem.getHelper());
        Bitmap bitmap1 = drawable1.getBitmap();
        RoundedAvatarDrawable tmpRoundedAvatarDrawable1;
        ImageView avatarProfile1;
        avatarProfile1 = (ImageView)convertView.findViewById(R.id.item_helper);
        tmpRoundedAvatarDrawable1 = new RoundedAvatarDrawable(bitmap1);
        avatarProfile1.setImageDrawable(tmpRoundedAvatarDrawable1);


        BitmapDrawable drawable2 = (BitmapDrawable) convertView.getResources().getDrawable(listviewitem.getProfile());
        Bitmap bitmap2 = drawable2.getBitmap();
        RoundedAvatarDrawable tmpRoundedAvatarDrawable2;
        ImageView avatarProfile2;
        avatarProfile2 = (ImageView)convertView.findViewById(R.id.item_profile);
        tmpRoundedAvatarDrawable2 = new RoundedAvatarDrawable(bitmap2);
        avatarProfile2.setImageDrawable(tmpRoundedAvatarDrawable2);

        return convertView;
    }
}