package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserMRepository extends JpaRepository<UserM,Long> {
    Optional<UserM> findByUsername(String username);
    @Query(value = "SELECT * from public.user_m Where username = ?1", nativeQuery = true)
    Optional<UserM> findByName(String name);

}
