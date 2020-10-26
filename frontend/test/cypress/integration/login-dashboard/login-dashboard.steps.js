import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';

//TC01
Given('el usuario que digito su usuario y contraseña correctamente', () => {
  cy.visit('http://localhost:8086');
  cy.url().should('contains', 'http://localhost:8086');
});

When('de click en el botón -Ingresar-', () => {
    cy.visit('/login')
    cy.wait(2000)        
    cy.get('#input-18').type('vivieall')
    cy.get('#input-22').type('1234567')
    cy.get('.info > .v-btn__content').click()
});

Then('se le mostrará la pantalla de inicio del dashboard', () => {
    cy.visit('/dashboard')
    cy.wait(2000)
    cy.contains('h1', 'Just Talk Dashboard')
});


//TC02
Given('el usuario ingresa el valor de usuario', () => {
    cy.visit('/login')
    cy.wait(2000)    
    cy.get('#input-18').type('vivieal')
  });

And('el usuario ingresa valor de contraseña', () => {
    cy.wait(2000)    
    cy.get('#input-22').type('Test123')    
});
  
When('el usuario da click en el botón -Ingresar-', () => {
    cy.get('.info > .v-btn__content').click()
});
  
Then('se muestra una ventana emergente con un mensaje de error', () => {
cy.log('Usuario o contraseña incorrecto')
});


//TC03
Given('el usuario ingresa el valor de usuario', () => {
    cy.visit('/login')
    cy.wait(2000)    
    cy.get('#input-18').type('vivieal')
  });

And('el usuario ingresa valor de contraseña', () => {
    cy.wait(2000)    
    cy.get('#input-22').should('have.value', '');
});
  
When('el usuario da click en el botón -Ingresar-', () => {
    cy.get('.info > .v-btn__content').click()
});
  
Then('se muestra una ventana emergente con un mensaje de error', () => {
    cy.log('Verificar que el campo usuario y/o contraseña no estén vacíos')
});