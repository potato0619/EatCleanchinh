package com.example.eatclean2;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CacbtActivity extends AppCompatActivity {


    Toolbar toolbar;
    RecyclerView recyclerView;
   public static VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacbt);
        recyclerView=findViewById(R.id.recycleview);
        toolbar=findViewById(R.id.toolbar);
        videoView=findViewById(R.id.video);

        ArrayList<vide> vides=new ArrayList<>();
        vides.add(new vide(R.drawable.anh1,"video giảm cân 1",R.raw.video));
        vides.add(new vide(R.drawable.video2,"video giảm cân 2",R.raw.video2));
        vides.add(new vide(R.drawable.video3,"video giảm cân 3",R.raw.video3));
        vides.add(new vide(R.drawable.video4,"video giảm cân 4",R.raw.video4));

        videoadapter thucdonadapter=new videoadapter(CacbtActivity.this,vides);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(CacbtActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(thucdonadapter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle("video");
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video3));
        videoView.requestFocus();
        videoView.start();
    }
    public void phatvideo(int a){
        videoView.setVisibility(View.INVISIBLE);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+a));
        videoView.requestFocus();
        videoView.start();

    }
}