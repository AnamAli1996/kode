package com.finalyearproject.kode.ServiceImp;

import com.finalyearproject.kode.DAOs.StudentDAO;
import com.finalyearproject.kode.Entity.Student;
import com.finalyearproject.kode.Repository.StudentRepository;
import com.finalyearproject.kode.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.transaction.Transactional;


@Service("StudentService")
@Transactional
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public Student loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(email);
        if(student == null){
            throw new UsernameNotFoundException(email);
        }

        return new Student(student.getFirstName(), student.getLastName(), student.getEmail(), student.getPassword(), student.getAge());
    }
}
