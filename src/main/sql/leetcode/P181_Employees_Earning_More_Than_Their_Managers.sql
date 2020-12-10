select a.Name as Employee
  from (select e1.Name
             , e1.Salary
             , e2.Name as managerName
             , e2.Salary as managerSalary
          from Employee e1
          left join Employee e2
            on e1.ManagerId = e2.Id) a
 where a.Salary > a.managerSalary