package com.team1.cinemaGo.run;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.team1.cinemaGo.model.Cinema;
import com.team1.cinemaGo.model.Client;
import com.team1.cinemaGo.model.Movie;
import com.team1.cinemaGo.model.Order;
import com.team1.cinemaGo.model.OrderItem;
import com.team1.cinemaGo.model.Schedule;
import com.team1.cinemaGo.model.Session;

public class MainClass {

	public static void main(String[] args) throws ParseException {		
		
		
		/*** SESSIONS CONTROL ***/
		System.out.println("\n\n*** SESSIONS ***\n");
		
		Cinema cinema1 = new Cinema();
		Cinema cinema2 = new Cinema();
		
		cinema1.setCinemaName("Cinema1");
		cinema1.setRowsCount(8);
		cinema1.setColumnsCount(12);
		
		cinema2.setCinemaName("Cinema2");
		cinema2.setRowsCount(10);
		cinema2.setColumnsCount(10);

		Movie movie1 = new Movie();
		Movie movie2 = new Movie();
				
		movie1.setMovieTitle("El espíritu de la colmena");
		movie1.setDescription("A sensitive seven-year-old girl living in 1940 in a small Spanish village is traumatized after viewing the movie 'Frankenstein' and drifts into her own fantasy world.");
		movie1.setDuration(Duration.ofMinutes(97));

		movie2.setMovieTitle("El verdugo");
		movie2.setDescription("An undertaker gets married to an old executioner's daughter and, although he doesn't like it, must continue the profession of his father-in-law after his retirement");
		movie2.setDuration(Duration.ofMinutes(87));

		
		List<Movie> movies = new ArrayList<Movie>(); 

		movies.add(movie1);
		movies.add(movie2);
		
		Session s1 = new Session();
		Session s2 = new Session();
		Session s3 = new Session();
		Session s4 = new Session();
		Session s5 = new Session();

		
		DateTimeFormatter dateTimeStamp = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm");
		
		s1.setCinema(cinema2);
		s1.setMovie(movie1);
		s1.setStartTime(LocalDateTime.parse("15.12.2014 12:00", dateTimeStamp));
		
		s2.setCinema(cinema2);
		s2.setMovie(movie2);
		s2.setStartTime(LocalDateTime.parse("30.11.2014 22:30", dateTimeStamp));

		s3.setCinema(cinema1);
		s3.setMovie(movie2);
		s3.setStartTime(LocalDateTime.parse("01.12.2014 21:00", dateTimeStamp));

		s4.setCinema(cinema2);
		s4.setMovie(movie2);
		s4.setStartTime(LocalDateTime.parse("15.12.2014 08:30", dateTimeStamp));

		s5.setCinema(cinema2);
		s5.setMovie(movie1);
		s5.setStartTime(LocalDateTime.parse("15.12.2014 14:07", dateTimeStamp));

		
		Schedule schedule = new Schedule();
		schedule.add(s1);
		schedule.add(s2);
		schedule.add(s3);
		schedule.add(s4);
		
		schedule.set(0, s5);
		
		schedule.sort();
		System.out.println("\nSorted schedule list:");		
		schedule.getSessions().stream().forEach(s -> System.out.println(s));
		
		System.out.println("\nUpcomming movies:");		
		schedule.getActiveSessions().stream().forEach(s -> System.out.println(s));
		
		/*** SALES ***/
		System.out.println("\n\n*** SALES ***\n");
		
		Client client1 = new Client(); 
		client1.setEmail("client@client.com");
		client1.setName("Jane");
		
		List<OrderItem> orderedItems = new ArrayList<OrderItem>();
		
		OrderItem os1  = new OrderItem();
		OrderItem os2  = new OrderItem();
		
		os1.setSession(schedule.getSessions().get(0));
		os1.setSeats(new HashSet<Integer>(Arrays.asList(1, 2, 23)));
		os2.setSession(schedule.getSessions().get(1));
		os2.setSeats(new HashSet<Integer>(Arrays.asList(1, 2, 23)));
		
		orderedItems.add(os1);
		orderedItems.add(os2);
		
		Order order1 = new Order();
		order1.setClient(client1);
		order1.setItems(orderedItems);
		order1.setOrderDate(LocalDateTime.now());
		
		System.out.println(order1.toString());
	
		
	}

}
