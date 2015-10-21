package com.example.andy.androidlistview.ArrayListAdapter;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andy.androidlistview.CountryActivity;
import com.example.andy.androidlistview.R;

public class ArrayListActivity extends ListActivity {

  private static final String LOG_TAG = ArrayListActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_array_list);

    /**
     * - context of the current activity
     * - custom row layout
     * - String array from resource
     */
    CountryArrayAdapter countryArrayAdapter = new CountryArrayAdapter(
        this,
        R.layout.row,
        getResources().getStringArray(R.array.list_data));
    setListAdapter(countryArrayAdapter);
  }


  /**
   * putExtra method parameters:
   * - key String
   * - value String
   * (other constructors available)
   */
  @Override
  public void onListItemClick(ListView listView, View view, int position, long id) {
    Intent intent = new Intent(ArrayListActivity.this, CountryActivity.class);
    String selectedCountry = (String) listView.getItemAtPosition(position);
    intent.putExtra("position", Integer.toString(position));
    intent.putExtra("country", selectedCountry);
    Log.d(LOG_TAG, "Extras: " + Integer.toString(position) + " : " + selectedCountry);
    startActivity(intent);
  }


  /**
   * override getView() method of ArrayAdapter
   */
  public class CountryArrayAdapter extends ArrayAdapter<String> {
    private int resourceId;

    private class ViewHolder {
      private TextView countryName;
      private ImageView countryFlag;
    }

    public CountryArrayAdapter(Context context, int textViewResourceId, String[] countryList) {
      super(context, textViewResourceId, countryList);
    }

    /**
     * convertView and ViewHolder pattern for reusing LayoutInflater rows
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder viewHolder;

      /**
       * inflate only if the a is empty
       * assign current row layout data elements to the ViewHolder
       */
      if (convertView == null) {
        Log.d(LOG_TAG, "Inflating...");
        convertView = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.row, parent, false);
        viewHolder = new ViewHolder();
        viewHolder.countryName = (TextView) convertView.findViewById(R.id.country_name);
        viewHolder.countryFlag = (ImageView) convertView.findViewById(R.id.country_flag);
        convertView.setTag(viewHolder);
      } else {
        Log.d(ArrayListActivity.class.getSimpleName(), "...re-using");
        viewHolder = (ViewHolder) convertView.getTag();
      }

      /**
       * assign data to the current row elements
       */
      String country = getItem(position);
      if (country != null) {
        if (country.equals("Ireland")) {
          resourceId = parent.getResources()
              .getIdentifier("ok", "drawable", getPackageName());
        } else {
          resourceId = parent.getResources()
              .getIdentifier(country.toLowerCase(), "drawable", getPackageName());
        }
        Log.d(LOG_TAG, "resourceId: " + resourceId);
        viewHolder.countryName.setText(country);
        viewHolder.countryFlag.setImageResource(resourceId);
      }
      return convertView;
    }
  }

}
