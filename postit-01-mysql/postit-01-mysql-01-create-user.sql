CREATE USER IF NOT EXISTS 'ilazardemo'@'localhost' 
	IDENTIFIED WITH caching_sha2_password BY 'ilazardemo';

GRANT ALL PRIVILEGES ON * . * TO 'ilazardemo'@'localhost';