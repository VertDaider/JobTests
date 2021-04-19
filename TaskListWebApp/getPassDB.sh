#!/bin/bash
#извлечение пароля из настроек

file_prop=./src/main/resources/application.properties
string_pass=$(egrep "^[^#]*password" $file_prop)

if [ -n "$string_pass" ]; then
	OLD_IFS="$IFS"
	IFS="="
	read text pass <<< "$string_pass"
	IFS="$OLD_IFS"
	echo $pass > passwordDataBase.txt
	echo " Пароль -> $pass 
	сохранен в файле passwordDataBase.txt"
else
	echo "No string with password" >&2
	exit 1
fi
