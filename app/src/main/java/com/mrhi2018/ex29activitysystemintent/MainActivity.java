package com.mrhi2018.ex29activitysystemintent;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickDial(View view) {

        //전화번호 입력하는 앱실행
        Intent intent= new Intent();
        //intent.setAction("android.intent.action.DIAL");
        intent.setAction( Intent.ACTION_DIAL );

        Uri uri= Uri.parse("tel:01012345678");
        intent.setData(uri);
        startActivity(intent);

    }

    public void clickSMS(View view) {

        Intent intent= new Intent();

        intent.setAction(Intent.ACTION_SENDTO);

        Uri uri= Uri.parse("smsto:01012345678, 01044445555");
        intent.setData(uri);

        //문자내용도 미리 작성되도록 하려면..추가데이터 필요
        intent.putExtra("sms_body", "Hello..Nice to meet you");


        startActivity(intent);
    }

    public void clickWeb(View view) {

        Uri uri= Uri.parse("http://www.naver.com");
        Intent intent= new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void clickGallery(View view) {

        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//미디어 타입 선택
        startActivity(intent);

    }

    public void clickCamera(View view) {

        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);

    }
}
