select * from table1
where '播放' > 20000
group by '用户名'
HAVING SUM('用户名')>2