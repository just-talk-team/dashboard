Feature: Autenticarse para usar Dashboard

    Como administrador 
    Quiero poder autenticarme con mi usuario y contraseña  
    Para hacer uso del dashboard

    Background: navegar hacia la pagina del login
        Given el usuario navega en el 'login' 

    @TC01
    Scenario: TC01 - Datos de usuario y password correctos
        Given un usuario que digito su usuario y contraseña correctamente 
        When de click sobre el botón 'Ingresar' 
        Then se le mostrará la pantalla de inicio del dashboard

    @TC02
    Scenario: TC02 - Datos de usuario y password incorrectos. <test>
        Given un usuario ingresa el valor '<user>' en 'user_Input'
        And el usuario ingresa valor '<password>' en 'password_Input'
        When el usuario da click en el botón de 'Ingresar' 
        Then se muestra una ventana emergente con un '<errorMessage>'

    Examples: <test>
            | test             | user     | password  | errorMessage                    |
            | WrongPassword    | vivieall | Test123!  | Usuario o contraseña incorrecto |
            | WrongUser        | vivieal  | Test123   | Usuario o contraseña incorrecto |

    @TC03
    Scenario:  TC03 - Datos de usuario y/o password incorrectos. <test>
        Given un usuario ingresa el valor '<user>' en 'user_Input'
        And el usuario ingresa valor '<password>' en 'password_Input'
        When el usuario da click en el botón de 'Ingresar' 
        Then se muestra una ventana emergente con un '<errorMessage>'

        Examples: <test>
            | test             | user       | password | errorMessage                                                  |
            | NoEmail          |            | Test123  | Verificar que el campo usuario y/o contraseña no estén vacíos |
            | NoPassword       | vivieall   |          | Verificar que el campo usuario y/o contraseña no estén vacíos |
            | NoEmail&Password |            |          | Verificar que el campo usuario y/o contraseña no estén vacíos |

            