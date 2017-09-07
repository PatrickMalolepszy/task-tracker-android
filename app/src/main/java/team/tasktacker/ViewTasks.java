package team.tasktacker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
        ButterKnife.bind(this);
        setContentView(R.layout.activity_view_tasks);
        // Construct the data source
        ArrayList<Task> arrayOfUsers = new ArrayList<Task>();
        // Create the adapter to convert the array to views
        TaskAdapter adapter = new TaskAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView

        taskList.setAdapter(adapter);
    }
}
