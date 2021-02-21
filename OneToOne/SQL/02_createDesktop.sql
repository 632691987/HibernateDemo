use HibernateDemo1;

DROP TABLE IF EXISTS `Desktop`;

CREATE TABLE `Desktop`
(
    `id`         INT NOT NULL AUTO_INCREMENT,
    `student_id` INT NOT NULL,
    `deskNo`     INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `index2` (`deskNo` ASC) VISIBLE,
    INDEX `index3` (`student_id` ASC) VISIBLE,
    CONSTRAINT `fk_Desktop_1` FOREIGN KEY (`student_id`) REFERENCES `Student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB;
