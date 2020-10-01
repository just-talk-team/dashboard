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