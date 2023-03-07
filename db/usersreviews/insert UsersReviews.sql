
DELETE FROM `usersreviewsdb`.`Reviews`;
ALTER TABLE `usersreviewsdb`.`Reviews` AUTO_INCREMENT = 1 ;

DELETE FROM `usersreviewsdb`.`Authorities`;
ALTER TABLE `usersreviewsdb`.`Authorities` AUTO_INCREMENT = 1 ;

DELETE FROM `usersreviewsdb`.`Users`;
ALTER TABLE `usersreviewsdb`.`Users` AUTO_INCREMENT = 1 ;
INSERT INTO `usersreviewsdb`.`Users` VALUES (1, 'admin', 'admin', 'admin@uah.es', 1);
INSERT INTO `usersreviewsdb`.`Users` VALUES (2, 'user1', 'one', 'user1@uah.es', 1);
INSERT INTO `usersreviewsdb`.`Users` VALUES (3, 'user2', 'two', 'user2@uah.es', 1);
INSERT INTO `usersreviewsdb`.`Users` VALUES (4, 'user3', 'three', 'user3@uah.es', 1);
INSERT INTO `usersreviewsdb`.`Users` VALUES (5, 'user4', 'four', 'user4@uah.es', 1);
INSERT INTO `usersreviewsdb`.`Users` VALUES (6, 'user5', 'five', 'user5@uah.es', 1);
INSERT INTO `usersreviewsdb`.`Users` VALUES (7, 'user6', 'six', 'user6@uah.es', 1);
INSERT INTO `usersreviewsdb`.`Authorities` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `usersreviewsdb`.`Authorities` VALUES (2, 'ROLE_USER');
INSERT INTO `usersreviewsdb`.`users_has_authorities` VALUES (1, 1);
INSERT INTO `usersreviewsdb`.`users_has_authorities` VALUES (2, 2);
INSERT INTO `usersreviewsdb`.`users_has_authorities` VALUES (3, 2);
INSERT INTO `usersreviewsdb`.`users_has_authorities` VALUES (4, 2);
INSERT INTO `usersreviewsdb`.`users_has_authorities` VALUES (5, 2);
INSERT INTO `usersreviewsdb`.`users_has_authorities` VALUES (6, 2);
INSERT INTO `usersreviewsdb`.`users_has_authorities` VALUES (7, 2);

