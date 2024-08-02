DROP DATABASE IF EXISTS ecommerce;
CREATE DATABASE ecommerce;
USE ecommerce;

CREATE TABLE gama_producto(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT NULL,
    imagen VARCHAR(256) NULL,
    CONSTRAINT PK_gama_producto PRIMARY KEY (id)
)ENGINE = InnoDB;

CREATE TABLE estado(
    id INT AUTO_INCREMENT NOT NULL,
    nombre_estado VARCHAR(20) NOT NULL,
    CONSTRAINT PK_estado PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE metodo_pago(
    id INT AUTO_INCREMENT NOT NULL,
    nombre_metodo VARCHAR(15),
    CONSTRAINT PK_metodo_pago PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE ciudad(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    codigo_region INT(10) NOT NULL,
    CONSTRAINT PK_ciudad PRIMARY KEY (id)
)ENGINE = InnoDB;

CREATE TABLE direccion(
    id INT AUTO_INCREMENT NOT NULL,
    linea_direccion1 VARCHAR(50) NOT NULL,
    linea_direccion2 VARCHAR(50) NULL,
    codigo_ciudad_d INT(10) NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_direccion_ciudad FOREIGN KEY (codigo_ciudad_d) REFERENCES ciudad(id)
)ENGINE = InnoDB;

CREATE TABLE oficina(
    id INT AUTO_INCREMENT NOT NULL,
    codigo_direccion_o INT(10) NOT NULL,
    CONSTRAINT PK_oficina PRIMARY KEY (id),
    CONSTRAINT FK_oficina_direccion FOREIGN KEY (codigo_direccion_o) REFERENCES direccion(id)
)ENGINE = InnoDB;

CREATE TABLE empleado(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido1 VARCHAR(50) NOT NULL,
    apellido2 VARCHAR(50) NULL,
    email VARCHAR(100) NOT NULL,
    codigo_oficina INT(10) NULL,
    CONSTRAINT PK_emplado PRIMARY KEY(id),
    CONSTRAINT PK_empleado_oficina FOREIGN KEY (codigo_oficina) REFERENCES oficina(id)
)ENGINE = InnoDB;

CREATE TABLE cliente(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    primer_apellido VARCHAR(30),
    segundo_apellido VARCHAR(30),
    email VARCHAR(50),
    codigo_ciudad_c INT(10) NOT NULL,
    codigo_direccion_c INT(10) NOT NULL,
    codigo_empleado_rep_ventas INT(10) NULL,
    CONSTRAINT PK_cliente PRIMARY KEY(id),
    CONSTRAINT FK_cliente_ciudad FOREIGN KEY (codigo_ciudad_c) REFERENCES ciudad(id),
    CONSTRAINT FK_cliente_direccion FOREIGN KEY (codigo_direccion_c) REFERENCES direccion(id),
    CONSTRAINT FK_cliente_empleado_rep FOREIGN KEY (codigo_empleado_rep_ventas) REFERENCES empleado(id)
)ENGINE = InnoDB;

CREATE TABLE telefono (
  id INT AUTO_INCREMENT NOT NULL,
  numero BIGINT NOT NULL,
  codigo_cliente_te INT(10) NULL,
  codigo_oficina_te INT(10) NULL,
  CONSTRAINT PK_telefono PRIMARY KEY (id),
  CONSTRAINT FK_telefono_cliente FOREIGN KEY (codigo_cliente_te) REFERENCES cliente(id),
  CONSTRAINT FK_telefono_oficina FOREIGN KEY (codigo_oficina_te) REFERENCES oficina(id)
)ENGINE = InnoDB;

CREATE TABLE pago(
    id INT AUTO_INCREMENT NOT NULL,
    fecha_pago DATE NOT NULL,
    total DOUBLE NOT NULL,
    codigo_metodo_pago INT(10) NOT NULL,
    codigo_cliente_pa INT(10) NOT NULL,
    CONSTRAINT PK_pago PRIMARY KEY (id),
    CONSTRAINT FK_pago_metodoPago FOREIGN KEY (codigo_metodo_pago) REFERENCES metodo_pago(id),
    CONSTRAINT FK_pago_cliente FOREIGN KEY (codigo_cliente_pa) REFERENCES cliente(id)
)ENGINE = InnoDB;

CREATE TABLE pedido(
    id INT AUTO_INCREMENT NOT NULL,
    fecha_pedido DATE NOT NULL,
    fecha_esperado DATE NOT NULL,
    fecha_entrega DATE NULL,
    comentario TEXT NULL,
    codigo_client_pedido INT(10) NOT NULL,
    codigo_estado_pedido INT(10) NOT NULL,
    CONSTRAINT PK_pedido PRIMARY KEY(id),
    CONSTRAINT FK_pedido_cliente FOREIGN KEY (codigo_client_pedido) REFERENCES cliente(id),
    CONSTRAINT FK_pedido_estado FOREIGN KEY (codigo_estado_pedido) REFERENCES estado(id)
)ENGINE = InnoDB;

CREATE TABLE producto(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(70) NOT NULL,
    cantidad_stock TINYINT NOT NULL,
    precio_venta DOUBLE NOT NULL,
    precio_proveedor DOUBLE NOT NULL,
    descripcion_producto TEXT NULL,
    codigo_gama INT(10) NOT NULL,
    dimension VARCHAR(255) NULL,
    CONSTRAINT PK_producto PRIMARY KEY (id),
    CONSTRAINT FK_producto_gama FOREIGN KEY (codigo_gama) REFERENCES gama_producto(id)
)ENGINE = InnoDB;

CREATE TABLE detalle_pedido(
    id_producto_pedido INT NOT NULL,
    id_pedido_producto INT NOT NULL,
    cantidad SMALLINT NOT NULL,
    precio_unidad DOUBLE NULL,
    numero_linea SMALLINT NULL,
    PRIMARY KEY (id_producto_pedido, id_pedido_producto),
    CONSTRAINT FK_producto_pedido FOREIGN KEY (id_producto_pedido) REFERENCES producto(id),
    CONSTRAINT FK_pedido_producto FOREIGN KEY (id_pedido_producto) REFERENCES pedido(id)
)ENGINE = InnoDB;

