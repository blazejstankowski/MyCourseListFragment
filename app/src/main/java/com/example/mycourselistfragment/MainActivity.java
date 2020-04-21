package com.example.mycourselistfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mycourselistfragment.data.Course;

public class MainActivity extends AppCompatActivity
        implements CourseListFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.myContainer);
//
//        if (fragment == null) {
//            fragment = new CourseListFragment();
//            fm.beginTransaction()
//                    .add(R.id.myContainer, fragment)
//                    .commit();
//        }
    }

    @Override
    public void onItemSelected(Course course, int position) {

//        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, CourseDetailActivity.class);
        intent.putExtra("course_id", position);
        startActivity(intent);

    }
}
