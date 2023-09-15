package Panels;

import org.hibernate.Session;
import com.mainpackage.lbManagement;

public class addBookPanel {
	
	//Kitap ekleme paneli
	
	
	public static void addBook(int bookId, String bookName, int bookamount, Session session) {
				
		lbManagement book = new lbManagement();
        book.setId(bookId);
        book.setBookname(bookName);
        book.setBookamount(bookamount);
        session.save(book);
        
        System.out.println("\"" + bookName + "\"" + " Adlı kitap başarılı bir şekilde kütüphaneye eklendi.");
	}
}
