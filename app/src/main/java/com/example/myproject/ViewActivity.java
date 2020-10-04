package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myproject.helper.MemberAdapter;
import com.example.myproject.models.Member;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {
    DatabaseReference db;
    List<Member> members;
    ListView listView;
List<String >keys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        db = FirebaseDatabase.getInstance().getReference();
        members = new ArrayList<>();
        listView = findViewById(R.id.userList);
        keys=new ArrayList<>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Member m = (Member) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ViewActivity.this, SingleViewActivity.class);
                intent.putExtra("data",m);
                intent.putExtra("key",keys.get(i));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                members.clear();
                keys.clear();
                for (DataSnapshot postSnapshot : snapshot.child(Member.class.getSimpleName()).getChildren()) {
                  String key= postSnapshot.getKey();
                  keys.add(key);
                    Member member = postSnapshot.getValue(Member.class);
                    members.add(member);
                }
                MemberAdapter artistAdapter = new MemberAdapter(ViewActivity.this, members);
                //attaching adapter to the listview
                listView.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}