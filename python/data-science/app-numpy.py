import streamlit as st
import numpy as np
import pandas as pd
import time

@st.cache_data
def load_data():
    return np.genfromtxt("U:\Estudos\Desenvolvimento\Estudos\python\data-science\dsa-fundamentos\capitulo-09\\notebooks\dataset.csv", delimiter=",")

def main():
    x = st.slider('X')
    st.write(x, "squared is", x * x)

    st.text_input("Your name", key="name")
    st.session_state.name

    if st.checkbox("Show dataframe"):
        chart_data = pd.DataFrame(
            np.random.randn(20,3),
            columns=["A","B","C"]
        )

        chart_data

    df = pd.DataFrame({
        "first column": [1, 2, 3, 4],
        "second column": [10, 20, 30, 40],
    })

    option = st.selectbox(
        "Which number do you like best?",
        df['first column']
    )

    'You selected: ', option

    add_selectbox = st.sidebar.selectbox(
        "How would you like to be contacted?",
        ("Email", "Home phone", "Mobile phone")
    )

    add_slider = st.sidebar.slider(
        "Select a range of values",
        0.0, 100.0, (25.0, 75.0)
    )

    left_column, right_column = st.columns(2)
    left_column.button("Press me!")

    with right_column:
        chosen = st.radio(
            "Sorting hat",
            ("Gryffindor", "Ravenclaw", "Hufflepuff", "Slytherin")
        )
        st.write(f"You are in {chosen} house!")

    'Start a long computation...'

    latest_iteration = st.empty()
    bar = st.progress(0)
    for i in range(100):
        latest_iteration.text(f"Iteration {i+1}")
        bar.progress(i+1)
        time.sleep(0.1)

    "...and now we're done!"

    dataframe = pd.DataFrame(load_data())
    st.dataframe(dataframe)

    st.markdown("# Main page")
    st.sidebar.markdown("# Main page")

if __name__ == "__main__":
    main()