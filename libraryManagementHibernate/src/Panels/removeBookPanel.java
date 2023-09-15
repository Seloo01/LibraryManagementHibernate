package Panels;

import org.hibernate.Session;

import com.mainpackage.lbManagement;

public class removeBookPanel {
	
	public static void removeBook(int bookId, Session session) {
		
		lbManagement book = session.get(lbManagement.class, bookId);
	    
	    if (book != null) {
	        session.delete(book);
	        System.out.println("\"" + book.getBookname() + "\"" + " Adlı kitap başarılı bir şekilde kütüphaneden kaldırıldı.");
	    } else {
	        System.out.println("\"" + bookId + "\"" + " Kodlu kitap bulunamadı.");
	    }
	}
}
