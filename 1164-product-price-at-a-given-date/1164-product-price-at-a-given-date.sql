SELECT DISTINCT p.product_id,
COALESCE(
    (SELECT new_price
    FROM Products pr 
    WHERE p.product_id=pr.product_id
    AND change_date<='2019-08-16'
    ORDER BY change_date DESC
    LIMIT 1
    ),10
) AS price 
FROM Products p