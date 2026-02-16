SELECT id,COUNT(*) AS num
FROM(
    -- UNION ALL se all combinations add hojaen ge then we can easily count
    --   id   | friend_id
    --    1   |     2
    --    1   |     3
    --    2   |     1
    --    2   |     3
    --    3   |     1
    --    3   |     2
    --    3   |     3
    --    4   |     3

    SELECT requester_id As id,accepter_id AS friend_id
    FROM RequestAccepted 
    UNION ALL
    SELECT accepter_id AS id,requester_id AS friend_id
    FROM RequestAccepted
)AS all_friends
GROUP BY id
-- group by hokar num count hoe hein
-- | id | num |
-- | -- | --- |
-- | 1  | 2   |
-- | 2  | 2   |
-- | 3  | 3   |
-- | 4  | 1   |

ORDER BY num DESC LIMIT 1;
-- | id | num |
-- | -- | --- |
-- | 3  | 3   |
