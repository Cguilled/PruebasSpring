CREATE TABLE "TAREAS" (
		"ID_TAREA" NUMBER(5, 0) NOT NULL,
		"NOMBRE_TAREA" VARCHAR2(100) NOT NULL,
		"DESCRIPCION_TAREA" VARCHAR2(2000),
		"ESTADO" NUMBER(1, 0) NOT NULL
	);
ALTER TABLE "TAREAS" ADD CONSTRAINT "ID_TAREA_PK" PRIMARY KEY ("ID_TAREA");

CREATE TABLE "USUARIOS" (
		"ID_USUARIO" NUMBER(5, 0) NOT NULL,
		"DAS" VARCHAR2(15) NOT NULL,
		"NOMBRE" VARCHAR2(20) NOT NULL,
		"APELLIDO" VARCHAR2(20) NOT NULL,
		"PASSWORD" VARCHAR2(10) NOT NULL,
		"ESTADO" VARCHAR2(10) NOT NULL,
		"INICIO" VARCHAR2(10) NOT NULL,
		"CODIGO_ROL" NUMBER(2 , 0)
	);
ALTER TABLE "USUARIOS" ADD CONSTRAINT "ID_USUARIO_PK" PRIMARY KEY ("ID_USUARIO");

CREATE TABLE "ROLES" (
		"CODIGO_ROL" NUMBER(2 , 0) NOT NULL,
		"NOMBRE_ROL" VARCHAR2(100) NOT NULL,
		"DESCRIPCION_ROL" VARCHAR2(100)
	);
ALTER TABLE "ROLES" ADD CONSTRAINT "CODIGO_ROL_PK" PRIMARY KEY ("CODIGO_ROL");

CREATE TABLE "ROLES_TAREAS" (
		"CODIGO_ROL" NUMBER(2 , 0) NOT NULL,
		"CODIGO_TAREA" NUMBER(2 , 0) NOT NULL
	);
ALTER TABLE "ROLES_TAREAS" ADD CONSTRAINT "ROLES_TAREAS_PK" PRIMARY KEY ("CODIGO_ROL", "CODIGO_TAREA");


ALTER TABLE "ROLES_TAREAS" ADD CONSTRAINT "CODIGO_TAREA_FK" FOREIGN KEY ("CODIGO_TAREA")
	REFERENCES "TAREAS" ("ID_TAREA");

ALTER TABLE "USUARIOS" ADD CONSTRAINT "CODIGO_ROL_USUARIOS_FK" FOREIGN KEY ("CODIGO_ROL")
	REFERENCES "ROLES" ("CODIGO_ROL");

ALTER TABLE "ROLES_TAREAS" ADD CONSTRAINT "CODIGO_ROL_FK" FOREIGN KEY ("CODIGO_ROL")
	REFERENCES "ROLES" ("CODIGO_ROL");
	
