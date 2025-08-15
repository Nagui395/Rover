Feature: Map-Spherical

#ESQUINA INFERIOR IZQUIERDA BORDE IZQUIERDO

  Scenario: Objeto se mueve más allá del borde izquierdo (en la esquina izquierda)
    Given un mapa de 3x3
    And un objeto en la posición (0,0)
    When el objeto se mueve 1 paso izquierda
    Then la posición del objeto debe ser (2,0)

#ESQUINA INFERIOR IZQUIERDA BORDE INFERIOR

 Scenario: Objeto se mueve más allá del borde inferior izquierdo (en la esquina izquierda)
    Given un mapa de 3x3
    And un objeto en la posición (0,0)
    When el objeto se mueve 1 paso abajo
    Then la posición del objeto debe ser (0,2)

#ESQUINA SUPERIOR IZQUIERDA BORDE IZQUIERDO

 Scenario: Objeto se mueve más allá del borde superior (en la esquina izquierda)
   Given un mapa de 3x3
   And un objeto en la posición (0,2)
   When el objeto se mueve 1 paso arriba
   Then la posición del objeto debe ser (0,0)

#ESQUINA SUPERIOR IZQUIERDA BORDE SUPERIOR

 Scenario: Objeto se mueve más allá del borde superior izquierdo (en la esquina izquierda)
   Given un mapa de 3x3
   And un objeto en la posición (0,2)
   When el objeto se mueve 1 paso izquierda
   Then la posición del objeto debe ser (2,2)

#ESQUINA INFERIOR DERECHA BORDE DERECHO

Scenario: Objeto se mueve más alla del borde derecho (en la esquina inferior derecha)
    Given un mapa de 3x3
    And un objeto en la posición (2,0)
    When el objeto se mueve 1 paso derecha
    Then la posición del objeto debe ser (0,0)

#ESQUINA INFERIOR DERECHA BORDE INFERIOR

Scenario: Objeto se mueve más allá del borde inferior derecho (en la esquina inferior derecha)
     Given un mapa de 3x3
     And un objeto en la posición (2,0)
     When el objeto se mueve 1 paso abajo
     Then la posición del objeto debe ser (2,2)


#ESQUINA SUPERIOR DERECHA BORDE DERECHO

Scenario: Objeto se mueve más allá del borde superior derecho (en la esquina superior derecha)
    Given un mapa 3x3
    And un objeto en la posición (2,2)
    When el objeto se mueve 1 paso arriba
    Then la posición del objeto debe ser (2,0)

#ESQUINA SUPERIOR DERECHA BORDE SUPERIOR

Scenario: Objeto se mueve más allá del borde superior (en la esquina superior derecha)
    Given un mapa 3x3
    And un objeto en la posición (2,2)
    When el objeto se mueve 1 paso derecha
    Then la posición del objeto debe ser (0,2)

# BORDE CENTRAL SUPERIOR BORDE SUPERIOR

Scenario: Objeto se mueve más allá del borde superior (en la casilla central superior)
    Given un mapa 3x3
    And un objeto en la posición (1,2)
    When el objeto se mueve un paso arriba
    Then la posición del objeto debe ser (1,0)


#BORDE CENTRAL INFERIOR BORDE INFERIOR

Scenario: Objeto se mueve más allá del borde inferior (en la casilla central inferior)
    Given un mapa 3x3
    And un objeto en la posición (1,0)
    When el objeto se mueve un paso abajo
    Then la posición del objeto debe ser (1,2)

#BORDE CENTRAL IZQUIERDO BORDE IZQUIERDA

Scenario: Objeto se mueve más allá del borde izquierdo(en la casilla central izquierda)
    Given un mapa 3x3
    And un objeto en la posición (0,1)
    When el objeto se mueve un paso izquierda
    Then la posición del objeto debe ser (2,1)

#BORDE CENTRAL DERECHO BORDE DERECHO

Scenario: Objeto se mueve más allá del borde derecho (en la casilla central derecha)
    Given un mapa 3x3
    And un objeto en la posición (2,1)
    When el objeto se mueve un paso derecha
    Then la posición del objeto debe ser (0,1)