package com.projectf5.changgong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public  class NoticeActivity extends AppCompatActivity {

//    private ArrayList<ItemObject> mList;
    private int code;

//    public NoticeActivity(ArrayList<ItemObject> list) {
//        this.mList = list;
//    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        TextView tv_title = findViewById(R.id.tv_title);
        TextView tv_address = findViewById(R.id.tv_address);
        TextView tv_date = findViewById(R.id.tv_date);
        TextView tv_content = findViewById(R.id.tv_content);

        Button bt_back = findViewById(R.id.bt_back);

        Intent intent = getIntent();
        code = intent.getIntExtra("NOTICE_KEY",0);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });

        GetDetailData getDetailData = null;

        if(code == 0) {
            tv_title.setText("경력활동계획서");
            tv_address.setText( "" );
            tv_date.setText( "" );
            tv_content.setText("오아시스>학사정보>학생상담>큰사람프로젝트관리>경력활동계획서>계획서 작성/검사 실시>검사결과(PDF)다운로드\n" +
                    "오아시스>학사정보>학생상담>큰사람프로젝트관리>포인트신청(신청 시 다운받은 검사결과 PDF 파일첨부)");
        }

        else if(code == 1) {
            tv_title.setText("인성검사, 적성검사 중 택 1");
            tv_address.setText( "" );
            tv_date.setText( "" );
            tv_content.setText("인성검사:행복드림센터 방문하여 검사 실시\n" +
                    "상담완료 후, 행복드림센터에서 일관 포인트 입력\n" +
                    "적성검사:오사시스>학사정보>학생상담>진로적성검사 예약\n" +
                    "예약시간에 방문하여 검사 및 상담 실시\n" +
                    "상담 완료 후,취업지원과에서 일괄 포인트 입력");
        }

       else if(code == 2) { //진로캠프
            new GetDetailData( "http://www.jbnu.ac.kr/kor/?menuID=139&subject=%EC%A7%84%EB%A1%9C%EC%BA%A0%ED%94%84&sfv=subject" ).execute();
            tv_title.setText( getDetailData.getTitle() );
            tv_address.setText(getDetailData.getAddress());
            tv_content.setText("프로그램 개설 시 개별신청(홈페이지 등을 통해 사전공지함)\n" +
                    "프로그램 종료 후 수료자에 한하여 취업지원과/창업교육센터에서 일괄 포인트 입력"  );
            tv_date.setText(getDetailData.getDate());
        }

        else if(code == 3) {
            tv_title.setText( "추천도서 4권" );
            tv_address.setText( "" );
            tv_date.setText( "" );
            tv_content.setText( "추천도서를 확인하고,독서감상문보고서(양식6)를 다운받아 작성(영역당 1권씩)\n" +
                    "오아시스>학사정보>학생상담>큰사람프로젝트 관리>포인트 신청(신청시 작성한 감상문보고서 파일첨부)" );
        }

        else if(code == 4) {
            tv_title.setText( "진로상담(취업지원과 진로상담팀)" );
            tv_address.setText( "" );
            tv_date.setText( "" );
            tv_content.setText( "진로상담:오아시스>학사정보>학생상담>진로취업상담>진로상담 예약\n" +
                    "예약시간에 방문하여 상담 실시 \n" +
                    "상담 완료 후 취업지원과에서 일괄포인트 일력\n" +
                    "창업상담:창업교육센터로 사전 예약 후 방문하여 상담 실시" );
        }

        else if(code == 5) {
            tv_title.setText( "사회(국내)봉사 20시간" );
            tv_address.setText( "" );
            tv_date.setText( "" );
            tv_content.setText( "교내기관:봉사활동 주관부서(국제교류부,언어교육원 등)로 포인트 입력 요청\n" +
                    "외부기관:오아시스>학사정보>학생상담>큰사람프로젝트 관리>포인트 신청(*해외봉사/헌혈은 불인정)" );
        }
        else if(code == 6) { //교내 멘토링

        }

        else if(code == 7) {
            tv_title.setText( "토익점수 제출(모의토익 가능)" );
            tv_address.setText( "" );
            tv_date.setText( "" );
            tv_content.setText( "토익 성적표를 파일로 스캔(White벨트에 한하여 모의토익 인정)\n" +
                    "오아시스>학사정보>학생상담>큰사람프로젝트 관리>포인트 신청(신청 시 스캔한 성적표 파일 첨부)" );
        }
    }

    public void load() {
        SharedPreferences student = getSharedPreferences("STUDENT",MODE_PRIVATE);
        int belt = student.getInt("belt",0);
        if(belt == R.id.rb_bt_n) {
            Intent intent = new Intent(getApplicationContext(), NBeltActivity.class);
            startActivity(intent);
            finish();
        }

        else if(belt == R.id.rb_bt_wt) {
            Intent intent = new Intent(getApplicationContext(), WbeltActivity.class);
            startActivity(intent);
            finish();
        }

        else if(belt == R.id.rb_bt_yl) {
            Intent intent = new Intent(getApplicationContext(), YBeltActivtiy.class);
            startActivity(intent);
            finish();
        }

        else if(belt == R.id.rb_bt_bl) {
            Intent intent = new Intent(getApplicationContext(), BBeltActivity.class);
            startActivity(intent);
            finish();
        }

        else if(belt == R.id.rb_bt_rd) {
            Intent intent = new Intent(getApplicationContext(), RBeltActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
