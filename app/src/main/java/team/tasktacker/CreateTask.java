package team.tasktacker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import models.Task;

public class CreateTask extends AppCompatActivity {

    @BindView(R.id.task_title_editText)
    EditText taskTitleEditText;

    @BindView(R.id.work_units_editText)
    EditText workUnitsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save_task_button)
    public void saveTask() {

        // Create task, and set fields from view.
        Task newTask = new Task();
        newTask.taskTitle = taskTitleEditText.getText().toString();
        try {
            newTask.workUnits = Integer.parseInt(workUnitsEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d("validation", "User entered invalid number: " + e.getMessage());
            throw e; //TODO: model binding validation layer.
        }
        // Set task as a json to backend:
        String task_json = new Gson().toJson(newTask);
        Log.d("To Backend", "Sending task to backend: " + task_json);
        //TODO: send to backend.

        // Go back to main activity
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
