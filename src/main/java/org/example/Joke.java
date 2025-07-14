package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//(שדות שבחרנו לא להשתמש בהם)מתעלם משדות שלא קיימים
@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {
  public String category;
  public String type;
  public String joke;
  public String setup;
  public String delivery;
  public String lang;


    @Override
    public String toString() {
        return "Joke{" +
                "category='" + category + '\'' +"\n"+
                ", type='" + type + '\'' +"\n"+
                ", joke='" + joke + '\'' +"\n"+
                ", setup='" + setup + '\'' +"\n"+
                ", delivery='" + delivery + '\'' +"\n"+
                ", lang='" + lang + '\'' +"\n"+
                '}';
    }
}
