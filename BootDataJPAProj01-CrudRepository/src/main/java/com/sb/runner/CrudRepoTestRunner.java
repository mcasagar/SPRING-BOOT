package com.sb.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sb.service.IMovieMgmtService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 * //invoke service method Movie movie = new Movie(); movie.setMname("RRR");
		 * movie.setRating(4.5f); movie.setYear("2022"); try {
		 * System.out.println(service.registerMovie(movie)); }catch(Exception e) {
		 * e.printStackTrace(); }
		 */
		
		/*
		 * try { System.out.println("Record Counts :: "+service.fetchMoviesCount());
		 * }catch(Exception e ) { e.printStackTrace(); }
		 */
		
		/*
		 * System.out.println("----------for findAll() methods--------"); try {
		 * Iterable<Movie> list = service.fetchAllMovies(); for(Movie movie : list) {
		 * //enhanced for loop System.out.println(movie); }//for
		 * System.out.println("--------------------"); list.forEach(movie ->
		 * System.out.println(movie)); //forEach method()
		 * 
		 * System.out.println("---------------------");
		 * list.forEach(System.out::println); //forEach Method + static method Reference
		 * 
		 * System.out.println("---------------------");
		 * Arrays.asList(list).stream().forEach(System.out::println); //forEach method()
		 * + streamingApi + static method reference
		 * 
		 * }//try catch(Exception e) { e.printStackTrace(); }
		 */
		
		System.out.println("-----For findAllById method()-------------");
		/*
		 * try { List<Integer> idsList = new ArrayList(); idsList.add(181);
		 * System.out.println("Movies are :: "+service.fetchAllMoviesByIds(idsList));
		 * System.out.println("------------------------------------------");
		 * System.out.println("Movies are :: "+service.fetchAllMoviesByIds(List.of(181,1
		 * ))); //from java 9
		 * System.out.println("------------------------------------------");
		 * System.out.println("Movies are :: "+service.fetchAllMoviesByIds(Arrays.asList
		 * (181,1))); }//try catch(Exception e) { e.printStackTrace(); }
		 */
		
		try {
			System.out.println("181 Movie  is :: "+service.fetchMovieById(181));
		}//try
		catch(Exception e ) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
