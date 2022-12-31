-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
-- Hint: DISTINCT will prevent duplicate values in your query results.
select distinct g.genre_name from genre as g join movie_genre as gm
on g.genre_id = gm.genre_id join movie as m on m.movie_id = gm.movie_id
join movie_actor as ma on ma.movie_id = m.movie_id
join person as p on p.person_id = ma.actor_id where person_name = 'Christopher Lloyd';
