package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Department;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface DepartmentService extends HelperService<Department>{
   List<Department> getDepartmentList();
   Optional<Department> getDepartmentByID(Long id);
  List<Optional<Department>> getBranchId(@Param("branch_id") Long branch_id);
}
