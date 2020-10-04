package com.example.myproject.helper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myproject.R;
import com.example.myproject.models.Member;

import java.util.List;

public class MemberAdapter extends ArrayAdapter<Member> {
    private Activity context;
    List<Member> members;

    public MemberAdapter(Activity context, List<Member> members) {
        super(context, R.layout.member, members);
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.member, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.memberName);
        TextView email = (TextView) listViewItem.findViewById(R.id.memberEmail);

        Member member = members.get(position);
        String name = member.getFullName();
        textViewName.setText(name);
        email.setText(member.getEmail());
        return listViewItem;
    }
}
