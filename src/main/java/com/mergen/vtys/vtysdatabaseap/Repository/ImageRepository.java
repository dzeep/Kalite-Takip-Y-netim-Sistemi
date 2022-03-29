package com.mergen.vtys.vtysdatabaseap.Repository;

import java.util.Optional;

import com.mergen.vtys.vtysdatabaseap.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
}
