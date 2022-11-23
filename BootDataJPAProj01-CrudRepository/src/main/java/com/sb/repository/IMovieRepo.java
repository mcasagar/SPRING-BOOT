package com.sb.repository;

import org.springframework.data.repository.CrudRepository;

import com.sb.entity.Movie;

public interface IMovieRepo extends CrudRepository<Movie, Integer> {
	
}
