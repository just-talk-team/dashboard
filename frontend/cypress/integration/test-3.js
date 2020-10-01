/// <reference types="Cypress" />
const time = 1000;
context('Company Data', () => {
	beforeEach(() => {
		cy.visit('/companydata');
		cy.wait(time);
	});
	it('Check if empty fields are showing errors', () => {
		cy.get('[data-cy=name]').should('have.value', '');
		cy.get('[data-cy=spend]').should('have.value', '');
		cy.get('[data-cy=min]').should('have.value', '');
		cy.get('[data-cy=max]').should('have.value', '');
		cy.wait(time);
		cy.get('[data-cy=name-error]').should('be.visible');
		cy.get('[data-cy=spend-error]').should('be.visible');
		cy.get('[data-cy=min-error]').should('be.visible');
		cy.get('[data-cy=max-error]').should('be.visible');
	});
	it('Type "name" field => Must not show error', () => {
		cy.get('[data-cy=name]').type('COMPANY TEST');
		cy.wait(time);
		cy.get('[data-cy=name-error]').should('not.be.visible');
	});
	it('Type negative value in "spend" field => Must be positive', () => {
		cy.get('[data-cy=spend]').type('-1234');
		cy.wait(time);
		cy.get('[data-cy=spend]').should('have.value', '$ 123,4');
	});
	it('Type "min" greater than "max" field => Must show comparisson error', () => {
		cy.get('[data-cy=min]').type('100');
		cy.get('[data-cy=max]').type('10');
		cy.wait(time);
		cy.get('[data-cy=min-error]')
			.should('be.visible')
			.should('contain', 'MIN must not be greater than MAX');
		cy.get('[data-cy=max-error]')
			.should('be.visible')
			.should('contain', 'MAX must not be lesser than MIN');
	});
	it('Type "min" lesser than "max" field => Must not show error', () => {
		cy.get('[data-cy=min]').type('10');
		cy.get('[data-cy=max]').type('100');
		cy.wait(time);
		cy.get('[data-cy=min-error]').should('not.be.visible');
		cy.get('[data-cy=max-error]').should('not.be.visible');
	});
});