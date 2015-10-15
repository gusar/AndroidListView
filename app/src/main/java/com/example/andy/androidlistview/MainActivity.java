package com.example.andy.androidlistview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    populateCountryList();
  }


  public void populateCountryList() {
    ArrayList<Country> arrayOfCountries = Country.getCountries();

    CustomCountriesAdapter adapter = new CustomCountriesAdapter(this, arrayOfCountries);
    ListView listView = (ListView) findViewById(R.id.country_list);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String cname =
      }
    });
  }


  //  DEFINE CUSTOM ADAPTER
  public static class CustomCountriesAdapter extends ArrayAdapter<String> {
    public CustomCountriesAdapter(Context context, ArrayList<Country> countries) {
      super(context, 0, countries);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      String countryName = getItem(position);

      //check if already inflated
      if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
      }

      TextView textView = (TextView) convertView.findViewById(R.id.country);
      textView.setText(countryName);

      return convertView;
    }
  }

//  public void onListItemClick(ListView listView, View view, int position, long id) {
//    Intent intent = new Intent(MainActivity.this, CountryActivity.class);
//    String extra = listView.getItemAtPosition(position).toString();
//    intent.putExtra("country", extra);
//    Log.v("", extra);
//    startActivity(intent);
//  }
}

