select IFNULL( (select distinct salary from Employee
                order by salary desc
                LIMIT 1
                    OFFSET 1 ), NULL ) as SecondHighestSalary