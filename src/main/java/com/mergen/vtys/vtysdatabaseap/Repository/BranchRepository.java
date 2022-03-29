package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
    @Query(value = "select * from public.branch u Where u.company_id=?",nativeQuery = true)
    List<Branch> FindByCompanyid(@Param("company_id") Long company_id);

}

