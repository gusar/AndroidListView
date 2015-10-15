package com.example.andy.androidlistview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Country {
  public int countryFlag;
  public String countryName;
  private static ResourceBundle resources;

  public Country(int countryFlag, String countryName) {
    this.countryFlag = countryFlag;
    this.countryName = countryName;
  }

  public static ArrayList<Country> getCountries() {
    ArrayList<Country> countries = new ArrayList<>();
    String[] stringList = getResources().getStringArray(R.array.list_data);
    ArrayList<String> arrayOfCountries = new ArrayList<>(Arrays.asList(stringList));

    return countries;
  }

  public static ResourceBundle getResources() {
    return resources;
  }
}


