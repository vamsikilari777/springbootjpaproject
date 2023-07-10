package com.swachksheer.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swachksheer.springboot.entity.Teacher;

import com.swachksheer.springboot.repository.TeacherRepository;
@Service
public class TeacherService
{
	

		
		@Autowired
		private TeacherRepository teacherRepository;
		
		public List<Teacher> getAllStudent() {
			
			return teacherRepository.findAll();
		}
		
		public void saveStudent(Teacher teacher) {
			// TODO Auto-generated method stub
			teacherRepository.save(teacher);
			
		}

		public Teacher findById(Long id) {
			// TODO Auto-generated method stub
			return teacherRepository.findById(id).get();
		}
		public Teacher updateById(Teacher teacher) {
			
			return teacherRepository.save(teacher);
			
		}

		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			teacherRepository.deleteById(id);
		}

	


}
