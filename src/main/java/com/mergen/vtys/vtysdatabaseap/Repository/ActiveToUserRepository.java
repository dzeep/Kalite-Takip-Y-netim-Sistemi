package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActiveToUserRepository extends CrudRepository<ActiveToUser, Long> {
    @Query(value = "SELECT a.id, a.name, a.place, a.datetime, a.organizator FROM activity a WHERE a.id in (SELECT activetouser.activity_ids FROM activetouser Where activetouser.user_ids= ?1) ",nativeQuery = true)
    List<Object> getUsersEnrolled(Long id);
    @Query(value = "SELECT activetouser.activity_ids,activity.name,activity.place,activity.datetime FROM activetouser LEFT JOIN activity ON activity.id = activetouser.activity_ids Where user_ids= ?1 ",nativeQuery = true)
    List<Long> getUsersEnrolledIDs(Long id);
}
