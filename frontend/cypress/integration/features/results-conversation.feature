Feature: Filtrar resultados de conversaciones

    Como administrador 
    Quiero poder tener un dashboard con información sobre conversaciones finalizadas
    Para poder analizar los mismos y poder tomar decisiones de cambio.

    Background: haber iniciado sesión
        Given el usuario navega en el 'dashboard' 

    @TC04
    Scenario: TC04 - Fecha Inicio y Fecha Fin digitados correctamente
        Given un usuario que ha colocado los valores obligatorios de 'FechaInicio' y 'FechaFin'
        And selecciona opcionalmente algún filtro adicional
        When de click sobre el botón 'Analizar'
        Then se le mostrará un dashboard con la información solicitada

    @TC05
    Scenario: TC05 - Fecha Inicio y/o Fecha Fin no indicados <test>
        Given un usuario que no ha colocado los valores obligatorios de 'FechaInicio' y 'FechaFin'
        And selecciona solo una fecha '<FechaInicio>' o '<FechaFin>'
        When de click sobre el botón 'Analizar'
        Then se muestra una ventana emergente con un '<errorMessage>'

    Examples: <test>
            | test           | FechaInicio | FechaFin  | errorMessage                                                                             |
            | EndDateEmpty   | 10/10/20    |           | Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis|
            | StartDateEmpty |             | 11/10/20  | Debe elegir una fecha de inicio y fin de forma obligatoria para continuar con el análisis|

    @TC06
    Scenario:  TC06 - Fecha Inicio y/o Fecha Fin digitados incorrectamente <test>'
        Given un usuario que ha colocado los valores obligatorios de 'FechaInicio' y 'FechaFin'
        And selecciona una 'FechaFin' en '<FechaFin>'' menor a la FechaInicio em '<FechaInicio>'
        When de click sobre el botón 'Analizar'
        Then se muestra una ventana emergente con un '<errorMessage>'

        Examples: <test>
            | test           | FechaInicio | FechaFin  | errorMessage                                       |
            | InvalidDate    | 10/10/20    | 09/10/20  | La fecha de inicio debe ser menor a la fecha fin   |
            
