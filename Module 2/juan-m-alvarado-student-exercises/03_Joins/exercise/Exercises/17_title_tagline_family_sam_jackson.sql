-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)
select title, tagline from movie as m join movie_actor as ma
on m.movie_id = ma.movie_id
join person as p on p.person_id = ma.actor_id
join movie_genre as mg on mg.movie_id = m.movie_id
join genre as g on mg.genre_id = g.genre_id
where g.genre_name = 'Family'
and p.person_name = 'Samuel L. Jackson';



