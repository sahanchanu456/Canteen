/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassSet;

import com.email.durgesh.Email;

/**
 *
 * @author G I U S Chamika
 */
public class EmailSend {
    public static void SendMail(String generatedString,String mailAddress, String subject){
        
         try {
             //System.out.println(rand);
            Email email=new Email("fotcanteenonlinefos@gmail.com","TecCanteen123%");
            email.setFrom("fotcanteenonlinefos@gmail.com","Tech Canteen");
            email.setSubject(subject);
            email.setContent("<h1> Please enter below number as your confirmation code.  </h1><br> <h2>$rand</h2> ", "text/html");
            email.setContent(generatedString, "text/html");
            //email.setContent("<script></script>");
           
            email.addRecipient(mailAddress);
            email.send();
        } catch (Exception e) {
            System.out.println("error occured.."+e);
        }  
    }
}
