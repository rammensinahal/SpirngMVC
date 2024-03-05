package springmvcRoom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import springmvcRoom.dto.Room;


@Repository
public class RoomDao {


	EntityManagerFactory f=Persistence.createEntityManagerFactory("ram");
	EntityManager m=f.createEntityManager();

	public Room saveRoom(Room room) {
		EntityTransaction t=m.getTransaction();
		t.begin();
		m.persist(room);
		t.commit();
		return room;

	}
	public Room updateRoom(Room room) {
		EntityTransaction t=m.getTransaction();
		t.begin();
		m.merge(room);
		t.commit();
		return room;
	}
	public boolean deleteRoom(int id) {
		EntityTransaction t=m.getTransaction();
		Room r=m.find(Room.class, id);
		if(r!=null) {
			t.begin();
			m.remove(r);
			t.commit();
			return true;
		}else {
			return false;
		}
	}
	public Room getById(int id) {
		return m.find(Room.class, id);

	}
	public List<Room> getall(){
		Query query=m.createQuery("select x from Room x");
		return query.getResultList();
	}
}
