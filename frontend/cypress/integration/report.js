describe('Probando compontentes', () => {

    it('Probamos el uso del checkbox', () => {
        cy.visit('/report')
        cy.wait(2000)        
        cy.get('.v-input--selection-controls__ripple').parent().click();
        cy.get('.v-input--selection-controls__ripple').parent().click();
        cy.get('.success > .v-btn__content').click()
        
    })

    it('Validamos campos vacíos', () => {
        cy.visit('/report')
        cy.wait(2000)        
        cy.get('.error > .v-btn__content')
        cy.get('.v-input--selection-controls__ripple').parent().click();
        cy.get('.success > .v-btn__content').click()
    })


    it('Validamos formulario de reporte', () => {
        cy.visit('/report')
        cy.wait(2000)        
        cy.get('#input-18').type('vivie')
        cy.get('.v-input--selection-controls__ripple').parent().click();
        cy.get('.success > .v-btn__content').click()
    })

    it('Validamos el correo', () => {
        cy.visit('/report')
        cy.wait(2000)        
        cy.get('#input-18').type('vivie@gmail')
        cy.get('.v-input--selection-controls__ripple').parent().click();
        cy.get('.success > .v-btn__content').click()
        cy.get('.warning > .v-btn__content')
        cy.get('#input-18').clear()
        cy.get('#input-18').type('vivie@gmail.com')
        cy.get('.success > .v-btn__content').click()
    })

})