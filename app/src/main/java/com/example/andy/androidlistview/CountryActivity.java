package com.example.andy.androidlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CountryActivity extends Activity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_country);
    
    TextView textView = (TextView) findViewById(R.id.country_name);
    textView.setText(getIntent().getExtras().getString("country"));
  }
}