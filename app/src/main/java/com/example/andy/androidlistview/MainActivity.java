package com.example.andy.androidlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ArrayList<Country> countryList = new ArrayList<>();
    String[] listData = getResources().getStringArray(R.array.list_data);

    for (String s : listData) {
      countryList.add(new Country(s));
    }

    CountryAdapter countryAdapter = new CountryAdapter(this, countryList);
    setListAdapter(countryAdapter);
  }


  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    String itemString = (String) l.getItemAtPosition(position);

  }


  // imageview.setImageResource(R.drawable.picture);
}
