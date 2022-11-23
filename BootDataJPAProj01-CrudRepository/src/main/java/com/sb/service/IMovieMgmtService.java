package com.sb.service;

import java.util.List;
import java.util.Optional;

import com.sb.entity.Movie;

public interface IMovieMgmtService {
	public String registerMovie(Movie movie);
	public long fetchMoviesCount();
	public Iterable<Movie> fetchAllMovies();
	public Iterable<Movie> fetchAllMoviesByIds(List<Integer> mids);
	public Movie fetchMovieById(Integer mid);
}
