package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Department;
import com.mergen.vtys.vtysdatabaseap.Model.Title;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TitleService  extends HelperService<Title> {
    List<Title> getTitleList();
    Optional<Title> getTitleByID(Long id);
    List<Optional<Title>> getDepartmentId(@Param("department_id") Long department_id);

}
