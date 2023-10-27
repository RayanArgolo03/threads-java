# Projeto de Exemplo: Sistema de Entrega de E-mails

Este projeto é um exemplo de um sistema de entrega de e-mails que simula o processo de envio e recebimento de e-mails em um ambiente multithread.

## Visão Geral

Este projeto consiste em duas classes principais:

1. `EmailProvider`: Esta classe representa o provedor de e-mails. Ele mantém uma fila de e-mails a serem entregues e fornece métodos para adicionar e recuperar e-mails. Além disso, ele pode ser fechado para encerrar o sistema.

2. `EmailDelivery`: Esta classe é responsável por entregar os e-mails. Ela é executada em uma thread separada e verifica continuamente o provedor de e-mails para entregar qualquer e-mail pendente.

## Funcionalidades

- Adicionar e-mails à fila de entrega.
- Entregar e-mails em threads separadas.
- Fechar o provedor de e-mails para encerrar o sistema de entrega.

## Uso

1. Execute o aplicativo `App.java` para iniciar o programa.
2. Insira os e-mails que deseja enviar na caixa de diálogo que aparece.
3. Você pode decidir se deseja manter o programa em execução após enviar os e-mails.
4. Os e-mails serão entregues em threads separadas, com um intervalo de 2 segundos entre cada entrega.
5. Você pode encerrar o programa a qualquer momento digitando um e-mail vazio ou clicando em "Cancelar".

## Pré-requisitos

- Este projeto foi desenvolvido em Java e requer um ambiente Java para ser executado.

## Conteudos Aprendidos
- Threads com programação concorrente
- Optional para prevenção de nullabilidades
- Estrutura de dados Fila (Queue)


