// https://docs.cypress.io/api/introduction/api.html

describe('Testeando las rutas correctas', () => {
  it('Visita la página principal', () => {
    cy.visit('/')
    cy.wait(2000)
    cy.contains('h1', 'Just Talk - Administradores')
    //cy.get('#auth').click()
    //cy.get('.info > .v-btn__content')
  })

  it('Visita la página del login', () => {
    cy.visit('/login')
    cy.wait(2000)
    cy.contains('h1', 'Iniciar Sesión')
  })

  it('Visita la página del dashboard', () => {
    cy.visit('/dashboard')
    cy.wait(2000)
    cy.contains('h1', 'Just Talk Dashboard')
  })

  it('Visita la página de contactar a soporte', () => {
    cy.visit('/report')
    cy.wait(2000)
    cy.contains('h1', 'Registro y totalidad de usuarios')
  })

  it('Visita la página de la tabla de usuarios', () => {
    cy.visit('/datatable')
    cy.wait(2000)
    cy.contains('h1', 'Registro y totalidad de usuarios')
  })
})