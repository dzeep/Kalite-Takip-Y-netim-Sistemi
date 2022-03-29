package com.mergen.vtys.vtysdatabaseap.Repository;
import com.mergen.vtys.vtysdatabaseap.Model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TitleRepository extends JpaRepository<Title,Long> {
    @Query(value ="select * from public.title u Where u.department_id=?",nativeQuery = true)
    List<Optional<Title>> getDepartmentId(@Param("department_id") Long department_id);
}
