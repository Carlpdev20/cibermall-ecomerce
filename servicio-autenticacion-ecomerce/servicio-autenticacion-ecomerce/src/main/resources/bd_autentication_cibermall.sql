DROP DATABASE IF EXISTS bd_cibermall_autentication;
CREATE DATABASE bd_cibermall_autentication;
USE bd_cibermall_autentication;

CREATE TABLE TB_DISTRITO (
    ID_DISTRITO INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(50) NOT NULL,
    COSTO_ENVIO DECIMAL(8,2) DEFAULT 0
);

CREATE TABLE TB_USUARIO (
    ID_USUARIO INT AUTO_INCREMENT PRIMARY KEY,
    CORREO VARCHAR(50) NOT NULL UNIQUE,
    CLAVE VARCHAR(255) NOT NULL,
    ROL VARCHAR(20) NOT NULL,
    ESTADO INT DEFAULT 1,
    NOMBRES VARCHAR(50) NOT NULL,
    APE_PATERNO VARCHAR(50) NOT NULL,
    APE_MATERNO VARCHAR(50) NOT NULL,
    NRO_DOC VARCHAR(15) NOT NULL UNIQUE,
    TELEFONO VARCHAR(9) NOT NULL,
    DIRECCION VARCHAR(50) DEFAULT NULL,
    ID_DISTRITO INT NOT NULL,
    ULTIMO_ACCESO DATETIME DEFAULT NULL,
    FECHA_ACTUALIZACION DATETIME DEFAULT NULL,
    FECHA_REGISTRO DATETIME DEFAULT NULL,
    FOREIGN KEY (ID_DISTRITO) REFERENCES TB_DISTRITO(ID_DISTRITO)
);

-- Distritos de Lima Metropolitana (43 distritos de la provincia de Lima)
INSERT INTO TB_DISTRITO (NOMBRE, COSTO_ENVIO) VALUES
('Ancón',                       15.00),
('Ate',                          8.00),
('Barranco',                     6.00),
('Breña',                        5.00),
('Carabayllo',                  12.00),
('Chaclacayo',                  13.00),
('Chorrillos',                   7.00),
('Cieneguilla',                 15.00),
('Comas',                       10.00),
('El Agustino',                  7.00),
('Independencia',                8.00),
('Jesús María',                  5.00),
('La Molina',                    8.00),
('La Victoria',                  5.00),
('Lima (Cercado)',                5.00),
('Lince',                        5.00),
('Los Olivos',                   9.00),
('Lurigancho-Chosica',          12.00),
('Lurín',                       15.00),
('Magdalena del Mar',            5.00),
('Magdalena Vieja (Pueblo Libre)',5.00),
('Miraflores',                   6.00),
('Pachacámac',                  15.00),
('Pucusana',                    20.00),
('Puente Piedra',               12.00),
('Punta Hermosa',               20.00),
('Punta Negra',                 20.00),
('Rímac',                        5.00),
('San Bartolo',                 20.00),
('San Borja',                    6.00),
('San Isidro',                   6.00),
('San Juan de Lurigancho',       9.00),
('San Juan de Miraflores',       7.00),
('San Luis',                     5.00),
('San Martín de Porres',         8.00),
('San Miguel',                   5.00),
('Santa Anita',                  7.00),
('Santa María del Mar',         20.00),
('Santa Rosa',                  15.00),
('Santiago de Surco',            7.00),
('Surquillo',                    5.00),
('Villa El Salvador',            9.00),
('Villa María del Triunfo',      9.00);

-- Distritos del Callao (7 distritos) — opcional
INSERT INTO TB_DISTRITO (NOMBRE, COSTO_ENVIO) VALUES
('Bellavista',                  10.00),
('Callao (Cercado)',            10.00),
('Carmen de la Legua-Reynoso',  10.00),
('La Perla',                    10.00),
('La Punta',                    12.00),
('Mi Perú',                     12.00),
('Ventanilla',                  14.00);
