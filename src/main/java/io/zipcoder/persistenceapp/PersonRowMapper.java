package io.zipcoder.persistenceapp;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
//Spring uses the row mapper to populate the java bean:
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setID(resultSet.getInt("ID"));
        person.setFIRST_NAME(resultSet.getString("FIRST_NAME"));
        person.setLAST_NAME(resultSet.getString("LAST_NAME"));
        person.setMOBILE(resultSet.getString("MOBILE"));
        person.setBIRTHDAY(resultSet.getDate("BIRTHDAY"));
        person.setHOME_ID(resultSet.getInt("HOME_ID"));

        return person;

    }
}