
# Movies Battle

### API do jogo **Movies Battle**

#### Jogo no estilo quiz que mede o conhecimento do jogador em Filmes   

> #### Feito por 
>
> - [Arthur Miranda](https://github.com/arthmrnd)   
> - [Elias Nogueira](https://github.com/lyusk8)    
> - [Thiago Magdalena](https://github.com/thiagomag)      
    
    

O cadastro do jogador é feito por meio do endpoint /jogador com o método POST passando um json com um nome de usuário "user" (5 a 10) e senha "password" (4 a 8), ambos letras e números, sem caracteres especiais nem espaços, como no exemplo abaixo.     


`{
    "user" : "johndoe",
    "password" : "123456"
}`    


O jogo se incia com a chamada do método GET no endpoint /quizz que retorna dois filmes para que o jogador escolha o filme com a maior nota no IMDB, o jogador responde com o método POST pasando um json com o objeto jogador passando o user e o password, o imdbId do filme escolhido e um booleano qualquer, como no exemplo abaixo.       


`{
    "jogador" : {
    "user" : "lorena",
    "password" : "030401"
    },
    "imdbId" : "tt0848228",
    "resposta" : false
}`     


É possivel acessar o ranking com os melhores jogadores por meio do método endpoint /ranking



