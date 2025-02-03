package in.vikas.entity.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.entity.Student;
import in.vikas.entity.repo.StudentRepo;

@RestController
public class StudentRestController {

	@Autowired
	private StudentRepo srepo;

	@GetMapping("/students")
	public Iterable<Student> getAllStudent() {
		return srepo.findAll();
	}

	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		srepo.save(student);
		return "Student Saved..!";
	}

	// we can perform all the needed CRUD operation here with Redis DB
}
