package com.example.product;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CertifiacteController 
{
	@Autowired
	private CertificateService service;
	// RESTful API methods for Retrieval operations
	@GetMapping("/certificates")
	public List<CertificateEntity> list()
	{
	return service.listAll();
	}
	@GetMapping("/certificates/{id}")
	public ResponseEntity<CertificateEntity> get(@PathVariable Integer id)
	{
	try
	{
		CertificateEntity ct = service.get(id);
	return new ResponseEntity<CertificateEntity>(ct, HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
	return new ResponseEntity<CertificateEntity>(HttpStatus.NOT_FOUND);
	}
	}
	// RESTful API method for Create operation
	@PostMapping("/certificates")
	public void add(@RequestBody CertificateEntity ct)
	{
	service.save(ct);
	}
	// RESTful API method for Update operation
	@PutMapping("/certificates/{id}")
	public ResponseEntity<?> update(@RequestBody CertificateEntity ct, @PathVariable Integer id)
	{
	try
	{
		CertificateEntity existCertificate = service.get(id);
		service.save(ct);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	// RESTful API method for Delete operation
	@DeleteMapping("/certificates/{id}")
	public void delete(@PathVariable Integer id)
	{
	service.delete(id);
	}
}
