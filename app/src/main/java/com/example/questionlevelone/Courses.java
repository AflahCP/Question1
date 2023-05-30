package com.example.questionlevelone;

public class Courses
{
    String course;
    String cost;

    public Courses(String course, String cost)
    {
        this.course = course;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                course + '\n' + cost + " INR + GST";
    }
}

