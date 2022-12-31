-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
select genre_name from person as p join movie_actor as ac on p.person_id = ac.actor_id
join movie as m on ac.movie_id = m.movie_id join movie_genre as mg on m.movie_id = mg.movie_id
join genre as g on mg.genre_id = g.genre_id where person_name = 'Robert De Niro'
and release_date > '1-1-2010' group by genre_name;



