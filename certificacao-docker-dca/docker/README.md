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
