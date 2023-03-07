DELETE FROM `filmsactorsdb`.`Films_has_Cast`;
DELETE FROM `filmsactorsdb`.`Films`;
DELETE FROM `filmsactorsdb`.`Actors`;

ALTER TABLE `filmsactorsdb`.`Films` AUTO_INCREMENT = 1 ;
INSERT INTO `filmsactorsdb`.`Films` VALUES (1,'Babel', 2006, 144, 'France / Mexico / USA', 'Alejandro Gonzalez Inarritu', 'drama', 'Tragedy strikes a married couple on vacation in the Moroccan desert, touching off an interlocking story involving four different families.', 'https://m.media-amazon.com/images/M/MV5BYTJkZDljNGYtNjRiNC00ZmY2LTg1NmItYTI1MTllNDQzMWVmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg');
INSERT INTO `filmsactorsdb`.`Films` VALUES (2,'Se7en', 1995, 127, 'USA', 'David Fincher', 'crime', 'Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.', 'https://take2.lancastersu.co.uk/wp-content/uploads/2020/09/seven-poster.jpg');
INSERT INTO `filmsactorsdb`.`Films` VALUES (3,'The Shawshank Redemption', 1994, 142, 'USA', 'Frank Darabont', 'drama', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'https://occ-0-987-990.1.nflxso.net/dnm/api/v6/X194eJsgWBDE2aQbaNdmCXGUP-Y/AAAABUQCmg3KKkFHVfXa_QGXW-ihQ7JcpYGwyHviLpsrg_5zzLStiFuI1eDQ5XjxnYNPWhP8wWQdS747Fn_LbVDC7U-paLWG.jpg?r=dac');
INSERT INTO `filmsactorsdb`.`Films` VALUES (4,'The Dark Knight', 2008 , 152, 'USA / UK', 'Christopher Nolan', 'action / crime', 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 'https://www.cinemascomics.com/wp-content/uploads/2012/05/tdkr-jpg.jpg');
INSERT INTO `filmsactorsdb`.`Films` VALUES (5,'The Prestige', 2006 , 130, 'USA / UK', 'Christopher Nolan', 'drama / thriller', 'After a tragic accident, two stage magicians in 1890s London engage in a battle to create the ultimate illusion while sacrificing everything they have to outwit each other.', 'https://m.media-amazon.com/images/I/51wILNNX2VL._SY445_.jpg');

ALTER TABLE `filmsactorsdb`.`Actors` AUTO_INCREMENT = 1 ;
INSERT INTO `filmsactorsdb`.`Actors` VALUES (1,'Brad Pitt', '1963-12-18', 'USA');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (2, 'Cate Blanchett', '1969-05-14', 'Australia');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (3, 'Adriana Barraza', '1956-03-05', 'Mexico');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (4, 'Gael García Bernal', '1978-11-30', 'Mexico');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (5,'Morgan Freeman', '1937-06-01', 'USA');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (6,'Kevin Spacey', '1959-07-26', 'USA');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (7,'Tim Robbins', '1958-10-16', 'USA');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (8,'Christian Bale', '1974-01-30', 'UK');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (9,'Heath Ledger', '1979-04-04', 'Australia');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (10,'Michael Caine', '1933-03-14', 'UK');
INSERT INTO `filmsactorsdb`.`Actors` VALUES (11,'Hugh Jackman', '1968-10-12', 'Australia');

INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (1, 1);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (1, 2);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (1, 3);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (1, 4);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (2, 1);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (2, 5);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (2, 6);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (3, 5);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (3, 7);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (4, 5);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (4, 8);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (4, 9);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (4, 10);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (5, 8);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (5, 10);
INSERT INTO `filmsactorsdb`.`Films_has_Cast` VALUES (5, 11);