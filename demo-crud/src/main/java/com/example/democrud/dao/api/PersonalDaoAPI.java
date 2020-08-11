package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;
import com.example.democrud.model.Personal;

public interface PersonalDaoAPI extends CrudRepository<Personal, Long> {

}
