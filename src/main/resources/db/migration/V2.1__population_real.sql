insert into campaign(title, summary, creation_date, expiration_date, target_funding, imageURI, videoURI, html)
values  (
'Archisle # 3 Open Photography Exhibition 2015',
'The Société Jersiaise Photographic Archive is launching an appeal inviting Jersey businesses and members of the public to make a pledge towards the work of the archive and Archisle: The Jersey Contemporary Photography Programme.',
'2015-03-14T22:47:00Z',
'2015-05-31T12:00:00Z',
10000,
'/img/archisle.jpg',
'/video/archisle.mov',
'<h3>What is the Archisle Project?</h3>
<p>Archisle #3 is our third biennial open call exhibition. Expanding upon the success of the first and second editions in 2011 and 2013 this event gives Jersey and international photographers a crucial opportunity to participate in a group exhibition to present their ideas to an audience. Since its inception in 2011, Archisle has been working hard to develop critical awareness and original thinking in contemporary photography. The evidence that these objectives are being achieved is overwhelming. Jersey photography students, in particular, are producing exciting new work with a number of participants in Archisle''s educational programme progressing to art and photography studies at university. Archisle #3 takes place at a fascinating time when new ideas, techniques and the local and international are coming together to express contemporary experiences through the medium of photography with Jersey as their creative destination. The 2013 edition received over 650 submissions from which 47 images by 25 photographers were presented by Jersey and international photographers. Award winners Amandine Crozat (Paris) and Paula Gortazar (Madrid) travelled to Jersey for the opening. Other international exhibitors also attended the opening. Overall this fast growing event continues to put Jersey and the Channel Islands as creative communities on the map.</p>
<p>The Archisle #2 Online gallery can be accessed at: <a href="http://www.archisle.org.je/archisle-2/">http://www.archisle.org.je/archisle-2/</a></p>

<h3>The Format</h3>
<p>Archisle #3 is an ''open call'' exhibition inviting international submissions. The competition will be divided into three award categories under the overall themes of Chance, Challenge & Change as follows:</p>
<ol><li>Open Category (open to all)</li><li>Channel Islands Category (images must be made in the Channel Islands)</li><li>Emerging talent (two awards for photographers under 18 years / under 25)</li></ol>
<p>Photographers will be required to submit a set of three photographs responding to the theme.</p>

<h3>The Schedule</h3>
<p>The open call will be launched in May 2015 and the deadline will be 7 September 2015.</p>

<h3>The Venue</h3>
<p>Winning and selected photographs will be part of a major exhibition curated by Gareth Syvret, Archisle Project Leader at The Berni Gallery, Jersey Arts Centre from 30 November 2015 until 3 January 2016.</p>

<h3>Why make a pledge?</h3>
<p>In the first five years the Archisle project has made significant progress with developing the objectives of educating, exhibiting and commissioning contemporary photography. We have grown a local photography competition into an international biennial event. With support from One Foundation through our International Photographer in Residence Programme we have delivered over sixty photography workshops in 2013-2014 to hundreds of participants. We have begun to develop a contemporary archive of photography about Jersey of international quality featuring photographers such as Martin Parr, Michelle Sank, Yury Toroptsov and Martin Toft. The Archisle project is hosted by the Société Jersiaise Photographic Archive and as a registered charity and non-profit organization all of our projects are achieved through sponsorship and donations. We have exciting plans for the Photographic Archive and Archisle in 2015 and beyond and we need your support to achieve them. Tom Pope 2015 International Photographer in Residence arrives in Jersey in April to produce an exciting new exhibition and continue our outreach programme. In May we launch Archisle #3 our third open call exhibition which will culminate in a major five week show at Jersey Arts Centre in November/December. The 2015 theme is Chance, Challenge & Change and the Archisle #3 exhibition is a vital opportunity for established and emerging photographers to communicate their work to an audience. We very much hope that you will support our appeal. All of your contribution will go towards our work to produce a fitting artistic record of our times and ensuring that creative cycles continue so that the archive can flourish for future generations.</p>
<p>We are asking members of the public to pledge £100 and in return for their contribution we will supply a high quality archival print of their choice from our superb archive, professionally framed by Victoria Gallery. We are asking businesses to pledge £1000 and in return we will work with them to research up to ten images from our archive to decorate their boardroom, office, hotel reception, restaurant, café, pub or alternative space.</p>
<p>Our Photographic Archive contains over 100,000 images of rich aesthetic quality and range from traditional landscapes to more surprising, quirky and unusual subjects. The right selection of images, creatively presented can have a huge positive impact on retail, office and business environments. We have a wealth of experience in exhibition design and installation to help you present your chosen images, framed or unframed, in traditional or modern methods to suit your decor. Your pledge of support is a great way of contributing to the development of the Photographic Archive for the benefit of all, while also sharing images to promote the enjoyment and value of cultural collections.</p>'
);

INSERT INTO reward(title, description, value)
VALUES(
'Individual Pledges',
'<p>Please contact the Société Jersiaise Photographic Archive to discuss your requirements at: Tel. 01534 633398 or email: <a href="mailto:photoarchive@societe-jersiaise.org">photoarchive@societe-jersiaise.org</a>. The Photographic Archive Online catalogue contains over 35,000 images for you to choose from and is accessible here: <a href="http://photographic-archive.societe-jersiaise.org/">http://photographic-archive.societe-jersiaise.org/</a>. When choosing your image please note the Image Reference number.</p>',
100);

INSERT INTO reward(title, description, value)
VALUES(
'Company/Business Pledges',
'<p>Please contact the Société Jersiaise Photographic Archive to discuss your requirements at: Tel. 01534 633398 or email: <a href="mailto:photoarchive@societe-jersiaise.org">photoarchive@societe-jersiaise.org</a>. We will be delighted to assist you with finding the perfect images to decorate your building and to advise upon the best method of presentation. Businesses pledging £1000 will receive permanent acknowledgement of their contribution on <a href="http://www.societe-jersiaise.org/">www.societe-jersiaise.org</a> and <a href="www.archisle.org.je">www.archisle.org.je</a> . Production costs will be met by the purchaser.</p>',
1000);

INSERT INTO campaign_reward(campaign_id, reward_id) VALUES
((select id from campaign where title like '%Archisle%'),
 (select id from reward where title like 'Individual Pledges'));

INSERT INTO campaign_reward(campaign_id, reward_id) VALUES
((select id from campaign where title like '%Archisle%'),
 (select id from reward where title like 'Company/Business Pledges'));