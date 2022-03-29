package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.Activity;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
   @Query(value = "SELECT * from public.activity u Where u.name = ?1", nativeQuery = true)
   Optional<Activity> findByName(String name);
//   @Query(" Select a from Activity a inner join ActiveToUser k on a.id=k.activity.id  ")
//  List<Activity>  findActivitiesByUserID(@Param("userId") Long userID);
//  // SELECT a FROM Activity a left JOIN ActiveToUser on a.id=ActiveToUser.activity.id where ActiveToUser.userID =:userId
}
