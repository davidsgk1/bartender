package com.keegandavidson.bartender.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Drink constructor(
    @JsonProperty("idDrink") val idDrink: String? = null,
    @JsonProperty("strDrink") val strDrink: String? = null,
    @JsonProperty("strCategory") val strCategory: String? = null,
    @JsonProperty("strAlcoholic") val strAlcoholic: String? = null,
    @JsonProperty("strInstructions") val strInstructions: String? = null,
    @JsonProperty("strDrinkThumb") val strDrinkThumb: String? = null
)