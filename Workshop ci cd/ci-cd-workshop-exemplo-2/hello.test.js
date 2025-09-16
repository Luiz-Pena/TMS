const numero = require('./index');

test('retorna par ou impar', () => {
  expect(numero(2)).toBe("2 eh par");
  expect(numero(3)).toBe("3 eh impar");
});