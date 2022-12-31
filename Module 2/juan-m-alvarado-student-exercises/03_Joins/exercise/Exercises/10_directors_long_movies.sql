-- 10. The names of directors who have directed a movie over 3 hours [180 minutes] (15 rows)

select person_name from movie as m join person as p on director_id = person_id
join movie_actor as ma on ma.movie_id = m.movie_id
where length_minutes > 180 group by person_name order by person_name;