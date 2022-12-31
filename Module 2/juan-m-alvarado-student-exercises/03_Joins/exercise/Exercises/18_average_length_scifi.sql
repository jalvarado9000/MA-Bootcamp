-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result around 110-120)
select avg(length_minutes) as average_length
from movie as m
join movie_genre as mg on mg.movie_id = m.movie_id
join genre as g on mg.genre_id = g.genre_id
where g.genre_name = 'Science Fiction';



