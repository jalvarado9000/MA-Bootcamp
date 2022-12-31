-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)

SELECT birthday,person_name FROM movie_actor as ma
left join person as p on ma.actor_id = p.person_id
left join movie as m on  ma.movie_id = m.movie_id
where p.birthday > '1-1-1950' and p.birthday < '12-31-1959'
and m.release_date > '1-1-1985' and  m.release_date < '12-31-1985' group by person_name,birthday;