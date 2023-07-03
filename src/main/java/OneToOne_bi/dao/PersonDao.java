package OneToOne_bi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToOne_bi.dto.AadharCard;
import OneToOne_bi.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("akash").createEntityManager();

	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		// AadharCard aadharcard=person.getAadharcard();
		entityTransaction.begin();
		// entityManager.persist(aadharcard);
		entityManager.persist(person);
		entityTransaction.commit();

	}

	public void getPerson(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		System.out.print(person);

	}

	public void getAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query q = entityManager.createQuery("select p from Person p");
		System.out.println(q.getResultList());

	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}
	}

	public void updatePerson(Person person,int id) { 
	  EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	  Person dbperson=entityManager.find(Person.class, id);
	  if(dbperson!=null) {
		  person.setId(id);
		  person.getAadharcard().setId(dbperson.getAadharcard().getId());
		  
		  entityTransaction.begin();
		  entityManager.merge(person);
		  entityTransaction.commit();
		  
	  }
  }

}
