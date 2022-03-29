package com.mergen.vtys.vtysdatabaseap.Repository;
import com.mergen.vtys.vtysdatabaseap.Model.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRequestRepository extends JpaRepository<VacationRequest,Long> {
    @Query(value = "select date_of_start from public.userdetails u Where u.id=?",nativeQuery = true)
    String GetDate_of_Start(@Param("id") Long id);
}

