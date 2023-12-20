# Kubernetes

## PODS

O POD envolve o container, ele é uma unidade do K8s que mantem os conteiner rodando, normalmente possui um container em cada POD. Ele prove recursos para o container.

Para criar um POD podemos criar um manifesto. No nosso caso `pod.yaml`

## REPLICA SET

Um ReplicaSet é usado para garantir que um determinado número de réplicas esteja em execução, e se qualquer uma delas morrer, outra será criada automaticamente.

## DEPLOYMENT

Camada que fica acima do replica set. Ele apaga os pods e recria

## ELASTIC SEARCH


## Progamas uteis

* Kind Kubernets - [Como instalar no ubuntu](https://medium.com/@binitabharati/setting-up-kind-cluster-9393aacbef43) O kind é um projeto que permite rodar kubernetes localmente, sem a necessidade de ter uma máquina virtual ou docker

## Um pouco sobre Kind

Para criar uns cluster

```console
kind create cluster
```

Para acessar o cluster criado

```console
kubectl cluster-invo --context kind-kind
```

para instalar o kubectl

```console
snap install kubectl --classic
```

Para verificar os nodes

```console
kubectl get nodes
```

Usar o arquivo pod.yaml

```console
kubectl apply -f pod.yaml
```

Para deletar os pods

```console
kubectl delete pod nginx
```
