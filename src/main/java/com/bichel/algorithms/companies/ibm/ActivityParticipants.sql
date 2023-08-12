SElECT activity
FROM friends
GROUP BY activity
HAVING count(*) > (SELECT count(*) FROM friends GROUP BY activity ORDER BY 1 LIMIT 1)
   AND count(*)< (SELECT count(*) FROM friends GROUP BY activity ORDER BY 1 DESC LIMIT 1)
