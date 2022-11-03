CREATE DATABASE HonduSuper;
USE HonduSuper;
CREATE TABLE Proveedor(idProveedor int PRIMARY KEY, nombre VARCHAR(50) not null, direccion VARCHAR(50), 
                       nombreContacto VARCHAR(50), telefono VARCHAR(20), correoElectronico VARCHAR(50));
CREATE TABLE Producto(idProducto int PRIMARY KEY, nombre VARCHAR(50), descripcion VARCHAR(50), precioCompra double,
                       existencia int, precioVenta double);
CREATE TABLE Provee(idProducto int, idProveedor int, PRIMARY KEY(idProducto, idProveedor), 
                    foreign key(idProducto) references Producto(idProducto),
                     foreign key(idProveedor) references Proveedor(idProveedor));	
CREATE TABLE Cliente(idCliente int PRIMARY KEY, nombre VARCHAR(50), direccion VARCHAR(50),telefono VARCHAR(20));
CREATE TABLE Factura(idFactura int PRIMARY KEY, fecha DATE, total double, idCliente int, foreign key (idCliente) references Cliente(idCliente));
CREATE TABLE DetalleFactura(idFactura int, idProducto int, PRIMARY KEY(idFactura, idProducto), 
                          foreign key(idFactura) references Factura(idFactura),
                          foreign key(idProducto) references Producto(idProducto),
						   precio double, cantidad int);
CREATE TABLE Empleado(idEmpleado int PRIMARY KEY, nombre VARCHAR(150), usuario VARCHAR(150),contrasenia VARCHAR(150), rol VARCHAR(45));

SELECT usuario, contrasenia, 1 activo FROM Empleado;
select usuario, rol from Empleado;