package com.example.asstwo;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

public class JSONPage extends AppCompatActivity {
    String JSON_STRING = "{\"CV\":{\"FirstPage\":\"Some general information should be entered, such as name, hobby, age and gender\",\"SecondPage\"Must enter the scientific experience obtained and the position based on it now}}";
    String FirstPage, SecondPage;
    TextView jobPage2CV, jobPage1CV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_s_o_n_page);
        jobPage1CV = (TextView) findViewById(R.id.txtfirst);
        jobPage2CV = (TextView) findViewById(R.id.name);
        try {
            JSONObject obj = new JSONObject(JSON_STRING);
            JSONObject CV = obj.getJSONObject("CV");
            FirstPage = CV.getString("FirstPage");
            SecondPage = CV.getString("SecondPage");
            jobPage2CV.setText("FirstPage: "+ FirstPage);
            jobPage1CV.setText("SecondPage: "+SecondPage);

        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}