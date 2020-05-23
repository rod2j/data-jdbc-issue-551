package fr.rod2j.poc.spring.data.jdbc.issue551;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class City {

	@Id
	private final Long id;
    private final String name;
    private final String countryCode;

    public static City of(String name, String countryCode) {
        return new City(null, name, countryCode);
    }

    @PersistenceConstructor
    public City(Long id, String name, String countryCode) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.countryCode = countryCode;
    }

    public City withId(Long id) {
        return new City(id, name, countryCode);
    }


	public Long getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryCode, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(countryCode, other.countryCode) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("City [id=%s, name=%s, countryCode=%s]", id, name, countryCode);
	}

}
