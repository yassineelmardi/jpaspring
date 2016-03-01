package ma.jpaspring.Main;

import ma.jpaspring.dao.StudentRepository;
import ma.jpaspring.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringData {
public static void main(String[]args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
		"App-context.xml");	
		
		
	StudentRepository StuRepo=context.getBean(StudentRepository.class);
		
	/*Student stud=new Student("salam", "Spring DATA");
	StuRepo.save(stud);*/

}
}
