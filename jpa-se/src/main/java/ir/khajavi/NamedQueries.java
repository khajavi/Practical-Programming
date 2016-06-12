package ir.khajavi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NamedQueries {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-se");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("find employee by id");

		query.setParameter("id", 1201);
		List<Employee> list = query.getResultList();

		for (Employee e : list) {
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee Name :" + e.getName());
		}

		em.close();
		emf.close();
	}
}