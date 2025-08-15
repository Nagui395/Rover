Feature: Map-Spherical-Obstacles

#ENCONTRAMOS UN OBSTACULO

  Scenario Outline: Objeto se mueve a una casilla con obstáculo
    Given un mapa de 3x3
    And un objeto en la posición (<rover_x>, <rover_y>)
    And un obstáculo en la posición (<destino_x>,<destino_y)
    When el objeto se mueve 1 paso <direccion>
    Then la posición del objeto sigue siendo (<rover_x>, <rover_y>)
    And notificación de obstáculo en (<destino_x>, <destino_y>)

Examples:
  | rover_x | rover_y | direccion  | destino_x | destino_y |
  | 0       | 0       | izquierda  | 2         | 0         |
  | 0       | 0       | abajo      | 0         | 2         |
  | 0       | 2       | arriba     | 0         | 0         |
  | 2       | 0       | derecha    | 0         | 0         |
  | 1       | 1       | izquierda  | 0         | 1         |
  | 1       | 1       | derecha    | 2         | 1         |
  | 1       | 1       | arriba     | 1         | 2         |
  | 1       | 1       | abajo      | 1         | 0         |


#SALIMOS DEL MAPA Y ENCONTRAMOS UN OBSTACULO

Scenario Outline: Objeto se desborda del mapa y encuentra obstáculo en casilla de destino
   Given un mapa 3x3
    And un objeto está en la posición (<rover_x>, <rover_y>)
    And un obstáculo en la posición (<destino_x>, <destino_y>)
    When el objeto se mueve 1 paso a la <direccion>
    Then la posición del rover sigue siendo (<rover_x>, <rover_y>)
    And se muestra un mensaje indicando "Obstáculo detectado en la dirección <direccion> <wrappedposition_x, warappedposition_y>"

Examples:
    | map_width | map_height | rover_x | rover_y | direccion | destino_x | destino_y | wrappedposition_x | wrappedposition_y |
    | 3         | 3          | 0       | 0       | izquierda | 2         | 0         | 2                 | 0                 |
    | 3         | 3          | 0       | 2       | arriba    | 0         | 0         | 0                 | 0                 |
    | 3         | 3          | 2       | 0       | derecha   | 0         | 0         | 0                 | 0                 |
    | 3         | 3          | 0       | 0       | abajo     | 0         | 2         | 0                 | 2                 |