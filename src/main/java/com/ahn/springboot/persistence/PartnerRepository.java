package com.ahn.springboot.persistence;

import com.ahn.springboot.domain.Partner;
import org.springframework.data.repository.CrudRepository;

public interface PartnerRepository extends CrudRepository<Partner, Long> {
}
