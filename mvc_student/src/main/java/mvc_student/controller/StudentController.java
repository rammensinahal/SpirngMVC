package mvc_student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvc_student.dao.StudentDao;
import mvc_student.dto.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;
	ModelAndView m=new ModelAndView();
	@RequestMapping("/register")
	public ModelAndView register() {
		m.addObject("std",new Student());
		m.setViewName("register.jsp");
		return m;
	}
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute Student student) {
		dao.savestudent(student);
		List<Student> list=dao.getall();
		m.addObject("list",list);
		m.setViewName("disply.jsp");
		return m;

	}
	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute Student student) {
		dao.updateStudent(student);
		List<Student> list=dao.getall();
		m.addObject("list",list);
		m.setViewName("disply.jsp");
		return m;

	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id ) {
		boolean b=dao.deleteStudent(id);
		if(b) {
			List<Student> list=dao.getall();
			m.addObject("list",list);
			m.setViewName("disply.jsp");
		}else {
			m.setViewName("register.jsp");
		}
		return m;
	}
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam int id) {
		Student s=dao.getbyid(id);
		m.addObject("s",s);
		m.setViewName("edit.jsp");
		return m;
	}

}
