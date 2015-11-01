#Spring training

##**Time**:

8-16 hours

##**Expected result:**

show demonstration and provide code.

##**Task description:**

1. Create Spring application with the following services and logic using either XML or Annotation configuration.
2. Create domain objects as needed.
3. Create DAO classes for storing data in maps (later, they will be replaced for storing data in DB).

##_UserService_ - Manages registered users

 - register
 - remove
 - getById
 - getUserByEmail
 - getUsersByName

##_MovieService_ - Manages movies

 - createMovie - should create Movie with name, duration base price for tickets, rating (high, mid, low)
 - deleteMovie
 - getAllMovies
 - getMoviesByName 
 - getMoviesByRating

##_ShowingService_ - Manages movie events 

 - createShowing - should create Showing with movie, theatre (movie theatre), date of event
 - removeShowing
 - getAllShowing
 - getShowingsByMovie(Movie) - returns all showing events with this movie
 - getShowingByTheatre(Theatre) - returns all showing events with this movie theatre
 - getShowingByTheatreAndDate(Theatre theatre, Date from, Date to) - returns all showing events with this movie theatre 
 for particular date range
 - getShowingByTheatreAndDate(Theatre theatre, Date to) - same as getShowingByTheatreAndDate starting from now

##_TheatreService_ - Returns info about cinema theatres and places

Since auditorium information is usually static, store it in some property file. The information that needs to be stored is:

 - name
 - number of seats
 - number of vip seats 
 
Several auditoriums can be stored in separate property files, 
information from them could be injected into the TheatreService

 - getAllTheatres()
 - getById()

##_BookingService_ - Manages tickets, prices, bookings

 - bookTicket( showing,  user,  isVip) can throw HasNoTicketException;
 - getAllTickets();
 - getTicketsByUser( user );
 - getAvailableTickets( showing );
 - getAvailableVipTickets( showing );
 - getTicketsByShowing( showing );
 - getVipTicketsByShowing( showing );
 - getById(id)
 
##_DiscountService_ - Counts different discounts for purchased tickets

 - getDiscount(user, showing, date) - returns discount for each ticket for the user on particular event
 
##_DiscountStrategy_ - single class with logic for calculating discount

 - Birthday strategy - give 10% if user has birthday
 - Every 10th ticket - give 50% for every 10th ticket purchased by user

All discount strategies should be injected as list into the DiscountService. The getDiscount method will execute each strategy to get max available discount.
Define DiscountService with all strategies as separate beans in separate configuration file (either separate XML or separate Java config class)

#_AOP Task_

##_CounterAspect_ 

count how many times each Showing was accessed by name, 
how many times its tickets were booked. 
Store counters in map for now (later could be replaced by DB dao)

##_DiscountAspect_ 
count how many times each discount was given total and for specific user

##_LuckyWinnerAspect_ 
every time the bookTicket method is executed perform the checkLucky method for the user that based on some randomness 
will return true or false. 
If user is lucky, the ticketPrice changes to zero and ticket is booked,thus user pays nothing. 
Store the information about this lucky event into the user object (like some system messages or so) - OPTIONAL
