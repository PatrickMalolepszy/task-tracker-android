package team.tasktacker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import models.BasicInfo;

public class AnotherActivity extends AppCompatActivity {

    @BindView(R.id.phone)
    EditText phone;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.date)
    EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void saveHere() {
        Log.v("HERE", "trying to save");
        BasicInfo basicInfo = new BasicInfo();
        basicInfo.phone = phone.getText().toString();
        basicInfo.email = email.getText().toString();
        basicInfo.date = date.getText().toString();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(basicInfo);
        Log.d("Basic Info Saving", s);
    }
}
