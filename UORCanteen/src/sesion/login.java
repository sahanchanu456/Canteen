
package sesion;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.User;





/**
 *
 * @author G I U S Chamika
 */
public class login {
    static Session session=null;
    
    public static void insert(User e){
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
        session.save(e);
        tx.commit();
        //session.flush();
        session.close();
    }
    
    public static void main(String[] args) {
     User e=new User("tg262", "sahan chamika", "chamika", "1234", "uytre@gmail.com", "address01", "student", "455588", "no", "077 0609541");
     insert(e);
    }
}

        