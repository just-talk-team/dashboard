// https://docs.cypress.io/api/introduction/api.html

describe('Login test', () => {
  it('Visita la página de login e ingresa', () => {
    cy.visit('/')
    cy.contains('h1', 'Just Talk - Administradores')
    cy.get('#auth').click()
  })

  it('Debe redirigir a dashboard y que contiene el mismo encabezado', () => {
    cy.visit('/dashboard')
    cy.wait(2000)
    cy.contains('h1', 'Just Talk Dashboard')
  })
})