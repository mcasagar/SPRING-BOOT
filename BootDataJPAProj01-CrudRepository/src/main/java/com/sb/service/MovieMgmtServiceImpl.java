package com.sb.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.entity.Movie;
import com.sb.repository.IMovieRepo;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	@Autowired //injects the dynamically proxy class objects
	private IMovieRepo movieRepo; // HAS-A property
	
	@Override
	public String registerMovie(Movie movie) {
		System.out.println("In Memory Proxy class name :: "+movieRepo.getClass()+"----------------"+Arrays.toString(movieRepo.getClass().getInterfaces()));
		//use repo
		System.out.println("befor saving :: "+movie);
		Movie movie1 = movieRepo.save(movie);
		System.out.println("after saving :: "+movie1);
		
		return "Movie is registered with the ID value :: "+movie1.getMid();
	}

	@Override
	public long fetchMoviesCount() {
		System.out.println("In Memory Proxy class name :: "+movieRepo.getClass()+"----------------"+Arrays.toString(movieRepo.getClass().getInterfaces()));
		return movieRepo.count();
	}

	@Override
	public Iterable<Movie> fetchAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public Iterable<Movie> fetchAllMoviesByIds(List<Integer> mids) {
		
		return movieRepo.findAllById(mids);
	}

	@Override
	public Movie fetchMovieById(Integer mid) {
		Optional<Movie> opt = movieRepo.findById(mid);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new IllegalArgumentException("Record Not found"); 
		}
		 
	}

}
