select a.customer_number
  from Orders a
 group by a.customer_number
 order by count(*) desc
 limit 1;