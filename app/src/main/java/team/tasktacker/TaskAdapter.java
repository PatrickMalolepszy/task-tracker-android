package team.tasktacker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.Task;

/**
 * Created by austin on 06/09/17.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    @BindView(R.id.task_title_textview)
    TextView title;

    @BindView(R.id.task_work_units_taskview)
    TextView workUnits;

    public TaskAdapter(Context context, ArrayList<Task> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Task task = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_task_item, parent, false);
        }
        ButterKnife.bind(this, convertView);

        // Populate the data into the template view using the data object
        title.setText(task.taskTitle);
        workUnits.setText(task.workUnits);
        // Return the completed view to render on screen
        return convertView;
    }
}
