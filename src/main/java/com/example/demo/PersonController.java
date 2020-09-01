package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	private userMongoRepository bank;
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@PostMapping("/add")
	public String addAccount(@RequestBody Person user) {
		bank.save(user);
		return "Added Book "+user.getName();
	}
	@GetMapping("/findall")
	public List<Person> getAll(){
		return bank.findAll();
	}
	@GetMapping("getOne/{id}")
	public Optional<Person> getAccount(@PathVariable int id){
		return bank.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteAccount(@PathVariable int id) {
		bank.deleteById(id);
		return "User deleted "+ id;
	}
	@PutMapping("/{id}")
	public String update(@PathVariable int id,@RequestBody Person user) {
		Optional<Person> new_user =bank.findById(id);
		new_user.get().setName(user.getName());
		new_user.get().setBalance(user.getBalance());
		bank.save(new_user.get());
		return "User updated "+ id;
	}
}
