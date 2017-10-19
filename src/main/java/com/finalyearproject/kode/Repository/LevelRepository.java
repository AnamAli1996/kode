package com.finalyearproject.kode.Repository;
import com.finalyearproject.kode.Entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LevelRepository extends JpaRepository<Level, Long> {

   public Level findByLevelDescription(String description);

}
