-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
select movie.title, person.person_name
from movie
join movie_actor on movie_actor.movie_id = movie.movie_id
join person on person.person_id = movie_actor.actor_id
where movie.director_id = movie_actor.actor_id;
