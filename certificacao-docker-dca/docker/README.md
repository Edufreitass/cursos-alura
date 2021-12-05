# Docker: Criando containers sem dor de cabeça

- Suba um container Docker
- Crie e personalize imagens
- Crie receitas e scripts
- Faça seus containers comunicarem entre si
- Faça deploy na nuvem

# O que é o Docker?

![image](https://user-images.githubusercontent.com/56324728/144732165-04fd4009-7e21-4681-8cf0-e77b626e2bcd.png)

## Docker, Inc.

Primeiramente, devemos falar sobre a Docker, Inc., que no início era chamada de dotCloud. 
A dotCloud era uma empresa de PaaS (Platform as a Service), sendo responsável pela hospedagem da nossa aplicação, 
levantando o servidor, configurando-o, liberando portas, etc, fazendo tudo o que é necessário para subir a nossa aplicação. 
Outros exemplos de empresas de PaaS são o Heroku, Microsoft Azure e Google Cloud Platform.

Inicialmente, para prover a parte de infraestrutura, a dotCloud utilizava o Amazon Web Services (AWS), serviço que 
nos disponibiliza máquinas virtuais e físicas para trabalharmos. E para hospedar uma aplicação, sabemos que precisamos do sistema operacional, 
mas a dotCloud introduziu o conceito de containers na hora de subir uma aplicação, dando origem ao Docker, 
tecnologia utilizada para baratear o custo de hospedar várias aplicações em uma mesma máquina.

Ou seja, quando a dotCloud criou o Docker, sua intenção era economizar os gastos da empresa, subindo várias aplicações em containers, 
em um mesmo hardware do AWS, e com o passar do tempo a empresa percebeu que tinham muitos desenvolvedores interessados na tecnologia 
que ela havia criado, a tecnologia que permite a criação de containers, que faz o intermédio entre eles e o sistema operacional, o Docker.

## As tecnologias do Docker

O Docker nada mais é do que uma coleção de tecnologias para facilitar o deploy e a execução das nossas aplicações. 
A sua principal tecnologia é a Docker Engine, a plataforma que segura os containers, fazendo o intermédio entre o sistema operacional.

Outras tecnologias do Docker que facilitam a nossa vida e que veremos neste curso são o Docker Compose, 
um jeito fácil de definir e orquestrar múltiplos containers; o Docker Swarm, uma ferramenta para colocar múltiplos docker engines para 
trabalharem juntos em um cluster; o Docker Hub, um repositório com mais de 250 mil imagens diferentes para os nossos containers; 
e a Docker Machine, uma ferramenta que nos permite gerenciar o Docker em um host virtual.

## Open Source

Quando a empresa dotCloud tornou-se a Docker, Inc., focada em manter o Docker, ela o abriu para o mundo open source, 
tudo disponibilizado no seu GitHub, inclusive com várias empresas contribuindo para o desenvolvimento dessa tecnologia.

Apesar de haver alguns serviços pagos, em sua grande parte a tecnologia do Docker é uma tecnologia open source, utilizada por várias empresas.

# O problema das máquinas virtuais

## A evolução do host de aplicações

Antigamente, quando queríamos montar o nosso sistema, com vários serviços (bancos de dados, proxy, etc) e aplicações, 
acabávamos tendo vários servidores físicos, cada um com um serviço ou aplicação do nosso sistema, por exemplo:

![image](https://user-images.githubusercontent.com/56324728/144731971-30f6b05e-8b74-4ae9-bed8-049dd60c4778.png)

E claro, não conseguimos instalar os serviços diretamente no hardware do servidor, ou seja, precisamos de um intermediário 
entre as aplicações e o hardware, que é o sistema operacional. Ou seja, devemos instalar sistemas operacionais em cada servidor, 
e os sistemas poderiam ser diferentes:

![image](https://user-images.githubusercontent.com/56324728/144731986-f6802a37-2944-4b2d-9eee-6cf46404271d.png)

E se quisermos que uma aplicação se comunique com outra ou faça qualquer comunicação externa, devemos conectar os servidores à rede. 
Além disso, para eles funcionarem, precisamos ligá-los à eletricidade. Logo, havia diversos custos de eletricidade, rede e configuração dos servidores.

Além disso, o processo era lento, já que a cada nova aplicação, deveríamos comprar/montar o servidor físico, instalar o sistema operacional, 
configurá-lo e subir a aplicação.

## Capacidade pouco aproveitada

O que foi falado anteriormente não era o único problema desse tipo de arquitetura. Era muito comum termos servidores parrudos, 
com uma única aplicação sendo executada, para normalmente ficarem funcionando abaixo da sua capacidade, para quando for necessário, 
o servidor aguentar uma grande quantidade de acessos. Isso resultava em muita capacidade ociosa nos servidores, com muitos recursos desperdiçados.

## Virtualização, uma solução?

Para fugir desses problemas de servidores ociosos e alto tempo e custo de subir e manter aplicações em servidores físicos, 
surgiu como solução a virtualização, surgindo assim as máquinas virtuais.

As máquinas virtuais foram possíveis de ser criadas graças a uma tecnologia chamada Hypervisor, que funciona em cima do sistema operacional, 
permitindo a virtualização dos recursos físicos do nosso sistema. Assim, criamos uma máquina virtual que tem acesso a uma parte do nosso HD, 
memória RAM e CPU, criando um computador dentro de outro:

![image](https://user-images.githubusercontent.com/56324728/144732017-f6eb1120-af8b-4d49-bd66-be03d4ae7ef2.png)

E se temos uma máquina virtual que está acessando uma parte do nosso hardware como um todo, conseguimos colocar dentro dela uma das nossas aplicações. 
E replicar isso, criando mais máquinas virtuais com outras aplicações:

![image](https://user-images.githubusercontent.com/56324728/144732033-6693abba-f7de-400d-a3fb-d480253d976b.png)

Assim, reduzimos a quantidade de servidores e consequentemente os custos com luz e rede. Além disso, 
dividimos melhor o nosso hardware, aproveitando melhor os seus recursos e diminuindo a ociosidade.

## Problemas das máquinas virtuais

Apesar de resolver os problemas do uso de vários servidores físicos, as máquinas virtuais também possuem problemas. 
Para podermos hospedar a nossa aplicação em uma máquina virtual, também precisamos instalar um sistema operacional nela:

![image](https://user-images.githubusercontent.com/56324728/144732056-382f9513-da8a-4abc-bc91-8d0ac5b0e1db.png)

Cada aplicação necessita de um sistema operacional para poder ser executada, e esses sistemas podem ser diferentes. 
E apesar dos sistemas operacionais serem um software, eles possuem um custo de memória RAM, disco e processamento. 
Ou seja, precisamos de uma capacidade mínima para manter as funcionalidades de um sistema operacional, 
aumentando o seu custo de manutenção a cada sistema que tivermos.

Além disso, há um custo de configuração, isto é, liberar portas, instalar alguma biblioteca específica, etc, 
toda uma configuração que um sistema operacional pede. Também devemos sempre estar atentos à sua segurança, 
mantendo o sistema de cada máquina virtual sempre atualizado.

Muitas vezes, o tempo voltado para a manutenção das máquinas virtuais era o mesmo tempo voltado para a nossa aplicação em si. 
Ou seja, acabávamos dividindo o valor da nossa empresa, ao invés de focar somente nas aplicações, 
dividíamos o trabalho com a manutenção dos sistemas operacionais.

# A era dos containers

Um container funcionará junto do nosso sistema operacional base, e conterá a nossa aplicação, ou seja, a aplicação será executada dentro dele. 
Criamos um container para cada aplicação, e esses containers vão dividir as funcionalidades do sistema operacional:

![image](https://user-images.githubusercontent.com/56324728/144732239-296c6128-9351-4b2e-a18a-1278268e7949.png)

Não temos mais um sistema operacional para cada aplicação, já que agora as aplicações estão dividindo o mesmo sistema operacional, que está em cima do nosso hardware. Os próprios containers terão a lógica que se encarregará dessa divisão.

Assim, com somente um sistema operacional, reduzimos os custos de manutenção e de infraestrutura como um todo.

## Vantagens de um container

Por não possuir um sistema operacional, o container é muito mais leve e não possui o custo de manter múltiplos sistemas operacionais, 
já que só teremos um sistema operacional, que será dividido entre os containers.

Além disso, por ser mais leve, o container é muito rápido de subir, subindo em questão de segundos. Logo, o container é uma solução para suprir o problema de múltiplas máquinas virtuais em um hardware físico, já que com o container, nós dividimos o sistema operacional entre as nossas aplicações.

## Necessidade do uso de containers

Mas por que precisamos dos containers, não podemos simplesmente instalar as aplicações no nosso próprio sistema operacional? 
Até por que já fazemos isso, já que no nosso sistema operacional temos um editor de texto, terminal, navegador, etc.

No caso das nossas aplicações, essa abordagem pode ter alguns problemas. Por exemplo, se dois aplicativos precisarem utilizar a mesma porta de rede? Precisaremos de algo para isolar uma aplicação da outra. E se uma aplicação consumir toda a CPU, a ponto de prejudicar o funcionamento das outras aplicações? Isso acontece se não limitarmos a aplicação. Outro problema que pode ocorrer é cada aplicação precisar de uma versão específica de uma linguagem, por exemplo, uma aplicação precisa do Java 7 e outra do Java 8. Além disso, uma aplicação pode acabar congelando todo o sistema. Por isso é bom ter essa separação das aplicações, isolar uma da outra, e isso pode ser feito com os containers.

Com os containers, conseguimos limitar o consumo de CPU das aplicações, melhorando o controle sobre o uso de cada recurso do nosso sistema (CPU, rede, etc). Também temos uma facilidade maior em trabalhar com versões específicas de linguagens/bibliotecas, além de ter uma agilidade maior na hora de criar e subir containers, já que eles são mais leves que as máquinas virtuais.

# Layered File System

## Camadas de uma imagem

Quando baixamos a imagem do Ubuntu, reparamos que ela possui camadas, mas como elas funcionam? Toda imagem que baixamos é composta de uma ou mais camadas, e esse sistema tem o nome de Layered File System.

Essas camadas podem ser reaproveitadas em outras imagens. Por exemplo, já temos a imagem do Ubuntu, isso inclui as suas camadas, e agora queremos baixar a imagem do CentOS. Se o CentOS compartilha alguma camada que já tem na imagem do Ubuntu, o Docker é inteligente e só baixará as camadas diferentes, e não baixará novamente as camadas que já temos no nosso computador:

![image](https://user-images.githubusercontent.com/56324728/144732907-ab5e2696-ed35-4f54-929a-ccbfa4691f86.png)

No caso da imagem acima, o Docker só baixará as duas primeiras camadas da imagem do CentOS, já que as duas últimas são as mesmas da imagem do Ubuntu, que já temos na nossa máquina. Assim poupamos tempo, já que precisamos de menos tempo para baixar uma imagem.

Uma outra vantagem é que as camadas de uma imagem são somente para leitura. Mas como então conseguimos criar arquivos na aula anterior? O que acontece é que não escrevemos na imagem, já que quando criamos um container, ele cria uma nova camada acima da imagem, e nessa camada podemos ler e escrever:

![image](https://user-images.githubusercontent.com/56324728/144732915-db304136-9003-42fb-b70d-60fd2e8b7199.png)

Então, quando criamos um container, ele é criado em cima de uma imagem já existente e nele nós conseguimos escrever. E com uma imagem base, podemos reaproveitá-la para diversos containers:

![image](https://user-images.githubusercontent.com/56324728/144732918-fa10eb1a-53e3-49ea-b19a-3049a2125d5b.png)

Isso nos traz economia de espaço, já que não precisamos ter uma imagem por container.

### Observação: todo esse conteúdo foi retirado do curso da Alura.
