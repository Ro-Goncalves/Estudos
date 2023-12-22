import streamlit as st
import pandas as pd
import pydeck as pdk
from urllib.error import URLError

st.set_page_config(
    page_title = "Mapping Demo",
    page_icon = "🌍"
)

st.markdown("# Mapping Demo")
st.sidebar.header("Mapping Demo")
st.write(
    """This demo shows how to use
[`st.pydeck_chart`](https://docs.streamlit.io/library/api-reference/charts/st.pydeck_chart)
to display geospatial data."""
)

@st.cache_data
def from_data_file(filename):
    url = (
        "http://raw.githubusercontent.com/streamlit/"
        "example-data/master/hello/v1/%s" % filename
    )
    return pd.read_json(url)

try:
    ALL_LAYERS = {
        "Bike Rentals": pdk.Layer(
            data=from_data_file("bike_rental_stats.json"),
            get_position="[lon, lat]",
            radius=200,
            elevation_scale=4
            elevation_range=[0, 1000],
            extruded=True
        )
    }