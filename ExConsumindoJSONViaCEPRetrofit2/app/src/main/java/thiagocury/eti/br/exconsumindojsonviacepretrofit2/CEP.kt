package thiagocury.eti.br.exconsumindojsonviacepretrofit2

import com.google.gson.annotations.SerializedName

data class CEP(
    @SerializedName("bairro")
    var bairro: String = "",
    @SerializedName("cep")
    var cep: String = "",
    @SerializedName("complemento")
    var complemento: String = "",
    @SerializedName("gia")
    var gia: String = "",
    @SerializedName("ibge")
    var ibge: String = "",
    @SerializedName("localidade")
    var localidade: String = "",
    @SerializedName("logradouro")
    var logradouro: String = "",
    @SerializedName("uf")
    var uf: String = "",
    @SerializedName("unidade")
    var unidade: String = ""
)