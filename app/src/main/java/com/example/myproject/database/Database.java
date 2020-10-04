package com.example.myproject.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public class Database {

    public static Database getInstance = new Database();

    private static DatabaseReference _database = null;

    private Database() {
    }

    ;

    private <T> DatabaseReference getCollection(T model) {
        if (_database == null) {
            _database = FirebaseDatabase.getInstance().getReference();
        }
        return _database.child(model.getClass().getSimpleName());
    }

    public <T> void insert(T model) {
        DatabaseReference collection = getCollection(model);
        String id = collection.push().getKey();
        collection.child(id).setValue(model);
    }


    public <T> void update(T model, String id) {
        DatabaseReference collection = getCollection(model).child(id);
        collection.setValue(model);
    }
}
