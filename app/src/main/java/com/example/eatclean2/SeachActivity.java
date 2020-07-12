package com.example.eatclean2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eatclean2.DBMonan.queryData;
import com.example.eatclean2.Model.Monan;
import com.example.eatclean2.adapter.adapter;
import com.example.eatclean2.adapter.adapter2;

import java.util.ArrayList;

public class SeachActivity extends AppCompatActivity {
    public static int id=0;
    static RecyclerView recyclerview;
    static ArrayList<Monan> monans;
    EditText editText;

    static com.example.eatclean2.adapter.adapter2 adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach);


        queryData queryData=new queryData(this,id);
        // queryData.xoabang();
        monans=queryData.getAlldata3table();

        editText=findViewById(R.id.ed_tk);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String key = editText.getText().toString();

                if(actionId==KeyEvent.KEYCODE_ENTER&& !key.equals("")) {


                    ArrayList<Monan> monanArrayList = new ArrayList<>();
                    for (Monan a : monans) {
                        if (a.getTen().contains(key)) {
                            monanArrayList.add(a);
                        }
                    }
                    adapter2=new adapter2(monanArrayList,SeachActivity.this);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SeachActivity.this);
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerview.setLayoutManager(linearLayoutManager);
                    recyclerview.setAdapter(adapter2);


                    Toast.makeText(SeachActivity.this, editText.getText().toString(), Toast.LENGTH_LONG).show();
                    return true;
                }
                if(key.equals("")){
                    //kí tự tìm kiếm trống thì...hiện all
                    //adapter=new adapter(monans,SeachActivity.this);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SeachActivity.this);
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerview.setLayoutManager(linearLayoutManager);
                    recyclerview.setAdapter(adapter2);
                    // return true;
                }
                return false;
            }
        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String key = editText.getText().toString();

                if(i==KeyEvent.KEYCODE_ENTER&& !key.equals("")) {


                    ArrayList<Monan> monanArrayList = new ArrayList<>();
                    for (Monan a : monans) {
                        if (a.getTen().contains(key)) {
                            monanArrayList.add(a);
                        }
                    }
                    adapter2=new adapter2(monanArrayList,SeachActivity.this);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SeachActivity.this);
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerview.setLayoutManager(linearLayoutManager);
                    recyclerview.setAdapter(adapter2);


                    Toast.makeText(SeachActivity.this, editText.getText().toString(), Toast.LENGTH_LONG).show();
                    return true;
                }
                if(key.equals("")){
                    //adapter=new adapter(monans,SeachActivity.this);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SeachActivity.this);
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerview.setLayoutManager(linearLayoutManager);
                    recyclerview.setAdapter(adapter2);
                    // return true;
                }
                return false;
            }

        });
        recyclerview=findViewById(R.id.recyclerview);
        adapter2=new adapter2(monans,SeachActivity.this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SeachActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter2);
    }
}