INSERT INTO `usersreviewsdb`.`Reviews` VALUES (1, 1, 8, '"Babel" is an unusual style film. Now I am not saying it\'s unique--there are other films like this that are made up of seemingly disparate stories that all end up tying together by the end--such as the multi-Oscar winning "Crash". 
This makes it quite unusual and the acting make it well worth seeing.
The film begins in Morocco and ultimately results in a senseless shooting of an American tourist. How and why this also results in the film episodically ending up in San Diego, Mexico and Tokyo is just something you\'ll need to see for yourself.
As I mentioned above, the acting is the big reason to see this one. Although there are some big name actors in this one (most notably Brad Pitt), these actors are nice because they are not the BIG STARS in the film--just actors acting naturally among a cast of many excellent minor actors and non-actors (like many of the Moroccans). 
All create a very realistic looking film--which I like.', '2019-01-10', 2);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (2, 1, 10, 'First off, I\'d like to say that both Rinko Kikuchi and Adriana Barraza deserved their Oscar nominations for their roles in Babel this year. 
And Brad Pitt and Cate Blanchett deserve thanks for lending their star power to this picture. Babel is a mostly compelling film about how four different stories taking place in the countries of Mexico, America, Morocco, and Japan are loosely connected. 
Some of the most interesting sequences concern a Mexican wedding that a nanny (Barraza) from that country takes her American charges (one of whom is Dakota Fanning\'s sister, Elle) to, and a Japanese deaf-mute teen\'s (Kikuchi) attempted seduction of the police detective when he arrives at her apartment. 
This movie can be frustrating to anyone who wants a conventional storyline but it mostly pays off at the end. It\'s certainly one of the most challenging movies I\'ve seen this year.', '2019-01-11', 3);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (3, 1, 4, 'Unfortunately this viewer was bored silly by it. Pretentious to the point of silliness this is a movie that is going to spell out its premise over and over again. 
Yes, we can\'t communicate (and if it isn\'t clear one of the characters is deaf), yes we are all connected, yes this will lead to tragedy. Thank you for pointing it out for us, but did you have to do it for almost two and a half hours? 
Don\'t get me wrong there is a good story in this movie, but the way the director has chosen to tell it, out of order with the grafting on of the Japanese portion of the film, it all becomes lost. Its an attempt to add some emotional and intellectual weight to a story that doesn\'t need it. 
I walked out of the the film admiring it and what it was trying to do, but not liking it much at all.', '2020-01-14', 6);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (4, 2, 7, 'As for the film, I won\'t say much--there are already TONS of reviews for this one. Suffice to say that the plot is exceptional--complex, shocking and worth seeing. 
The acting also is quite nice all around. The bottom line is that this IS a quality production and if it\'s the sort of thing you\'d normally watch, watch away and enjoy.', '2020-05-25', 3);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (5, 2, 10, 'My favourite movie', '2020-06-05', 4);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (6, 2, 9, 'Absolutely one of the best shockers to come along in a very long time. Two detectives(Brad Pitt and Morgan Freeman)work in tandem trying to track down a ruthless serial killer, whose modus operandi is inspired by the seven deadly sins. 
Some very graphic after-the-fact violence. Pitt and Morgan could not appear more realistic. Very strong language is atmospheric in this crime drama. Don\'t be ashamed if you flinch, hide your eyes or redecorate the chair you\'re sitting in. 
This movie is powerfully good. Also in the cast are: Kevin Spacey, Gwyneth Paltrow, R. Lee Ermey and Daniel Zacapa.', '2020-07-25', 5);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (7, 3, 10, 'It is no wonder that the film has such a high rating, it is quite literally breathtaking. What can I say that hasn\'t said before? Not much, it\'s the story, the acting, the premise, but most of all, this movie is about how it makes you feel. 
Sometimes you watch a film, and can\'t remember it days later, this film loves with you, once you\'ve seen it, you don\'t forget. The ultimate story of friendship, of hope, and of life, and overcoming adversity. I understand why so many class this as the best film of all time, it isn\'t mine, but I get it. 
If you haven\'t seen it, or haven\'t seen it for some time, you need to watch it, it\'s amazing. 10/10.', '2020-09-10', 2);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (8, 3, 10, 'Loved everything about this movie, recommend!!!', '2020-10-02', 3);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (9, 3, 6, 'Tim Robbins plays Andy Dufresne, a man convicted of double murder who is sent to jail, eventually befriending other lifers including Morgan Freeman\'s Ellis Redding. 
Exceptionally handsome adaptation of Stephen King\'s short story "Rita Hayworth and Shawshank Redemption" (in the film version, it\'s really Raquel Welch, not Rita, who aids in the ultimate twist). 
On the surface, it\'s another prison-genre picture with the usual stereotypes such as a rotten warden, a cruel guard, a few homosexuals, and a quirky old-timer who doesn\'t want his parole. However, the film\'s emotions run surprisingly deep, justice is well served by the conclusion, and several of the cast members carve out amazing, three-dimensional characterizations. 
The finale is pure fantasy, however it does provide the audience with the release it needs, and Robbins and Freeman are excellent. Long, involved, but engrossing and satisfying, "Shawshank" was not a big hit at the box-office but found a devoted following on video and cable. **1/2 from ****', '2020-09-10', 4);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (10, 3, 8, 'very nice, very nice', '2020-10-02', 5);
INSERT INTO `usersreviewsdb`.`Reviews` VALUES (11, 3, 9, '', '2020-09-10', 6);