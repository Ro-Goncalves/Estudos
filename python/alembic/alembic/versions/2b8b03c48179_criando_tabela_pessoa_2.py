"""Criando tabela pessoa 2

Revision ID: 2b8b03c48179
Revises: 59da9464e98b
Create Date: 2024-01-17 22:35:08.010968

"""
from typing import Sequence, Union

from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision: str = '2b8b03c48179'
down_revision: Union[str, None] = '59da9464e98b'
branch_labels: Union[str, Sequence[str], None] = None
depends_on: Union[str, Sequence[str], None] = None


def upgrade() -> None:
    with op.batch_alter_table("pessoas",schema=None) as batch_op:
        batch_op.create_table('pessoa2',
        sa.Column('id2', sa.Integer(), nullable=False),
        sa.Column('nome2', sa.String(length=50), nullable=False),
        sa.Column('email2', sa.String(length=50), nullable=False),
        sa.Column('senha2', sa.String(length=50), nullable=False),
        sa.PrimaryKeyConstraint('id2')
    )
   


def downgrade() -> None:
    
    op.drop_table('pessoa2')
   
