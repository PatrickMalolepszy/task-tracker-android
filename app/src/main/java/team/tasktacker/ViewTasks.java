package team.tasktacker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.Task;

public class ViewTasks extends AppCompatActivity {

    @BindView(R.id.task_viewer_listView)
    ListView taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);
        ButterKnife.bind(this);
        // Construct the data source
        ArrayList<Task> tasks = new ArrayList<Task>();
        Task task1 = new Task("test1", 2);
        Task task7 = new Task("test7", 1);
        Task task4 = new Task("test4", 46);
        Task task3 = new Task("test3", 23);
        Task task2 = new Task("test2", 8);
        tasks.add(task1);
        tasks.add(task7);
        tasks.add(task4);
        tasks.add(task3);
        tasks.add(task2);



        // Create the adapter to convert the array to views
        TaskAdapter adapter = new TaskAdapter(this, tasks);
        // Attach the adapter to a ListView

        taskList.setAdapter(adapter);
    }
}
