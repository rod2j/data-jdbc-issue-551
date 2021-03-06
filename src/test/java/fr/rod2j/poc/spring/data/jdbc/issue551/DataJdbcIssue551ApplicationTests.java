package fr.rod2j.poc.spring.data.jdbc.issue551;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataJdbcIssue551ApplicationTests {

	@Autowired
	CityRepository repo;
	
	@Test
	void contextLoads() {
	}

	@BeforeEach
	void beforeEach() {
		repo.deleteAll();
	}
	
	@Test
	void canDeleteWithListReturnType() {
		City city1 = repo.save(City.of("Grenoble", "FR"));
		assertThat(city1.getId()).isNotNull();
		City retrieved = repo.findById(city1.getId()).get();
		assertThat(retrieved).isEqualTo(city1);

		City city2 = repo.save(City.of("Vancouver", "CA"));
		assertThat(city2.getId()).isNotNull();
		
		List<City> deletedCAList = repo.removeByNameAndCountryCode("Vancouver", "CA");
		assertThat(deletedCAList).size().isEqualTo(1);
		assertThat(repo.findById(city2.getId())).isEmpty(); // fails
		
	}
	
	@Test
	void canDeleteWithLongReturnType() {
		City city1 = repo.save(City.of("Grenoble", "FR"));
		assertThat(city1.getId()).isNotNull();
		City retrieved = repo.findById(city1.getId()).get();
		assertThat(retrieved).isEqualTo(city1);

		City city2 = repo.save(City.of("Vancouver", "CA"));
		assertThat(city2.getId()).isNotNull();
		
		long nbDeletedFR = repo.deleteByNameAndCountryCode("Grenoble", "FR"); // fails
		assertThat(nbDeletedFR).isEqualTo(1);
		assertThat(repo.findById(city1.getId())).isEmpty();
	}
}
