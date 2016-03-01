package ma.jpaspring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ma.jpaspring.model.Student;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DaoStudent{

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional
	public Student create(Student object) {
		entityManager.persist(object);
		return null;
	}
}
