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

}


