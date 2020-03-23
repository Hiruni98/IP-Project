package com.example.adminpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;
    private EditText venueTxt,mnameTxt,mDescTxt,mdateTxt,mtimeTxt;

    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        venueTxt = (EditText)findViewById(R.id.venueTxt);
        mnameTxt = (EditText)findViewById(R.id.nameTxt);
        mDescTxt = (EditText)findViewById(R.id.DescTxt);
        mdateTxt = (EditText)findViewById(R.id.dateTxt);
        mtimeTxt = (EditText)findViewById(R.id.timeTxt);

        mSendData = (Button)findViewById(R.id.SendData);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Events");

        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInformation();
            }
        });
    }

    private void SaveInformation() {

        String Venue = venueTxt.getText().toString();
        String Name = mnameTxt.getText().toString();
        String Description = mDescTxt.getText().toString();
        String Date = mdateTxt.getText().toString();
        String Time = mtimeTxt.getText().toString();

        HashMap infoMap = new HashMap();
        infoMap.put("Venue",Venue);
        infoMap.put("Name",Name);
        infoMap.put("Description",Description);
        infoMap.put("Date",Date);
        infoMap.put("Time",Time);

        databaseReference.updateChildren(infoMap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
