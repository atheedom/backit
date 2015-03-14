CREATE TABLE app_user (
  id serial PRIMARY KEY,
  username character varying UNIQUE NOT NULL,
  password bytea NOT NULL,
  salt bytea NOT NULL,
  first_name character varying,
  last_name character varying,
  email character varying
);

CREATE TABLE tag (
  id serial PRIMARY KEY,
  tag text NOT NULL,
  description text NOT NULL
);

CREATE TABLE campaign (
  id serial PRIMARY KEY,
  title text,
  summary text,
  hashtag text,
  imageURI text,
  videoURI text,
  html text,
  creation_date timestamp with time zone,
  expiration_date timestamp with time zone,
  target_funding numeric(20, 2)
);

CREATE TABLE campaign_tag (
  campaign_id integer references campaign(id),
  tag_id integer references tag(id)
);

CREATE TABLE campaign_viewer (
  campaign_id integer references campaign(id),
  user_id integer references app_user(id),
  view_date timestamp with time zone
);

CREATE TABLE campaign_owner (
  campaign_id integer references campaign(id),
  user_id integer references app_user(id)
);

CREATE TABLE funding (
  id serial PRIMARY KEY, --a donor can give more than once so can't use (donor, campaign) as a key
  donor_id integer references app_user(id),
  campaign_id integer references campaign(id),
  funding_amount numeric(20, 2),
  funding_date timestamp with time zone
);
