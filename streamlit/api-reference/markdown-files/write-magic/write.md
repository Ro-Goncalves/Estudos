# Write

É o faz tudo, qualquer coisa que foi passado para ele o `st.write` tentará escrever na tela. Eis algumas de suas propriedades:

* Podemos passar vários argumentos, todos serão escritos;
* Seu comportamento depende dos tipo de entrada;
* Quando não consegue escrever, retorna `none`.

## Assinatura

```python
st.write(*args, unsafe_allow_html=False, **kwargs)
```

* ***args**(any): Um ou mais objetos para serem impressos;
* **unsafe_allow_html**: Não é recomendado usar html, mas se quiser, é só passar True.

## Exemplos

```python
import streamlit as st

st.write("Olá, *Humano!* :sunglasses:")
```

```python
import streamlit as st
import pandas as pd

data_frame = pd.DataFrame({
    "Nome": ["Ana", "Bia", "Carlos"],
    "Idade": [25, 30, 45],
})
st.write(data_frame)
```

```python
import streamlit as st

st.write("1 + 1 = ", 2)
st.write("Estou aqui em cima", data_frame, "Estou aqui em baixo")
```

```python
import streamlit as st
import pandas as pd
import numpy as np
import altair as alt

df = pd.DataFrame(
    np.random.randn(200, 3),
    columns=["Col1", "Col2", "Col3"]
)
c = alt.Chart(df).mark_circle().encode(
    x="Col1", 
    y="Col2",
    size="Col3",
    color="Col3",
    tooltip=["Col1", "Col2", "Col3"]
)
st.write(c)
```
