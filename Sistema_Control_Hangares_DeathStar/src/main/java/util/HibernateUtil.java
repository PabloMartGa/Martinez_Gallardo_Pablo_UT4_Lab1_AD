/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author DAM2P
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    
    
    static{
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("SessionFactory inicializada correctamente");
            
        } catch (Throwable ex) {
            System.err.println("Fallo al inicializar SessionFactory de Hibernate");
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    public static void shutdown(){
        if(sessionFactory != null && !sessionFactory.isClosed())
            sessionFactory.close();
        
        System.out.println("SessionFactory cerrada correctamente");
    }
}
