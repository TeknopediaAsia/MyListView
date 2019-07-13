package com.mahesaiqbal.mylistview;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private AndroidVersionAdapter adapter;
    private ArrayList<AndroidVersion> androidVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new AndroidVersionAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, androidVersions.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        androidVersions = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setPhoto(dataPhoto.getResourceId(i, -1));
            androidVersion.setName(dataName[i]);
            androidVersion.setDescription(dataDescription[i]);
            androidVersions.add(androidVersion);
        }

        adapter.setAndroidVersions(androidVersions);
    }
}
