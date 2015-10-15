package com.example.andy.androidlistview;


import java.util.ArrayList;
import java.util.ResourceBundle;

public class Country {
  public int flag;
  public String name;
  private static ResourceBundle resources;

  public Country(int flag, String name) {
    this.flag = flag;
    this.name = name;
  }

  public Country(String name) {
    this.name = name;
  }

  public static ArrayList<Country> getCountries() {
    ArrayList<Country> countryList = new ArrayList<>();
//    String[] stringList = getResources().getStringArray(R.array.list_data);
//    ArrayList<String> arrayOfCountries = new ArrayList<>(Arrays.asList(stringList));
//
//    return countries;
//  }
//
//  public static ResourceBundle getResources() {
    return countryList;
  }
}


