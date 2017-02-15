/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook1;

/**
 *
 * @author Misho
 */
public class Contact {
    
    
    public String name;
    public String surename;
    public String number;
    public int beenSearched;
    
    public Contact(){
    }
    
    public Contact (String nme , String srnme, String nu){
        name=nme;
        surename=srnme;
        number=nu;
        beenSearched=0;
    }
    
    public void setName (String nme)
    {
        name=nme;
    }
    
     public void setSurename (String srnme)
    {
        surename=srnme;
    }
     
      public void setNumber (String nu)
    {
        number=nu;
    }
      
      public void setBeenSearched(int i)
      {
          beenSearched=i;
      }
      public String getName ()
      { 
          return name;
      }
      
      public String getSurename ()
      { 
          return surename;
      }
      
      public String getNumber ()
      { 
          return number;
      }
    public String printContact(){
    
        return name + " " + surename + " " + number;
    }
    
    
}
