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

Isso nos traz economia de espaço, já que não precisamos ter uma imagem por container. Imagens são Read-Only sempre (apenas para leitura) e containers representam uma instância de uma imagem. Como imagens são Read-Only os containers criam nova camada (layer) para guardar as alterações

# Salvando dados com volumes

## O que são os volumes?

Quando escrevemos em um container, assim que ele for removido, os dados também serão. Mas podemos criar um local especial dentro dele, e especificamos que esse local será o nosso volume de dados.

Quando criamos um volume de dados, o que estamos fazendo é apontá-lo para uma pequena pasta no Docker Host. Então, quando criamos um volume, criamos uma pasta dentro do container, e o que escrevermos dentro dessa pasta na verdade estaremos escrevendo do Docker Host.

Isso faz com que não percamos os nossos dados, pois o container até pode ser removido, mas a pasta no Docker Host ficará intacta.

## Trabalhando com volumes

Sabendo disso, vamos ver como trabalhar com o Docker Host. No Terminal ou PowerShell (ou Docker Quickstart Terminal), criamos um container com o docker run, mas dessa vez utilizando a flag -v para criar um volume, seguido do nome do mesmo:

`docker run -v "/var/www" ubuntu`

No exemplo acima, criamos o volume /var/www, mas a que pasta no Docker Host ele faz referência? Para descobrir, podemos inspecionar o container, executando o comando docker inspect, passando o seu id para o mesmo:

`docker inspect 8cf7b40ce226`

Temos uma saída com diversas informações, mas a que nos interessa é o "Mounts":

```
"Mounts": [
    {
        "Type": "volume",
        "Name": "5e1cbfd48d07284680552e56087c9d5196659600ccd6874bfa3831b51ddd0576",
        "Source": "/var/lib/docker/volumes/5e1cbfd48d07284680552e56087c9d5196659600ccd6874bfa3831b51ddd0576/_data",
        "Destination": "/var/www",
        "Driver": "local",
        "Mode": "",
        "RW": true,
        "Propagation": ""
    }
]
```

Nele, podemos ver que o /var/www será escrito na nossa máquina no diretório /var/lib/docker/volumes/5e1cbfd48d07284680552e56087c9d5196659600ccd6874bfa3831b51ddd0576/_data, endereço que foi gerado automaticamente pelo Docker. Ou seja, tudo que escrevermos na pasta /var/www do container, na verdade estaremos escrevendo na pasta /var/lib/docker/volumes/5e1cbfd48d07284680552e56087c9d5196659600ccd6874bfa3831b51ddd0576/_data da nossa máquina.

E ao remover o container, a pasta continuará na nossa máquina. Essa pasta gerada pelo Docker pode ser configurada, podemos dizer a pasta que será referenciada pela pasta /var/www do container. Por exemplo, se quisermos escrever dentro do Desktop da nossa máquina, devemos passá-lo antes do volume, separando-os com dois pontos. Além disso, vamos executar o container no modo interativo:

```bash
docker run -it -v "/home/eduardo/Desktop:/var/www" ubuntu
root@abd0286c0083:/#
```

Ou seja, quando escrevermos na pasta /var/www do container, estaremos escrevendo no Desktop da nossa máquina. Para provar isso, na pasta /var/www, vamos criar um arquivo e escrever nele uma mensagem:

```bash
root@abd0286c0083:/# cd /var/www/
root@abd0286c0083:/var/www# touch novo-arquivo.txt
root@abd0286c0083:/var/www# echo "Este arquivo foi criado dentro de um volume" > novo-arquivo.txt
```

Ao acessarmos o nosso Desktop, o arquivo estará lá, também com a mensagem escrita. E ao remover o container, a sua camada de escrita é removida, mas os arquivos continuam no nosso Desktop.

Então, o uso de volumes é importante para salvarmos os nossos dados fora do container, e esses volumes sempre estarão atrelados ao Docker Host. No caso acima, atrelamos o volume com o Desktop, mas podemos atrelar com um lugar mais seguro, salvando os dados do banco de dados nele, logs, e até mesmo o código fonte

