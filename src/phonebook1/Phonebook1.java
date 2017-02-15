/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author misho.velichkovski
 */
public class Phonebook1 {
    
    public static ArrayList<Contact> contacts=new ArrayList<>();

  public static void main(String[] args) {
        
         
         String fileName="C:\\Users\\misho.velichkovski\\Documents\\NetBeansProjects\\Phonebook1\\src\\phonebook1\\ContactList.txt";
         String[] singleContact;
           String patternString1 = "+3598[789][0-9][{7}";
           Pattern pattern1 = Pattern.compile(patternString1);
           String patternString2 = "08[789][0-9]{7}";
           Pattern pattern2 = Pattern.compile(patternString2);
           String patternString3 = "003598[789][0-9]{7}";
           Pattern pattern3 = Pattern.compile(patternString3);
     
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				                                singleContact=line.split(" ");
                                Contact c=new Contact(singleContact[0],singleContact[1], singleContact[2]);
                                contacts.add(c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
               for (Contact c : contacts)
               {    
                   /*if(c.getNumber().length()!= 13 || c.getNumber().length()!= 10 || c.getNumber().length()!= 14 )
                   {
                       contacts.remove(c);
                   }
                   else 
                   {*/
                    Matcher matcher1 = pattern1.matcher(c.getNumber());
                    Matcher matcher2 = pattern2.matcher(c.getNumber());
                    Matcher matcher3 = pattern3.matcher(c.getNumber());
                   if( !(matcher1.matches() || matcher2.matches() || matcher3.matches()))
                   {
                       contacts.remove(c);
                   }
                   
                   
                   //}
               }
               
                 for (Contact c : contacts)
               {    
                   
                   StringBuilder str = new StringBuilder(c.getNumber());
                   if(str.charAt(0)=='0' && str.charAt(1)=='8')
                   {
                       str.deleteCharAt(0);
                       str=str.insert(0,"+359");
                       c.setNumber(str.toString());
                   }
                   if(str.charAt(0)=='0' && str.charAt(1)=='0')
                   {
                       str.deleteCharAt(0);
                       str.deleteCharAt(1);
                       str=str.insert(0,"+");
                       c.setNumber(str.toString());
                   }
               
               }
               
                 
               
      }
  
  public String searchContact(String ct)
               {
                   for (Contact c : contacts )
                   {
                       if(c.getName().equals(ct))
                       {
                            c.beenSearched=c.beenSearched +1 ;
                           return c.printContact();
                          
                       }
                   }
                   return "ERROR";
               }
    
}
    

