package Querys;

import java.util.Scanner;

import org.hibernate.Session;

import Panels.addBookPanel;

public class AddQuery {
	
	
	public static void Add(int bookid, String bookname, int bookamount, Session session) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Lütfen eklemek istediğiniz kitaba bir kod giriniz: ");
        bookid = scn.nextInt();
        scn.nextLine();

        System.out.println("Lütfen eklemek istediğiniz kitabın ismini giriniz: ");
        bookname = scn.nextLine();

        System.out.println("Lütfen " + bookname + " adlı kitabınızn kaç adet olacağını giriniz: ");
        bookamount = scn.nextInt();
        scn.nextLine();
        
        addBookPanel.addBook(bookid, bookname, bookamount, session);
        
	}
}
