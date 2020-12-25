SELECT (CASE WHEN (SELECT COUNT(DISTINCT Salary)
                     FROM Employee) < 2 THEN NULL
             ELSE (SELECT Salary
                     FROM Employee
                    ORDER BY Salary DESC
                    LIMIT 1,1)
        END) AS SecondHighestSalary