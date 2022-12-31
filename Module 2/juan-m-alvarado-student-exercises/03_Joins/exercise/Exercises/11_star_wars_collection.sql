-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent to earliest (9 rows)

--select title from movie as m full join collection as c on c.collection_id = m.collection_id
--join movie_actor as ma on ma.movie_id = m.movie_id
--where title = 'The Empire Strikes Back' or title like '%Star Wars%' group by title order by title;

SELECT title
FROM movie
JOIN collection on collection.collection_id = movie.collection_id
WHERE collection_name LIKE 'Star Wars Collection'
ORDER BY release_date DESC;


