from sqlalchemy import Column, Integer, String, create_engine
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()


class Pessoa(Base):
    __tablename__ = 'pessoa'

    id = Column(Integer, primary_key=True)
    nome = Column(String(50), nullable=False)
    email = Column(String(50), nullable=False)
    senha = Column(String(50), nullable=False)

class Pessoa2(Base):
    __tablename__ = 'pessoa2'

    id2 = Column(Integer, primary_key=True)
    nome2 = Column(String(50), nullable=False)
    email2 = Column(String(50), nullable=False)
    senha2 = Column(String(50), nullable=False)