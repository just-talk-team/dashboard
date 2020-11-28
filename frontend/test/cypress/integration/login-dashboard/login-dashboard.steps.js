import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';

//TC01
Given('the user that entered your username and password correctly', () => {
  cy.visit('https://jt-dashboard-development.herokuapp.com');
  cy.url().should('contains', 'https://jt-dashboard-development.herokuapp.com');
});

When('he clicks the button -Loggin-', () => {
    cy.visit('/login')
    cy.wait(2000)        
    cy.get('#input-18').type('vivieall')
    cy.get('#input-22').type('1234567')
    cy.get('.info > .v-btn__content').click()
});

Then('he will be shown the dashboard home screen', () => {
    cy.visit('/dashboard')
    cy.wait(2000)
    cy.contains('h1', 'Just Talk Dashboard')
});


//TC02
Given('the user enter the user value', () => {
    cy.visit('/login')
    cy.wait(2000)    
    cy.get('#input-18').type('vivieal')
  });

And('the user enters password value', () => {
    cy.wait(2000)    
    cy.get('#input-22').type('Test123')    
});
  
When('the user clicks the button -Loggin-', () => {
    cy.get('.info > .v-btn__content').click()
});
  
Then('a pop-up window is shown with an error message', () => {
cy.log('Usuario o contraseña incorrecto')
});


//TC03
Given('the user enter the user value', () => {
    cy.visit('/login')
    cy.wait(2000)    
    cy.get('#input-18').type('vivieal')
  });

And('the user enters password value', () => {
    cy.wait(2000)    
    cy.get('#input-22').should('have.value', '');
});
  
When('the user clicks the button -Loggin-', () => {
    cy.get('.info > .v-btn__content').click()
});
  
Then('a pop-up window is shown with an error message', () => {
    cy.log('Verificar que el campo usuario y/o contraseña no estén vacíos')
});