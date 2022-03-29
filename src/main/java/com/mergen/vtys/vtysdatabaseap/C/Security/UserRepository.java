package com.mergen.vtys.vtysdatabaseap.C.Security;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * from public.user_m Where username = ?1", nativeQuery = true)
    Optional<User> findByName(String name);

//    @Query(value = "SELECT * from public.user_m u Where u.name = ?1 and u.password = ?2", nativeQuery = true)
//    Optional<User> findNameAndPassword(String name, String password);
//    @Query(value = "SELECT * from public.user u Where u.email = ?1 and u.password = ?2", nativeQuery = true)
//    Optional<User> findEmailAndPassword(String email,String password);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);
}

