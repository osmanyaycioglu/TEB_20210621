package com.training.ee.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.training.ee.rest.Person;

@Singleton
@LocalBean
public class PersonStorage {

    private final Map<String, Person> personMap = new ConcurrentHashMap<>();

    public PersonStorage() {
    }

    public void add(final Person personParam) {
        this.personMap.put(personParam.getName(),
                           personParam);
    }

    public Person getPerson(final String name) {
        return this.personMap.get(name);
    }

    public List<Person> getAllPersons() {
        Collection<Person> valuesLoc = this.personMap.values();
        return new ArrayList<>(valuesLoc);
    }

}
