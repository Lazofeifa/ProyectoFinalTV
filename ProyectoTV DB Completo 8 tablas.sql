CREATE SCHEMA spectrum ;
use spectrum ;
create user 'usuario_spectrum'@'%' identified by 'spectrum1234';
grant all privileges on spectrum.* to 'usuario_spectrum'@'%';
flush privileges;

CREATE TABLE spectrum.ubicacion (
id_ubicacion INT NOT NULL AUTO_INCREMENT,
pais VARCHAR(200) NOT NULL,
ciudad VARCHAR(200) NOT NULL,
PRIMARY KEY (id_ubicacion)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE spectrum.suscripcion (
  id_suscripcion INT NOT NULL AUTO_INCREMENT,
  tiposus VARCHAR(30) NOT NULL,
  PRIMARY KEY (id_suscripcion))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE spectrum.cliente (
id_cliente INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(30) NOT NULL,
apellidos VARCHAR(30) NOT NULL,
telefono INT NOT NULL,
id_ubicacion INT NOT NULL,
id_suscripcion INT NOT NULL,
foreign key fk_cliente_suscripcion (id_suscripcion) references suscripcion(id_suscripcion),
PRIMARY KEY (id_cliente)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE spectrum.producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(500) NOT NULL,
  precio double NOT NULL,
  PRIMARY KEY (id_producto)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE spectrum.comentario (
id_comentario INT NOT NULL AUTO_INCREMENT,
detalle VARCHAR(1000) NOT NULL,
id_producto INT NOT NULL,
PRIMARY KEY (id_comentario),
foreign key fk_comentario_producto (id_producto) references producto(id_producto)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

INSERT INTO spectrum.ubicacion (id_ubicacion, pais, ciudad) VALUES
(1,'Costa Rica','San Jose'),
(2,'Nicaragua','Managua'),
(3,'Panama','Ciudad de Panama');

INSERT INTO spectrum.suscripcion (id_suscripcion, tiposus) VALUES 
(1,'Regular'), 
(2,'Premium'),
(3,'Ilimitado'),
(4,'Mensual'),
(5,'PayPerView');

INSERT INTO spectrum.cliente (id_cliente, nombre, apellidos, telefono, id_ubicacion, id_suscripcion) VALUES
(1,'Kevin','Alfaro Herrera','45568978',1,1),
(2,'Victor','Torrez Torrez','54568789',2,2),
(3,'Daniel','Castcante Marin','78988936',3,4),
(4,'Juana','Perez Solis','54568789',2,3),
(5,'Albaro','Chaves Roman','78988936',3,5);

INSERT INTO spectrum.producto (id_producto, descripcion, precio) VALUES
(1,'Televisiònn','25540'),
(2,'Mobile','12500'),
(3,'Telefono hogar','5850'),
(4,'Internet','21000');

INSERT INTO spectrum.comentario (id_comentario, detalle, id_producto) VALUES
(1,'MEJORES PRECIOS,AMPLIO CONTENIDO Y ACTUALIZACIONES SEMANALES',1),
(2,'ESTABILIDAD DEL SERVICIO, SIN CONTRATOS y COMPATIBILIDAD CON TODOS MIS DISPOSITIVOS',2);



CREATE TABLE spectrum.usuario(
id_usuario INT NOT NULL AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
password VARCHAR(300) NOT NULL,
correo VARCHAR(30) NOT NULL,
PRIMARY KEY (id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE spectrum.rol(
id_rol INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(30) NOT NULL,
id_usuario INT NOT NULL,
PRIMARY KEY (id_rol),
foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


INSERT INTO spectrum.usuario (id_usuario, username, password, correo) VALUES
(1, 'Kevin', '$2a$10$mDELCA1w1Vf6pfST/MEsIeiFu1vWTo8Prz0FJm7bO8ltWPqWQrm2m','a@a'),
(2, 'Victor', '$2a$10$ONHLv3JaXEKBKK5t4hlccOB4PAX5Ma.ExYJvxx1HzFM571rXUnbea','b@b'),
(3, 'Daniel', '$2a$10$0dRJzEYWnIep/57j8BfMeuKXb5Wk/WExtVoH33BXed.zQhyeIrCeu','c@c');

INSERT INTO spectrum.rol (id_rol, nombre, id_usuario) VALUES
(1,'ROLE_ADMIN',1),
(2,'ROLE_VENDEDOR',2),
(3,'ROLE_USER',3);

