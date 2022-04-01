package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserMRepository extends JpaRepository<UserM,Long> {
    @Query(value = "SELECT * from public.user_m Where name = ?1", nativeQuery = true)
    Optional<UserM> findByName(String name);
    @Query(value = "SELECT * from public.user_m u Where u.name = ?1 and u.password = ?2", nativeQuery = true)
    Optional<UserM> findNameAndPassword(String name, String password);
    @Query(value = "SELECT * from public.user_m u Where u.email = ?1 and u.password = ?2", nativeQuery = true)
    Optional<UserM> findEmailAndPassword(String email,String password);
    @Query(value = "SELECT * from public.user_m u Where u.email = ?1 and u.name = ?2", nativeQuery = true)
    Optional<UserM> findEmailAndName(String email,String name);

}
