create table Company_Bank (
	uuid_ VARCHAR(75) null,
	bankId LONG not null primary key,
	bankName VARCHAR(75) null,
	BIK LONG,
	address VARCHAR(75) null
);

create table Company_Employee (
	uuid_ VARCHAR(75) null,
	employeesId LONG not null primary key,
	surname VARCHAR(75) null,
	name VARCHAR(75) null,
	patronymic VARCHAR(75) null,
	sex VARCHAR(75) null,
	birthDay DATE null,
	position INTEGER,
	dateOfEmployment DATE null,
	salary INTEGER,
	mobilePhone INTEGER,
	jobPhone INTEGER,
	bank INTEGER,
	archive BOOLEAN
);

create table Company_Position (
	uuid_ VARCHAR(75) null,
	positionId LONG not null primary key,
	name VARCHAR(75) null,
	archive BOOLEAN
);