# SIVEBO - Sistema de Ventas y Bodega
# PROPUESTA DE PROYECTO

**Sistema POS Integral para Operadores Polifuncionales - RapidinBombin**

Fecha: Abril 2025

## 1\. Definición del Negocio y Problemática

### 1.1 Contexto de la Empresa

RapidinBombin es una empresa de logística con presencia en múltiples sucursales, cuya operación diaria depende de operadores polifuncionales. Estos trabajadores son responsables de ejecutar una amplia variedad de tareas críticas para el funcionamiento del negocio.

### 1.2 Funciones del Operador Polifuncional

- Admisión y recepción de paquetería entrante
- Manejo del inventario de paquetes recepcionados y despachados
- Control del inventario de materiales de embalaje
- Venta de embalaje y servicios adicionales a los clientes
- Gestión de las finanzas de la sucursal (caja, cierre, reportes)

### 1.3 Descripción del Problema

La empresa busca un sistema integrado para los operadores polifuncionales. Debido a la gran cantidad de funciones, la empresa busca que el operador interactúe a través de una única interfaz unificada, rápida y fácil de aprender para atender un alto volumen de clientes. Los problemas actuales incluyen la fragmentación de herramientas, la elevada curva de aprendizaje, la falta de trazabilidad integral y el riesgo de errores financieros.

## 2\. Solución Propuesta

| Solución                                    | Descripción                                                                                                                                                                                                                              | Ventajas                                                                                                  | Desventajas                                                     |
| ------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------- |
| **Sistema POS Integral con Microservicios** | Desarrollo de un sistema web unificado basado en arquitectura de microservicios con Spring Boot. Cada funcionalidad opera como un servicio independiente con su propia base de datos MariaDB, comunicados mediante API REST y WebClient. | Alta escalabilidad. Fácil mantenimiento por módulos. Alineado con directrices académicas de 3er semestre. | Mayor complejidad inicial. Requiere coordinación y API Gateway. |

## 3\. Arquitectura de Microservicios (Solución Recomendada)

El sistema se desarrollará obligatoriamente utilizando **Spring Boot** y estará compuesto por un **API Gateway (Eureka)** para la gestión de peticiones y los siguientes 10 microservicios independientes:

- **MS-01 Auth & Usuarios:** Gestión de login, tokens de sesión, encriptación de contraseñas y roles (Admin, Operador, Cliente).
- **MS-02 Sucursales:** Configuración y administración de la sucursal.
- **MS-03 Admisión de Paquetes:** Registro de ingreso y generación de número de tracking.
- **MS-04 Tracking & Logística:** Control de estados (recibido, en tránsito, entregado).
- **MS-05 Inventario de Paquetes:** Stock de paquetes recepcionados y despachados.
- **MS-06 Inventario de Embalaje:** Control de materiales de embalaje por sucursal.
- **MS-07 Ventas / POS:** Venta de embalaje y servicios, generación de boletas.
- **MS-08 Finanzas:** Apertura y cierre de caja, reportes de ventas y gastos.
- **MS-09 Clientes:** Registro de remitentes y destinatarios.
- **MS-10 Portal Cliente:** Consulta pública de tracking.

## 4\. Desacoplamiento y Principios Técnicos

- **Comunicación:** Interacción mediante **API REST** y consultas de datos utilizando **WebClient**. Los microservicios estarán completamente desacoplados.
- **API Gateway:** Implementación de **Eureka** (u otro equivalente) para el enrutamiento y registro de servicios.
- **Database per Service:** Cada microservicio tendrá su propia base de datos independiente. **No se compartirán tablas ni se duplicarán estructuras.**
- **Motor de Base de Datos:** Se utilizará **MariaDB** en entorno local, garantizando la normalización y modelos relacionales validados.
- **Patrón de Diseño:** Implementación del Patrón **CSR (Controller-Service-Repository)** y uso de **DTOs**.

## 5\. Seguridad Básica

El MS-01 implementará mecanismos de seguridad que incluyen:

- Encriptación de contraseñas antes del almacenamiento en la base de datos.
- Autenticación de usuarios y generación de tokens de sesión (JWT) en el login.
- Validación de accesos según los roles definidos (Admin, Operador, Cliente).

## 6\. Estructura de Datos (Borrador de Entidades Principales)

- **MS-Auth:** Usuario, Rol, Permiso.
- **MS-Sucursales:** Sucursal, Caja.
- **MS-Admisión:** Admision, Etiqueta.
- **MS-Tracking:** Tracking, EstadoLogistico.
- **MS-InvPaquetes:** Paquete, MovimientoPaquete.
- **MS-InvEmbalaje:** ArticuloEmbalaje, MovimientoEmbalaje.
- **MS-Ventas:** Venta, DetalleVenta.
- **MS-Finanzas:** TransaccionFinanciera, CierreCaja.
- **MS-Clientes:** Cliente, Direccion.
- **MS-Portal:** (Consulta de vistas integradas/DTOs desde Tracking).

## 7\. Reglas de Negocio

