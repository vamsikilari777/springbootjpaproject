package com.swachksheer.springboot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swachksheer.springboot.entity.Student;
import com.swachksheer.springboot.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}
	
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		
	}

	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}
	public Student updateById(Student student) {
		
		return studentRepository.save(student);
		
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

}
