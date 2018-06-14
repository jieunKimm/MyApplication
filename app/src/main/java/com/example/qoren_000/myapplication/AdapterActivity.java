package com.example.qoren_000.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.content.res.Resources;

public class AdapterActivity extends AppCompatActivity{
    ListView listView1;
    IconTextListAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_board);

        //리스트 뷰의 아이디 값을 찾아서 불러온 후 변수에 담아준다
        listView1 = (ListView)findViewById(R.id.listView);

        adapter = new IconTextListAdapter(this);
        Resources res = getResources();

        String[][] data = new String[3][2];
        data[0][0] = "2018.05.06";
        data[0][1] = "300";
        data[1][0] = "2018.06,14";
        data[1][1] = "200";
        data[2][0] = "";
        String s;
        for(int i = 0; !data[i][0].equals(""); i++){
            s = i + "";
            adapter.addItem(new IconTextItem(s, data[i][0], data[i][1]));
        }
        listView1.setAdapter(adapter);
    }
}
