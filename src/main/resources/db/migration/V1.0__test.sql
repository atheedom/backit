/*
*       Users
*/

CREATE TABLE app_user (
  id serial PRIMARY KEY,
  username character varying UNIQUE NOT NULL,
  password bytea NOT NULL,
  salt bytea NOT NULL,
  first_name character varying,
  last_name character varying,
  email character varying
);