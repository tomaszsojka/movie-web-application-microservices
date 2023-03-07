
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema filmmanagementdb
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `filmsactorsdb` DEFAULT CHARACTER SET utf8;
USE `filmsactorsdb` ;

-- -----------------------------------------------------
-- Table `filmmanagementdb`.`Films`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `filmsactorsdb`.`Films` ;

CREATE TABLE IF NOT EXISTS `filmsactorsdb`.`Films` (
  `idFilm` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `year` YEAR,
  `duration` INT NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `direction` VARCHAR(45) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `synopsis` VARCHAR(500) NOT NULL,
  `image` VARCHAR(250) NULL,
  PRIMARY KEY (`idFilm`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cursosalumnosdb`.`Actors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `filmsactorsdb`.`Actors` ;

CREATE TABLE IF NOT EXISTS `filmsactorsdb`.`Actors` (
  `idActor` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthdate` DATE,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idActor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filmmanagementdb`.`Films_has_Cast`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `filmsactorsdb`.`Films_has_Cast` ;

CREATE TABLE IF NOT EXISTS `filmsactorsdb`.`Films_has_Cast` (
  `Films_idFilm` INT NOT NULL,
  `Actors_idActor` INT NOT NULL,
  PRIMARY KEY (`Films_idFilm`, `Actors_idActor`),
  INDEX `fk_Films_has_Cast_Actors_idx` (`Actors_idActor` ASC) VISIBLE,
  INDEX `fk_Films_has_Cast_Films_idx` (`Films_idFilm` ASC) VISIBLE,
  CONSTRAINT `fk_Films_has_Cast_Films`
    FOREIGN KEY (`Films_idFilm`)
    REFERENCES `filmsactorsdb`.`Films` (`idFilm`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Films_has_Cast_Actors`
    FOREIGN KEY (`Actors_idActor`)
    REFERENCES `filmsactorsdb`.`Actors` (`idActor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
