-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
select person.person_name,person.birthday from person join movie_actor on movie_actor.actor_id = person.person_id
join movie on movie_actor.movie_id = movie.movie_id
where title = 'The Fifth Element';


