package com.ahn.springboot.persistence;

import com.ahn.springboot.domain.WideAdmin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WideAdminRepository extends CrudRepository<WideAdmin, Long> {
    @Query(value="select * from tb_wide_admin where wide_admin_email=?1",nativeQuery = true)
    List<WideAdmin> findByWide_admin_email(String wide_admin_email);
}

