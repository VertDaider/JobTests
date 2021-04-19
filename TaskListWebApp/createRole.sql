CREATE USER test PASSWORD 'user';
CREATE DATABASE tasklist OWNER test;
GRANT ALL privileges ON DATABASE tasklist TO test;