# Criando um Dockerfile

Já trabalhamos com a imagem do ubuntu, hello-world, dockersamples/static-site e por fim do node, mas até agora não criamos a nossa própria imagem, para podermos distribuir para as outras pessoas.

No começo do treinamento, foi comentado que a imagem é como se fosse uma receita de bolo. Então, para criarmos a nossa própria imagem, temos que criar a nossa receita de bolo, o Dockerfile, ensinando o Docker a criar uma imagem a partir da nossa aplicação, para que ela seja utilizada em outros locais.

## Montando o Dockerfile

Então, no nosso projeto, devemos criar o arquivo Dockerfile, que nada mais é do que um arquivo de texto. Ele pode ter qualquer nome, porém nesse caso ele também deve possuir a extensão .dockerfile, por exemplo node.dockerfile, mas vamos manter o nome padrão mesmo.

Geralmente, montamos as nossas imagens a partir de uma imagem já existente. Nós podemos criar uma imagem do zero, mas a prática de utilizar uma imagem como base e adicionar nela o que quisermos é mais comum. Para dizer a imagem-base que queremos, utilizamos a palavra FROM mais o nome da imagem.

Como o nosso projeto precisa do Node.js, vamos utilizar a sua imagem:

`FROM node`

Além disso, podemos indicar a versão da imagem que queremos, ou utilizar o **latest**, que faz referência à versão mais recente da imagem. Se não passarmos versão nenhuma, o Docker irá assumir que queremos o **latest**, mas vamos deixar isso explícito:

`FROM node:latest`

Outra instrução que é comum colocarmos é quem cuida, quem criou a imagem, através do MAINTAINER(depreciado, a recomendação da documetação é usar LABEL):

    FROM node:latest
    MAINTAINER Eduardo Freitas
    
Agora, especificamos o que queremos na imagem. No caso, queremos colocar o nosso código dentro da imagem, então utilizarmos o COPY. Como queremos copiar tudo o que está dentro da pasta, vamos utilizar o . para copiar tudo que está na pasta do arquivo Dockerfile, e vamos copiar para /var/www, do exemplo da aula anterior:

    FROM node:latest
    MAINTAINER Eduardo Freitas
    COPY . /var/www
    
No projeto, já temos as suas dependências dentro da pasta node_modules, mas não queremos copiar essa pasta para dentro do container, pois elas podem estar desatualizadas, quebradas, então queremos que a própria imagem instale as dependências para nós, rodando o comando npm install. Para executar um comando, utilizamos o RUN:

    FROM node:latest
    MAINTAINER Eduardo Freitas
    COPY . /var/www
    RUN npm install

Agora, deletamos a pasta node_modules, para ela não ser copiada para o container. Além disso, toda imagem possui um comando que é executado quando a mesma inicia, e o comando que utilizamos na aula anterior foi o npm start. Para isso, utilizamos o ENTRYPOINT, que executará o comando que quisermos assim que o container for carregado:

    FROM node:latest
    MAINTAINER Eduardo Freitas
    COPY . /var/www
    RUN npm install
    ENTRYPOINT npm start
    
Também podemos passar o comando como se fosse em um array, por exemplo ["npm", "start"], ambos funcionam.

Falta colocarmos a porta em que a aplicação executará, a porta em que ela ficará exposta. Para isso, utilizamos o EXPOSE:

    FROM node:latest
    MAINTAINER Eduardo Freitas
    COPY . /var/www
    RUN npm install
    ENTRYPOINT ["npm", "start"]
    EXPOSE 3000

Por fim, falta dizermos onde os comandos rodarão, pois eles devem ser executados dentro da pasta /var/www. Então, através do WORKDIR, assim que copiarmos o projeto, dizemos em qual diretório iremos trabalhar;

    FROM node:latest
    MAINTAINER Eduardo Freitas
    WORKDIR /var/www
    RUN npm install
    ENTRYPOINT npm start
    EXPOSE 3000

Com isso, finalizamos o Dockerfile, baseado no comando que fizemos na aula anterior:

