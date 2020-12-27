select s1.id
     , case when s1.id % 2 = 1 and
       (select count(*)
        from seat s3
        where s1.id + 1 = s3.id) = 0
    then s1.student
            when s1.id % 2 = 1
            then (select s2.student
                    from seat s2
                   where s1.id + 1 = s2.id)
            else (select s2.student
                    from seat s2
                   where s1.id - 1 = s2.id)
end as student
  from seat s1