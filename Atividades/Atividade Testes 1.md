
![[Pasted image 20250727155513.png]]

1. Ja realizei testes para verificar se a logica do algoritmo esta correta, se a sintaxe esta correta, entre outros.
2. Especificação de software: software que calcula o fatorial de um numero maior que -1. Dominio de entrada: {(0), (1), (2)} . Dominio de saida: {(1), (1), (2)}

![[Pasted image 20250727160228.png]]

Software Failures: Understanding Bugs, Defects, Errors, and Failures in Software Engineering. O artigo explora as diferenças fundamentais entre os termos bug, defeito, erro e falha no contexto de engenharia de software. Os autores definem: Erro: Um engano humano durante o desenvolvimento. Defeito: Uma manifestação do erro no código, também chamado de _bug_. Falha: A ocorrência observável quando o defeito é executado, causando comportamento incorreto.

![[Pasted image 20250727160633.png]]

1. Um caso notável foi a falha do sistema de saúde HealthCare.gov (EUA, 2013), lançado com graves problemas que impediram usuários de se cadastrarem. Investigações apontaram a falta de testes adequados como uma das causas principais. O sistema não foi submetido a testes de carga ou integração robustos antes do lançamento, resultando em travamentos e lentidão. Um relatório do Government Accountability Office (GAO) destacou que prazos apertados e gestão ineficiente levaram à negligência nos testes, custando milhões em reparos. Referência:  U.S. Government Accountability Office (GAO). (2014). "Healthcare.gov: Ineffective Planning and Oversight Practices Underscore the Need for Improved Contract Management" (Report GAO-14-694). Disponível em: [www.gao.gov/products/GAO-14-694](https://www.gao.gov/products/GAO-14-694).
2. Um exemplo notável de melhoria em projetos através da adoção de boas práticas de testes é o caso da Microsoft com o Windows 7. Após as críticas recebidas pelo Windows Vista, que enfrentou problemas de desempenho e compatibilidade, a Microsoft implementou um processo de teste mais rigoroso, incluindo testes automatizados, beta testing público e um programa de feedback contínuo. Como resultado, o Windows 7 foi lançado com maior estabilidade e aceitação do mercado, reduzindo significativamente os bugs reportados em comparação com seu predecessor. Referência: Microsoft. (2009). "Engineering Windows 7: Quality". Disponível em: [https://blogs.msdn.microsoft.com/e7/2009/01/30/engineering-windows-7-quality/](https://blogs.msdn.microsoft.com/e7/2009/01/30/engineering-windows-7-quality/).

![[Pasted image 20250826133812.png]]

Nível Júnior
Foco: Aprendizado, execução de testes manuais e automação básica, sob supervisão.
Vagas Típicas: Analista de Testes Júnior, Tester Júnior, Estagiário em Qualidade de Software (QA)
Conceitos Fundamentais: Ciclo de vida do software, tipos de teste (funcionais, não-funcionais, regressão, smoke test), criação e execução de casos de teste. Metodologias: Conhecimento em Ágeis (Scrum, Kanban). Gestão de Testes: Jira, Azure DevOps, TestRail. Automação (Diferencial): Contato inicial com Selenium WebDriver (geralmente com Java ou Python), Cypress ou Playwright. Muitas vagas Júnior não exigem automação, mas é um grande diferencial. API (Diferencial): Noção básica de API REST e ferramentas como Postman ou Insomnia. Habilidades Comportamentais: Curiosidade, atenção aos detalhes, boa comunicação (para reportar bugs claramente), vontade de aprender. Referências para busca: 
https://www.linkedin.com/jobs/search/?keywords=analista%2520de%2520testes%2520jr&position=1&pageNum=0
https://portal.gupy.io/job-search/term=teste%2520jr

Nível Pleno
Foco: Autonomia na criação de estratégias de teste, automação robusta e mentoria a juniores.
Vagas Típicas: Analista de Testes Pleno, QA Engineer Pleno, Analista de Automação de Testes. Automação: Experiência sólida em pelo menos uma ferramenta. O mercado está muito forte em: Web: Cypress, Playwright, Selenium WebDriver. API: RestAssured (Java), Supertest (Node.js), Pytest (Python). Mobile: Appium, Espresso (Android), XCUITest (iOS). Linguagens de Programação: Domínio de uma linguagem para automação: Java, JavaScript/TypeScript, Python ou C#. CI/CD: Experiência com integração de testes em pipelines (Jenkins, GitLab CI, GitHub Actions). Bancos de Dados: Conhecimento em SQL para realizar consultas e validar dados. Gestão: Experiência em planejar e estimar esforços de teste para sprints. Habilidades Comportamentais: Proatividade, capacidade de trabalhar com equipes de desenvolvimento e produto, resolução de problemas complexos. Referência para Busca:
https://www.linkedin.com/jobs/search/?keywords=analista%2520de%2520testes%2520pleno%2520OR%2520qa%2520pleno&position=1&pageNum=0

Nível Sênior
Foco: Liderança técnica, definição de estratégia de QA, arquitetura de frameworks de automação e melhoria de processos. Vagas Típicas: Analista/Engenheiro de Testes Sênior, QA Lead, Especialista em Automação de Testes, Arquiteto de Testes. Arquitetura: Capacidade de projetar, implementar e manter frameworks de automação escaláveis e robustos do zero. Estratégia: Definição da Estratégia de Testes (Test Pyramid), escolha de ferramentas e tecnologias para o projeto/empresa. CI/CD Avançado: Otimização de pipelines para testes paralelos, rápidos e confiáveis. Uso de containers (Docker). Performance e Segurança (Diferencial): Conhecimento em ferramentas como k6, JMeter (Performance) ou OWASP ZAP (Segurança) é um grande plus. Gestão de Pessoas: Mentoria da equipe de QA, participação em decisões técnicas e de produto. Habilidades Comportamentais: Liderança, visão estratégica, comunicação clara com todos os níveis (desde desenvolvedores até gestores), capacidade de evangelizar a cultura de qualidade na empresa. Referência para Busca: https://www.catho.com.br/vagas/arquiteto+de+testes
https://www.linkedin.com/jobs/search/?keywords=analista%2520de%2520testes%2520senior%2520OR%2520qa%2520lead&position=1&pageNum=0

![[Pasted image 20250826133843.png]]

- Integrando testes aos times de dev, Automatizando tudo com CI/CD. Mudando o foco para prevenção (Quality Assistance) e não apenas detecção (Quality Assurance). Exigindo perfis técnicos (SDET/QE) que codifiquem.
- Domínio de programação para automação (Java, Python, JS) e ferramentas modernas (Cypress, Playwright, Selenium). Domínio de programação para automação (Java, Python, JS) e ferramentas modernas (Cypress, Playwright, Selenium). Atuar com "Shift-Left", ajudando a prevenir bugs desde o início do desenvolvimento, não apenas encontrá-los no final. Saber escolher O QUE, COMO e QUANDO testar, priorizando eficiência e impacto nos negócios, não apenas cobrir 100% com automação.
- Fim do Testador Manual: A função puramente manual e não técnica será gradualmente extinta. Ascensão do SDET/QE: O futuro é do Software Developer Engineer in Test (SDET) e do Quality Engineer (QE), profissionais altamente técnicos que integram qualidade no processo de desenvolvimento. Especialização em DevOps/CI/CD: Profissionais precisarão dominar a integração de testes em pipelines de entrega contínua para garantir velocidade e confiabilidade. Foco em Estratégia e Dados: O papel evoluirá para definir estratégia de teste, analisar métricas de qualidade e tomar decisões baseadas em dados para melhorar a confiabilidade do produto.

![[Pasted image 20250826140736.png]]

1. Teste Exploratório: 
Técnicas Principais: Sessões de teste com tempo definido, Heurísticas (ex: CRUSSPIC STMPL), Análise e aprendizado contínuo. Ferramentas Comuns: Ferramentas de Anotação: Notepad++, OneNote, Screen Recorder: OBS Studio, Gestão de Bugs: Jira, Trello. 
Teste de Unidade: Técnicas Principais: TDD (Test-Driven Development), Desenvolvimento baseado em comportamentos (BDD). Ferramentas Comuns: Java: JUnit, TestNG, Mockito, JavaScript/TS: Jest, Mocha, Chai, Python: pytest, unittest, C#: xUnit, NUnit, Moq.
Teste de Integração: Técnicas Principais: Teste Top-Down, Bottom-Up, Sandwich, Teste de serviços/componentes interconectados. Ferramentas Comuns: Frameworks de Unidade (JUnit, pytest) com setups complexos, TestContainers (para levantar dependências reais em containers Docker).
Teste de API: Técnicas Principais: Teste de contrato (OpenAPI/Swagger), Teste funcional de endpoints, Teste de carga básica. Ferramentas Comuns: Postman, Insomnia (GUI e automação), REST Assured (Java), Supertest (Node.js), pytest + requests (Python).
Teste de Sistema: Técnicas Principais: Teste baseado em requisitos, Teste funcional e não-funcional completo. Ferramentas Comuns: Ferramentas de Automação de UI: Selenium, Cypress, Playwright. Ferramentas de API (para back-end).
Teste de Aceitação: Técnicas Principais: BDD (Behavior-Driven Development), Definição de critérios com o PO (ex: Gherkin). Ferramentas Comuns: Cucumber (suporte a várias linguagens), SpecFlow (.NET), Behave (Python), Ferramentas de UI/API para automação.
Teste de Usabilidade: Técnicas Principais:  BDD (Behavior-Driven Development), Definição de critérios com o PO (ex: Gherkin). Ferramentas Comuns: Hotjar, Crazy Egg (heatmaps, gravação de sessões), Google Analytics, SurveyMonkey (para pesquisas).
Teste de Desempenho: Técnicas Principais: Teste de Carga (Load Test), Teste de Estresse (Stress Test), Teste de Pico (Spike Test), Teste de Resistência (Soak Test). 
Teste de segurança: Técnicas Principais: SAST (Análise Estática de Segurança), DAST (Análise Dinâmica de Segurança), Teste de Invasão (Pentest). Ferramentas Comuns: k6 (moderno, baseado em código), Gatling (baseado em código, Scala/Java), JMeter (baseado em GUI, amplamente usado).
Teste de Confiablidade: Técnicas Principais: Chaos Engineering (ex: desligar instâncias), Teste de longa duração (Soak Test), Monitoramento de SLOs/SLIs. Ferramentas comuns: OWASP ZAP (DAST), SonarQube (SAST), Burp Suite (Pentest profissional), Snyk, Checkmarx (dependências vulneráveis). 
Teste de regressão: Técnicas Principais: Re-teste de funcionalidades existentes. Ferramentas Comuns: Suite de Automação existente (UI, API), Cypress, Playwright, Selenium (UI), Postman Collections, REST Assured (API).
Teste de recuperação: Técnicas Principais: Simulação de falhas (ex: derrubar servidor, DB), Verificação dos procedimentos de backup e restore. Ferramentas Comuns: Scripts manuais ou automatizados, Chaos Engineering Tools (Gremlin, Chaos Monkey).
Teste de configuração: Técnicas Principais: Teste em diferentes ambientes, OS, browsers, dispositivos. Ferramentas Comuns: Selenium Grid, BrowserStack, Sauce Labs (cross-browser/device), Docker (para diferentes configurações de ambiente). Fontes:
https://www.satisfice.com/download/exploratory-testing
https://www.satisfice.com/blog/archives/1503
https://www.amazon.com/Test-Driven-Development-Kent-Beck/dp/0321146530
https://dannorth.net/introducing-bdd/
https://junit.org/junit5/docs/current/user-guide/
https://docs.pytest.org/en/stable/
https://martinfowler.com/articles/practical-test-pyramid.html
https://www.testcontainers.org/
https://learning.postman.com/docs/writing-scripts/test-scripts/
https://rest-assured.io/
https://swagger.io/specification/
https://cucumber.io/docs/guides/overview/
https://cucumber.io/docs/gherkin/reference/
https://www.nngroup.com/articles/usability-101-introduction-to-usability/
https://www.hotjar.com/usability-testing/
https://k6.io/docs/
https://jmeter.apache.org/usermanual/index.html
https://gatling.io/docs/
https://owasp.org/www-project-top-ten/
https://www.zaproxy.org/
https://portswigger.net/burp/documentation
https://principlesofchaos.org/
https://www.gremlin.com/docs/
https://docs.microsoft.com/en-us/azure/devops/test/overview?view=azure-devops#regression-testing
https://docs.aws.amazon.com/wellarchitected/latest/reliability-pillar/testing-reliability.html
https://www.selenium.dev/documentation/grid/
https://www.browserstack.com/docs/
2. Ferramenta: JUnit 5, Mockito.  Artefato Produzido: Código do Teste Unitário (ex: para uma classe `Calculator`). Relatório de Cobertura de Testes (gerado pelo JaCoCo ou IDE), mostrando que 85% das linhas de código da classe `Calculator` foram exercitadas pelos testes.
3. https://github.com/postmanlabs/newman#reporters https://www.npmjs.com/package/newman-reporter-html https://jestjs.io/docs/configuration#coveragereporters-arraystring--string-options https://jestjs.io/docs/configuration#coveragereporters-arraystring--string-options

![[Pasted image 20250826150031.png]]

- As primeiras iniciativas surgiram na década de 1950, quando os programadores começaram a verificar manualmente seus códigos em busca de erros. O marco significativo foi em 1972, quando **William Hetzel** organizou o primeiro congresso sobre testes de software, estabelecendo as bases formais para a área. Na mesma época, a IBM desenvolveu conceitos de teste estruturado, e o termo "engenharia de software" começou a ganhar força, incorporando testes como parte essencial do ciclo de desenvolvimento.
- No Google, os testes são altamente automatizados e integrados à cultura de desenvolvimento (_eng-driven culture_). Eles seguem práticas como: Testes Unitários: Desenvolvedores são incentivados a escrever testes unitários para suas próprias funcionalidades. Testes de Integração e Sistema: São realizados de forma contínua, integrados ao pipeline de CI/CD (Integração Contínua/Entrega Contínua). Testes Automatizados: A maioria dos testes é automatizada, executada em ambientes que simulam a produção. Culture of Quality: A responsabilidade pela qualidade é compartilhada entre todos os engenheiros, não apenas dos testadores.
- Um dos autores mais referenciados na área de testes de software é **Boris Beizer**, conhecido por suas contribuições fundamentais e livros clássicos como "Software Testing Techniques". Outro autor notável é **Glenford J. Myers**, que escreveu "The Art of Software Testing", considerado uma leitura essencial para testadores.
- Um plano de testes deve conter, pelo menos: Objetivos: Definição clara do que será testado e os objetivos dos testes. Escopo: Itens a serem testados e, igualmente importante, os que não serão. Estratégia de Testes: Abordagem geral, tipos de testes a serem realizados (unitários, integração, sistema, aceitação). Recursos: Equipe, ambiente, ferramentas e infraestrutura necessários. Cronograma: Datas e marcos para as atividades de teste. Critérios de Entrada e Saída: Condições para iniciar e finalizar os testes. Riscos: Possíveis problemas e planos de mitigação.