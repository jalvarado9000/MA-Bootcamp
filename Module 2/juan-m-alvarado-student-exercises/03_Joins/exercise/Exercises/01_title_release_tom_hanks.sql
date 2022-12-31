-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)

select movie.title, movie.release_date from movie join movie_actor on movie.movie_id = movie_actor.movie_id
join person on person.person_id = movie_actor.actor_id where person.person_name = 'Tom Hanks';
