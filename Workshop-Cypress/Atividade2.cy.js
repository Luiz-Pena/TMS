describe('Atividade2', () => {
    it('Sumir/Aparecer botao', () => {
            cy.visit('https://the-internet.herokuapp.com')
            cy.get('div[id="content"] a').contains('Add/Remove Elements').click()
            cy.contains('Add Element').click()
        cy.get('.added-manually').should('be.visible')
        cy.get('.added-manually').click()
        cy.get('.added-manually').should('not.exist')
        })
    })