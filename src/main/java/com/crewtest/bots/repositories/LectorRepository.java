package com.crewtest.bots.repositories;

import com.crewtest.bots.entities.LectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<LectorEntity, Integer> {

    @Query("SELECT l FROM LectorEntity l WHERE l.name LIKE %:searchField%")
    List<LectorEntity> findLectorEntitiesWhereNameOrSurnameLike(@Param("searchField") String searchField);

}
