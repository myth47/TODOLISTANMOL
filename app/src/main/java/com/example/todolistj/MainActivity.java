package com.example.todolistj;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;

    private ArrayAdapter<String>itemsAdapter;

    private ListView listView;

    private EditText editTextInput;





    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        listView = findViewById(R.id.listView);

        Button button = findViewById(R.id.button);

        editTextInput = findViewById(R.id.editTextInput);



        button.setOnClickListener(this::addItem);

        items = new ArrayList<>();

        itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);

        listView.setAdapter(itemsAdapter);

        SetupListViewListner();

    }



    private void SetupListViewListner() {

        listView.setOnItemLongClickListener((adapterView, view, item, i) -> {

            Context context = getApplicationContext();

            Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();

            items.remove(i);

            itemsAdapter.notifyDataSetChanged();

            return true;



        });

        Context context = getApplicationContext();

        Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();

        items.remove(items);

        itemsAdapter.notifyDataSetChanged();


    }



    private void addItem(View view) {

        editTextInput  = findViewById(R.id.editTextInput);

        String itemText = editTextInput.getText().toString();

        if (!(itemText.equals(""))){

            itemsAdapter.add(itemText);

            editTextInput.setText("");

        }

        else {

            Toast.makeText(getApplicationContext(),"Please Enter Text",Toast.LENGTH_LONG).show();

        }





    }






}