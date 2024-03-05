package mvc_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mvc_student.dto.Student;
@Repository
public class StudentDao {

	EntityManagerFactory f=Persistence.createEntityManagerFactory("ram");
	EntityManager m=f.createEntityManager();


	public Student savestudent(Student student) {
		EntityTransaction t=m.getTransaction();
		t.begin();
		m.persist(student);
		t.commit();
		return student;

	}
	public Student updateStudent(Student student) {
		EntityTransaction t=m.getTransaction();
		t.begin();
		m.merge(student);
		t.commit();
		return student;
	}
	public boolean deleteStudent(int id) {
		EntityTransaction t=m.getTransaction();
		Student s=m.find(Student.class, id);
		t.begin();
		if(s!=null) {	
		m.remove(s);
		t.commit();
		return true;
		}else {
			return false;
		}
	}
	public Student getbyid(int id) {
		return m.find(Student.class, id);
		
	}
	public List<Student> getall() {
		Query q=m.createQuery("select x from Student x");
		return q.getResultList();
		
	}
}

