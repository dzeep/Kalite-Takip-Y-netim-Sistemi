package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BranchService extends HelperService<Branch>{
    List<Branch> getBranchList();
    Optional<Branch> getBranchById(Long id);
    /*String createBranch(Branch branch);
    String updateBranch(Long id, Branch branch);
    String deleteBranch(Long id);*/

    List<Branch>FindByCompanyid(@Param("company_id") Long company_id);

}
