Para ejecutar este proyecto, asegúrate de tener Maven y Java configurados correctamente en tu máquina. Aquí tienes los pasos detallados:

**Se recomienda el uso de IntelliJ IDEA**

### 1. **Verifica tus herramientas**
- Asegúrate de tener Java y Maven instalados y configurados:
  ```bash
  java -version
  mvn -version
  ```
  
- La versión de Java debe ser compatible con este proyecto Spring, la cual es Java 21 para Spring Boot 3.x.

### 2. **Compila el proyecto**
Desde la raíz del proyecto, ejecuta el siguiente comando para compilar y verificar que no hay errores en el código:
```bash
mvn clean install
```

Esto:
- Limpia el directorio `target`.
- Descarga dependencias necesarias.
- Compila el proyecto.
- Ejecuta pruebas unitarias.

### 3. **Ejecuta la aplicación**
Se puede iniciar con el siguiente comando:
```bash
mvn spring-boot:run
```

Este comando:
- Inicia tu aplicación.
- Carga las configuraciones definidas en `application.properties`.

### 4. **Ejecuta el JAR directamente (opcional)**
Si has generado un archivo JAR (usualmente en el directorio `target`), puedes ejecutarlo directamente con:
```bash
java -jar target/nombre-del-archivo.jar
```

Asegúrate de reemplazar `nombre-del-archivo.jar` con el nombre real de tu archivo JAR generado.

### 5. **Verifica la aplicación**
- Por defecto, la aplicación de esta prueba de Spring Boot está disponible en `http://localhost:8082`.
- Consulta la configuración del archivo `application.properties` si necesitas un puerto diferente.

### Solución de problemas
- **Error de dependencia:** Si encuentras errores relacionados con dependencias, verifica el archivo `pom.xml` y asegúrate de que todas las dependencias necesarias estén importadas.
- **Error de versión de Java:** Asegúrate de que la versión de Java configurada en tu entorno es compatible con la del proyecto (Java 21).
