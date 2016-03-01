package ma.jpaspring.dao;

import java.util.Date;
import java.util.List;

import ma.jpaspring.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByNom(String string);
	 
	/*List<Student> findByNom(String nom);*/
	List<Student> findByNomLike(String string);
	List<Student> findBydatenaiBetween(Date dat1,Date date2);
	
	@Query("select s from Student s where s.nom = ?1")
	  Student findByNomJPA(String nom);
	
	@Query(value="select * from Student where Student.prenom = ?1", nativeQuery = true)
	  Student  findByPrenomSqlNatif(String prenom);
	
	@Query("SELECT NEW ma.jpaspring.dto.DtoStudent(s.id,s.nom) FROM Student s")
	  List<Student> findJPADto();
}
