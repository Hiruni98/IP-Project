package com.example.nsbmgreenuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class test3 extends AppCompatActivity {

    private static final int    REQUEST_CALL=1;
    private TextView callText;
    private Button callbtn;

    private EditText eTo,eSub,eMess;
    private Button bSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        callText=findViewById(R.id.callButton);
        callbtn=findViewById(R.id.callButton);
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton();
            }
        });
    }
    private void CallButton()
    {
        String number=callText.getText().toString();
        if(number.trim().length()>0)
        {
            if(ContextCompat.checkSelfPermission(test3.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(test3.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else
            {
                String dial="tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[]grantResults)
    {
        if (requestCode==REQUEST_CALL)
        {
            if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                CallButton();
            }
            else
            {
                Toast.makeText(this,"permission DENIED",Toast.LENGTH_SHORT).show();
            }
        }

        eTo=findViewById(R.id.to);
//        eSub=findViewById(R.id.sub);
//        eMess=findViewById(R.id.mess);
        bSend=findViewById(R.id.btn);

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" +eTo.getText().toString()));
//                intent.putExtra(Intent.EXTRA_SUBJECT,eSub.getText().toString());
//                intent.putExtra(Intent.EXTRA_TEXT,eMess.getText().toString());
                startActivity(intent);
            }
        });
    }
}
