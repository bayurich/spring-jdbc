select * from customers c
                  inner join orders o
                             on c.id = o.customer_id
where lower(name) = lower(?)