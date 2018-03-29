package com.finalyearproject.kode.Service;

import com.finalyearproject.kode.Entity.Student;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface StudentService {

   public Student loadUserByUsername(String email) throws UsernameNotFoundException;

}
