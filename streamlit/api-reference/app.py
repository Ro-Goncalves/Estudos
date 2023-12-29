import streamlit as st
from pathlib import Path
import os.path
import os
from dotenv import load_dotenv
import re

load_dotenv()

PATH_MARKDOWN_FILES = os.path.join(Path(__file__).resolve().parent,os.getenv("FOLDER_MARKDOWN"))
def read_markdown_file(markdown_file):
    return Path(PATH_MARKDOWN_FILES, markdown_file).read_text(encoding="utf-8")

def teste():
    path = os.path.join(PATH_MARKDOWN_FILES, folder_reference, file_reference)
    return read_markdown_file(path)

st.set_page_config(
    page_title = os.getenv("APP_NAME"),
    page_icon = ""
)

folder_reference = st.sidebar.selectbox(
     label=os.getenv("LABEL_FOLDER_REFERENCE"), 
     options=[folder for folder in os.listdir(PATH_MARKDOWN_FILES)],
     index=0,
     format_func=(lambda folder: folder.replace("-", " ").title()),
)

file_reference = st.sidebar.selectbox(
    label=os.getenv("LABEL_FILE_REFERENCE"),
    options=[file for file in os.listdir(os.path.join(PATH_MARKDOWN_FILES, folder_reference))],
    index=0,
    format_func=lambda folder: folder.replace(".md", "").capitalize()
)

file_content = teste()
texto_exemplo = re.sub(r".*## Exemplos", "## Exemplos", file_content, flags=re.DOTALL)
texto_sem_exemplo = re.sub(r"## Exemplos.*", "", file_content, flags=re.DOTALL)
python_code = re.findall(r"```python\n(.*?)\n```", texto_exemplo, re.DOTALL)

st.write(texto_sem_exemplo)

st.write("## Exemplos")
for indice, code_block in enumerate(python_code):
    st.write(f"### Exemplo {indice + 1}")
    st.code(code_block)
    exec(code_block)