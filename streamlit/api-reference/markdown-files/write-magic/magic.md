# Magic

Em resumo: renderiza tudo o que aparecer, coloque o valor em uma váriavel, escreva ela e veja a mágica acontecer

## Como funciona

Sempre que encontra uma váriavel ou valor literal, ele meio que usar o `st.write` para escrever o objeto.

## Exemplos

```python
# Draw a title and some text to the app:

'''
# This is the document title

This is some _markdown_.
'''

import pandas as pd
df = pd.DataFrame({"col1": [1, 2, 3]})
df # Draw the dataframe

x = 10
'x', x # Draw the string 'x' and then the value of x

# Also works with most supported chart types
import matplotlib.pyplot as plt
import numpy as np

arr = np.random.normal(1, 1, size=100)
fig, ax = plt.subplots()
ax.hist(arr, bins=20)

fig # Draw a Matplotlib chart
```
