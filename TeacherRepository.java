package com.swachksheer.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swachksheer.springboot.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
