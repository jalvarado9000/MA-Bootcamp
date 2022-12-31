-- 3. For all actors with the last name of "Jones", display the actor's name
--and movie titles they appeared in. Order the results by the actor names (A-Z). (48 rows)

select person.person_name, movie.title from person join movie_actor
on person.person_id = movie_actor.actor_id join movie
on movie.movie_id = movie_actor.movie_id where person_name like '% Jones'
 order by person_name;

--The error is: that it does give you the last name Jones but there are 50 instead of 48 rows