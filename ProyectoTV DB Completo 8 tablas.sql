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

CREATE TABLE spectrum.tipop(
id_tipop INT NOT NULL AUTO_INCREMENT,
tipoperfil VARCHAR(30) NOT NULL,
PRIMARY KEY (id_tipop)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE spectrum.perfil(
id_perfil INT NOT NULL AUTO_INCREMENT,
usuario VARCHAR(30) NOT NULL,
correo VARCHAR(30) NOT NULL,
contrasena VARCHAR(30) NOT NULL,
id_cliente INT NOT NULL,
id_tipop INT NOT NULL,
PRIMARY KEY (id_perfil),
foreign key fk_perfil_cliente (id_cliente) references cliente(id_cliente),
foreign key fk_perfil_tipop (id_tipop) references tipop(id_tipop)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE spectrum.producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(500) NOT NULL,
  detalle VARCHAR(500) NOT NULL,
  precio double NOT NULL,
  PRIMARY KEY (id_producto)
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

CREATE TABLE spectrum.factura (
  id_factura INT NOT NULL AUTO_INCREMENT,
  fecha VARCHAR(50) NOT NULL,  
  total double NOT NULL,
  id_producto INT NOT NULL,
  id_suscripcion INT NOT NULL,
  id_perfil INT NOT NULL,
  PRIMARY KEY (id_factura),
  foreign key fk_factura_producto (id_producto) references producto(id_producto),
  foreign key fk_factura_suscripcion (id_suscripcion) references suscripcion(id_suscripcion),
  foreign key fk_factura_perfil (id_perfil) references perfil(id_perfil)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

CREATE TABLE spectrum.comentario (
id_comentario INT NOT NULL AUTO_INCREMENT,
detalle VARCHAR(1000) NOT NULL,
id_factura INT NOT NULL,
PRIMARY KEY (id_comentario),
foreign key fk_comentario_factura (id_factura) references factura(id_factura)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

cREATE TABLE spectrum.usuario(
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
(1, 'Kevin', '$2a$10$AKRT/w/8Lo/tp5088v2mX.KK0ci9qXb0Y1Q0Si45w57nWdVAvgD7m','a@a'),
(2, 'Victor', '$2a$10$mQ89cdxqd25rfvLZqnjufuU.pW9ayiLGpDU5I/Nw1LooMUnxgYau.','b@b'),
(3, 'Daniel', '$2a$10$ZUDOF7iAJxTkbCV0/JZ7eO9kk1PJOyC1RPFzMPo9zeyIAPOvmFlJe','c@c');

INSERT INTO spectrum.rol (id_rol, nombre, id_usuario) VALUES
(1,'ROLE_ADMIN',1),
(2,'ROLE_VENDEDOR',1),
(3,'ROLE_USER',1),
(4,'ROLE_VENDEDOR',2),
(5,'ROLE_USER',2),
(6,'ROLE_USER',3);

INSERT INTO spectrum.ubicacion (id_ubicacion, pais, ciudad) VALUES
(1,'Costa Rica','San Jose'),
(2,'Nicaragua','Managua'),
(3,'Panama','Ciudad de Panama');

INSERT INTO spectrum.cliente (id_cliente, nombre, apellidos, telefono, id_ubicacion, id_suscripcion) VALUES
(1,'Kevin','Alfaro Herrera','45568978',1,1),
(2,'Victor','Torrez Torrez','54568789',2,2),
(3,'Daniel','Castcante Marin','78988936',3,4),
(4,'Juana','Perez Solis','54568789',2,3),
(5,'Albaro','Chaves Roman','78988936',3,5);

INSERT INTO spectrum.tipop (id_tipop, tipoperfil) VALUES
(1,'administrador'),
(2,'Administrativo'),
(3,'Gerente'),
(4,'cliente'),
(5,'vendedor');
INSERT INTO spectrum.perfil (id_perfil, usuario, correo, contrasena, id_cliente, id_tipop) VALUES
(1, 'Kevin', 'kevin@perfiles.com','K$2021',1,1),
(2, 'Victor', 'victor@perfiles.com','v$2021',2,2),
(3, 'Daniel', 'daniel@perfiles.com','CM%2023',2,2),
(4, 'Juana', 'juana@perfiles.com','IP&192',2,2),
(5, 'Albaro', 'albaro@perfiles.com','alfaM',3,2);

INSERT INTO spectrum.suscripcion (id_suscripcion, tiposus) VALUES 
(1,'Regular'), 
(2,'Premium'),
(3,'Ilimitado'),
(4,'Mensual'),
(5,'PayPerView');

INSERT INTO spectrum.producto (id_producto, descripcion, detalle, precio) VALUES
(1,'Televisiònn','+10.000 CANALES EN VIVO','25540'),
(2,'Mobile','Cobertura satelital','12500'),
(3,'Telefono hogar','Llama a quien quieras con una tarifa plan por mes','5850'),
(4,'Internet','Disfriuta la alta velocidad y descargas ilimitaras,','21000');

INSERT INTO spectrum.factura (id_factura, fecha, total, id_producto, id_suscripcion, id_perfil) VALUES
(1,'2022-01-05',211560,1,2,2),
(2,'2022-01-07',554340,4,2,3);

INSERT INTO spectrum.comentario (id_comentario, detalle, id_factura) VALUES
(1,'MEJORES PRECIOS,AMPLIO CONTENIDO Y ACTUALIZACIONES SEMANALES',1),
(2,'ESTABILIDAD DEL SERVICIO, SIN CONTRATOS y COMPATIBILIDAD CON TODOS MIS DISPOSITIVOS',2);