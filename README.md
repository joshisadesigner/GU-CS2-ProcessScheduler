# CC2 2023<br />Proyecto #2<br />Process Scheduler

##### Proyecto: Process Scheduler<br />Tema: Pilas, Colas, Herencia y Threads<br />Fecha de Entrega: 19 de noviembre de 2023<br />Grupo: Grupos de tres<br />Calificacion personal: 20 de noviembre de 2023

---

**ATENCION:**
Todos los proyectos consumen tiempo, así que trate de empezar lo más pronto que pueda. No puede trabajar junto a otros compañeros de otro grupo. No puede compartir código con ningún otro estudiante. Si se encuentra código compartido o soluciones iguales, se tomará como copia y se le evaluará con 0.

---

## Process Scheduling

Para este proyecto, implementarán una simulación de un Calendarizador de Procesos, similar a cómo los procesadores atienden a los procesos que solicitan su servicio. La multiprogramación permite que varios procesos utilicen varios recursos del sistema simultáneamente. Esto aumenta el uso de cada recurso (por ejemplo: un proceso utiliza el CPU mientras otro utiliza el disco, ambos recursos están siendo utilizados). Al diseñar un sistema como este, la dificultad surge cuando hay más de un proceso compitiendo por el mismo recurso. Es entonces donde se debe aplicar un algoritmo que decida cuál de los procesos recibirá el servicio primero.

Generalmente, los procesos son todos diferentes y se diferencian por el tipo de tarea que realizan. Se deben tener en cuenta estas características para decidir qué proceso se debe atender primero. A continuación, se explican algunas de las políticas para el proceso de planificación:

- **First-Come First-Served (FCFS):** El proceso que llega primero es el primero en ser atendido.
- **Last-Come First-Served (LCFS):** El proceso que llega último es atendido primero.
- **Priority Policy (PP):** El proceso con mayor prioridad es el primero en ser atendido.
- **Round-Robin (RR):** Se define una unidad de tiempo fija llamada "quantum". Cada proceso se atiende en una forma FCFS durante ese tiempo, y si no alcanza ese tiempo para concluir el requerimiento del proceso, el proceso pasa a la cola para esperar su turno nuevamente. Cuando su tiempo requerido acaba, sale de la cola definitivamente.

## Su proyecto

**En general:**
¿Que es lo que tiene que hacer en su proyecto? Implementar la simulacion de el funcionamiento de un Calendarizador de Procesos. Su calendarizador debe implemetar simulacion para cuatro de las politicas descritas anteriormente:

- First Come First Served
- Last Come First Served
- Round Robin
- Priority Policy

Utilizando solo una cola de atención y una cantidad definida de procesadores.

**Especificaciones:**
La politica en que se manejaran los procesos sera escogida por el usuario al momento de ejecutar el programa. Por cada ejecucion solo se podra correr la simulacion de una politica a la vez (Mas adelante se mostrara como elije el usuario dicha politica). Ya escogida la politica, su programa debe empezar la simulacion de ingreso y atencion de procesos.

Cada proceso debe guardar un numero de id (codigo) y un tiempo de servicio en segundos o milisegundos (como le funcione a ud mejor). Este tiempo esta definido dependiendo el tipo de proceso que sea. En este proyecto manejaremos cuatro tipos de proceso: Aritmetico, de Input/Output, condicional e iterativo. Los tiempos seran definidos al momento de mandar a ejecutar el programa, y seran fijos para todos los procesos del mismo tipo. Ejemplo: Todos los procesos Aritmeticos duran 400 milisegundos, todos los de input/ouput duran 200 milisegundos, y asi sucesivamente.

Los procesos deben ser generados en forma aleatoria, y en tiempos aleatorios. El id de los procesos debe ir incrementando (no es aleatorio) con cada proceso, es decir que el primer proceso tendra id = 1, el segundo id = 2, etc. Su tipo sera aleatorio, es decir que se eligira de forma aleatorea que tipo de proceso es (aritmetico, input/output. etc...). El numero correlativo es compartido entre todos los tipos de proceso, es decir que no hay contadores separados para cada tipo.

Los procesos generados aleatoriamente se posicionaran en una "cola" de servicios, esta "cola" debe ser implementada segun la politica que se haya escogido. Para el caso de Priority Policy se debe tener tres colas diferentes, una para prioridad 1, una para prioridad 2 y otra para prioridad 3. Los procesos se iran metiendo en la cola correspondiente a su prioridad.

Al mismo tiempo que llegan los procesos a la "cola" el "procesador" debe irlos atendiendo, otra vez, dependiendo de la politica que se haya escogido. Cada proceso tiene su tiempo de servicio, y eso es lo que se debe tardar el "procesador" en atenderlos. Como esto es solo una simulacion, el procesador solo tiene que "esperar" los milisegundos que el proceso tardaria en ser atendido, en vez de atenderlo en realidad. Es decir :

