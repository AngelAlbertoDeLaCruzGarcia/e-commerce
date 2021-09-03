CREATE TABLE tblusuarios(
vchuser VARCHAR(20) NOT NULL,
vchpassword VARCHAR(20) NOT NULL
);
INSERT INTO tblusuarios VALUES('Angel','123');
CREATE TABLE tblproductos(
intidprod INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
vchnombre VARCHAR(20) NULL,
vchimg VARCHAR(50) NULL,
fltprecio FLOAT NULL,
intexistencia INT NULL
);
