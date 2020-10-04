package com.example.myproject.helper;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AppData {
    public static String[] budgets={"Low","Med","High"};
    public  static String[] durations={"1 Day","2 Days","3 Days"};

    public static ArrayAdapter  getDurationAdapter(Context c){
         ArrayAdapter durations=new ArrayAdapter(c,android.R.layout.simple_spinner_item, AppData.durations);

         durations.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return durations;
    }
    public static ArrayAdapter  getBudgetsAdapter(Context c){
        ArrayAdapter budgets=new ArrayAdapter(c,android.R.layout.simple_spinner_item, AppData.budgets);

        budgets.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return budgets;
    }
}
