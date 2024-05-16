package com.example.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CertificateService 
{
	@Autowired
	private CertificateRepository repo;
	
	public List<CertificateEntity> listAll()
	{
	return repo.findAll();
	}
	public void save(CertificateEntity ct)
	{
	repo.save(ct);
	}
	public CertificateEntity get(Integer id)
	{
	return repo.findById(id).get();
	}
	public void delete(Integer id)
	{
	repo.deleteById(id);
	}
}
