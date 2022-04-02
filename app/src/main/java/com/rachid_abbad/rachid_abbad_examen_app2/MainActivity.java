package com.rachid_abbad.rachid_abbad_examen_app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rachid_abbad.rachid_abbad_examen_app2.adapters.Prof_Rachid_Adapter;
import com.rachid_abbad.rachid_abbad_examen_app2.classes.Prof_Rachid;
import com.rachid_abbad.rachid_abbad_examen_app2.data.ManageDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ManageDatabase manageDatabase;
    List<Prof_Rachid> listMain;
    Prof_Rachid_Adapter adapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manageDatabase = new ManageDatabase(this);

        rv = findViewById(R.id.rv);

        listMain = new ArrayList<Prof_Rachid>();

        adapter = new Prof_Rachid_Adapter(this,R.layout.prof_layout, listMain);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        Bundle b = getIntent().getExtras();
        ArrayList<Prof_Rachid> list = (ArrayList<Prof_Rachid>) b.getSerializable("list");
        if(b!=null){
            listMain.clear();
            listMain.addAll(list);
            manageDatabase.addProfs(list);
            adapter.notifyDataSetChanged();
        }

    }
}