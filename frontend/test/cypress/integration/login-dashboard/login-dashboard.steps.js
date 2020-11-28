import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';

//TC01
Given('the user that entered your username and password correctly', () => {
  cy.visit('https://jt-dashboard-development.herokuapp.com');
  //cy.url().should('contains', '/login');
  cy.wait(2000);
});

When('he clicks the button -Loggin-', () => {
    cy.get('.v-toolbar__content > [href="/login"] > .v-btn__content').click();
    cy.wait(2000)        
    cy.get('#input-22').type('jalfonso')
    cy.get('#input-26').type('blancoazul')
    cy.get('.info > .v-btn__content').click()
});

Then('he will be shown the dashboard home screen', () => {
    //cy.visit('https://jt-dashboard-development.herokuapp.com/dashboard')
    cy.wait(2000)
    cy.contains('h1', 'Just Talk Dashboard')
});


//TC02
Given('the user enter the user value', () => {
    cy.visit('https://jt-dashboard-development.herokuapp.com')
    cy.get('.v-toolbar__content > [href="/login"] > .v-btn__content').click();
    cy.wait(2000)    
    cy.get('#input-22').type('vivieal')
  });

And('the user enters password value', () => {
    cy.wait(2000)    
    cy.get('#input-26').type('Test123')    
});
  
When('the user clicks the button -Loggin-', () => {
    cy.get('.info > .v-btn__content').click()
});
  
Then('a pop-up window is shown with an error message', () => {
cy.log('Usuario o contraseña incorrecto')
});


//TC03
Given('the user enter the user value', () => {
    cy.visit('https://jt-dashboard-development.herokuapp.com')
    cy.get('.v-toolbar__content > [href="/login"] > .v-btn__content').click();
    cy.wait(2000)    
    cy.get('#input-22').type('vivieal')
  });

And('the user enters password value', () => {
    cy.wait(2000)    
    cy.get('#input-26').should('have.value', '');
});
  
When('the user clicks the button -Loggin-', () => {
    cy.get('.info > .v-btn__content').click()
});
  
Then('a pop-up window is shown with an error message', () => {
    cy.log('Verificar que el campo usuario y/o contraseña no estén vacíos')
});