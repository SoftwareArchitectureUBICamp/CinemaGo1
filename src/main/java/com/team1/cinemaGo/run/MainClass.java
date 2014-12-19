package com.team1.cinemaGo.run;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.team1.cinemaGo.model.Cinema;
import com.team1.cinemaGo.model.Client;
import com.team1.cinemaGo.model.Movie;
import com.team1.cinemaGo.model.MovieSession;
import com.team1.cinemaGo.model.Order;
import com.team1.cinemaGo.model.OrderItem;
import com.team1.cinemaGo.model.Schedule;
import com.team1.cinemaGo.model.Seat;
import com.team1.cinemaGo.model.SessionType;

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
		movie1.setDuration(97);

		movie2.setMovieTitle("El verdugo");
		movie2.setDescription("An undertaker gets married to an old executioner's daughter and, although he doesn't like it, must continue the profession of his father-in-law after his retirement");
		movie2.setDuration(87);

		List<Movie> movies = new ArrayList<Movie>(); 

		movies.add(movie1);
		movies.add(movie2);
		
		
		SessionType sessType = new SessionType();
		
		
		MovieSession s1 = new MovieSession();
		MovieSession s2 = new MovieSession();
		MovieSession s3 = new MovieSession();
		MovieSession s4 = new MovieSession();
		MovieSession s5 = new MovieSession();
		
		DateTimeFormatter dateTimeStamp = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
		
		s1.setCinema(cinema2);
		s1.setMovie(movie1);
		s1.setSessionType(sessType);
		s1.setStartTime(LocalDateTime.parse("2014-12-15 12:00", dateTimeStamp));
		
		s2.setCinema(cinema2);
		s2.setMovie(movie2);
		s2.setSessionType(sessType);
		s2.setStartTime(LocalDateTime.parse("2014-11-30 22:30", dateTimeStamp));

		s3.setCinema(cinema1);
		s3.setMovie(movie2);
		s3.setSessionType(sessType);
		s3.setStartTime(LocalDateTime.parse("2014-12-01 21:00", dateTimeStamp));

		s4.setCinema(cinema2);
		s4.setMovie(movie2);
		s4.setStartTime(LocalDateTime.parse("2014-12-15 08:30", dateTimeStamp));

		s5.setCinema(cinema2);
		s5.setMovie(movie1);
		s5.setStartTime(LocalDateTime.parse("2014-12-15 14:07", dateTimeStamp));

		
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
		
		
		
		/*** WORKING WITH DB ***/
		System.out.println("\n\n*** SAVE TO AND READ FROM DB ***\n");
	
		
		Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());	       
        org.hibernate.Session session = factory.openSession();
        session.beginTransaction();
        
        session.persist(cinema1);
        session.persist(cinema2);
        
        session.persist(movie1);
        session.persist(movie2);
        
        session.persist(sessType);
        
        Set<Seat> seats = new HashSet<Seat>();       
        seats.add(new Seat(1, 1));
        seats.add(new Seat(4, 1));
        seats.add(new Seat(5, 1));

        
        s1.setOccupiedSeats(seats);
        s2.addOccupiedSeat(new Seat(5, 5));
        s2.getOccupiedSeats().add(new Seat(s2, 1,16));
        
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);
        session.persist(s4);
        session.persist(s5);
                        
        session.getTransaction().commit();        
        

        session.beginTransaction();
        @SuppressWarnings("unchecked")
		List<com.team1.cinemaGo.model.MovieSession> ses = (List<com.team1.cinemaGo.model.MovieSession>) session.createCriteria(com.team1.cinemaGo.model.MovieSession.class).list();
        session.getTransaction().commit();
        session.close();

		System.out.println("\n\n*** SESSIONS LIST FROM DB ***\n");
        for (com.team1.cinemaGo.model.MovieSession s : ses){
        	System.out.println(s.toString());	
        }
        
        
        System.exit(0);
        
        
	}

}
