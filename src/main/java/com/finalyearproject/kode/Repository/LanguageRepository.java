package com.finalyearproject.kode.Repository;

import com.finalyearproject.kode.Entity.Course;
import com.finalyearproject.kode.Entity.Language;
import com.finalyearproject.kode.Entity.Level;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    public Language findByLanguageDescription(String description);
}
