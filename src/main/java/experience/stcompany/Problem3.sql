/* 어려운 부분은 없는 문제 */

SELECT A.id,
       A.title,
       CASE WHEN B.reserved_tickets is null then 0
            ELSE B.reserved_tickets
		END
  FROM plays A
  LEFT OUTER JOIN (SELECT play_id,
                          SUM(number_of_tickets) as reserved_tickets
                     FROM reservations
                    GROUP BY play_id) B ON A.id = B.play_id
 ORDER BY B.reserved_tickets desc, A.id asc;