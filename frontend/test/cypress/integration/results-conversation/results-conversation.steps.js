import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';

//TC04
Given('the user who has placed the mandatory values of -StartDate- and -EndDate-', () => {
    cy.visit('https://jt-dashboard-development.herokuapp.com');
    cy.get('.v-toolbar__content > [href="/login"] > .v-btn__content').click();
    cy.wait(2000)        
    cy.get('#input-22').type('jalfonso')
    cy.get('#input-26').type('blancoazul')
    cy.get('.info > .v-btn__content').click()
    cy.url().should('contains', '/dashboard');
});

And('optionally select some additional filter', () => {
    cy.wait(2000)    
    cy.get(':nth-child(3) > select').type('Todos')
});


When('he clicks on the button -Analyze-', () => {       
    cy.get('.search-row > :nth-child(1) > input').type('2020-09-20')
    cy.get('.search-row > :nth-child(2) > input').type('2020-09-21')
    cy.get('.v-card__actions > .v-btn > .v-btn__content').click()
});

Then('a dashboard will be shown with the requested information', () => {
    cy.contains('h1', 'Just Talk Dashboard')
    cy.wait(2000)
    cy.get(':nth-child(1) > .v-card > .text-center > .display-1').contains('Edad de Usuarios')
});


//TC05
Given('the user has not placed the mandatory values of -StartDate- and -EndDate-', () => {
    cy.get('.search-row > :nth-child(1) > input')
    cy.get('.search-row > :nth-child(2) > input')
  });

And('select only one date -StartDate- or -EndDate-', () => {
    cy.wait(2000)    
    cy.get('.search-row > :nth-child(1) > input').type('2020-09-20')
});
  
When('he clicks on the button -Analyze-', () => {
    cy.get('.v-card__actions > .v-btn > .v-btn__content').click()
});
  
Then('a pop-up window is shown with an error message', () => {
    cy.get(':nth-child(2) > .v-card > .text-center > .display-1').contains('Duración de Chats')
});


//TC06
Given('the user who has not yet set the mandatory values of -StartDate- and -EndDate-', () => {
    cy.visit('https://jt-dashboard-development.herokuapp.com');
    cy.get('.v-toolbar__content > [href="/login"] > .v-btn__content').click();
    cy.wait(2000)        
    cy.get('#input-22').type('jalfonso')
    cy.get('#input-26').type('blancoazul')
    cy.get('.info > .v-btn__content').click()
    cy.url().should('contains', '/dashboard');
    cy.wait(2000)    
  });

And('select an -EndDate- less than -StartDate-', () => {
    cy.wait(2000)    
    cy.get('.search-row > :nth-child(1) > input').type('2020-09-22')
    cy.get('.search-row > :nth-child(2) > input').type('2020-09-20')
});
  
When('he clicks on the button -Analyze-', () => {
    cy.get('.v-card__actions > .v-btn > .v-btn__content').click()
});
  
Then('a pop-up window is shown with an error message', () => {
    cy.get(':nth-child(3) > .v-card > .text-center > .display-1').contains('Usuarios Registrados')
});