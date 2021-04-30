select emp.name, pos.name from company_employee as emp
left join company_position as pos ON
(pos.positionid = emp.position);
