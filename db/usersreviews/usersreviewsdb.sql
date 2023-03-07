SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE,
SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema usersreviewsdb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema usersreviewsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usersreviewsdb` DEFAULT CHARACTER SET utf8;
USE `usersreviewsdb` ;
-- -----------------------------------------------------
-- Table `usersreviewsdb`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usersreviewsdb`.`Users` ;
CREATE TABLE IF NOT EXISTS `usersreviewsdb`.`Users` (
 `idUser` INT NOT NULL AUTO_INCREMENT,
 `username` VARCHAR(45) NOT NULL,
 `password` VARCHAR(60) NOT NULL,
 `email` VARCHAR(45) NOT NULL,
 `enable` TINYINT(1) NOT NULL DEFAULT 1,
 PRIMARY KEY (`idUser`),
 UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `usersreviewsdb`.`Reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usersreviewsdb`.`Reviews` ;
CREATE TABLE IF NOT EXISTS `usersreviewsdb`.`Reviews` (
 `idReview` INT NOT NULL AUTO_INCREMENT,
 `idFilm` INT NOT NULL,
 `note` INT NOT NULL,
 `rating` VARCHAR(1500) NOT NULL,
 `date` DATE NOT NULL,
 `Users_idUser` INT NOT NULL,
 PRIMARY KEY (`idReview`, `Users_idUser`),
 INDEX `fk_Reviews_Users_idx` (`Users_idUser` ASC) VISIBLE,
 CONSTRAINT `fk_Reviews_Users`
 FOREIGN KEY (`Users_idUser`)
 REFERENCES `usersreviewsdb`.`Users` (`idUser`)
 ON DELETE CASCADE
 ON UPDATE CASCADE)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `usersreviewsdb`.`Authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usersreviewsdb`.`Authorities` ;
CREATE TABLE IF NOT EXISTS `usersreviewsdb`.`Authorities` (
 `idRole` INT NOT NULL AUTO_INCREMENT,
 `authority` VARCHAR(45) NOT NULL,
 PRIMARY KEY (`idRole`))
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `usersreviewsdb`.`Users_has_Authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `usersreviewsdb`.`Users_has_Authorities` ;
CREATE TABLE IF NOT EXISTS `usersreviewsdb`.`Users_has_Authorities` (
 `Users_idUser` INT NOT NULL,
 `Authorities_idRole` INT NOT NULL,
 PRIMARY KEY (`Users_idUser`, `Authorities_idRole`),
 INDEX `fk_Users_has_Authorities_Authorities1_idx` (`Authorities_idRole` ASC) VISIBLE,INDEX `fk_Users_has_Authorities_Users1_idx` (`Users_idUser` ASC) VISIBLE,
 CONSTRAINT `fk_Users_has_Authorities_Users1`
 FOREIGN KEY (`Users_idUser`)
 REFERENCES `usersreviewsdb`.`Users` (`idUser`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION,
 CONSTRAINT `fk_Users_has_Authorities_Authorities1`
 FOREIGN KEY (`Authorities_idRole`)
 REFERENCES `usersreviewsdb`.`Authorities` (`idRole`)
 ON DELETE NO ACTION
 ON UPDATE NO ACTION)
ENGINE = InnoDB;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
