package com.hrms.hroperatiion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hroperatiion.entity.JobPostEntity;
import com.hrms.hroperatiion.service.JobPostService;

@RestController
@RequestMapping("/job")
public class PostingController {

	@Autowired
	private JobPostService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@Valid @RequestBody JobPostEntity entity) {

		service.saveJobPost(entity);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<JobPostEntity> getJobList() {
		return service.getJobPost();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public JobPostEntity getJobPostById(@PathVariable("id") Integer id) {
		return service.getJobPostById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}
