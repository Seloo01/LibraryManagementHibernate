package com.mainpackage;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

import Panels.ListsPanel;
import Querys.AddQuery;
import Querys.RemoveQuery;
import Querys.roleQuery;


public class Main {
    public static boolean isWorking = true;

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(lbManagement.class)
                .buildSessionFactory();

        lists lists = new lists();
        ListsPanel listPanel = new ListsPanel();
        AddQuery add = new AddQuery();
        RemoveQuery remove = new RemoveQuery();
        Scanner scn = new Scanner(System.in);

        int bookid = 0;
        String bookname = "";
        int bookamount = 0;

        roleQuery.queryRole(lists);
        while (isWorking) {
        	Session session = factory.getCurrentSession();
            try {
                session.beginTransaction();

                System.out.println("Ne yapmak istersiniz?");
                System.out.println("--Ekle--Sil--Listele");
                String request = scn.nextLine();
                switch (request) {
                	case "ekle":  
                		if(lists.isManager()) {
                	       add.Add(bookid, bookname, bookamount, session);       
                		}else {
                			System.out.println("Maalesef Yönetici Değilsiniz!");
                			roleQuery.queryRole(lists);
                		}
                		session.getTransaction().commit(); 
                        break;
                    case "sil":
                    	if(lists.isManager()) {
                    		remove.Remove(bookid, session);
                    	}else {
                    		System.out.println("Maalesef Yönetici Değilsiniz!");
                			System.exit(0);
                    	}
                    	session.getTransaction().commit();
                    	break;
                    case "listele":
                    	if(lists.isUser() || lists.isManager()) {
                    		listPanel.listBooks(session);
                    	}else {
                    		System.out.println("Herhangi bir rütbeye sahip değilsiniz!");
                    	}
           			  session.getTransaction().commit();
                    	break;
                    default:
                    	System.out.println("Hata! Yanlış komut girdiniz!");
                    	break;    
                }
            } catch (Exception e) {
                e.printStackTrace();
                session.getTransaction().rollback();         
                /*
                 * session.getTransaction().rollback(); ifadesi, 
                 * bir işlem sırasında meydana gelen hataları ele almak 
                 * ve veritabanını istenmeyen değişikliklerden korumak 
                 * için kullanılır.
                 */ 
            } finally {
                session.close();
            }
        }
        factory.close();
    }
}

