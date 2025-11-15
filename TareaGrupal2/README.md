Objetivo y alcance

El objetivo de nuestra versión de Tetris es acumular puntos cada vez que se llena una fila, entre otros casos especiales. Esto sucede cuando se posicionan 4 distintas formas de pieza de 4 bloques cada una: la forma L, la forma T, una línea recta de 4 bloques y una que tiene forma cuadrada. Cada una tiene diferente color entre amarillo, rojo, azul, verde, naranja y morado. Se pueden hacer combos de filas llenas seguidas, que multiplican los puntos obtenidos de acuerdo a la cantidad encontrada de filas, y se suman puntos cuando se crea una fila vertical de un mismo color. El puntaje se va acumulando mediante los bloques que se eliminan y el juego termina cuando el tablero se llena o ya no encuentra espacio para colocar una pieza más. Cada pieza se puede rotar y mover hacia la izquierda, derecha o abajo hasta topar con alguna otra pieza.



Cómo compilar y ejecutar 



Para compilar y ejecutar el juego, se llama Main.java  desde la terminal y aparecerá un menú que pregunte si se desea jugar una nueva partida o ver el puntaje del juego anterior. Al escoger empezar una partida, solo se necesitan usar 4 teclas esenciales y enter. Entre las teclas están A para moverse un espacio a la izquierda, D para colocarse un espacio a la derecha, S para bajar y R para rotar la pieza en el sentido de las agujas de reloj. 



Controles

Para controlar el juego se utilizan los números del uno al tres, los cuales permiten acceder al menú principal con las opciones de iniciar partida, visualizar el último puntaje y cerrar el programa. Durante la ejecución del juego únicamente se aceptan las teclas “A”, “S”, “D” y “R”: la tecla “A” desplaza la pieza hacia la izquierda, la tecla “D” la desplaza hacia la derecha, la tecla “S” la mueve hacia abajo y la tecla “R” permite rotarla en sentido horario. Cada acción requiere confirmar la entrada mediante la tecla “ENTER”, garantizando así la correcta interpretación de los comandos por parte del sistema.



Diseño

Se eligió una estructura basada en clases porque permite organizar el programa de manera más limpia y comprensible. Al agrupar atributos y métodos dentro de clases específicas, se logra una mayor coherencia en el diseño, facilitando la reutilización y el mantenimiento del código. Además, esta organización favorece la automatización de procesos y optimiza el uso de recursos, entregando un sistema más estructurado y eficiente.



Limitaciones

Entre las limitaciones conocidas se encuentra la ausencia de una opción para que las piezas desciendan automáticamente, así como la necesidad de intentar nuevamente el movimiento hacia abajo para fijar una pieza en el tablero. Además, al eliminar varias filas de manera simultánea, el tablero no se actualiza de forma inmediata como debería. Como trabajo futuro se plantea realizar más pruebas de uso durante el desarrollo, ya que algunos errores fueron detectados cerca del límite de entrega y requirieron más tiempo del disponible para ser solucionados. Esto impidió implementar otras mejoras previstas, por lo que se propone optimizar la detección temprana de fallos y ampliar las funcionalidades en versiones posteriores.





