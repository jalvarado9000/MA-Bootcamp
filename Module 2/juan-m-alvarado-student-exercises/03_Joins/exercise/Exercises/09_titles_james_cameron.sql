-- 9. The titles of movies directed by James Cameron (6 rows)
select title from movie as m join person as p on director_id = person_id
where person_name = 'James Cameron';

