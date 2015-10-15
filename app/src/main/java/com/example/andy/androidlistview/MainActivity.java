package com.example.andy.androidlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] stringList = getResources().getStringArray(R.array.list_data);

    ArrayAdapter<String> adapter = new ArrayAdapter<>(
        this,
        android.R.layout.simple_list_item_1,
        stringList);

    this.setListAdapter(adapter);
  }


  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    String itemString = (String) l.getItemAtPosition(position);

  }


  // imageview.setImageResource(R.drawable.picture);
}
