-- 6. The genres of "The Wizard of Oz" (3 rows)
select genre.genre_name from movie join movie_genre on movie.movie_id = movie_genre.movie_id
join genre on genre.genre_id = movie_genre.genre_id where title = 'The Wizard of Oz';



