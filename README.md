# reingenieria
Practica EMS
La ETSISI becó hace varios años a dos estudiantes para la elaboración de software para dar soporte a la gestión
de la información académica de asignaturas de la escuela. Se desarrolló una aplicación Java para gestionar una
determinada asignatura de acuerdo con los requisitos y necesidades de los profesores de la asignatura. Esta
aplicación se estuvo operando y utilizando durante varios años, mientras los desarrolladores daban soporte de
ayuda al usuario (help desk) y de mantenimiento. Cuando los desarrolladores terminaron su beca, la aplicación
cayó cada vez más en desuso debido a las restricciones y fallos de dicho software. La restricción más importante
fue el hecho de que se trataba de una aplicación de escritorio, y por tanto si los profesores querían consultar los
datos desde diferentes dispositivos, entonces tenían que instalarse la aplicación en todos ellos. Además, no
tenían la posibilidad de consultar los datos de la asignatura desde móvil o tablet con sistemas operativos Android
o iOS.
Las profesoras de la asignatura EMS, conscientes de esta necesidad, y dado que sus alumnos de EMS tienen los
conocimientos y aptitudes para recuperar este sistema heredado o legado, piden a sus alumnos la realización
de un proceso de reingeniería software para adaptar la aplicación de acuerdo con las necesidades de los
profesores.
Para realizar este proceso, se proporciona a los alumnos todos los artefactos software que se han podido
recuperar de la aplicación Java. Estos artefactos son:
- Estructura del código fuente: carpetas config, images, javadoc, lib, src, y tutorial
- Ejecutable: fichero .jar junto con librerías y ficheros de configuración
- Fichero SQL de creación de la base de datos.

Parte 1
Dado que la única documentación de la que se disponible es de un javadoc, se pide a los alumnos de EMS que
realicen ingeniería inversa para obtener los modelos necesarios para analizar y entender la aplicación de gestión
de información de asignaturas. Como parte de esta tarea se desea obtener:
- modelos de clases, E/R, modelo de secuencia de alguna funcionalidad compleja (ej. alta evaluación),
métricas, code smells, etc.
- especificación de requisitos (funcionales) – formato tradicional o ágil (caso de uso extendido o más ágil
pero lo suficientemente específico como para un desarrollador lo pueda implementar)

Parte 2
Los alumnos de EMS han realizado un proceso de ingeniería inversa para recuperar la documentación perdida
(requisitos y diseño) de la aplicación de gestión de la información académica de asignaturas de la escuela cuyo
código se les proporcionó.
Una vez analizada la aplicación heredada o legada, la escuela decide, por diversas razones, que necesita llevar
al cabo un proceso de reingeniería que incluya cambios de funcionalidad y una migración de plataforma
tecnológica de la aplicación.
Por tanto, se les plantea a los alumnos de EMS un proyecto de migración. Es un proyecto complejo ya que este
sistema soporta el 100% de profesores se considera un sistema de misión crítica. A saber, que la aplicación se
instancia por asignatura, por ej. para EMS. La aplicación gestiona datos históricos hasta el curso 2020-21 y datos
vivos del curso actual (2021-22).
Se necesita idear una estrategia de desarrollo del proyecto que permita un proceso de transición gradual del
sistema legado al nuevo sistema con los recursos técnicos disponibles y con el menor impacto posible.
Se pide a los alumnos, realicen:
1. Un plan de migración con los principales puntos (ver Anexo 1). Ese plan debe incluir un análisis de los
métodos/estrategias para afrontar un proceso de migración y la elección de un método justificando su
adecuación al proyecto de migración objetivo teniendo en cuenta la criticidad del sistema. También se debe justificar si el equipo va a adoptar un ciclo de desarrollo de la nueva aplicación cascada, iterativo
e incremental, u otro.
2. Proyecto de migración. Diseño y desarrollo de una aplicación web (multidispositivo). La reestructuración
arquitectónica implícita lleva consigo también una migración tecnológica. Se propone el reto de migrar
de tecnología Java a tecnología .NET. El proyecto debe considerar un flujo de control de versiones (de
los vistos en el Tema 2) y se debe especificar a grandes rasgos cómo y cuándo se hará la integración
continua y la entrega o despliegue continuo.
Los profesores de EMS han realizado un trabajo previo de análisis y recomiendan que los alumnos tengan en
cuenta en su plan de migración las siguientes cuestiones:
• Se estima que la migración de los datos llevaría un tiempo significativo y durante ese tiempo el sistema
legado estaría inaccesible, lo cual es inaceptable dadas las restricciones impuestas desde la dirección de
la ETSISI. El sistema legado seguirá funcionando hasta que los profesores de EMS den el visto bueno a la
nueva aplicación, momento en el cual la aplicación legada deje de funcionar (la base de datos legada
quedará inaccesible).
• La aplicación legada tiene una arquitectura cliente servidor. La base de datos está en un servidor no
accesible por los alumnos dada la privacidad de los datos y acorde a la nueva Ley de Protección de Datos
(GDPR) que entró en vigor en mayo de 2018. Los alumnos disponen de scripts con datos ficticios para
describir de la forma más fehaciente posible el proceso de migración de los datos, que será realizado
por personal de la escuela (departamento de operaciones / sistemas) según lo especifiquen los alumnos
en el plan de migración.
• La dirección de la ETSISI requiere de un modelo de entregas incremental, de tal forma que, los usuarios
de la aplicación puedan usar y probar (en producción) funcionalidades concretas del software desde
fases tempranas del desarrollo. De esta forma se permite a los usuarios la posibilidad de proporcionar
feedback sobre si la funcionalidad del sistema satisface sus necesidades, y se rompe la barrera de
‘resistencia al cambio’ mediante el conocimiento gradual del uso de la herramienta que van adquiriendo
los usuarios con su uso. Con este enfoque de entregas existe también la posibilidad de implementar
patrones de entrega de tipo A/B testing aunque esto último está fuera del alcance de la práctica.
A continuación, se muestra un prototipo (mockup) de la interfaz web. En ella se puede observar una barra de
menús que representa las principales funcionalidades de la aplicación: (Ver pdf)
La funcionalidad básica consiste en la gestión de cursos, grupos de clase, la asignación docente (es decir, qué
grupos de clase imparte cada profesor por curso), la matrícula de alumnos por curso y grupo de clase, y la
evaluación. Por último, la aplicación permite a los alumnos la consulta de sus notas. La aplicación incluye el
acceso por usuario (cuenta de correo institucional) y contraseña. 

