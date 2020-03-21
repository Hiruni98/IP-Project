package com.example.nsbmgreenuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Main_page extends AppCompatActivity {

    TextView userEmail;
    Button userLogout;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        userEmail = findViewById(R.id.tvUserEmail);
        userLogout = findViewById(R.id.btnLogout);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        userEmail.setText(firebaseUser.getEmail());

        userLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Main_page.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        Button btn1 = (Button) findViewById(R.id.button5);
        Button btn2 = (Button) findViewById(R.id.button13);
        Button btn3 = (Button) findViewById(R.id.button11);
        Button btn7 = (Button) findViewById(R.id.button14);
        Button btn8 = (Button) findViewById(R.id.button4);

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(Main_page.this, test3.class);
                startActivity(int1);
            }
        });
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(Main_page.this, Map.class);
                startActivity(int2);
            }
        });
        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(Main_page.this, Time_table.class);
                startActivity(int3);
            }
        });
        btn7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(Main_page.this, Places_uni.class);
                startActivity(int4);
            }
        });
        btn8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent(Main_page.this, About_us.class);
                startActivity(int5);
            }
        });

    }
    public void browser1 (View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://lmsnew.nsbm.lk/"));
        startActivity(browserIntent);
    }


}

