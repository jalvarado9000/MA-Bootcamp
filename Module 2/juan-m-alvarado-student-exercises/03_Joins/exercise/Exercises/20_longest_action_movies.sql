-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre.
--Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)
select title, length_minutes, release_date
from movie as m
join movie_genre as mg on m.movie_id = mg.movie_id
join genre as g on mg.genre_id = g.genre_id
where genre_name = 'Action' order by length_minutes desc, m.release_date desc limit 5;



