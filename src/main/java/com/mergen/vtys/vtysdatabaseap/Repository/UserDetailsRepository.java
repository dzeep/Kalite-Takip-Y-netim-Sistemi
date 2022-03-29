package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    @Query(value = "select u.tc_no from public.userdetails u Where u.tc_no=?",nativeQuery = true)
 Optional<UserDetails>findTcNo(String tc_no);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM  UserDetails p WHERE p.tc_no = :tc_no")
    boolean existsByEmail(@Param("tc_no") String tc_no);

   @Query(value = "select * from public.userdetails u Where u.user_id=?",nativeQuery = true)
    Optional<UserDetails>FindByUserid(@Param("user_id") Long user_id);

}
