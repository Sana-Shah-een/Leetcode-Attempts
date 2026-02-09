# name of customers show krwane that's why c.name from Customers Table
# LEFT JOIN lgaya (Customers Table) se all names ajaen g r Orders sematching  r baqi null
#r condition lgai jhan o.customerId null hogi wo wale records le ao
SELECT c.name AS 'Customers' FROM Customers c LEFT JOIN Orders o 
on c.id = o.customerId WHERE o.customerId is NULL;