package com.example.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="certificates")
public class CertificateEntity
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer year;

    public CertificateEntity() {
        // Default constructor
    }

    public CertificateEntity(Integer id, Integer year) {
        this.id = id;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CertificateEntity{" +
                "id=" + id +
                ", year=" + year +
                '}';
    }
}
//org.hibernate.InstantiationException: No default constructor for entity 'com.example.product.CertificateEntity'