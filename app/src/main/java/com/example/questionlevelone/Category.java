package com.example.questionlevelone;

public class Category
{
    String courseName;
    int noOfCourses;

    public Category(String courseName, int noOfCourses)
    {
        this.courseName = courseName;
        this.noOfCourses = noOfCourses;
    }

    @Override
    public String toString() {
        return "courseName=" + courseName +'\n' + Integer.toString(noOfCourses) + " Courses";
    }
}
