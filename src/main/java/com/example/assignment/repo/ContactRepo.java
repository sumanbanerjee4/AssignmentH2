package com.example.assignment.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.stereotype.Repository;

//import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.assignment.model.Contacts;


@Repository
public interface ContactRepo extends CrudRepository<Contacts,Integer>{

	void deleteById(String name);
    
	Optional<Contacts> findByName(String name);

	
	@Query("select c from Contacts c left outer join Devices d on d.deviceName = :deviceName order by c.version desc")
	List<Contacts> findBydeviceName(@Param("deviceName")String deviceName);

	 /* @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
	  User findByLastnameOrFirstname(@Param("lastname") String lastname,
	                                 @Param("firstname") String firstname);

	*/
	//public <Contacts> findByName(String name);


}
