package dao;

import pojo.Person;

import java.util.List;

public interface PersonMapper {
    List<Person> getAllPerson();

    List<Person> getPersonByGroupID(Integer p_g_id);

    int addPerson(Person person);

    int delPersonByName(String p_name);

    int updatePerson(Person person);

}
