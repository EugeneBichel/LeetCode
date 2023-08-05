/**

Normalized databases are designed to minimize redundancy,
while denormalized databases are designed to optimize read time.

Denormalization is commonly used to create highly scalable systems.
 */

/**
Database 1:

Courses: CourseID(PK), CourseName, TeacherID
Teachers: TeacherID(PK), TeacherName
Students: StudentID(PK), StudentName
StudentCourses: CourseID(PK), StudentID(PK)
 */

/**
Query 1: Student Enrollment
Implement a query to get a list of all students and how many courses
each student is enrolled in
 */

/**
Solution 1
 */
select Students.StudentName, CoursesNumber
from Students INNER JOIN
  (select Students.StudentID, count(StudentCourses.CourseID) as CoursesNumber
from Students LEFT JOIN StudentCourses
  on Students.StudentID = StudentCourses.StudentID
GROUP BY StudentCourses.StudentID) w
  on Students.StudentID = w.StudentID

/**
Solution 1 has 2 select queries. We can improve it.

Keep in mind, that we can only select values that are in aggregate function
or in the GROUP BY clause.
 */

/**
Solution 2
 */
select Students.StudentName, Students.StudentID, count(StudentCourse.CourseID)
from Students LEFT JOIN StudentCourse
  on Student.StudentID = StudentCourse.StudentID
GROUP BY Student.StudentID, Student.StudentName

/**
Solution 3
 */
select max(Students.StudentName) as StudentName, Students.StudentID, count(StudentCourses.CourseID)
from Students LEFT JOIN StudentCourses
  on Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID

/**
Database 1:

Courses: CourseID(PK), CourseName, TeacherID
Teachers: TeacherID(PK), TeacherName
Students: StudentID(PK), StudentName
StudentCourses: CourseID(PK), StudentID(PK)
 */

/**
Query 2: Teacher Class Size

Implement a query to get a list of all teachers and how many students they each teach.
If a teacher teaches the same student in 2 courses, you should double count the student.
Sort the list in descending order of the number of students a teacher teaches.
 */

/**
Solution 1
 */
select Courses.TeacherID, count(StudentCourses.CourseID) as Number
from Courses inner join StudentCourses
  on Courses.CourseID = StudentCourses.CourseID
GROUP BY Courses.TeacherID
/**
Note that this INNER JOIN will not select teachers who are not teaching classes.
We will handle that in the below query when we join it with the list of all teachers.
 */

/**
Solution 2
 */
select TeacherName, isnull(StudentSize.Number, 0)
from Teachers left join
(select TeacherID, count(StudentCourses.CourseID) as Number
from Courses inner join StudentCourses
on Courses.CourseID = StudentCourses.CourseID
group by Courses.TeacherID) StudentSize
on Teachers.TeacherID = StudentSize.TeacherID
order by StudentSize.Number desc


/**
Database 2

Apartments: AptID, UnitNumber, BuildingID
Buildings: BuildingID, ComplexID, BuildingName, Address
Tenants: TenantID, TenantName
Complexes: ComplexID, ComplexName
AptTenants: TenantID, AptID
Requests: RequestID, Status, AptID, Description

Note: each apartment can have multiple tenants, and each tenant can have multiple apartments.
Each apartment belongs to one building, and each building belongs to one complex.
 */

/**
Query 1:
Write a SQL query to a get a list of tenants who are renting more than one apartment
 */

select Tenants.TenantName, Tenants.TenantId
from Tenants inner join (
select TenantID
from AptTenants
GROUP BY AptId
HAVING count(AptId) > 1 ) T
  on Tenants.TenantId = T.TenantID


/**
Query 2:
Write a SQL query to get a list of all buildings and the number of open requests
(Requests in which status equals 'Open')
 */
select Buildings.BuildingName, isnull(T.Number, 0)
from Buildings left join (
select Apartments.BuildingID, count(Apartments.AptID) as Number
from Apartments inner join Requests
  on Apartments.AptID = Requests.AptID
GROUP BY Requests.AptID
having Requests.Status = 'Open') T
  on Buildings.BuildingID = T.BuildingID

/**
Query 3:
Building #11 is undergoing a major renovation. Implement a query to close all
requests from apartments in this building.
 */
update Requests
set Status = 'Closed'
where AptID in (
    select AptID from Apartments
    where BuildingID = 11
)



