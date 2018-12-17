package fr.ubordeaux.ao.domain.type;

import java.util.regex.*;
import java.util.Scanner;
import java.lang.Boolean;

public class CatalogName{
  private String name;

  public CatalogName(){
    boolean cont = true;
    Scanner sc = new Scanner(System.in);
    while (cont){
      System.out.println("Enter a name for the catlog. It must be between 3 and 10 letters, all lower case.");
      String nametrial = sc.nextLine();
      Boolean check = checkName(nametrial);
      if (check == true){
        this.name=nametrial;
        cont = false;
      }
      else{
        System.out.println("Sorry your name is not good enough.");
      }
    }
  }

  private Boolean checkName(String name){
    String pattern = "[a-z]*";
    int maxlength = 10;
    int minlength = 3;
    int len = name.length();
    if(len<maxlength && len>minlength && name.matches(pattern)){
      return true;
    }
    return false;
  }

  public String getStringName(){
    return name;
  }
}
