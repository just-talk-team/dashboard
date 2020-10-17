describe('Probando el login', () => {

    it('Probamos que username no esté vacío', () => {
        cy.visit('/login')
        cy.wait(2000)        
        cy.get('#input-19').should('have.value', '');
        cy.log('campos vacios')
    })

    it('Probamos que password no esté vacío', () => {
        cy.visit('/login')
        cy.wait(2000)        
        cy.get('#input-23').should('have.value', '');
        cy.log('campos vacios')
    })

    it('Probamos que no sea un usuario incorrecto', () => {
        cy.visit('/login')
        cy.wait(2000)    
        cy.get('#input-19').type('anonymous')
        cy.get('#input-23').type('7654321')    
        cy.get('.info > .v-btn__content').click()
        cy.log('Usuario o contraseña incorrecto.')
    })

    it('Probamos el flujo normal', () => {
        cy.visit('/login')
        cy.wait(2000)        
        cy.get('#input-19').type('vivieall7')
        cy.get('#input-23').type('1234567')
        cy.get('.info > .v-btn__content').click()
    })
})