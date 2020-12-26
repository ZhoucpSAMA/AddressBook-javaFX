package dao;

import pojo.Person;

import java.util.List;

public interface PersonMapper {
    List<Person> getAllPerson();


    int addPerson(Person person);

    int delPersonByName(String p_name);

    int updatePersonByName(Person person);

    Person getPersonByName(String p_name);

    int delPersonByGroupID(Integer p_g_id);

}
