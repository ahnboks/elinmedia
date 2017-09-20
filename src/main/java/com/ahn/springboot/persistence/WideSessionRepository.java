package com.ahn.springboot.persistence;

import com.ahn.springboot.domain.WideSession;
import org.springframework.data.repository.CrudRepository;

public interface WideSessionRepository extends CrudRepository<WideSession,String >{
}
