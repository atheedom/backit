INSERT INTO app_user(username, password, salt)
VALUES ('assylias', '0'::bytea, '0'::bytea);

INSERT INTO tag(tag, description)
VALUES
  ('ARTS', 'Art & Photo'),
  ('SPORTS', 'Sports & Games'),
  ('MUSIC', 'Music'),
  ('SOCIAL', 'Social Projects');

insert into campaign(title, hashtag, summary, creation_date, expiration_date, target_funding, imageURI, videoURI, html)
values  ('Local Arts Project', '#localarts', 'A project about getting kids involve with art and stuff',
'2015-03-12T12:52:27Z', '2015-03-22T12:52:27Z', 1500, '/img/localarts.jpg', '/video/localarts.mov',
'<html><body><h1>Title 1</h1>Some text</body></html>');

insert into campaign(title, hashtag, summary, creation_date, expiration_date, target_funding, imageURI, videoURI, html)
values  ('Crowdfunding website', '#backit', 'A project to introduce crowdfunding in Jersey',
'2015-03-12T12:52:27Z', '2015-03-22T12:52:27Z', 500000, '/img/backit.jpg', '/video/backit.mov',
'<html><body><h1>Go Backit!!!</h1>Such a great project!</body></html>');

insert into campaign(title, hashtag, summary, creation_date, expiration_date, target_funding, imageURI, videoURI, html)
values  ('Crowdfunding website, again???', '#backit-pirates', 'A project to copy backit because it is such a greaaaat concept',
'2015-03-14T12:52:27Z', '2015-03-14T12:52:27Z', 500, '/img/backit-again.jpg', '/video/backit-again.mov',
'<html><body><h1>We are the pirates!!!</h1>There is no project!</body></html>');

insert into campaign_tag values (1, 1);
insert into campaign_tag values (1, 2);
insert into campaign_tag values (2, 4);
insert into campaign_tag values (3, 4);