Si un proceso n tiene tiempo de `1000` milisegundos entonces su procesador deberia ejecutar un:

```java
Thread.sleep(1000);
```

Después de ser atendido, el proceso se elimina de la "cola" y se atiende el siguiente proceso. En el caso de Priority Policy, la atención de procesos es por prioridad, definida por los tipos de proceso: se atenderán primero los de input/output, luego los aritméticos, después los condicionales y finalmente los iterativos.

**Definición de sus clases:**
La documentacion que se le provee para este proyecto se encuentran en el material de apoyo en el GES con el nombre material-pj2.zip. La documentacion se puede ver desde index.html.

Las clases ya se incluyeron en Replit. Para la definicion de sus clases debe cumplir con lo siguiente:

- En este proyecto, SE DEBE utilizar herencia, clases abstractas e interfaces.
- Debe definir cuatro tipos de proceso: `ArithmeticProcess`, `IOProcess`, `ConditionalProcess` y `LoopProcess`. Se proporciona una clase abstracta `SimpleProcess` para que todos sus tipos de procesos hereden de ella (TIENE que heredar de ella). Las clases que usted defina para esto deben pertenecer al paquete llamado scheduler.processing.
- Tome en cuenta que para la política Round Robin, el proceso debería tener dos tiempos: el tiempo total de procesamiento y el tiempo que le falta para terminar de ser procesado.
- Cada una de las clases que representen una política deben heredar de la clase abstracta `Policy` e implementar la interfaz `Enqueable`, incluidas en las clases proporcionadas para el proyecto. Todas estas deben pertenecer al paquete llamado `policies`, que es un subpaquete del paquete `scheduler.scheduling`. Las clases que las utilicen deben importar este paquete.
- Las clases que defina (que no sean políticas o tipos de proceso) deben pertenecer al paquete `scheduler`, no estar metidas en un subpaquete de él.Ejemplo: procesador y generador de procesos.
- DEBE utilizar pilas y colas para guardar los procesos. NO puede utilizar arreglos o ArrayList.
- Las clases como estructuras de datos que se le permiten utilizar son: [ConcurrentLinkedQueue](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ConcurrentLinkedQueue.html) como cola, [Stack](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Stack.html) como pila y [LinkedList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedList.html) como lista encadenada, proporcionadas en Java. La estructura de LinkedList solo puede ser utilizada en una política, no más. NO puede utilizar estructuras de datos hechas por usted.
- NO puede utilizar Menus para la ejecucion de politicas.
- La clase principal: `ProcessScheduler` no debe pertenecer a ningun paquete.
- TODAS sus clases deben ir comentariadas de la siguiente forma:

  - En la primera linea debe llevar siempre el nombre del archivo

  ```java
  /* Proceso.java */
  ```

  - En la parte de arriba deben llevar nombre del implementador, seccion y carnet

  ```java
  /**
   ** Hecho por: Juan Perez
   ** Carnet: 14007891
   ** Seccion: A
   **/
  ```

  - Despues debe llevar una breve descripcion de para que sirve la clase.
  - Cada uno de los metodos debe llevar un comentario antes de la declaracion en donde diga como se llama el metodo, que parametros recibe y que devuelve al final y para que sirve.

---

## Presentación

Recuerde que usted debe seguir TODAS las especificaciones del proyecto para que no se le bajen puntos en su calificacion total del mismo. He aqui entonces las especificaciones para su presentacion:

