package ir.khajavi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateEmployee {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-se");

		EntityManager em = emf.createEntityManager();

		Employee employee = new Employee();
		employee.setEid( 1202 );
		employee.setName("Gopal");
		employee.setSalary(40000);
		employee.setDeg("Technical Manager");

		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		em.close();

		emf.close();
	}
}
