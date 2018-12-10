package com.projectf5.changgong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class RBeltActivity extends AppCompatActivity {
    private CheckBox call;
    private CheckBox[] c;
    private TextView[] t;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbelt);
        SharedPreferences Student = getSharedPreferences("STUDENT", MODE_PRIVATE);
        final SharedPreferences.Editor editor = Student.edit();

        c = new CheckBox[6];
        t = new TextView[6];

        call = findViewById(R.id.call);

        c[0] = findViewById(R.id.c0);
        c[1] = findViewById(R.id.c1);
        c[2] = findViewById(R.id.c2);
        c[3] = findViewById(R.id.c3);
        c[4] = findViewById(R.id.c4);
        c[5] = findViewById(R.id.c5);

        t[0] = findViewById(R.id.t0);
        t[1] = findViewById(R.id.t1);
        t[2] = findViewById(R.id.t2);
        t[3] = findViewById(R.id.t3);
        t[4] = findViewById(R.id.t4);
        t[5] = findViewById(R.id.t5);

        b = findViewById(R.id.b);

        call.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(call.isChecked() == true) {
                    for(int i = 0; i < 6; i++) {
                        c[i].setChecked(true);
                    }
                }
                else {
                    for(int i = 0; i < 6; i++) {
                        c[i].setChecked(false);
                    }
                }
            }
        });

        ArrayList<String> data = new ArrayList<>();

        data.add("추천도서 4권(누적 20권)");
        data.add("토익스피킹 레벨7이상 oplc IH 이상 제2외국어 50점이상 중 택1");
        data.add("사회(국내)봉사 20시간(누적 100시간)");
        data.add("정규토익 인문 850점 이상, 이공 800점 이상");
        data.add("기업탐방/기업체험 전공자격증 한국어능력시험 한국사능력시험 한자2급 이상 중 택1");
        data.add("공모전");

        for(int i = 0; i < data.size(); i++) {
            t[i].setText(data.get(i));
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                editor.clear().commit();
                Intent intent = new Intent(getApplicationContext(),InformationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}