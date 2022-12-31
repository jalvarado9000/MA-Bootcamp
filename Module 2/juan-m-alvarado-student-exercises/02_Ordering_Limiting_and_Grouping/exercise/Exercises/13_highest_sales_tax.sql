-- 13. The state (or territory) name and sales tax for the top five highest sales of tax of all states and territories. 
-- Order the results by sales tax with the highest number first, then by state name alphabetically.
-- (5 rows)

select state_name, sales_tax from state
where census_region is null or census_region
IN ('Northeast', 'South', 'Midwest', 'West')
order by  sales_tax DESC limit 5;
