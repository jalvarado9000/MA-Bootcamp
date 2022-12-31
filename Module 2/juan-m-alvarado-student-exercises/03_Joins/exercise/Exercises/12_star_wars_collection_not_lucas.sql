-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)

--select title from movie as m join collection as c on m.collection_id = m.collection_id
--join person as p on m.director_id = person_id
--where person_name <> 'George Lucas' and title = 'The Empire Strikes Back' group by title;

SELECT title
FROM movie
JOIN collection on collection.collection_id = movie.collection_id
join person as p on movie.director_id = p.person_id
WHERE collection_name LIKE 'Star Wars Collection' and person_name <> 'George Lucas';

