describe('suite 04', () => {
  it('context menu', () => {
    cy.visit('https://the-internet.herokuapp.com')
    cy.get('div[id="content" a]').contains('Dropdown').click()
    cy.get('select[id="dropdown"]').select('Option 2')
    cy.get('option[selected=selected]').should('have.text','Option 2')
  })
})