import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';

//TC04
Given('el usuario que ha colocado los valores obligatorios de -FechaInicio- y -FechaFin-', () => {
  cy.visit('/dashboard');
  cy.url().should('contains', '/dashboard');
});

And('selecciona opcionalmente algún filtro adicional', () => {
    cy.wait(2000)    
    cy.get(':nth-child(3) > select').type('Todos')
});


When('de click sobre el botón -Analizar-', () => {       
    cy.get(':nth-child(1) > input').type('2020-09-20')
    cy.get(':nth-child(2) > input').type('2020-09-20')
    cy.get('.v-card__actions > .v-btn > .v-btn__content').click()
});

Then('se le mostrará un dashboard con la información solicitada', () => {
    cy.contains('h1', 'Just Talk Dashboard')
    cy.wait(2000)
    cy.get(':nth-child(1) > .v-card > .text-center > .display-1').contains('Edad de Usuarios')
});


//TC05
Given('el usuario no ha colocado los valores obligatorios de -FechaInicio- y -FechaFin-', () => {
    cy.get(':nth-child(1) > input').type('yyyy-mm-dd')
    cy.get(':nth-child(2) > input').type('yyyy-mm-dd')
  });

And('selecciona solo una fecha -FechaInicio- o -FechaFin-', () => {
    cy.wait(2000)    
    cy.get(':nth-child(1) > input').type('09-09-20')
});
  
When('de click sobre el botón -Analizar-', () => {
    cy.get('.v-card__actions > .v-btn > .v-btn__content').click()
});
  
Then('se muestra una ventana emergente con un mensaje de error', () => {
    cy.get(':nth-child(2) > .v-card > .text-center > .display-1').contains('Duración de Chats')
});


//TC06
Given('el usuario que aun no ha colocado los valores obligatorios de -FechaInicio- y -FechaFin-', () => {
    cy.visit('/dashboard')
    cy.wait(2000)    
    cy.get(':nth-child(1) > input').type('')
    cy.get(':nth-child(2) > input').type('')
  });

And('selecciona una -FechaFin- menor a -FechaInicio-', () => {
    cy.wait(2000)    
    cy.get(':nth-child(1) > input').type('2020-09-22')
    cy.get(':nth-child(2) > input').type('2020-09-20')
});
  
When('de click sobre el botón -Analizar-', () => {
    cy.get('.v-card__actions > .v-btn > .v-btn__content').click()
});
  
Then('se muestra una ventana emergente con un mensaje de error', () => {
    cy.get(':nth-child(3) > .v-card > .text-center > .display-1').contains('Usuarios Registrados')
});