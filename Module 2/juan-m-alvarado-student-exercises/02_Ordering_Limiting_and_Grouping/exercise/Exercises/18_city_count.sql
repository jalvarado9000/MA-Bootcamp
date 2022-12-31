-- 18. The count of the number of cities (name column 'num_cities') and the state abbreviation for each state and territory (exclude state abbreviation DC).
-- Order the results by state abbreviation.
-- (55 rows)

select count(city_name) as num_cities, state_abbreviation from city where state_abbreviation <> 'DC' group by state_abbreviation order by state_abbreviation;

