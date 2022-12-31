-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).
select genre_name, count(title) as num_of_movies
from movie as m
join movie_genre as mg on mg.movie_id = m.movie_id
join genre as g on mg.genre_id = g.genre_id
group by genre_name;
