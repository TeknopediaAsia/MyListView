package com.mahesaiqbal.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AndroidVersionAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AndroidVersion> androidVersions;

    public void setAndroidVersions(ArrayList<AndroidVersion> androidVersions) {
        this.androidVersions = androidVersions;
    }

    public AndroidVersionAdapter(Context context) {
        this.context = context;
        androidVersions = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return androidVersions.size();
    }

    @Override
    public Object getItem(int i) {
        return androidVersions.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        AndroidVersion androidVersion = (AndroidVersion) getItem(i);
        viewHolder.bind(androidVersion);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(AndroidVersion androidVersion) {
            txtName.setText(androidVersion.getName());
            txtDescription.setText(androidVersion.getDescription());
            Glide.with(context)
                    .load(androidVersion.getPhoto())
                    .centerCrop()
                    .into(imgPhoto);
        }
    }
}
