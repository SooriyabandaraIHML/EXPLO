package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myproject.database.Database;
import com.example.myproject.helper.AppData;
import com.example.myproject.models.Member;

public class InsertActivity extends AppCompatActivity {

    Button button;
    EditText tname, temail, tphone, tplace, ttravelmode, tdescription;
    Spinner sbudget, sduration;
    String name , email ,phone , place ,mode , description  ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        button = (Button) findViewById(R.id.button);
        tname = findViewById(R.id.tname);
        temail = findViewById(R.id.temail);
        tphone = findViewById(R.id.tphone);
        tplace = findViewById(R.id.tplace);
        ttravelmode = findViewById(R.id.ttransmode);
        tdescription = findViewById(R.id.tdescription);

        sbudget=findViewById(R.id.sbudget);
        sduration=findViewById(R.id.sduration);

        sbudget.setAdapter(AppData.getBudgetsAdapter(this));
        sduration.setAdapter(AppData.getDurationAdapter(this));


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                name = tname.getText().toString();
                phone = tphone.getText().toString();
                description = tdescription.getText().toString();
                place = tplace.getText().toString();
                mode = ttravelmode.getText().toString();


                if (name.isEmpty()) {
                    tname.setError("enter full name");
                    return;
                }else if (phone.isEmpty()) {
                    tphone.setError("enter phone number");
                    return;
                }

                else if (place.isEmpty()) {
                    tplace.setError("enter place");
                    return;
                }


                else if (mode.isEmpty()) {
                    ttravelmode.setError("enter travel mode");
                    return;
                }


                else if (description.isEmpty()) {
                    tdescription.setError("enter phone number");
                    return;
                }


                   else{
                       Database.getInstance.insert(new Member(tname.getText().toString(), temail.getText().toString(), tphone.getText().toString(), tplace.getText().toString(), ttravelmode.getText().toString(), sbudget.getSelectedItem().toString(), sduration.getSelectedItem().toString(), tdescription.getText().toString()));
                       Toast.makeText(InsertActivity.this,"Successfully saved",Toast.LENGTH_LONG).show();

                   }


                //Database.getInstance.insert(new Member(tname.getText().toString(), temail.getText().toString(), tphone.getText().toString(), tplace.getText().toString(), ttravelmode.getText().toString(), sbudget.getSelectedItem().toString(), sduration.getSelectedItem().toString(), tdescription.getText().toString()));
                //Toast.makeText(InsertActivity.this,"Successfully saved",Toast.LENGTH_LONG).show();//
            }
        });



    }



}