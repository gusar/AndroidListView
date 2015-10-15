package com.example.andy.androidlistview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

  public static final String LOG_TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ArrayList<Country> countryList = new ArrayList<>();
    String[] listData = getResources().getStringArray(R.array.list_data);

    for (String s : listData) {
      Country c = new Country(s);
      countryList.add(c);
      Log.d(LOG_TAG, "Initializing... " + c.getName());
    }

    CountryAdapter countryAdapter = new CountryAdapter(this, countryList);
    setListAdapter(countryAdapter);
  }


  @Override
  public void onListItemClick(ListView listView, View view, int position, long id) {
    Intent intent = new Intent(MainActivity.this, CountryActivity.class);
    Country selectedCountry = (Country) (listView.getItemAtPosition(position));
//    Log.d(LOG_TAG, "Selected country: " + extra);
    intent.putExtra("country", selectedCountry.getName());
    startActivity(intent);
  }

}
