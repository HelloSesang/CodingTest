SELECT c.Name AS Customers
  FROM Customers c
 WHERE NOT exists(SELECT *
                    FROM Orders o
                   WHERE c.Id = o.CustomerId)