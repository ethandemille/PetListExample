package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import model.Pet;

public class MainActivity extends AppCompatActivity {

    ListView mainList;
    ArrayList<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainList = findViewById(R.id.mainList);
        int selection = 2;

        pets = new ArrayList<>();
        pets.add(new Pet("Kenny", "Husky", 14));

        populateListView(selection);

    }

    private void populateListView(int selection) {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String[] contents = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contents);
        mainList.setAdapter(adapter);
    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {
        ArrayAdapter<Pet> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pets);
        mainList.setAdapter(adapter);

    }
}