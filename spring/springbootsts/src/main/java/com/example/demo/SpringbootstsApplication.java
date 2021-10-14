package com.example.demo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringbootstsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstsApplication.class, args);
	}
}

@Component
class BookingCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public void run(String... args) throws Exception {
		this.bookingRepository.findAll().stream()
		    .forEach(System.out::println);
	}
}

@RestController
class BookingRestController{
	@Autowired
	BookingRepository bookingRepository;
	
	@RequestMapping("/bookings")
	Collection<Booking> bookings(){
		return bookingRepository.findAll();
	}
}

interface BookingRepository extends JpaRepository<Booking, Long>{
	Collection<Booking> findByBookingName(String bookingName);
}

@Entity
class Booking {
	@Id
	@GeneratedValue
	private int id;
	private String bookingName;
	
	public Booking(String bookingName) {
		super();
		this.bookingName = bookingName;
	}

	public Booking() {
	}

	public int getId() {
		return id;
	}

	public String getBookingName() {
		return bookingName;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingName=" + bookingName + "]";
	}
}
