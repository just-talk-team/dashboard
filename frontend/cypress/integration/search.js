describe('Probando el buscador..', () => {

    it('Probamos el compontente buscador', () => {
        cy.visit('/datatable')
        cy.wait(2000)        
        cy.get('#input-21').type('abc') // Buscamos por clase 
    })

    it('Comprobamos si coincide con los resultados', () => {
      cy.visit('/datatable')
      cy.wait(2000)        
      cy.get('#input-21').type('Viviana')
      cy.get('.v-input__slot > .v-input__append-inner > .v-input__icon > .v-icon').click
      cy.get('tbody > :nth-child(1) > :nth-child(1)').contains('Viviana')
    })

    it('Probamos nuevamente si coincide con los resultados', () => {
        cy.visit('/datatable')
        cy.wait(2000)        
        cy.get('#input-21').type('Maria')
        cy.get('.v-input__slot > .v-input__append-inner > .v-input__icon > .v-icon').click
        cy.get('tbody > :nth-child(1) > :nth-child(1)').contains('Maria')
    })

    it('Probamos nuevamente si coincide con los resultados', () => {
        cy.visit('/datatable')
        cy.wait(2000)        
        cy.get('#input-21').type('abc')
        cy.get('.v-input__slot > .v-input__append-inner > .v-input__icon > .v-icon').click
        cy.get('tbody > tr > :nth-child(3)').contains('abc')
    })

    it('Vamos a escribir y limpiar en el buscador', () => {
        cy.visit('/datatable')
        cy.wait(2000)        
        cy.get('#input-21').clear()
        cy.get('#input-21').type('vivi')
        cy.get('#input-21').clear()
        cy.get('#input-21').type('Marta')
        cy.get('#input-21').clear()
    })

 })