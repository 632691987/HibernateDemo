use HibernateDemo1;

DROP TABLE IF EXISTS `Student`;

CREATE TABLE `Student`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `age`  INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `name` (`name` ASC) VISIBLE
) ENGINE = InnoDB;
