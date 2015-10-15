package com.example.andy.androidlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CountryAdapter extends ArrayAdapter<Country> {

  private static class ViewHolder {
    private TextView countryName;
  }

  public CountryAdapter(Context context, ArrayList<Country> countries) {
    super(context, 0, countries);
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = LayoutInflater.from(this.getContext())
          .inflate(R.layout.row, parent, false);

      viewHolder = new ViewHolder();
      viewHolder.countryName = (TextView) convertView.findViewById(R.id.country);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    Country country = getItem(position);
    if (country != null) {
      viewHolder.countryName.setText(country.getName());
    }

    return convertView;
  }

}
