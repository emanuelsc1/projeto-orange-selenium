Feature: Buscar System Users

  Scenario: Realizar consulta por Username
    Given o usuário acessa o menu Admin
    When usuário realiza uma consulta por Username
    Then o sistema deve atualizar a tabela filtrando pelo Username
#
#  Scenario: Realizar consulta por User Role
#    Given o usuário acessa o menu Admin
#    When usuário realiza uma consulta por User Role
#    Then o sistema deve atualziar a tabela filtrando pelo User Role
#
#  Scenario: Realizar consulta por Employee Name
#    Given o usuário acessa o menu Admin
#    When usuário realiza uma consulta por Employee Name
#    Then o sistema deve atualziar a tabela filtrando pelo Employee Name
#
#  Scenario: Realizar consulta por Employee Name inválido
#    Given o usuário acessa o menu Admin
#    When usuário realiza uma consulta por Employee Name não cadastrado
#    Then o sistema deve apresentar a mensagem "Invalid" abaixo do campo
#
#  Scenario: Realizar consulta por Status
#    Given o usuário acessa o menu Admin
#    When usuário realiza uma consulta por Status
#    Then o sistema deve atualziar a tabela filtrando pelo Status
#
#  Scenario: Realizar consulta sem resultado
#    Given o usuário acessa o menu Admin
#    When usuário realiza uma consulta por parâmetros de forma a não trazer resultado
#    Then o sistema deve trazer a tabela vazia
#    And deve apresentar a mensagem "No Records Found"
#
#  Scenario: Validar botão reset
#    Given o usuário acessa o menu Admin
#    And realiza uma consulta
#    When usuário clica no botão "Reset"
#    Then o sistema deve limpar os campos de busca
#    And deve atualziar a tabela com todos os resultados