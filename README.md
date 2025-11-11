# PSP_ActEva3_Ev1

## 🍽️ Simulador de Cocina Multihilo (Java y Python)

Este proyecto simula el funcionamiento de la cocina de un restaurante, donde varios **cocineros** (hilos) preparan **pedidos** de manera concurrente.  
El objetivo es practicar la **programación concurrente** y la **sincronización de hilos** en dos lenguajes distintos: **Java** y **Python**.

---

## 🧠 Descripción del proyecto

Cada cocinero toma un pedido de una lista compartida, lo prepara (simulado con un retardo de tiempo) y registra la operación en un archivo de log.  
La sincronización garantiza que **solo un hilo acceda al recurso compartido** (lista de pedidos o archivo de registro) en cada momento, evitando conflictos o corrupción de datos.

El comportamiento del programa es equivalente tanto en Java como en Python.

---

## 🗂️ Estructura del repositorio
├── java/
│ ├── cocina.java
│ ├── cocinero.java
│ └── pedido.java
└── python/
  ├── cocina.py
  ├── cocinero.py
  └── pedido.py

- **cocina / cocina.py** → Archivo principal. Crea los hilos (cocineros), genera los pedidos y coordina la ejecución.  
- **cocinero / cocinero.py** → Define la clase que representa a un cocinero (hilo).  
- **pedido / pedido.py** → Define la estructura de un pedido (nombre, tiempo de preparación, etc.).

---

## ⚙️ Tecnologías utilizadas

- **Java 17+**  
  - Uso de `Thread`, `synchronized` y bloqueos de objetos.  
- **Python 3.10+**  
  - Uso del módulo `threading` y `Lock` para sincronización.

---

## ▶️ Ejecución del proyecto

### En **Java**
1. Abre la carpeta `java/`.
2. Compila los archivos:
   ```bash
   javac *.java
3. Ejecuta el programa principal:
   java cocina

### En **Python**
1. Se genera una lista de pedidos.
2. Se crean varios hilos (cocineros), cada uno toma pedidos disponibles.
3. Cada cocinero:
   - Prepara un pedido (usando sleep para simular el tiempo de cocción).
   - Registra el resultado en un archivo de log (por ejemplo: log_pedidos.txt).
4. El proceso termina cuando todos los pedidos han sido preparados.

## Autores

Proyecto desarrollado por Gonzalo "Maroto" Bravo, para la asignatura de Programación de Servicios y Procesos (PSP).
