SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `EduNav` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `EduNav` ;

-- -----------------------------------------------------
-- Table `EduNav`.`USERS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`USERS` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`USERS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL,
  `PASSWORD` VARCHAR(45) NULL,
  `PHONE` INT NULL,
  `WECHAT` VARCHAR(45) NULL,
  `EMAIL` VARCHAR(45) NULL,
  `INVITATION_CODE` VARCHAR(45) NULL,
  `LAST_LOGIN_TIME` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `idUSERS_UNIQUE` (`ID` ASC))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`ROLES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`ROLES` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`ROLES` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETE` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`GROUPS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`GROUPS` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`GROUPS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `ROLE_ID` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`USER_GROUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`USER_GROUP` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`USER_GROUP` (
  `ID` INT NOT NULL,
  `USER_ID` VARCHAR(45) NULL,
  `GROUP_ID` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`PERMISSIONS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`PERMISSIONS` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`PERMISSIONS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `PATH` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`ROLE_PERMISSION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`ROLE_PERMISSION` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`ROLE_PERMISSION` (
  `ID` INT NOT NULL,
  `ROLE_ID` VARCHAR(45) NULL,
  `PERMISSION_ID` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`CATEGORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`CATEGORY` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`CATEGORY` (
  `ID` INT NOT NULL,
  `VALUE` VARCHAR(45) NULL,
  `NAME` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`LOCATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`LOCATION` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`LOCATION` (
  `ID` INT NOT NULL,
  `VALUE` VARCHAR(45) NULL,
  `NAME` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`PARTNER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`PARTNER` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`PARTNER` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `LOGO` VARCHAR(45) NULL,
  `CONTRACT` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_TEMPLATE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`COURSE_TEMPLATE` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`COURSE_TEMPLATE` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `CATEGORY_ID` VARCHAR(45) NULL,
  `PARTNER_ID` VARCHAR(45) NULL,
  `PRICE` VARCHAR(45) NULL,
  `COMMISSION` VARCHAR(45) NULL,
  `SERVICE_CHARGE` VARCHAR(45) NULL,
  `STATUS` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`COURSE` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`COURSE` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `COURSE_TEMPLATE_ID` VARCHAR(45) NULL,
  `STATUS` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_COMMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`COURSE_COMMENT` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`COURSE_COMMENT` (
  `ID` INT NOT NULL,
  `USER_ID` VARCHAR(45) NULL,
  `COURSE_TEMPLATE_ID` VARCHAR(45) NULL,
  `TITLE` VARCHAR(45) NULL,
  `CONTENT` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELTED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`APPROVE_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`APPROVE_HISTORY` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`APPROVE_HISTORY` (
  `ID` INT NOT NULL,
  `TYPE` VARCHAR(45) NULL,
  `ATTACHED_ID` VARCHAR(45) NULL,
  `SUBMIT_USER_ID` VARCHAR(45) NULL,
  `APPROVE_USER_ID` VARCHAR(45) NULL,
  `PREVIOUS_STATUS` VARCHAR(45) NULL,
  `NEXT_STATUS` VARCHAR(45) NULL,
  `COMMENT` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`BOOKING`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`BOOKING` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`BOOKING` (
  `ID` INT NOT NULL,
  `USER_ID` VARCHAR(45) NULL,
  `COURSE_ID` VARCHAR(45) NULL,
  `CONTACT_NAME` VARCHAR(45) NULL,
  `CONTACT_PHONE` VARCHAR(45) NULL,
  `STATUS` VARCHAR(45) NULL,
  `REMARK` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`COUNPON`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`COUNPON` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`COUNPON` (
  `ID` INT NOT NULL,
  `CODE` VARCHAR(45) NULL,
  `TOTAL` VARCHAR(45) NULL,
  `BALANCE` VARCHAR(45) NULL,
  `EXPIRY_TIME` VARCHAR(45) NULL,
  `REMARK` VARCHAR(45) NULL,
  `USER_ID` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`COUPON_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`COUPON_HISTORY` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`COUPON_HISTORY` (
  `ID` INT NOT NULL,
  `COUNPON_ID` VARCHAR(45) NULL,
  `CHARGE` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`CREDIT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`CREDIT` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`CREDIT` (
  `ID` INT NOT NULL,
  `CREDIT` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`CREDIT_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`CREDIT_HISTORY` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`CREDIT_HISTORY` (
  `ID` INT NOT NULL,
  `CHARGE` VARCHAR(45) NULL,
  `USER_ID` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ACCOUNT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`ACCOUNT` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`ACCOUNT` (
  `ID` INT NOT NULL,
  `BALANCE` VARCHAR(45) NULL,
  `ALIPAY_ID` VARCHAR(45) NULL,
  `TENPAY_ID` VARCHAR(45) NULL,
  `BACK_ID` VARCHAR(45) NULL,
  `REAL_NAME` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ACCOUNT_HISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`ACCOUNT_HISTORY` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`ACCOUNT_HISTORY` (
  `ID` INT NOT NULL,
  `CHARGE` VARCHAR(45) NULL,
  `TYPE` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `REMARK` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`SPREAD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`SPREAD` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`SPREAD` (
  `ID` INT NOT NULL,
  `USER_ID` VARCHAR(45) NULL,
  `PARTNER_ID` VARCHAR(45) NULL,
  `COURSE_ID` VARCHAR(45) NULL,
  `URL` VARCHAR(45) NULL,
  `REMARK` VARCHAR(45) NULL,
  `STATUS` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`TEACHER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`TEACHER` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`TEACHER` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `PHOTO` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_TEACHER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`COURSE_TEACHER` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`COURSE_TEACHER` (
  `ID` INT NOT NULL,
  `COURSE_ID` VARCHAR(45) NULL,
  `TEACHER_ID` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ACTIVITY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `EduNav`.`ACTIVITY` ;

CREATE TABLE IF NOT EXISTS `EduNav`.`ACTIVITY` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `PARTNER_ID` VARCHAR(45) NULL,
  `COURSE_ID` VARCHAR(45) NULL,
  `REMARK` VARCHAR(45) NULL,
  `START_TIME` VARCHAR(45) NULL,
  `END_TIME` VARCHAR(45) NULL,
  `STATUS` VARCHAR(45) NULL,
  `LAST_MODIFY_TIME` VARCHAR(45) NULL,
  `CREATE_TIME` VARCHAR(45) NULL,
  `ENABLED` VARCHAR(45) NULL,
  `DELETED` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
