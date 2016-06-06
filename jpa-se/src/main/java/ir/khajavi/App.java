package ir.khajavi;

import javax.persistence.EntityManager;
import java.util.List;

public class App {
	public static void main(String[] args) {
		Address address = new Address();
		address.setCity("Esfahan")
				.setCountry("Iran")
				.setPostcode("1000346276")
				.setStreet("Bahar");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction()
				.begin();
		em.persist(address);
		em.getTransaction()
				.commit();


		List res = em.createQuery(
				"SELECT c FROM Address c").getResultList();
		System.out.println(res);


		em.close();
		PersistenceManager.INSTANCE.close();
	}
}