Entrega
ÚNICO DOCUMENTO PDF
1. Especificación de requisitos, tradicional o ágil pero completa de la aplicación legada (parte 1).
2. Análisis y Diseño de la aplicación legada (parte 1): Modelo de análisis del dominio del problema (es
decir, diagrama de clases de análisis con las principales clases del dominio del problema), modelo de
diseño arquitectónico (solo a nivel arquitectónico, no se pide diseño detallado), modelos de datos, un
diagrama secuencia de una funcionalidad importante y relevante, métricas, etc. Se trata de realizar una
documentación comprensible para entender el sistema. Por tanto, no se trata de pegar los diagramas
o la información generada por las herramientas automáticamente, sino de aquellos
diagramas/información trabajada por los alumnos para entender el sistema con las respectivas
explicaciones que se consideren necesarias.
3. Plan de migración (parte 2), como mínimo ese plan abordará:
- Especificación de requisitos, tradicional o ágil pero completa de la aplicación nueva (incluir como anexo
actas de reuniones de la extracción de requisitos con el profesor).
- Modelos de análisis y datos de la nueva aplicación
- Tecnología y Arquitectura objetivo
- Definición de la estrategia y proceso de migración. La definición de la estrategia y proceso de migración
es el core de la práctica. En primer lugar, deberá definirse qué método/estrategia de migración de la
aplicación y de los datos de los estudiados en clase se va a implementar (Cold Turkey, Database last,
Database first, Database first & last, o Chicken Little) y justificar su elección. En segundo lugar, deberá
definirse el proceso de migración del software y de los datos, el cual debe incluir una descripción
detallada de su realización en el tiempo (si es incremental o no) y si es incremental cómo se divide el
desarrollo de la nueva aplicación en esos incrementos (es decir, qué componentes se desarrollan, qué
tablas se migran, y qué datos se migran); si son necesarios componentes software extra (ej. gateways,
ETLs) debe describirse su funcionalidad (pseudocódigo), entradas y salidas; flujo de control de versiones,
procesos de integración continua y entrega o despliegue continuo.
- Anexos Actas reunión(es) extracción de requisitos
CÓDIGO
Repositorio GitHub con el código de la aplicación .NET. Ejecutar la siguiente tarea de GitHub classroom para la
creación de un repositorio vacío por equipo en la organización del curso de EMS en GitHub.
GIWM31 https://classroom.github.com/g/YKPC96JN
GIWM32 https://classroom.github.com/g/HW6f0jZG
GIWT31 https://classroom.github.com/g/8l5YBLjb
GIWT32 https://classroom.github.com/g/P7Dcf4e1
EF https://classroom.github.com/a/UaNWN5-M
*Es requisito imprescindible que se configure adecuadamente el fichero .gitignore del proyecto para evitar subir
cualquier fichero que no se corresponda con los fuentes de la aplicación migrada
