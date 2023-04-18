select a.name
  from SalesPerson a
 where a.sales_id not in (select a.sales_id
                            from SalesPerson a
                           inner join  Orders b
                              on a.sales_id = b.sales_id
                           inner join Company c
                              on b.com_id = c.com_id
                           where c.name = 'RED');