CREATE TABLE reward (
  id serial PRIMARY KEY,
  title text,
  description text,
  value numeric(20, 2),
  total_number integer
);

CREATE TABLE campaign_reward (
  campaign_id integer references campaign(id),
  reward_id integer references reward(id)
);