create index IX_CB5FC5F on Company_Bank (bankName[$COLUMN_LENGTH:75$]);
create index IX_4F4227F0 on Company_Bank (uuid_[$COLUMN_LENGTH:75$]);

create index IX_E7541AE6 on Company_Employee (bank);
create index IX_3073AA93 on Company_Employee (position);
create index IX_121DB8BE on Company_Employee (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D44CBEF0 on Company_Position (name[$COLUMN_LENGTH:75$]);
create index IX_497FA0A3 on Company_Position (uuid_[$COLUMN_LENGTH:75$]);