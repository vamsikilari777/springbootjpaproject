package com.swachksheer.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.swachksheer.springboot.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.swachksheer.springboot.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		
		model.addAttribute("students",studentService.getAllStudent());
		return "student";
	}
	
	@GetMapping("/addNewStudent")
	public String addNewStudent(Model model)
	{
		Student student =new Student();
		 model.addAttribute("student",student);
		return "addStudent";
	}
	
	@PostMapping("/addStudents")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/student/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model)
	{
		model.addAttribute("student",studentService.findById(id));
		return "edit_Student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student, Model model) {
		
		//get student from database by id
		Student existingstudent = studentService.findById(id);
		existingstudent.setFirstname(student.getFirstname());
		existingstudent.setLastname(student.getLastname());
		existingstudent.setEmail(student.getEmail());
		
		//save updated student
		
		studentService.updateById(existingstudent);
		return "redirect:/students";
	}
	
	@GetMapping("/student/delete/{id}")
	public String deleteStudentById(@PathVariable Long id)
	{
		
				studentService.deleteById(id);
				return "redirect:/students";
				
	}

}
