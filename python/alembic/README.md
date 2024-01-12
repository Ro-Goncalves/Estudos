# Um tanto de Alembic

Para iniciar os estudos começar com:

```console
pip install pipenv

echo 'export PATH="/home/rogon/.local/bin:$PATH"' >> ~/.bash_profile
source ~/.bash_profile
```

Dependências:

```java
pipenv install alembic
```

Ativar ambiente:

```console
pipenv shell
```

## Sobre alembic

No console, começe com:

```console
alembic init alembic
```

Para criar uma nova versão do banco:

```console
alembic revision -m"[Descrição]"
```


https://medium.com/@wilfilho/porque-os-desenvolvedores-python-devem-usar-o-pipenv-ae3d3154c44


https://pt.linux-console.net/?p=6845#google_vignette