- **Control de Stock:** No se puede realizar una venta en MS-07 si el MS-06 indica que no hay stock suficiente de embalaje.
- **Generación de Tracking:** Todo paquete admitido en MS-03 debe generar automáticamente un estado inicial en MS-04.
- **Cierre de Caja:** MS-08 debe cuadrar las ventas registradas en MS-07 antes de permitir el cierre de caja diario.
- **Validación de Roles:** Solo un usuario con rol 'Admin' o 'Supervisor' puede anular una venta.

## 8\. Control de Versiones, Pruebas y Despliegue

- **Repositorio:** Uso obligatorio de **GitHub** para evidenciar el avance progresivo, la participación del equipo, el historial de cambios, y el uso de ramas de desarrollo con commits frecuentes.
- **Pruebas y Documentación:** Se desarrollará documentación técnica del sistema y pruebas unitarias de los módulos principales.
- **Despliegue:** Despliegue en entorno local exponiendo los servicios a través del API Gateway, dejando el sistema disponible mediante una URL para el consumo de las APIs.

## 9\. Entidades

**1\. db_ms_auth (Usuarios y Seguridad)**

- **Rol: id_rol (PK), nombre_rol, descripcion.**
- **Usuario: id_usuario (PK), username (UK), password_hash, email (UK), id_rol (FK), id_sucursal_asignada (Ref Ext).**
- **Token_Sesion: id_token (PK), id_usuario (FK), token, fecha_expiracion.**

**2\. db_ms_sucursales (Configuración de Red)**

- **Comuna: id_comuna (PK), nombre_comuna, id_region (FK).**
- **Region: id_region (PK), nombre_region.**
- **Sucursal: id_sucursal (PK), nombre_sucursal, id_comuna (FK), direccion_fisica, telefono_contacto.**

**3\. db_ms_admision (Ingreso de Carga)**

- **Tipo_Carga: id_tipo (PK), nombre_tipo (Ej: Documento, Encomienda).**
- **Admision: id_admision (PK), id_cliente_rem (Ref Ext), id_cliente_dest (Ref Ext), id_sucursal_origen (Ref Ext), id_tipo (FK), peso_kg, fecha_creacion.**

**4\. db_ms_tracking (Logística y Estados)**

- **Estado_Maestro: id_estado (PK), nombre_estado (Ej: Recibido, En Tránsito, Entregado).**
- **Guia_Despacho: id_guia (PK), codigo_tracking (UK), id_admision (Ref Ext).**
- **Historial_Logistico: id_hist (PK), id_guia (FK), id_estado (FK), id_sucursal_actual (Ref Ext), fecha_hora, comentario.**

**5\. db_ms_inv_paquetes (Stock de Envíos en Bodega)**

- **Ubicacion_Bodega: id_ubicacion (PK), id_sucursal (Ref Ext), codigo_estante.**
- **Inventario_Paquete: id_inv (PK), id_guia_tracking (Ref Ext), id_ubicacion (FK), fecha_ingreso_bodega, fecha_salida_bodega (NULL).**

**6\. db_ms_inv_embalaje (Materiales de Venta)**

- **Categoria_Embalaje: id_cat (PK), nombre_categoria (Ej: Cajas, Sobres).**
- **Articulo_Embalaje: id_art (PK), id_cat (FK), nombre, descripcion, precio_vta.**
- **Stock_Sucursal: id_stock (PK), id_art (FK), id_sucursal (Ref Ext), cantidad_disponible.**

**7\. db_ms_ventas (Transacciones POS)**

- **Venta: id_venta (PK), nro_boleta (UK), id_usuario_vta (Ref Ext), id_sucursal (Ref Ext), fecha_vta, subtotal, iva, total.**
- **Detalle_Venta: id_det (PK), id_venta (FK), id_articulo_emb (Ref Ext), cantidad, precio_unit_historico.**

**8\. db_ms_finanzas (Caja y Reportes)**

- **Caja_Sucursal: id_caja (PK), id_sucursal (Ref Ext), estado_actual.**
- **Apertura_Cierre: id_sesion (PK), id_caja (FK), id_usuario (Ref Ext), monto_apertura, monto_cierre, fecha_hora_ap, fecha_hora_ci.**
- **Movimiento_Caja: id_mov (PK), id_sesion (FK), tipo (Ingreso/Egreso), monto, id_referencia_vta (Ref Ext).**

**9\. db_ms_clientes (Base de Datos de Personas)**

- **Tipo_Documento: id_tipo_doc (PK), descripcion (Ej: RUT, Pasaporte).**
- **Cliente: id_cliente (PK), id_tipo_doc (FK), nro_documento (UK), nombre, apellido, email, telefono.**

**10\. db_ms_portal (Consultas Públicas y Feedback)**

- **Consulta_Publica: id_cons (PK), codigo_tracking_consultado, ip_usuario, fecha_hora.**
- **Feedback_Cliente: id_feed (PK), id_guia_tracking (Ref Ext), calificacion (1-5), comentario.**
