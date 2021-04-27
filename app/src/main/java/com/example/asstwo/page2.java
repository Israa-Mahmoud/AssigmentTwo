package com.example.asstwo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.EditText;

public class page2 extends AppCompatActivity {
    private EditText Educational;
    private EditText Work;
    private TextView textV;
    private TextView txtWork;
    private Button applyTextButton;
    private Button saveButton;
    private Switch switch1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SWITCH1 = "switch1";
    public static final String TEXT = "text";
    public static final String TEXT2 = "text2";
    private String text;
    private boolean switchOnOff;
    private String text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        setupViews();
        textV = (TextView) findViewById(R.id.tView);
        txtWork = (TextView) findViewById(R.id.txtWork);
        applyTextButton = (Button) findViewById(R.id.apply_text_button);
        saveButton = (Button) findViewById(R.id.save_button);
        switch1 = (Switch) findViewById(R.id.switch1);
        applyTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textV.setText(Educational.getText().toString());
                txtWork.setText(Work.getText().toString());
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadData();
        updateViews();
    }


    private void setupViews() {
        Educational = findViewById(R.id.etEduc);
        Work = findViewById(R.id.edWork);
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT,  textV.getText().toString());
        editor.putBoolean(SWITCH1, switch1.isChecked());
        editor.putString(TEXT,  txtWork.getText().toString());

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false);
       // txtWork = sharedPreferences.getString(TEXT, "");
    }
    public void updateViews() {
        textV.setText(text);
        switch1.setChecked(switchOnOff);
        txtWork.setText(text);
    }
}