package Querys;

import java.util.Scanner;

import org.hibernate.Session;

import Panels.removeBookPanel;

public class RemoveQuery {
	
	public static void Remove(int id, Session session) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Silmek istediğiniz kitabın kodunu giriniz: ");
		id = scn.nextInt();
		scn.nextLine();
		
		removeBookPanel rbp = new removeBookPanel();
		rbp.removeBook(id, session);
	}

}