`eduardo@pop-os:~/Desktop/volume-exemplo$ docker run -p 8080:3000 -v "$(pwd):/var/www" -w "/var/www" node npm start`

Resta agora criar a imagem.

## Criando a imagem

Para criar a imagem, precisamos fazer o seu build através do comando docker build, comando utilizado para buildar uma imagem a partir de um Dockerfile. Para configurar esse comando, passamos o nome do Dockerfile através da flag -f:

`eduardo@pop-os:~/Desktop/volume-exemplo$ docker build -f Dockerfile`

Como o nome do nosso Dockerfile é o padrão, poderíamos omitir esse parâmetro, mas se o nome for diferente, por exemplo node.dockerfile, é preciso especificar, mas vamos deixar especificado para detalharmos melhor o comando.

Além disso, passamos a tag da imagem, o seu nome, através da flag -t. Já vimos que para imagens não-oficiais, colocamos o nome no padrão NOME_DO_USUARIO/NOME_DA_IMAGEM, então é isso que faremos, por exemplo:

`eduardo@pop-os:~/Desktop/volume-exemplo$ docker build -f Dockerfile -t edufreitass/node`

E agora dizemos onde está o Dockerfile. Como já estamos rodando o comando dentro da pasta volume-exemplo, vamos utilizar o ponto (.);

`eduardo@pop-os:~/Desktop/volume-exemplo$ docker build -f Dockerfile -t edufreitass/node .`

Ao executar o comando, podemos perceber que cada instrução executada do nosso Dockerfile possui um id. Isso por que para cada passo o Docker cria um container intermediário, para se aproveitar do seu sistema de camadas. Ou seja, cada instrução gera uma nova camada, que fará parte da imagem final, que nada mais é do que a imagem-base com vários containers intermediários em cima, sendo que cada um desses containers representa um comando do Dockerfile.

Assim, se um dia a imagem precisar ser alterada, somente o container referente à instrução modificada será alterado, com as outras partes intermediárias da imagem já prontas.

## Criando um container a partir da nossa imagem

Agora que já temos a imagem criada, podemos criar um container a partir dela:

`docker run -d -p 8080:3000 edufreitass/node`

Ao acessar o endereço da porta no navegador, vemos a página da nossa aplicação. No Dockerfile, também podemos criar variáveis de ambiente, utilizando o ENV. Por exemplo, para criar a variável PORT, para dizer em que porta a nossa aplicação irá rodar, fazemos:

    FROM node:latest
    MAINTAINER Eduardo Freitas
    ENV PORT=3000
    COPY . /var/www
    WORKDIR /var/www
    RUN npm install
    ENTRYPOINT npm start
    EXPOSE 3000

E no próprio Dockerfile, podemos utilizar essa variável:

    FROM node:latest
    MAINTAINER Eduardo Freitas
    ENV PORT=3000
    COPY . /var/www
    WORKDIR /var/www
    RUN npm install
    ENTRYPOINT npm start
    EXPOSE $PORT

E como modificamos o Dockerfile, precisamos construir a nossa imagem novamente e podemos perceber que dessa vez o comando é bem mais rápido, já que quase todas as camadas estão cacheadas pelo Docker.

Agora que criamos a imagem, vamos disponibilizá-la para outras pessoas.

# Networking no Docker

## Redes com Docker

A boa notícia é que no Docker, por padrão, já existe uma default network. Isso significa que, quando criamos os nossos containers, por padrão eles funcionam na mesma rede:

