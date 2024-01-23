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

Para configurar o banco, colocar o seguinte em `sqlalchemy.url` no arquivo **alembic.ini**

```python
sqlalchemy.url = sqlite:///mydatabase.db
```

Con tudo configurado, basta usar:

```console
alembic upgrade head

#Retorno
INFO  [alembic.runtime.migration] Context impl SQLiteImpl.
INFO  [alembic.runtime.migration] Will assume non-transactional DDL.
INFO  [alembic.runtime.migration] Running upgrade  -> 9cccf8b76f10, primeira
```

Para fazer o downgrade

```console
alembic downgrade base
```

Para ver tudo o que foi feito:

```console
alembic history
```

Para saber onde estamos:

```console
alembic history -i
```

O `head` aplica todas as migração, se tivermos 10 ele irá aplicar todas.

### Um pouco Sobre metadados

Primeiro, criamos um arquivo como o seguinte:

```python
from sqlalchemy import Column, Integer, String, create_engine
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()


class Pessoa(Base):
    __tablename__ = 'pessoa'

    id = Column(Integer, primary_key=True)
    nome = Column(String(50), nullable=False)
    email = Column(String(100), nullable=False)
    senha = Column(String(50), nullable=False)
```

Em env.py importamos `from models import Base` e em ***target_metadata*** colocamos `target_metadata = Base.metadata`

Agora é só executar o comando:

```console
alembic revision --autogenerate -m "Criando campo senha na tabela pessoa"

#Retorno
INFO  [alembic.runtime.migration] Context impl SQLiteImpl.
INFO  [alembic.runtime.migration] Will assume non-transactional DDL.
INFO  [alembic.autogenerate.compare] Detected added column 'pessoa.senha'
INFO  [alembic.autogenerate.compare] Detected type change from VARCHAR(length=50) to String(length=100) on 'pessoa.email'
  Generating /home/rogon/Documents/Desenvolvimento/Estudos/python/alembic/alembic/versions/59da9464e98b_c
  riando_campo_senha_na_tabela_pessoa.py ...  done
```

Para conseguir fazer comparação de tipo, temos que incluir `compare_type=True` em, lembrar de colocar em **online** e **offline**

```python
with connectable.connect() as connection:
  context.configure(
      connection=connection, 
      target_metadata=target_metadata,
      compare_type=True
  )
```

## sqlacodegen

é possível trabalhar em um banco que já existe. Para isso usamos o ***sqlacodegen***. Ele é um CLI. Para começar, basta digitar:

```console
sqlacodegen sqlite:///mydatabase.db

#Retorno
# coding: utf-8
from sqlalchemy import Column, Integer, String
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()
metadata = Base.metadata


class Pessoa(Base):
    __tablename__ = 'pessoa'

    id = Column(Integer, primary_key=True)
    nome = Column(String(50), nullable=False)
    email = Column(String(50), nullable=False)
```


https://medium.com/@wilfilho/porque-os-desenvolvedores-python-devem-usar-o-pipenv-ae3d3154c44


https://pt.linux-console.net/?p=6845#google_vignette