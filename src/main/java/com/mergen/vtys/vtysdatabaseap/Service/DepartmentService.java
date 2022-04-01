package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.DepartmentDto;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DepartmentService extends HelperService<DepartmentDto>{
    List<DepartmentDto> getDepartmentList();
    DepartmentDto getDepartmentByID(Long id);
    List<DepartmentDto> getDepartmentsByBranchId(@Param("branch_id") Long branch_id);
}