![image](https://user-images.githubusercontent.com/56324728/144936796-24619849-6e24-4179-a93e-6de650f8b9ad.png)

Para verificar isso, vamos subir um container com Ubuntu:

`docker run -it ubuntu`

Em outro terminal, vamos verificar o id desse container através do comando docker ps, e com ele em mãos, vamos passá-lo para o comando docker inspect. Na saída desse comando, em NetworkSettings, vemos que o container está na rede padrão bridge, rede em que ficam todos os containers que criamos.

Voltando ao terminal do container, se executarmos o comando hostname -i vemos o IP atribuído a ele pela rede local do Docker:

    root@973feeeeb1df:/# hostname -i
    172.17.0.2
    
Então, dentro dessa rede local, os containers podem se comunicar através desses IPs. Para comprovar isso, vamos deixar esse container rodando e criar um novo:

`docker run -it ubuntu`

E vamos verificar o seu IP:

    root@dd316a9f585f:/# hostname -i
    172.17.0.3

Agora, no primeiro container, vamos instalar o pacote iputils-ping para podermos executar o comando ping para verificar a comunicação entre os containers:

`root@973feeeeb1df:/# apt-get update && apt-get install iputils-ping`

Após o término da instalação, executamos o comando ping, passando para ele o IP do segundo container. Para interromper o comando, utilizamos o atalho CTRL + C:

    root@973feeeeb1df:/# ping 172.17.0.3
    PING 172.17.0.3 (172.17.0.3) 56(84) bytes of data.
    64 bytes from 172.17.0.3: icmp_seq=1 ttl=64 time=0.180 ms
    64 bytes from 172.17.0.3: icmp_seq=2 ttl=64 time=0.133 ms
    64 bytes from 172.17.0.3: icmp_seq=3 ttl=64 time=0.148 ms
    ^C
    --- 172.17.0.3 ping statistics ---
    3 packets transmitted, 3 received, 0% packet loss, time 1999ms
    rtt min/avg/max/mdev = 0.133/0.153/0.180/0.024 ms
    
Assim, podemos ver que os containers estão conseguindo se comunicar entre eles.

## Comunicação entre containers utilizando os seus nomes

Então, o Docker criar uma rede virtual, em que todos os containers fazem parte dela, com os IPs automaticamente atribuídos. Mas quando os IPs são atribuídos, cada hora em que subirmos um container, ele irá receber um IP novo, que será determinado pelo Docker. Logo, se não sabemos qual o IP que será atribuído, isso não é muito útil quando queremos fazer a comunicação entre os containers. Por exemplo, podemos querer colocar dentro do aplicativo o endereço exato do banco de dados, e para saber exatamente o endereço do banco de dados, devemos configurar um nome para aquele container.

Mas nomear um container nós já sabemos, basta adicionar o --name, passando o nome que queremos na hora da criação do container, certo? Apesar de conseguirmos dar um nome a um container, a rede do Docker não permite com que atribuamos um hostname a um container, diferentemente de quando criamos a nossa própria rede.

Na rede padrão do Docker, só podemos realizar a comunicação utilizando IPs, mas se criarmos a nossa própria rede, podemos "batizar" os nossos containers, e realizar a comunicação entre eles utilizando os seus nomes:

![image](https://user-images.githubusercontent.com/56324728/144937075-4e88d7cd-be8a-4124-8ff1-8f8ea8bb0a31.png)

Isso não pode ser feito na rede padrão do Docker, somente quando criamos a nossa própria rede.

## Criando a nossa própria rede do Docker

Então, vamos criar a nossa própria rede, através do comando docker network create, mas não é só isso, para esse comando também precisamos dizer qual driver vamos utilizar. Para o padrão que vimos, de ter uma nuvem e os containers compartilhando a rede, devemos utilizar o driver de bridge.

Especificamos o driver através do --driver e após isso nós dizemos o nome da rede. Um exemplo do comando é o seguinte:

`docker network create --driver bridge minha-rede`

Agora, quando criamos um container, ao invés de deixarmos ele ser associado à rede padrão do Docker, atrelamos à rede que acabamos de criar, através da flag --network. Vamos aproveitar e nomear o container: 

`docker run -it --name meu-container-de-ubuntu --network minha-rede ubuntu`

Agora, se executarmos o comando docker inspect meu-container-de-ubuntu, podemos ver em NetworkSettings o container está na rede minha-rede. E para testar a comunicação entre os containers na nossa rede, vamos abrir outro terminal e criar um segundo container:

`docker run -it --name segundo-ubuntu --network minha-rede ubuntu`

Agora, no segundo-ubuntu, instalamos o ping e testamos a comunicação com o meu-container-de-ubuntu:

    root@00f93075d079:/# ping meu-container-de-ubuntu
    PING meu-container-de-ubuntu (172.18.0.2) 56(84) bytes of data.
    64 bytes from meu-container-de-ubuntu.minha-rede (172.18.0.2): icmp_seq=1 ttl=64 time=0.210 ms
    64 bytes from meu-container-de-ubuntu.minha-rede (172.18.0.2): icmp_seq=2 ttl=64 time=0.148 ms
    64 bytes from meu-container-de-ubuntu.minha-rede (172.18.0.2): icmp_seq=3 ttl=64 time=0.138 ms
    ^C
    --- meu-container-de-ubuntu ping statistics ---
    3 packets transmitted, 3 received, 0% packet loss, time 2000ms
    rtt min/avg/max/mdev = 0.138/0.165/0.210/0.033 ms

Conseguimos realizar a comunicação entre os containers utilizando somente os seus nomes. É como se o Docker Host, o ambiente que está rodando os containers, criasse uma rede local chamada minha-rede, e o nome do container será utilizado como se fosse um hostname.

Mas lembrando que só conseguimos fazer isso em redes próprias, redes que criamos, isso não é possível na rede padrão dos containers.

# Entendendo o Docker Compose

Docker Compose nos auxilia a lidar com múltiplos containers simultaneamente.

Para subir a aplicação alura-books, foi necessário subirmos dois containers, executando os seguintes comandos:

    docker run -d --name meu-mongo --network minha-rede mongo
    docker run --network minha-rede -d -p 8080:3000 douglasq/alura-books:cap05

Isso tudo depois de termos construído pelo menos a imagem douglasq/alura-books

## O problema

Esses dois comandos criam dois containers, mas subindo eles desse jeito manual, é muito comum esquecermos de passar alguma flag, ou subir o container na ordem errada, sem a devida rede, ou seja, é um trabalho muito manual e facilmente suscetível a erros, isso com somente dois containers.

Esse modo de subir os containers na mão é bom se quisermos criar um ambiente rapidamente, ou são poucos containers, mas quando a aplicação começa a crescer, temos que digitar muitos comandos.

## Funcionamento das aplicações em geral

Na vida real, sabemos que a aplicação é maior que somente dois containers, geralmente temos dois, três ou mais containers para segurar o tráfego da aplicação, distribuindo a carga. Além disso, temos que colocar todos esses containers para se comunicar com o banco de dados em um outro container, mas quanto maior a aplicação, devemos ter mais de um container para o banco também.

E claro, se temos três aplicações rodando, não podemos ter três endereços diferentes, então nesses casos utilizamos um Load Balancer em um outro container, para fazer a distribuição de carga quando tivermos muitos acessos. Ele recebe as requisições e distribui para uma das aplicações, e ele também é muito utilizado para servir os arquivos estáticos, como imagens, arquivos CSS e JavaScript. Assim, a nossa aplicação controla somente a lógica, as regras de negócio, com os arquivos estáticos ficando a cargo do Load Balancer:

![image](https://user-images.githubusercontent.com/56324728/144945689-1154c579-5c27-46e3-ba77-a18b8ee49654.png)

Se formos seguir esse diagrama, teríamos que criar cinco containers na mão, e claro, cada container com configurações e flags diferentes, além de termos que nos preocupar com a ordem em que vamos subi-los.

## Docker Compose

Ao invés de subir todos esses containers na mão, o que vamos fazer é utilizar uma tecnologia aliada do Docker, chamada Docker Compose, feito para nos auxiliar a orquestrar melhor múltiplos containers. Ele funciona seguindo um arquivo de texto YAML (extensão .yml), e nele nós descrevemos tudo o que queremos que aconteça para subir a nossa aplicação, todo o nosso processo de build, isto é, subir o banco, os containers das aplicações, etc.

Assim, não precisamos ficar executando muitos comandos no terminal sem necessidade. E esse será o foco desta aula, montar uma aplicação na estrutura descrita anteriormente na imagem, que é uma situação comum no nosso dia-a-dia.

### Observação: todo esse conteúdo foi retirado do curso da Alura.
