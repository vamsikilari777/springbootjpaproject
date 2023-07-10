package com.swachksheer.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.swachksheer.springboot.entity.Teacher;
import com.swachksheer.springboot.service.TeacherService;

@Controller
public class TeacherController {
	
	
		
		@Autowired
		private TeacherService teacherService;
		
		@GetMapping("/teachers")
		public String getAllStudent(Model model) {
			
			model.addAttribute("teachers",teacherService.getAllStudent());
			return "teacher";
		}
		
		@GetMapping("/addNewTeacher")
		public String addNewStudent(Model model)
		{
			Teacher teacher =new Teacher();
			 model.addAttribute("teacher",teacher);
			return "addTeacher";
		}
		
		@PostMapping("/addTeacher")
		public String saveStudent(@ModelAttribute("teacher") Teacher teacher)
		{
			teacherService.saveStudent(teacher);
			return "redirect:/teachers";
		}
		
		@GetMapping("/teacher/edit/{id}")
		public String editStudent(@PathVariable Long id, Model model)
		{
			model.addAttribute("teacher",teacherService.findById(id));
			return "edit_Teacher";
		}
		
		@PostMapping("/teachers/{id}")
		public String updateStudent(@PathVariable Long id,@ModelAttribute("teacher") Teacher teacher, Model model) {
			
			//get student from database by id
			Teacher existingteacher = teacherService.findById(id);
			existingteacher.setFirstname(teacher.getFirstname());
			existingteacher.setLastname(teacher.getLastname());
			existingteacher.setEmail(teacher.getEmail());
			
			//save updated student
			
			teacherService.updateById(existingteacher);
			return "redirect:/teachers";
		}
		
		@GetMapping("/teacher/delete/{id}")
		public String deleteStudentById(@PathVariable Long id)
		{
			
					teacherService.deleteById(id);
					return "redirect:/teachers";
					
		}


}
