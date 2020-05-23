package fr.rod2j.poc.spring.data.jdbc.issue551;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

	long countByNameAndCountryCode(String name, String countryCode);

	// Will fail: wrong query derivation issue a select instead of delete
	long deleteByNameAndCountryCode(String name, String countryCode);
	
	// Will succeed
	List<City> removeByNameAndCountryCode(String name, String countryCode);
}
