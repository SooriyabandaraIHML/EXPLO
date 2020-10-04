package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myproject.database.Database;
import com.example.myproject.helper.AppData;
import com.example.myproject.models.Member;

import java.util.ArrayList;
import java.util.Arrays;


public class EditActivity extends AppCompatActivity {

    public Button button;
    Member selctedMember;
    String id;
    EditText tname, temail, tphone, tplace, ttravelmode, tdescription;
    Spinner sbudget, sduration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = getIntent();
        id = i.getStringExtra("id");
        selctedMember = (Member) i.getSerializableExtra("data");

        button = (Button) findViewById(R.id.button);
        tname = findViewById(R.id.tname);
        temail = findViewById(R.id.temail);
        tphone = findViewById(R.id.tphone);
        tplace = findViewById(R.id.tplace);
        ttravelmode = findViewById(R.id.ttransmode);
        tdescription = findViewById(R.id.tdescription);

        sbudget = findViewById(R.id.sbudget);
        sduration = findViewById(R.id.sduration);


        sbudget.setAdapter(AppData.getBudgetsAdapter(this));
        sduration.setAdapter(AppData.getDurationAdapter(this));

        sbudget.setSelection(Arrays.asList(AppData.budgets).indexOf(selctedMember.getBudget()));
        sduration.setSelection(Arrays.asList(AppData.durations).indexOf(selctedMember.getDuration()));

        tname.setText(selctedMember.getFullName());
        temail.setText(selctedMember.getEmail());
        tphone.setText(selctedMember.getPhone());
        tplace.setText(selctedMember.getTravelPlace());
        ttravelmode.setText(selctedMember.getTransportationMode());
        tdescription.setText(selctedMember.getDescription());


        button = findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Database.getInstance.update(new Member(tname.getText().toString(), temail.getText().toString(), tphone.getText().toString(), tplace.getText().toString(), ttravelmode.getText().toString(), sbudget.getSelectedItem().toString(), sduration.getSelectedItem().toString(), tdescription.getText().toString()), id);
                Toast.makeText(EditActivity.this, "Successfully updated", Toast.LENGTH_LONG).show();

            }

        });

    }
}