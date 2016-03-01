package ma.jpaspring.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ma.jpaspring.dao.DaoStudent;
import ma.jpaspring.model.Student;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
		"App-context.xml");		
		DaoStudent daoS = context.getBean(DaoStudent.class);
		Date d= new  SimpleDateFormat("dd/MM/yyyy").parse("31/02/2000");
		Student S = new Student("El Mardi", "Yassine",d);
		daoS.create(S);
	}
}
