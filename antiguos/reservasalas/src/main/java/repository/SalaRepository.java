package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entityes.Sala;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long> {
	 @Query("select * from Sala")
	List<Sala> findAll(String title);
	
}