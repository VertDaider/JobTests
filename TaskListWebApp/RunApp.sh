#!/bin/bash

read -p 'Создать новую базу данных tasklist и роль test? Существующая БД будет удалена [Y/N] ' 

if [[ $REPLY =~ ^[Yy]$ ]]
	then
		sudo -u postgres psql -f dropRole.sql
		sudo -u postgres psql -f createRole.sql
		. getPassDB.sh
		sudo -u postgres psql -h localhost -U test -d tasklist -f createDB.sql
fi

mvn spring-boot:run
