/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatetest;

import model.User;
import model.Seat;
import model.Show;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author Adamoc
 */
public class HibernateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User a = new User("a", "a");
        User b = new User("b", "b");
        User c = new User("c", "c");
        User d = new User("d", "d");
        User e = new User("e", "e");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.save(b);
        session.save(c);
        session.save(d);
        session.save(e);
        session.getTransaction().commit();
        
        session.beginTransaction();
        User user = (User)session.get(User.class, "a");
        System.out.println(user);
        session.getTransaction().commit();
        
        session.beginTransaction();
        ArrayList<User> al = new ArrayList<>();
        al.addAll(session.createQuery("from User").list());
        for (User user1 : al) {
            System.out.println(user1);
        }
        session.getTransaction().commit();
        
        Show show = new Show("Av", 3, 3);
        Seat seat = new Seat(2,2);
        session.beginTransaction();
        user = (User)session.get(User.class, "b");
        user.addBooking(show, seat);
        session.getTransaction().commit();
        
        session.beginTransaction();
        al.clear();
        al.addAll(session.createQuery("from User").list());
        for (User user1 : al) {
            System.out.println(user1);
        }
        session.getTransaction().commit();
        
        
        session.close();
        
        
        
        
        
        HibernateUtil.closeSessionFactory();
    }
    
}
