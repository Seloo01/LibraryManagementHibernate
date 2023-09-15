package Panels;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

public class ListsPanel {
	
	public static void listBooks(Session session) {
        List<String> names =
                session.createQuery("select b.bookname from lbManagement b GROUP BY b.bookname").getResultList();

        List<Integer> ids = session.createQuery("select b.id from lbManagement b GROUP BY b.id").getResultList();

        List<Integer> amounts = session.createQuery("select b.bookamount from lbManagement b GROUP BY b.bookamount").getResultList();

        int listSize = Math.min(Math.min(ids.size(), names.size()), amounts.size());

        System.out.println("----------------------------");
        System.out.println("Kütüphanedeki Tüm Kitaplar: ");
        System.out.println("----------------------------");

        for (int i = 0; i < listSize; i++) {
            int id = ids.get(i);
            String name = names.get(i);
            int amount = amounts.get(i);

            System.out.println("ID: " + id + " İsim: " + name + " Adet: " + amount);
        }
    }
}
