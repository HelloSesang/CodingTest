select s1.Score as score
     , (select count(distinct(s2.score))
          from Scores s2
         where s1.score <= s2.score) as Rank
  from Scores s1
 order by s1.Score desc