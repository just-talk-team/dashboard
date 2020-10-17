import { Then, When } from 'cypress-cucumber-preprocessor/steps';

//TC01
Given('un usuario que digito su usuario y contraseña correctamente ', () => {
  cy.visit('http://localhost:8081');
  cy.url().should('contains', 'http://localhost:8081');
});

When('de click en el botón -Ingresar-', () => {
    cy.visit('/login')
    cy.wait(2000)        
    cy.get('#input-19').type('vivieall')
    cy.get('#input-23').type('Test123!')
    cy.get('.info > .v-btn__content').click()
});

Then('se le mostrará la pantalla de inicio del dashboard', () => {
    cy.visit('/dashboard')
    cy.wait(2000)
    cy.contains('h1', 'Just Talk Dashboard')
});

//TC02
Given('un usuario ingresa el valor de usuario', () => {
    cy.visit('/login')
    cy.wait(2000)    
    cy.get('#input-19').type('vivieal')
  });

And('el usuario ingresa valor de contraseña', () => {
    cy.wait(2000)    
    cy.get('#input-23').type('Test123')    
});
  
When('el usuario da click en el botón -Ingresar-', () => {
    cy.get('.info > .v-btn__content').click()
});
  
Then('se muestra una ventana emergente con un mensaje', () => {
cy.log('Usuario o contraseña incorrecto')
});

//TC03
Given('se muestra una ventana emergente con un mensaje', () => {
    cy.visit('/login')
    cy.wait(2000)    
    cy.get('#input-19').type('vivieal')
  });

And('el usuario ingresa valor de contraseña', () => {
    cy.wait(2000)    
    cy.get('#input-23').should('have.value', '');
});
  
When('el usuario da click en el botón -Ingresar-', () => {
    cy.get('.info > .v-btn__content').click()
});
  
Then('se le mostrará la pantalla de inicio del dashboard', () => {
    cy.log('Verificar que el campo usuario y/o contraseña no estén vacíos')
});