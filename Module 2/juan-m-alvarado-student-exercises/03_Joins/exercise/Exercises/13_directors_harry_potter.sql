-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)
SELECT p.person_name
FROM movie
JOIN person as p on movie.director_id = p.person_id
JOIN collection on collection.collection_id = movie.collection_id
WHERE collection_name LIKE 'Harry Potter Collection' group by p.person_name;
