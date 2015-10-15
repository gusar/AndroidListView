package com.example.andy.androidlistview;


public class Country {
  private int flag;
  private String name;

  public Country(int flag, String name) {
    this.flag = flag;
    this.name = name;
  }

  public Country(String name) {
    this.name = name;
  }

  public int getFlag() {
    return flag;
  }

  public String getName() {
    return name;
  }


  //  Create an ArrayList of Countries
//  public static ArrayList<Country> getCountries() {
//    ArrayList<Country> countryList = new ArrayList<>();
//
//    final Resources resources = Resources.getSystem();
//    String[] listData = resources.getStringArray(R.array.list_data);
//
//    for (String s : listData) {
//      countryList.add(new Country(s));
//    }
//    return countryList;
//  }

}