- Su programa se debe poder mandar a ejecutar de las siguientes formas (note que es desde la consola de comandos)

  ```java
  java ProcessScheduler -politica(en minusculas) rango_tiempo_ingreso arith io cond loop
  ```

  o

  ```java
  java ProcessScheduler -dual -politica(en minusculas) rango_tiempo_ingreso arith io cond loop
  ```

  En la bandera `-politica` debe ir `-fcfs` para FIRST COME FIRST SERVED, `-lcfs` para LAST COME FIRST SERVED `-rr` para ROUND ROBIN, y `-pp` para PRIORITY POLICY.

  La bandera `-dual` significa que su calendarizador correra con dos procesadores.

  Con respecto a los tiempos: `rango_tiempo_ingreso` es el rango de tiempos dentro del cual se elije aleatoriamente el tiempo en el que se va a ingresar un nuevo proceso; `arith` es el tiempo que duran los procesos aritmeticos; `io` es el tiempo que duran los procesos input/ouput; `cond` es el tiempo que duran los procesos condicionales; y loop es el tiempo que duran los procesos iterativos. Para la politica Round Robin, hay que agregar un tiempo adicional `quantum`.

  ```java
  java ProcessScheduler -fcfs rango_tiempo_ingreso arith io cond loop
  ```

  o

  ```java
  java ProcessScheduler -lcfs rango_tiempo_ingreso arith io cond loop
  ```

  o

  ```java
  java ProcessScheduler -pp   rango_tiempo_ingreso arith io cond loop
  ```

  o

  ```java
   ProcessScheduler -rr   rango_tiempo_ingreso arith io cond loop  quantum
  ```

  Ejemplos:

  ```java
  java ProcessScheduler -fcfs  1.5-3  2 1 2.5 3
  ```

  Significa que su Process Scheduler debe utilizar la politica FIRST COME FIRST SERVED,
  utilizando para la simulacion 1 programa procesador,
  Tiempo de entrada de procesos debe estar entre 1.5 segundos y 3 segundos
  El tiempo de procesos aritmeticos es 2 segundos
  El tiempo de procesos input/output es 1 segundo
  El tiempo de procesos condicionales es 2.5 segundos
  El tiempo de procesos iterativos es 3 segundos

  ```java
  java ProcessScheduler -rr  1-2.5  1.5 1 3 4  0.5
  ```

  politica: Round Robin
  Cantidad de programas procesador: 1
  tiempo de entrada entre 1 y 2.5 segundos
  El tiempo de procesos aritmeticos es 1.5 segundos
  El tiempo de procesos input/output es 1 segundo
  El tiempo de procesos condicionales es 3 segundos
  El tiempo de procesos iterativos es 4 segundos
  y un quantum de 0.5 segundos.

  ```java
  java ProcessScheduler -dual -lcfs 1-2 2 2 2 2
  ```

  politica: Last Come First Served
  Cantidad de programas procesador: 2
  tiempo de entrada entre 1 y 2 segundos
  El tiempo de procesos aritmeticos es 2 segundos
  El tiempo de procesos input/output es 2 segundos
  El tiempo de procesos condicionales es 2 segundos
  El tiempo de procesos iterativos es 2 segundos.
  Ya escogida la politica, el process Scheduler debe empezar el simulador e imprimir los datos correspondientes en la pantalla.

- Al correr la simulacion, su programa debe desplegar en pantalla la siguiente informacion:
  - La cola de procesos: representando cada proceso con su numero, su tiempo de atencion y su tipo: A si es aritmetico, IO si es de input/output, C si es condicional y L si es iterativo.
  - Todos los datos de el proceso o procesos que estan siendo atendidos en el momento
  - La politica que se esta utilizando
  - El numero de procesos ya atendidos hasta el momento.
  - Cada vez que se de una accion: Ingreso de proceso a la cola(s), se termino de atender un proceso y se empieza a atender otro, se debe desplegar en pantalla toda la informacion: cola, procesos, etc.
  - La informacion debe ser ordenada y legible.
- Su programa terminara si oprimimos la tecla q. (Puede ser q y ENTER). Y puede detenerse en cualquier momento de la ejecucion. Al detenerse debe imprimir en la pantalla la informacion de: cuantos procesos se atendieron, cuantos procesos quedaron en cola (sin atenderse), el tiempo promedio de atencion por proceso (por procesador) y la politica utilizada. Para el caso de round-robin entre los procesos atendidos solo se tomara en cuenta los procesos que se terminaron de atender por completo.

Estas son todas las especificaciones que necesita para realizar el proyecto, si en caso tiene alguna duda sobre especificaciones SOLO puede preguntarle al catedratico del curso. Asi nos evitaremos ambiguedades.

---

## Entrega de su solucion

Todo su proyecto debe estar en un directorio llamado **pj2**, en el cual debe incluir los directorios ya hechos de los paquetes (con los paquetes ya compilados). Completado su directorio, debe agregarlo a un archivo **pj2-GrupoN.zip** y subirlo al GES.

No puede entregar su proyecto tarde

> Para poder obtener su numero de grupo debe mandar un correo con las siguientes indicaciones:
>
> - Correo dirigido a su docente.
> - Copia al auxiliar de catedra (A y C: Rodrigo Mendoza - B y D: Juan Carlos Lopez - AN: Raul Fernandez - BN: Samuel Chacon).
> - Copia a cada integrante del grupo.
> - Nombre, carne, seccion y usuario de Replit de cada integrante.
> - Fecha limite de envio de correo: martes 14 de noviembre.
>
> Si no envia dicho correo no podra entregar el proyecto y obtendra cero.

---

##Puntos Extra

Para poder implementar los puntos extra, deberia haber terminado el proyecto completo, NO se meta a hacer puntos extra antes de terminarlo.

- Ninguna politica adicional , se le tomara en cuenta, asi que ni lo haga.
- Puede implementar su proyecto en forma grafica. (Applets o JFrames)
- Puede implementar la documentacion de java para sus clases, que se pueda generar con javadoc (formato API)
- Cualquier cosa adicional(que no sea otra politica) que implemente por su propia cuenta y se considere para puntos extra.

---

¡Éxito en su proyecto!
