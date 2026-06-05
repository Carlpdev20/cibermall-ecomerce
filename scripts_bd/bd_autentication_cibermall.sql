DROP DATABASE IF EXISTS bd_cibermall_autentication;
CREATE DATABASE bd_cibermall_autentication;
USE bd_cibermall_autentication;

-- 1. Tabla de Roles (Define los accesos dentro del sistema)
CREATE TABLE TB_ROL (
    ID_ROL INT AUTO_INCREMENT PRIMARY KEY,
    DESCRIPCION CHAR(1) NOT NULL -- 'C' (Cliente), 'V' (Vendedor), 'A' (Administrador)
);

-- 1. CREACIÓN DE TABLAS
CREATE TABLE TB_DISTRITO (
    ID_DISTRITO INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(50) NOT NULL,
    COSTO_ENVIO DECIMAL(8,2) DEFAULT 0
);

-- 2. Tabla de Usuarios (Almacena las credenciales que leerá Security)
CREATE TABLE TB_USUARIO (
    ID_USUARIO INT AUTO_INCREMENT PRIMARY KEY,
    CORREO VARCHAR(50) NOT NULL UNIQUE, -- Funcionará como el "Username" de Spring Security
    CLAVE VARCHAR(255) NOT NULL,        -- Contraseña cifrada (El hash de BCrypt requiere espacio)
    ROL INT NOT NULL,                   -- Vincula al usuario con sus permisos
    ESTADO TINYINT(1) DEFAULT 1,        -- 1 = Activo, 0 = Suspendido (Útil para bloquear accesos)
    
    -- Campos adicionales requeridos por tu negocio para el registro básico
    NOMBRES VARCHAR(50) NOT NULL,
    APE_PATERNO VARCHAR(50) NOT NULL,
    APE_MATERNO VARCHAR(50) NOT NULL,
    NRO_DOC VARCHAR(15) NOT NULL UNIQUE,
    TELEFONO CHAR(9) NOT NULL,
    ID_DISTRITO INT NOT NULL,
    
    CONSTRAINT FK_USUARIO_ROL FOREIGN KEY (ROL) REFERENCES TB_ROL(ID_ROL)
);

USE bd_cibermall_autentication;

-- Insertamos un distrito y un rol de prueba por si acaso
INSERT INTO TB_DISTRITO (NOMBRE) VALUES ('Miraflores') ON DUPLICATE KEY UPDATE ID_DISTRITO=ID_DISTRITO;
INSERT INTO TB_ROL (DESCRIPCION) VALUES ('A') ON DUPLICATE KEY UPDATE ID_ROL=ID_ROL;

-- Insertamos al usuario de pruebas con la clave "clave123" ya cifrada en BCrypt
INSERT INTO TB_USUARIO (NOMBRES, APE_PATERNO, APE_MATERNO, CORREO, CLAVE, NRO_DOC, TELEFONO, ID_DISTRITO, ROL, ESTADO)
VALUES 
('Carlos', 'Pérez', 'Gomez', 'carlos@cibermall.com', '$2a$10$76Y1v41IAtM.fI7I7VpXgeJv6YjI5g1Y7vG7O/yH8GvS6d7GvI6e.', '99999999', '987654321', 1, 1, 1);

USE bd_cibermall_autentication;

UPDATE TB_USUARIO 
SET CLAVE = '$2a$10$9rx3mcRPo2wFgbUL72gvduEDk9H.QpspkaSfKG9WRifFBnE9l4ksG' 
WHERE ID_USUARIO = 1;