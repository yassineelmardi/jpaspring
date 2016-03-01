package ma.jpaspring.Main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ma.jpaspring.dao.StudentRepository;
import ma.jpaspring.model.Student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/App-context.xml"})
public class TestJunit {
	@Autowired
	StudentRepository StuRepo;
	
	Student stu;
	Student stu2;

	@Before
	public void setUp() throws ParseException {
			Date d= new  SimpleDateFormat("dd/MM/yyyy").parse("01/04/2013");
		stu = new Student("Farmaja","Yassine",d);
		stu2 = new Student("Test","Test",d);
		
	}
	@Test
	public void TestBetweenDate() throws ParseException {

		 stu = StuRepo.save(stu2);
		 Date d1= new  SimpleDateFormat("dd/MM/yyyy").parse("01/05/2013");
		 Date d2= new  SimpleDateFormat("dd/MM/yyyy").parse("01/09/2013");
		 List<Student> stubydate= StuRepo.findBydatenaiBetween(d1, d2);
		 System.out.println("*********************"+stubydate.size());
		 assertEquals(stubydate.size(),0);
	

	}
	@Test
	public void TestSave(){
		stu = StuRepo.save(stu);
		List<Student> stus = StuRepo.findByNom("Spring data");
		assertNotNull(stus);
		
	}
	@Test
	public void TestFindByNom(){
		 List<Student> stubynom= StuRepo.findByNomLike("lol");
		 assertEquals(stubynom.size(),0);
	}
	@Test
	public void TestJPAByNom(){
		Student S=StuRepo.findByNomJPA("Farmaja");
		assertEquals(S.getPrenom(), "Yassine");
	}
	
	@Test
	public void TestSqlNatif(){
		Student S=StuRepo.findByPrenomSqlNatif("Yassine");
		assertEquals(S.getNom(), "Farmaja");
	}
	@Test
	public void TestDtoStudent(){
		List<Student> dtoStudent=StuRepo.findJPADto();
		Assert.assertTrue(dtoStudent.size()<3);
	}

}
