package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.BranchDto;
import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BranchService extends HelperService<BranchDto>{
    List<BranchDto> getBranchList();
    BranchDto getBranchById(Long id);
    List<BranchDto>FindByCompanyid(@Param("company_id") Long company_id);

}
