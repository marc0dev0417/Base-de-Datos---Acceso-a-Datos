/* Create New Database In MySQL */
CREATE DATABASE tutorialDb;

/* Use The Newly Created Database To Create A Table */
USE tutorialDb;

/* Create Table In MySQL */
CREATE TABLE technical_editors (tech_id int(11) NOT NULL AUTO_INCREMENT, tech_username varchar(20) DEFAULT NULL, PRIMARY KEY (tech_id));

/* Insert Data Into Table */
INSERT INTO technical_editors (tech_id, tech_username) VALUES (1, 'Java Code Geek');
INSERT INTO technical_editors (tech_id, tech_username) VALUES (2, 'Harry Potter');

/* Display Table Data */
SELECT * FROM technical_editors;

/* Display Table Structure */
DESC technical_editors;