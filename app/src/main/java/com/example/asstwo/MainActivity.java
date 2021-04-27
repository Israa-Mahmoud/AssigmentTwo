package com.example.asstwo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import java.util.Calendar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    CheckBox male, female;
   // private Button applyTextButton;
    private EditText Name;
    private EditText Phone;
    private EditText Email;
    private EditText Hoopies;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private Button button;
    private Button saveButton;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "name";
    public static final String TEXT2="phone";
    public static final String TEXT3="email";
    public static final String TEXT4="hoopies";
    public static final String TEXT5="male";
    public static final String TEXT6="female";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate views
        male = (CheckBox) findViewById(R.id.Gender_male);
        male.setOnClickListener(this);
        female = (CheckBox) findViewById(R.id.Gender_female);
        female.setOnClickListener(this);
        setupViews();
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, onDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet : mm/dd/yyy: " + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        saveButton =(Button) findViewById(R.id.save_button);
       /* applyTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });////////////////////////*/
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, page2.class);
        startActivity(intent);
    }
    private void setupViews() {
        Name = findViewById(R.id.txtName);
        Phone = findViewById(R.id.txtPhone);
        Email = findViewById(R.id.txtEmail);
        Hoopies = findViewById(R.id.txtHoopies);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Gender_male:
                if (male.isChecked())
                    Toast.makeText(getApplicationContext(), "Male", Toast.LENGTH_LONG).show();
                break;
            case R.id.Gender_female:
                if (female.isChecked())
                    Toast.makeText(getApplicationContext(), "Female", Toast.LENGTH_LONG).show();
                break;
        }

    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, Name.getText().toString());
        editor.putString(TEXT2, Phone.getText().toString());
        editor.putString(TEXT3, Email.getText().toString());
        editor.putString(TEXT4, Hoopies.getText().toString());
        editor.putString(TEXT4, Hoopies.getText().toString());
        editor.putString(TEXT5, male.getText().toString());
        editor.putString(TEXT6, female.getText().toString());


        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();

    }

}