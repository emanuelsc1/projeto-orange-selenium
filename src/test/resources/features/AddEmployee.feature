Feature: Adicionar usuário no sistema OrangeHRM

  @login
  Scenario: Adicionar usuario
    Given que o usuário acessa o menu PIM
    And clicar no botão adicionar
    And preencho o nome do funcionario
    And clica para salvar
    Then o funcionario deve ser cadastrado com sucesso