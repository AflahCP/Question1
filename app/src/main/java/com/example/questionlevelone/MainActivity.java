package com.example.questionlevelone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    GridView gr_categories;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        gr_categories = findViewById(R.id.grid_categories);

        RequestFetch requestFetch = new RequestFetch(MainActivity.this);

        requestFetch.getCategories(new RequestFetch.AfterResponse() {
            @Override
            public void onResponse(List<Category> categories)
            {
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.gridcell, categories);

                gr_categories.setAdapter(arrayAdapter);
            }

            @Override
            public void onError(String message)
            {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });



        button = findViewById(R.id.btn);


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openActivity2();
            }
        });

    }
    public void openActivity2()
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}