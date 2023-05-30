package com.example.questionlevelone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity
{
    Button button;
    ListView lv_courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv_courses = findViewById(R.id.courses);

        RequestFetch requestFetch = new RequestFetch(MainActivity2.this);

        requestFetch.getCourses(new RequestFetch.AfterCourseResponse()
        {
            @Override
            public void onResponse(List<Courses> courses)
            {
                ArrayAdapter arrayAdapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1, courses);

                lv_courses.setAdapter(arrayAdapter);

            }

            @Override
            public void onError(String message)
            {
                Toast.makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }
}