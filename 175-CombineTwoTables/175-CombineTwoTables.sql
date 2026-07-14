-- Last updated: 7/14/2026, 2:25:29 PM
# Write your MySQL query statement below
select Person.firstName, Person.lastName, Address.city ,Address.state 
FROM Person
LEFT JOIN Address
ON Person.personId = Address.personId;