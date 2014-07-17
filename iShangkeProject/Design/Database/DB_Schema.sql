DROP database edunav;
CREATE database edunav;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `EduNav` DEFAULT CHARACTER SET utf8 ;
USE `EduNav` ;

-- -----------------------------------------------------
-- Table `EduNav`.`USERS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`USERS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NULL ,
  `PASSWORD` VARCHAR(200) NULL ,
  `PHONE` VARCHAR(45) NULL ,
  `WECHAT` VARCHAR(45) NULL ,
  `EMAIL` VARCHAR(100) NULL ,
  `AVATAR_URL` VARCHAR(100) NULL ,
  `INVITATION_CODE` VARCHAR(45) NULL ,
  `APPLIED_INVITATION_CODE` VARCHAR(45) NULL ,
  `REFERENCE` VARCHAR(45) NULL ,
  `LAST_LOGIN_TIME` DATETIME NOT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  `GENDER` INT NULL ,
  `BIRTHDAY` DATETIME NULL ,
  `SCHOOL` VARCHAR(45) NULL ,
  `MAJOR` VARCHAR(45) NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`ROLES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`ROLES` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`PARTNER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`PARTNER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `INST_NAME` VARCHAR(45) NULL ,
  `LOGO_URL` VARCHAR(100) NULL ,
  `CONTRACT` VARCHAR(45) NULL ,
  `RATING` DOUBLE NULL ,
  `LAST_LOGIN_TIME` DATETIME NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  `WHOLE_NAME` VARCHAR(45) NULL ,
  `LICENCE` VARCHAR(45) NULL ,
  `ORGANIZATION_NUM` VARCHAR(45) NULL ,
  `REFERENCE` VARCHAR(45) NULL ,
  `PASSWORD` VARCHAR(200) NULL ,
  `PARTNER_INTRO` VARCHAR(100) NULL ,
  `PARTNER_DISTINCTION` VARCHAR(100) NULL ,
  `LICENCE_IMG_URL` VARCHAR(100) NULL ,
  `TAX_REG_IMG_URL` VARCHAR(100) NULL ,
  `EDU_QUALIFICATION_IMG_URL` VARCHAR(100) NULL ,
  `HQ_LOCATION` VARCHAR(100) NULL ,
  `UNI_REG_LOCATION` INT NULL ,
  `HQ_CONTACT` VARCHAR(100) NULL ,
  `HQ_CONTACT_PHONE` VARCHAR(100) NULL ,
  `HQ_CONTACT_SECOPT` VARCHAR(100) NULL ,
  `COURSE_CONTACT` VARCHAR(100) NULL ,
  `COURSE_CONTACT_PHONE` VARCHAR(100) NULL ,
  `STUDENT_INQUERY_PHONE` VARCHAR(100) NULL ,
  `REG_CONTACT` VARCHAR(100) NULL ,
  `REG_CONTACT_PHONE` VARCHAR(100) NULL ,
  `REG_CONTACT_FAX` VARCHAR(100) NULL ,
  `CUTOFF_DAY` INT NULL ,
  `CUTOFF_TIME` INT NULL ,
  `PARTNER_QUALIFICATION` INT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`GROUPS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`GROUPS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NULL ,
  `ROLE_ID` INT NOT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  `PARTNER_ID` INT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_ROLES_GROUPS_idx` (`ROLE_ID` ASC) ,
  INDEX `FK_PARENER_GROUPS_idx` (`PARTNER_ID` ASC) ,
  CONSTRAINT `FK_ROLES_GROUPS`
    FOREIGN KEY (`ROLE_ID` )
    REFERENCES `EduNav`.`ROLES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PARENER_GROUPS`
    FOREIGN KEY (`PARTNER_ID` )
    REFERENCES `EduNav`.`PARTNER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`USER_GROUP`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`USER_GROUP` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_ID` INT NOT NULL ,
  `GROUP_ID` INT NOT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERGROUP_USERS_idx` (`USER_ID` ASC) ,
  INDEX `FK_USERGROUP_GROUPS_idx` (`GROUP_ID` ASC) ,
  CONSTRAINT `FK_USERS_USERGROUP`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_GROUPS_USERGROUP`
    FOREIGN KEY (`GROUP_ID` )
    REFERENCES `EduNav`.`GROUPS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`PERMISSIONS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`PERMISSIONS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NULL ,
  `PATH` VARCHAR(45) NULL ,
  `TAG` VARCHAR(45) NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`ROLE_PERMISSION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`ROLE_PERMISSION` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ROLE_ID` INT NOT NULL ,
  `PERMISSION_ID` INT NOT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_ROLEPERMISSION_ROLES_idx` (`ROLE_ID` ASC) ,
  INDEX `FK_ROLEPERMISSION_PERMISSIONS_idx` (`PERMISSION_ID` ASC) ,
  CONSTRAINT `FK_ROLES_ROLEPERMISSION`
    FOREIGN KEY (`ROLE_ID` )
    REFERENCES `EduNav`.`ROLES` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PERMISSIONS_ROLEPERMISSION`
    FOREIGN KEY (`PERMISSION_ID` )
    REFERENCES `EduNav`.`PERMISSIONS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`CATEGORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`CATEGORY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `VALUE` VARCHAR(45) NULL ,
  `NAME` VARCHAR(45) NULL ,
  `RANK` INT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`LOCATION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`LOCATION` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `VALUE` VARCHAR(45) NULL ,
  `NAME` VARCHAR(45) NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`CIRCLE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`CIRCLE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `VALUE` VARCHAR(45) NULL ,
  `NAME` VARCHAR(45) NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ADDRESS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`ADDRESS` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `PARTNER_ID` INT NOT NULL ,
  `DETAIL` VARCHAR(100) NOT NULL ,
  `LAT` DOUBLE NULL ,
  `LNG` DOUBLE NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_PARTNER_ADDRESS_idx` (`PARTNER_ID` ASC) ,
  CONSTRAINT `FK_PARTNER_ADDRESS`
    FOREIGN KEY (`PARTNER_ID` )
    REFERENCES `EduNav`.`PARTNER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_TEMPLATE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COURSE_TEMPLATE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `COURSE_NAME` VARCHAR(45) NULL ,
  `CATEGORY_ID` INT NOT NULL ,
  `LOCATION_ID` INT NOT NULL ,
  `CIRCLE_ID` INT NOT NULL ,
  `PARTNER_ID` INT NOT NULL ,
  `ADDRESS_ID` INT NOT NULL ,
  `PRICE` DOUBLE NULL ,
  `ORIGINAL_PRICE` DOUBLE NULL ,
  `CASHBACK` DOUBLE NULL ,
  `COMMISSION` DOUBLE NULL ,
  `SERVICE_CHARGE` DOUBLE NULL ,
  `STATUS` INT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  `COURSE_HOUR_NUM` INT NULL ,
  `COURSE_HOUR_LENGTH` INT NULL ,
  `POPULARITY` INT NULL ,
  `START_DATE` DATETIME NULL ,
  `FINISH_DATE` DATETIME NULL ,
  `CUTOFF_DATE` DATETIME NULL ,
  `NO_REFUND_DATE` DATETIME NULL ,
  `CASHBACK_DATE` DATETIME NULL ,
  `BOOKING_TYPE` INT NULL ,
  `START_UPON_ARRIVAL` INT NULL ,
  `START_TIME1` INT NULL ,
  `FINISH_TIME1` INT NULL ,
  `START_TIME2` INT NULL ,
  `FINISH_TIME2` INT NULL ,
  `REG_LOCATION` VARCHAR(100) NULL ,
  `REFERENCE` VARCHAR(45) NULL ,
  `COURSE_INTRO` VARCHAR(100) NULL ,
  `QUIZ` VARCHAR(100) NULL ,
  `CERTIFICATION` VARCHAR(100) NULL ,
  `OPEN_COURSE_REQUIREMENT` VARCHAR(100) NULL ,
  `SUITABLE_STUDENT` VARCHAR(100) NULL ,
  `PREREQUEST` VARCHAR(100) NULL ,
  `HIGH_SCORE_REWARD` VARCHAR(100) NULL ,
  `STUDY_DAY_NOTE` VARCHAR(100) NULL ,
  `TEACHING_MATERIAL_INTRO` VARCHAR(100) NULL ,
  `QUESTION_BANK` VARCHAR(100) NULL ,
  `QUALITY_ASSURANCE` VARCHAR(100) NULL ,
  `PASS_AGREEMENT` VARCHAR(100) NULL ,
  `EXTRACURRICULAR` VARCHAR(100) NULL ,
  `CONTACT` VARCHAR(100) NULL ,
  `REG_PHONE` VARCHAR(100) NULL ,
  `OUTLINE` VARCHAR(400) NULL ,
  `GOAL` VARCHAR(400) NULL ,
  `CLASS_TEACHER` VARCHAR(100) NULL ,
  `TEACHING_AND_EXERCISE` VARCHAR(100) NULL ,
  `QUESTION_SESSION` VARCHAR(100) NULL ,
  `TRAIL` VARCHAR(100) NULL ,
  `ASSIGNMENTS` VARCHAR(100) NULL ,
  `MARKING` VARCHAR(100) NULL ,
  `BONUS_SERVICE` VARCHAR(100) NULL ,
  `DOWNLOAD_MATERIALS` VARCHAR(100) NULL ,
  `TEACHING_MATERIAL_FEE` VARCHAR(100) NULL ,
  `TEACHING_METHOD` VARCHAR(100) NULL ,
  `CLASS_SIZE` VARCHAR(100) NULL ,
  `CLASS_TYPE` INT NULL ,
  `DISCOUNT` DOUBLE NULL ,
  `RATING` DOUBLE NULL ,
  `BOOKING_TOTAL` INT NULL ,
  `SCHOOLTIMEDAY` INT NULL ,
  `SCHOOLTIMEWEEK` INT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_CATEGORY_COURSETEMPLATE_idx` (`CATEGORY_ID` ASC) ,
  INDEX `FK_PARTNER_COURSETEMPLATE_idx` (`PARTNER_ID` ASC) ,
  INDEX `FK_LOCATION_COURSETEMPLATE_idx` (`LOCATION_ID` ASC) ,
  INDEX `fk_COURSE_TEMPLATE_Circles1_idx` (`CIRCLE_ID` ASC) ,
  INDEX `FK_ADDRESS_COURSETEMPLATE_idx` (`ADDRESS_ID` ASC) ,
  CONSTRAINT `FK_CATEGORY_COURSETEMPLATE`
    FOREIGN KEY (`CATEGORY_ID` )
    REFERENCES `EduNav`.`CATEGORY` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PARTNER_COURSETEMPLATE`
    FOREIGN KEY (`PARTNER_ID` )
    REFERENCES `EduNav`.`PARTNER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_LOCATION_COURSETEMPLATE`
    FOREIGN KEY (`LOCATION_ID` )
    REFERENCES `EduNav`.`LOCATION` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CIRCLE_COURSETEMPLATE`
    FOREIGN KEY (`CIRCLE_ID` )
    REFERENCES `EduNav`.`CIRCLE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ADDRESS_COURSETEMPLATE`
    FOREIGN KEY (`ADDRESS_ID` )
    REFERENCES `EduNav`.`ADDRESS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COURSE` (
  `ID` INT NOT NULL ,
  `COURSE_NAME` VARCHAR(45) NULL ,
  `COURSE_TEMPLATE_ID` INT NOT NULL ,
  `CATEGORY_ID` INT NOT NULL ,
  `LOCATION_ID` INT NOT NULL ,
  `CIRCLE_ID` INT NOT NULL ,
  `PARTNER_ID` INT NOT NULL ,
  `ADDRESS_ID` INT NOT NULL ,
  `PRICE` DOUBLE NULL ,
  `ORIGINAL_PRICE` DOUBLE NULL ,
  `CASHBACK` DOUBLE NULL ,
  `COMMISSION` DOUBLE NULL ,
  `SERVICE_CHARGE` DOUBLE NULL ,
  `STATUS` INT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  `COURSE_HOUR_LENGTH` INT NULL ,
  `TEACHING_METHOD` VARCHAR(100) NULL ,
  `TEACHING_MATERIAL_FEE` VARCHAR(100) NULL ,
  `DOWNLOAD_MATERIALS` VARCHAR(100) NULL ,
  `BONUS_SERVICE` VARCHAR(100) NULL ,
  `MARKING` VARCHAR(100) NULL ,
  `ASSIGNMENTS` VARCHAR(100) NULL ,
  `TRAIL` VARCHAR(100) NULL ,
  `QUESTION_SESSION` VARCHAR(100) NULL ,
  `TEACHING_AND_EXERCISE` VARCHAR(100) NULL ,
  `CLASS_TEACHER` VARCHAR(100) NULL ,
  `GOAL` VARCHAR(400) NULL ,
  `OUTLINE` VARCHAR(400) NULL ,
  `REG_PHONE` VARCHAR(100) NULL ,
  `CONTACT` VARCHAR(100) NULL ,
  `EXTRACURRICULAR` VARCHAR(100) NULL ,
  `PASS_AGREEMENT` VARCHAR(100) NULL ,
  `QUALITY_ASSURANCE` VARCHAR(100) NULL ,
  `QUESTION_BANK` VARCHAR(100) NULL ,
  `TEACHING_MATERIAL_INTRO` VARCHAR(100) NULL ,
  `STUDY_DAY_NOTE` VARCHAR(100) NULL ,
  `HIGH_SCORE_REWARD` VARCHAR(100) NULL ,
  `PREREQUEST` VARCHAR(100) NULL ,
  `SUITABLE_STUDENT` VARCHAR(100) NULL ,
  `OPEN_COURSE_REQUIREMENT` VARCHAR(100) NULL ,
  `CERTIFICATION` VARCHAR(100) NULL ,
  `QUIZ` VARCHAR(100) NULL ,
  `COURSE_INTRO` VARCHAR(100) NULL ,
  `REFERENCE` VARCHAR(45) NULL ,
  `REG_LOCATION` VARCHAR(100) NULL ,
  `FINISH_TIME2` INT NULL ,
  `START_TIME2` INT NULL ,
  `FINISH_TIME1` INT NULL ,
  `START_TIME1` INT NULL ,
  `START_UPON_ARRIVAL` INT NULL ,
  `BOOKING_TYPE` INT NULL ,
  `CASHBACK_DATE` DATETIME NULL ,
  `NO_REFUND_DATE` DATETIME NULL ,
  `CUTOFF_DATE` DATETIME NULL ,
  `FINISH_DATE` DATETIME NULL ,
  `START_DATE` DATETIME NULL ,
  `POPULARITY` INT NULL ,
  `COURSE_HOUR_NUM` INT NULL ,
  `CLASS_SIZE` VARCHAR(100) NULL ,
  `CLASS_TYPE` INT NULL ,
  `DISCOUNT` DOUBLE NULL ,
  `SCHOOLTIMEDAY` INT NULL ,
  `SCHOOLTIMEWEEK` INT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_COURSETEMPLATE_COURSE_idx` (`COURSE_TEMPLATE_ID` ASC) ,
  INDEX `FK_CATEGORY_COURSE_idx` (`CATEGORY_ID` ASC) ,
  INDEX `FK_PARTNER_COURSE_idx` (`PARTNER_ID` ASC) ,
  INDEX `FK_LOCATION_COURSE_idx` (`LOCATION_ID` ASC) ,
  INDEX `FK_CIRCLE_COURSE_idx` (`CIRCLE_ID` ASC) ,
  INDEX `FK_ADDRESS_COURSE_idx` (`ADDRESS_ID` ASC) ,
  CONSTRAINT `FK_COURSETEMPLATE_COURSE`
    FOREIGN KEY (`COURSE_TEMPLATE_ID` )
    REFERENCES `EduNav`.`COURSE_TEMPLATE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CATEGORY_COURSE`
    FOREIGN KEY (`CATEGORY_ID` )
    REFERENCES `EduNav`.`CATEGORY` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PARTNER_COURSE`
    FOREIGN KEY (`PARTNER_ID` )
    REFERENCES `EduNav`.`PARTNER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_LOCATION_COURSE`
    FOREIGN KEY (`LOCATION_ID` )
    REFERENCES `EduNav`.`LOCATION` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CIRCLE_COURSE`
    FOREIGN KEY (`CIRCLE_ID` )
    REFERENCES `EduNav`.`CIRCLE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ADDRESS_COURSE`
    FOREIGN KEY (`ADDRESS_ID` )
    REFERENCES `EduNav`.`ADDRESS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_COMMENT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COURSE_COMMENT` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_ID` INT NOT NULL ,
  `COURSE_TEMPLATE_ID` INT NOT NULL ,
  `TITLE` VARCHAR(45) NULL ,
  `CONTENT` VARCHAR(200) NULL ,
  `TOTAL_RATING` DOUBLE NULL ,
  `CONDITION_RATING` DOUBLE NULL ,
  `ATTITUDE_RATING` DOUBLE NULL ,
  `SATISFACTION_RATING` DOUBLE NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_COURSECOMMENT_idx` (`USER_ID` ASC) ,
  INDEX `FK_COURSETEMPLATE_COURSECOMMENT_idx` (`COURSE_TEMPLATE_ID` ASC) ,
  CONSTRAINT `FK_USERS_COURSECOMMENT`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSETEMPLATE_COURSECOMMENT`
    FOREIGN KEY (`COURSE_TEMPLATE_ID` )
    REFERENCES `EduNav`.`COURSE_TEMPLATE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`APPROVE_HISTORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`APPROVE_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `TYPE` INT NOT NULL ,
  `ATTACHED_ID` INT NOT NULL ,
  `SUBMIT_USER_ID` INT NULL ,
  `APPROVE_USER_ID` INT NULL ,
  `PRE_STATUS` INT NULL ,
  `POST_STATUS` INT NULL ,
  `COMMENT` VARCHAR(100) NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_APPROVEHISTORY_SUBMIT_idx` (`SUBMIT_USER_ID` ASC) ,
  INDEX `FK_USERS_APPROVEHISTORY_APPROVE_idx` (`APPROVE_USER_ID` ASC) ,
  CONSTRAINT `FK_USERS_APPROVEHISTORY_SUBMIT`
    FOREIGN KEY (`SUBMIT_USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_USERS_APPROVEHISTORY_APPROVE`
    FOREIGN KEY (`APPROVE_USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`BOOKING`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`BOOKING` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_ID` INT NOT NULL ,
  `COURSE_ID` INT NOT NULL ,
  `COURSE_TEMPLATE_ID` INT NOT NULL ,
  `REFERENCE` VARCHAR(45) NULL ,
  `NAME` VARCHAR(45) NULL ,
  `PHONE` VARCHAR(45) NULL ,
  `EMAIL` VARCHAR(100) NULL ,
  `STATUS` INT NULL ,
  `SCHEDULED_TIME` DATETIME NULL ,
  `NO_REFUND_DATE` DATETIME NULL ,
  `CASHBACK_DATE` DATETIME NULL ,
  `TYPE` INT NULL ,
  `NOTE` VARCHAR(100) NULL ,
  `CASHBACK_AMOUNT` DOUBLE NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_BOOKING_idx` (`USER_ID` ASC) ,
  INDEX `FK_COURSE_BOOKING_idx` (`COURSE_ID` ASC) ,
  INDEX `FK_COURSETEMPLATE_BOOKING_idx` (`COURSE_TEMPLATE_ID` ASC) ,
  CONSTRAINT `FK_USERS_BOOKING`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSE_BOOKING`
    FOREIGN KEY (`COURSE_ID` )
    REFERENCES `EduNav`.`COURSE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSETEMPLATE_BOOKING`
    FOREIGN KEY (`COURSE_TEMPLATE_ID` )
    REFERENCES `EduNav`.`COURSE_TEMPLATE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`COUPON`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COUPON` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `CODE` VARCHAR(45) NULL ,
  `TOTAL` DOUBLE NULL ,
  `BALANCE` DOUBLE NULL ,
  `ORIGIN` INT NULL ,
  `EXPIRY_TIME` DATETIME NOT NULL ,
  `REMARK` VARCHAR(100) NULL ,
  `USER_ID` INT NOT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_COUNPON_idx` (`USER_ID` ASC) ,
  CONSTRAINT `FK_USERS_COUNPON`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`COUPON_HISTORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COUPON_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `COUPON_ID` INT NOT NULL ,
  `CHARGE` DOUBLE NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_COUNPON_COUNPONHISTORY_idx` (`COUPON_ID` ASC) ,
  CONSTRAINT `FK_COUPON_COUPONHISTORY`
    FOREIGN KEY (`COUPON_ID` )
    REFERENCES `EduNav`.`COUPON` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '<double-click to overwrite multiple objects>';


-- -----------------------------------------------------
-- Table `EduNav`.`CREDIT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`CREDIT` (
  `ID` INT NOT NULL ,
  `CREDIT` DOUBLE NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  INDEX `FK_USERS_CREDIT_idx` (`ID` ASC) ,
  CONSTRAINT `FK_USERS_CREDIT`
    FOREIGN KEY (`ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`CREDIT_HISTORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`CREDIT_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `CHARGE` DOUBLE NULL ,
  `USER_ID` INT NOT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_CREDITHOSTORY_idx` (`USER_ID` ASC) ,
  CONSTRAINT `FK_USERS_CREDITHOSTORY`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ACCOUNT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`ACCOUNT` (
  `ID` INT NOT NULL ,
  `BALANCE` DOUBLE NULL ,
  `REAL_NAME` VARCHAR(45) NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  CONSTRAINT `FK_USERS_ACCOUNT`
    FOREIGN KEY (`ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`WITHDRAW`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`WITHDRAW` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_ID` INT NOT NULL ,
  `PAYEE_ID` VARCHAR(100) NULL ,
  `PEYEE_NAME` VARCHAR(45) NULL ,
  `TYPE` INT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_WITHDRAW_idx` (`USER_ID` ASC) ,
  CONSTRAINT `FK_USERS_WITHDRAW`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ACCOUNT_HISTORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`ACCOUNT_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_ID` INT NOT NULL ,
  `WITHDRAW_ID` INT NULL ,
  `CHARGE` DOUBLE NULL ,
  `TYPE` INT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `REMARK` VARCHAR(100) NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_ACCOUNTHISTORY_idx` (`USER_ID` ASC) ,
  INDEX `FK_WITHDRAW_ACCOUNTHISTORY_idx` (`WITHDRAW_ID` ASC) ,
  CONSTRAINT `FK_USERS_ACCOUNTHISTORY`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_WITHDRAW_ACCOUNTHISTORY`
    FOREIGN KEY (`WITHDRAW_ID` )
    REFERENCES `EduNav`.`WITHDRAW` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`SPREAD`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`SPREAD` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_ID` INT NULL ,
  `PARTNER_ID` INT NULL ,
  `COURSE_ID` INT NULL ,
  `URL` VARCHAR(200) NULL ,
  `REMARK` VARCHAR(100) NULL ,
  `STATUS` INT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_SPREAD_idx` (`USER_ID` ASC) ,
  INDEX `FK_PARTNER_SPREAD_idx` (`PARTNER_ID` ASC) ,
  INDEX `FK_COURSE_SPREAD_idx` (`COURSE_ID` ASC) ,
  CONSTRAINT `FK_USERS_SPREAD`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PARTNER_SPREAD`
    FOREIGN KEY (`PARTNER_ID` )
    REFERENCES `EduNav`.`PARTNER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSE_SPREAD`
    FOREIGN KEY (`COURSE_ID` )
    REFERENCES `EduNav`.`COURSE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`TEACHER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`TEACHER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `PARTNER_ID` INT NOT NULL ,
  `IMG_URL` VARCHAR(100) NULL ,
  `NAME` VARCHAR(45) NULL ,
  `INTRO` VARCHAR(200) NULL ,
  `POPULARITY` INT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_TEACHER_idx` (`PARTNER_ID` ASC) ,
  CONSTRAINT `FK_PARTNER_TEACHER`
    FOREIGN KEY (`PARTNER_ID` )
    REFERENCES `EduNav`.`PARTNER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_TEACHER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COURSE_TEACHER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `COURSE_ID` INT NOT NULL ,
  `TEACHER_ID` INT NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_COURSE_COURSETEACHER_idx` (`COURSE_ID` ASC) ,
  INDEX `FK_TEACHER_COURSETEACHER_idx` (`TEACHER_ID` ASC) ,
  CONSTRAINT `FK_COURSE_COURSETEACHER`
    FOREIGN KEY (`COURSE_ID` )
    REFERENCES `EduNav`.`COURSE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TEACHER_COURSETEACHER`
    FOREIGN KEY (`TEACHER_ID` )
    REFERENCES `EduNav`.`TEACHER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ACTIVITY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`ACTIVITY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NULL ,
  `PARTNER_ID` INT NULL ,
  `COURSE_ID` INT NULL ,
  `REMARK` VARCHAR(100) NULL ,
  `START_TIME` DATETIME NULL ,
  `END_TIME` DATETIME NULL ,
  `STATUS` INT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_PARTNER_ACTIVITY_idx` (`PARTNER_ID` ASC) ,
  INDEX `FK_COURSE_ACTIVITY_idx` (`COURSE_ID` ASC) ,
  CONSTRAINT `FK_PARTNER_ACTIVITY`
    FOREIGN KEY (`PARTNER_ID` )
    REFERENCES `EduNav`.`PARTNER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSE_ACTIVITY`
    FOREIGN KEY (`COURSE_ID` )
    REFERENCES `EduNav`.`COURSE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`MESSAGE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`MESSAGE` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `MESSAGE_TEXT` VARCHAR(45) NULL ,
  `USER_FROM_ID` INT NOT NULL ,
  `USER_TO_ID` INT NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_FROM_MESSAGE_idx` (`USER_FROM_ID` ASC) ,
  INDEX `FK_USERS_TO_MESSAGE_idx` (`USER_TO_ID` ASC) ,
  CONSTRAINT `FK_USERS_FROM_MESSAGE`
    FOREIGN KEY (`USER_FROM_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_USERS_TO_MESSAGE`
    FOREIGN KEY (`USER_TO_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_TEMPLATE_TEACHER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COURSE_TEMPLATE_TEACHER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `COURSE_TEMPLATE_ID` INT NOT NULL ,
  `TEACHER_ID` INT NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_COURSETEMPALTE_COURSETEMPLATETEACHER_idx` (`COURSE_TEMPLATE_ID` ASC) ,
  INDEX `FK_TEACHER_COURSETEMPLATETEACHER_idx` (`TEACHER_ID` ASC) ,
  CONSTRAINT `FK_COURSETEMPALTE_COURSETEMPLATETEACHER`
    FOREIGN KEY (`COURSE_TEMPLATE_ID` )
    REFERENCES `EduNav`.`COURSE_TEMPLATE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TEACHER_COURSETEMPLATETEACHER`
    FOREIGN KEY (`TEACHER_ID` )
    REFERENCES `EduNav`.`TEACHER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`CLASS_PHOTO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`CLASS_PHOTO` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `PARTNER_ID` INT NOT NULL ,
  `IMG_URL` VARCHAR(100) NULL ,
  `TITLE` VARCHAR(45) NULL ,
  `DESCRIPTION` VARCHAR(200) NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_PARTNER_CLASSPHOTO_idx` (`PARTNER_ID` ASC) ,
  CONSTRAINT `FK_PARTNER_CLASSPHOTO`
    FOREIGN KEY (`PARTNER_ID` )
    REFERENCES `EduNav`.`PARTNER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_CLASS_PHOTO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COURSE_CLASS_PHOTO` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `COURSE_ID` INT NOT NULL ,
  `CLASS_PHOTO_ID` INT NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_COURSE_COURSECLASSPHOTO_idx` (`COURSE_ID` ASC) ,
  INDEX `FK_CLASSPHOTO_COURSECLASSPHOTO_idx` (`CLASS_PHOTO_ID` ASC) ,
  CONSTRAINT `FK_COURSE_COURSECLASSPHOTO`
    FOREIGN KEY (`COURSE_ID` )
    REFERENCES `EduNav`.`COURSE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CLASSPHOTO_COURSECLASSPHOTO`
    FOREIGN KEY (`CLASS_PHOTO_ID` )
    REFERENCES `EduNav`.`CLASS_PHOTO` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`COURSE_TEMPLATE_CLASS_PHOTO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`COURSE_TEMPLATE_CLASS_PHOTO` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `COURSE_TEMPLATE_ID` INT NOT NULL ,
  `CLASS_PHOTO_ID` INT NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_COURSETEMPLATE_COURSETEMPLATECLASSPHOTO_idx` (`COURSE_TEMPLATE_ID` ASC) ,
  INDEX `FK_CLASSPHOTO_COURSETEMPLATECLASSPHOTO_idx` (`CLASS_PHOTO_ID` ASC) ,
  CONSTRAINT `FK_COURSETEMPLATE_COURSETEMPLATECLASSPHOTO`
    FOREIGN KEY (`COURSE_TEMPLATE_ID` )
    REFERENCES `EduNav`.`COURSE_TEMPLATE` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CLASSPHOTO_COURSETEMPLATECLASSPHOTO`
    FOREIGN KEY (`CLASS_PHOTO_ID` )
    REFERENCES `EduNav`.`CLASS_PHOTO` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`USER_LOCATION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`USER_LOCATION` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_ID` INT NOT NULL ,
  `LOCATION_ID` INT NOT NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_USERLOCATION_idx` (`USER_ID` ASC) ,
  INDEX `FK_LOCATION_USERLOCATION_idx` (`LOCATION_ID` ASC) ,
  CONSTRAINT `FK_USERS_USERLOCATION`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_LOCATION_USERLOCATION`
    FOREIGN KEY (`LOCATION_ID` )
    REFERENCES `EduNav`.`LOCATION` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`BOOKING_HISTORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`BOOKING_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `BOOKING_ID` INT NOT NULL ,
  `USER_ID` INT NOT NULL ,
  `OPT_NAME` INT NULL ,
  `REMARK` VARCHAR(100) NULL ,
  `PRE_STATUS` INT NOT NULL ,
  `POST_STATUS` INT NOT NULL ,
  `NORMAL` INT NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_BOOKINGHISTORY_idx` (`USER_ID` ASC) ,
  INDEX `FK_BOOKING_BOOKINGHISTORY_idx` (`BOOKING_ID` ASC) ,
  CONSTRAINT `FK_BOOKING_BOOKINGHISTORY`
    FOREIGN KEY (`BOOKING_ID` )
    REFERENCES `EduNav`.`BOOKING` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_USERS_BOOKINGHISTORY`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ORDER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`ORDER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `BOOKING_ID` INT NULL ,
  `CREATE_TIME` DATETIME NULL ,
  `TYPE` VARCHAR(45) NULL ,
  `PRICE` DOUBLE NULL ,
  `RUNING_NUMBER` VARCHAR(45) NULL ,
  `STATUS` VARCHAR(45) NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_BOOKING_ORDER_idx` (`BOOKING_ID` ASC) ,
  CONSTRAINT `FK_BOOKING_ORDER`
    FOREIGN KEY (`BOOKING_ID` )
    REFERENCES `EduNav`.`BOOKING` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`ORDER_HISTORY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`ORDER_HISTORY` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `ORDER_ID` INT NOT NULL ,
  `USER_ID` INT NOT NULL ,
  `OPT_NAME` INT NULL ,
  `REMARK` VARCHAR(100) NULL ,
  `PRE_STATUS` INT NOT NULL ,
  `POST_STATUS` INT NOT NULL ,
  `NORMAL` INT NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `ENABLED` INT NOT NULL ,
  `DELETED` INT NOT NULL ,
  INDEX `FK_ORDER_ORDERHISTORY_idx` (`ORDER_ID` ASC) ,
  INDEX `FK_USERS_ORDERHISTORY_idx` (`USER_ID` ASC) ,
  PRIMARY KEY (`ID`) ,
  CONSTRAINT `FK_ORDER_ORDERHISTORY`
    FOREIGN KEY (`ORDER_ID` )
    REFERENCES `EduNav`.`ORDER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_USERS_ORDERHISTORY`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `EduNav`.`CONTACT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `EduNav`.`CONTACT` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `USER_ID` INT NOT NULL ,
  `NAME` VARCHAR(45) NULL ,
  `PHONE` VARCHAR(45) NULL ,
  `EMAIL` VARCHAR(100) NULL ,
  `LAST_MODIFY_TIME` DATETIME NOT NULL ,
  `CREATE_TIME` DATETIME NOT NULL ,
  `DELETED` INT NOT NULL ,
  `ENABLED` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_USERS_CONTACT_idx` (`USER_ID` ASC) ,
  CONSTRAINT `FK_USERS_CONTACT`
    FOREIGN KEY (`USER_ID` )
    REFERENCES `EduNav`.`USERS` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `EduNav` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
