describe('Atividade3', () => {
    it('Caixa pontilhada com notificacao', () => {
        cy.visit('https://the-internet.herokuapp.com')
        cy.get('div[id="content"] a').contains('Context Menu').click()
        cy.on('window:alert', (str) => {
            expect(str).to.equal('You selected a context menu')
        })
        cy.get('#hot-spot').rightclick()
    })
})