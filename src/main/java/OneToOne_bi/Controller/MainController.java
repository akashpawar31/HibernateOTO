package OneToOne_bi.Controller;

import OneToOne_bi.dao.PersonDao;
import OneToOne_bi.dto.AadharCard;
import OneToOne_bi.dto.Person;

public class MainController {
	public static void main(String[] args) {
		Person person=new Person();
		person .setName("aniket");
		person.setAddress("nashik");
		person.setPhone(757432483);
		
		AadharCard aadharcard=new AadharCard();
		aadharcard.setName("jayesh");
		aadharcard.setAddress("pune");
		aadharcard.setPerson(person);
		person.setAadharcard(aadharcard);
		
		PersonDao dao=new PersonDao();
		//dao.savePerson(person);
	//	dao.getPerson(1);
		//dao.getAllPerson();
	//	dao.deletePerson(1);
		dao.updatePerson(person, 3);
	}

}
