import streamlit as st
from pathlib import Path
import os.path
import os

PATH_MARKDOWN_FILES = os.path.join(Path(__file__).resolve().parent,"markdown-files")
def read_markdown_file(markdown_file):
    return Path(PATH_MARKDOWN_FILES, markdown_file).read_text()

st.set_page_config(
    page_title = "App",
    page_icon = ""
)

st.sidebar.header("API Reference")
option = st.sidebar.selectbox(
    label="Write e Magic",
    placeholder="Olá",
    options=[file for file in os.listdir(os.path.join(PATH_MARKDOWN_FILES, "write-magic"))]
)

intro_markdown = read_markdown_file(option)
st.markdown(intro_markdown)