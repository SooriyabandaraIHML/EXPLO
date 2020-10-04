package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import com.example.myproject.models.Member;


public class SingleViewActivity extends AppCompatActivity {

    public Button button;
    Member selectedMember;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_view);

        Intent i = getIntent();
        selectedMember = (Member) i.getSerializableExtra("data");
        id = i.getStringExtra("key");

        button = (Button) findViewById(R.id.btnEdit);
        ((TextView) findViewById(R.id.budget)).setText(selectedMember.getBudget());
        ((TextView) findViewById(R.id.description)).setText(selectedMember.getDescription());
        ((TextView) findViewById(R.id.duration)).setText(selectedMember.getDuration());
        ((TextView) findViewById(R.id.email)).setText(selectedMember.getEmail());
        ((TextView) findViewById(R.id.fullName)).setText(selectedMember.getFullName());
        ((TextView) findViewById(R.id.phone)).setText(selectedMember.getPhone());
        ((TextView) findViewById(R.id.mode)).setText(selectedMember.getTransportationMode());
        ((TextView) findViewById(R.id.place)).setText(selectedMember.getTravelPlace());


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SingleViewActivity.this, EditActivity.class);
                intent.putExtra("data", selectedMember);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });


    }
}