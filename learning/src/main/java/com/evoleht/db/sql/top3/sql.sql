select * from grade g
where (
select count(*) from grade where g.course = course and g.grade < grade
) <3
ORDER BY course,grade DESC

