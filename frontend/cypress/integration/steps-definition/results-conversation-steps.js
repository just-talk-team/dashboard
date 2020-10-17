describe('Componentes del dashboard', () => {
    
    it('Comprueba el título del gráfico #1', () => {
        cy.visit('/dashboard')
        cy.wait(2000)
        cy.get(':nth-child(1) > .v-card > .text-center > .display-1').contains('Edad de Usuarios')
    })

    it('Comprueba el título del gráfico #2', () => {
        cy.visit('/dashboard')
        cy.wait(2000)
        cy.get(':nth-child(2) > .v-card > .text-center > .display-1').contains('Duración de Chats')
    })

    it('Comprueba el título del gráfico #3', () => {
        cy.visit('/dashboard')
        cy.wait(2000)
        cy.get(':nth-child(3) > .v-card > .text-center > .display-1').contains('Usuarios Registrados')
    })

})




import { Then, When } from 'cypress-cucumber-preprocessor/steps';

Given('Inicia la web del administrador', () => {
  cy.visit('http://localhost:8081');
  cy.url().should('contains', 'http://localhost:8081');
});

When('el usuario da click en -login-', () => {
  cy.get('#login').click();
});

And('the scoreboard shows 1:1', () => {
  const modifyScore = (document) => {
    document.getElementById('user-score').innerHTML = 1;
    document.getElementById('machine-score').innerHTML = 1;
  }

  cy.document().then(document => modifyScore(document));

  cy.get('#user-score').should('have.text', '1');
  cy.get('#machine-score').should('have.text', '1');
});

Then('the scoreboard shows 0:0', () => {
  cy.get('#user-score').should('have.text', '0');
  cy.get('#machine-score').should('have.text', '0');
});

Then(/^result text show \"([^\"]*)\"$/, function (resultText) {
  cy.get('#result-text p:nth-of-type(1)').should('have.text', resultText);
});


