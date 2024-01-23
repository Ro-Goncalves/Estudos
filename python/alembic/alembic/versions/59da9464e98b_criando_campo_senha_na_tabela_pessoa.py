"""Criando campo senha na tabela pessoa

Revision ID: 59da9464e98b
Revises: 9cccf8b76f10
Create Date: 2024-01-16 23:08:37.951904

"""
from typing import Sequence, Union

from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision: str = '59da9464e98b'
down_revision: Union[str, None] = '9cccf8b76f10'
branch_labels: Union[str, Sequence[str], None] = None
depends_on: Union[str, Sequence[str], None] = None


def upgrade() -> None:
    op.add_column(
        'pessoa', 
        sa.Column('senha', sa.String(length=50), nullable=False))
    
def downgrade() -> None:    
    op.drop_column('pessoa', 'senha')
    
