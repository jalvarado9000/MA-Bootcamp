-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection" (28 rows)
SELECT p.person_name
FROM person as p
JOIN movie_actor as ma on p.person_id = ma.actor_id
Join movie as m on m.movie_id = ma.movie_id
JOIN collection on collection.collection_id = m.collection_id
WHERE collection_name LIKE 'Back to the Future Collection' group by p.person_name;