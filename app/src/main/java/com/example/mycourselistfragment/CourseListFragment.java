package com.example.mycourselistfragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.mycourselistfragment.ScreenUlility.ScreenUlitity;
import com.example.mycourselistfragment.data.Course;
import com.example.mycourselistfragment.data.CourseArrayAdapter;
import com.example.mycourselistfragment.data.CourseData;

import java.util.List;

public class CourseListFragment extends ListFragment {

    public static final String TAG = "MyFragment";
    private List<Course> courses = new CourseData().courseList();
    private Callbacks activity;

    public CourseListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenUlitity screenUlitity = new ScreenUlitity(getActivity());

        Log.d(TAG, "onCreate: WIDTH " + screenUlitity.getDpWidth() + ", HEIGHT " + screenUlitity.getDpHeight() );

        CourseArrayAdapter adapter = new CourseArrayAdapter(getActivity(), R.layout.course_listitem, courses);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course_list_fragment, container, false);
        return view;
    }

    public interface Callbacks {
        public void onItemSelected(Course course, int position);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Course course = courses.get(position);
//        Toast.makeText(getActivity(), "Name " + course.getCourseName(), Toast.LENGTH_SHORT).show();
        this.activity.onItemSelected(course, position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Callbacks) context;
    }
}
