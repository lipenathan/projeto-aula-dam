Projeto Android Disciplina Desenvolvimento de Aplicativos Utilizando API's externas.

Projeto exemplo a ser evoluído durante o decorrer das disciplinas de acordo com o conteudo ministrado.

AULA do dia 06/11/2024

Tópicos Abordados até aqui:

Kotlin
Estrutura de um Projeto Android
AndroidManifest.cml
Layouts xml: LinearLanyout; RelativeLayout; ConstraintLayout
Classe Activity
Classe R
Ciclo de vida da activity
Manipulando dados da UI/XML
ViewBinding
Navegação
Coroutines

Gradle
Retrofit para chamadas REST
Gson como parser de dados recebidos do REST
OkHttp para criar client de chamadas REST


##Suspend Functions##

Um tópico não abordado em aula foram as suspend functions em kotlin.

Uma suspend function ou função suspensa é uma função que pode ser inicializada em derminado tempo em uma thread e ser 
terminada em outro tempo sem parar a Thread em questão.
Essas funções funcionam como um escopo de coroutine e por isso são utilizadas para fazer requisições assíncronas.

Quando uma função é suspensa, podemos utilizar todos os métodos disponíveis dentro de um escopo de coroutine, como delay,
withContext, entre diversos outros.