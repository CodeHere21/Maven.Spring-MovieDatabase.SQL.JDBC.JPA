package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PersonService {

    @Autowired
    JdbcTemplate jdbc;

    //we can now pass the row mapper to the query API and get fully populated Java objects:
    public Person getPersonById(int personId) {
        String sql = "SELECT * FROM PERSON WHERE ID = ?";
        return (Person) jdbc.queryForObject(sql, new Object[]{personId}, new PersonRowMapper());

    }

    public List<Person> getAllPerson()  {
        String sql = "SELECT * FROM PERSON";
        List<Person> people = new ArrayList<>();
        List<Map<String, Object>> rows = jdbc.queryForList(sql);
        buildPersonList(people, rows);
        return people;
    }

    public void deletePerson(int personId)  {
        String sql = "DELETE FROM PERSON WHERE ID = " + personId;
        jdbc.execute(sql);
    }

    public Person getPersonByMobile(String mobile) {
        String sql = "SELECT * FROM PERSON WHERE MOBILE = ?";
        return (Person) jdbc.queryForObject(sql, new Object[]{mobile}, new PersonRowMapper());
    }

    public void addPerson(Person person) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO person ( LAST_NAME, FIRST_NAME, MOBILE, BIRTHDAY, HOME_ID ) VALUES ('" + person.getLAST_NAME() +
                "','" + person.getFIRST_NAME() + "','" + person.getMOBILE() + "','" + format.format(person.getBIRTHDAY()) + "','" + person.getHOME_ID() + "')";
        jdbc.execute(sql);
    }

    public void updatePerson(Person person, int id) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "UPDATE person SET FIRST_NAME = '" + person.getLAST_NAME() +"', LAST_NAME = '" + person.getLAST_NAME() +
                "', MOBILE = '" + person.getMOBILE() + "', BIRTHDAY = '" + format.format(person.getBIRTHDAY()) + "', HOME_ID = '" +
                person.getHOME_ID() + "' WHERE ID = " + id;
        jdbc.execute(sql);
    }

    private void buildPersonList(List<Person> listToBuild, List<Map<String, Object>> results) {
        for (Map row : results) {
            Person person = new Person();
            person.setID((int) row.get("ID"));
            person.setFIRST_NAME((String) row.get("FIRST_NAME"));
            person.setLAST_NAME((String) row.get("LAST_NAME"));
            person.setMOBILE((String) row.get("MOBILE"));
            person.setBIRTHDAY((Date) row.get("BIRTHDAY"));
            person.setHOME_ID((short) row.get("HOME_ID"));
            listToBuild.add(person);
        }

    }


}