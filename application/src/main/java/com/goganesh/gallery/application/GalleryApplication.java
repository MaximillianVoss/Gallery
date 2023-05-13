package com.goganesh.gallery.application;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
@SpringBootApplication
@AllArgsConstructor
public class GalleryApplication {


	public static void main(String[] args) {
		SpringApplication.run(GalleryApplication.class, args);
	}

	@PostConstruct
	private void postConstruct() {
	}

}
