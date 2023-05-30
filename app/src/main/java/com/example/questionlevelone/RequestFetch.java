package com.example.questionlevelone;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class RequestFetch
{
    Context context;
    private final String url1 = "https://futursity.com/course/api/categories";
    private final String url2 = "https://futursity.com/course/api/top_courses";

    public RequestFetch(Context context)
    {
        this.context = context;
    }

    public interface AfterResponse
    {
        void onResponse(List<Category> categories);

        void onError(String message);
    }

    public void getCategories(AfterResponse afterResponse)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url1, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        List<Category> categories = new ArrayList<>();
                        try
                        {
                            for (int i = 0; i < response.length(); i++)
                            {
                                Category x = new Category(response.getJSONObject(i).getString("name"), response.getJSONObject(i).getInt("number_of_courses"));

                                categories.add(x);
                            }
                        }
                        catch (JSONException e)
                        {
                                throw new RuntimeException(e);
                        }
                        afterResponse.onResponse(categories);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        afterResponse.onError(error.toString());
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }


















    public interface AfterCourseResponse
    {
        void onResponse(List<Courses> courses);

        void onError(String message);
    }

    public void getCourses(AfterCourseResponse afterCourseResponse)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url2, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        List<Courses> courses = new ArrayList<>();

                        try
                        {
                            for (int i = 0; i < response.length(); i++)
                            {
                                Courses x = new Courses(response.getJSONObject(i).getString("title"), response.getJSONObject(i).getString("full_price"));

                                courses.add(x);
                            }
                        }
                        catch (JSONException e)
                        {
                            throw new RuntimeException(e);
                        }
                        afterCourseResponse.onResponse(courses);

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        afterCourseResponse.onError(error.toString());

                    }
                });
        requestQueue.add(jsonArrayRequest);

    }
}
