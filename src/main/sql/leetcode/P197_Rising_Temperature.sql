select w1.id as Id
  from Weather w1
 inner join Weather w2
    on w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
 where w1.Temperature > w2.Temperature