CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE idx int;

  select N - 1
    into idx;

  RETURN (
      # Write your MySQL query statement below.
      select distinct a.salary
        from Employee a
       order by a.salary
       limit idx, 1
  );
END