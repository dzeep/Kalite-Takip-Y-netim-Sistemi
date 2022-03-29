package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {
  @Query(value ="select * from public.department u Where u.branch_id=?",nativeQuery = true)
  List<Optional<Department>> getBranchId(@Param("branch_id") Long branch_id);
}
