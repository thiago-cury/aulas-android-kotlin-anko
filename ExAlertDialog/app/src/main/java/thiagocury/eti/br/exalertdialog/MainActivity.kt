package thiagocury.eti.br.exalertdialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Site lib Anko: https://github.com/Kotlin/anko
//        Para utilizar a Anko precisamos:
//        Adicionar em buildscript nível do projeto
//        ext.anko_version = '0.10.8' //Não esquecer de verificar por versões mais atuais.
//        Utilizar o implementation a seguir:
//        implementation "org.jetbrains.anko:anko:$anko_version"

        //Dessa forma não estamos internacionalizando o projeto.
        alert("título alert 1","mensagem alert 1") {
            positiveButton("OK") {}
        }.show()

        //Alert com OK e Cancel
        alert("título alert 2", "mensagem alert 2") {
            yesButton {
                toast("Você clicou em ok!")
            }
            noButton {
                toast("Você clicou em cancelar!")
            }
        }.show()

        //ou //Alert com sim e não
        alert("título alert 3", "mensagem alert 3") {
            positiveButton("Sim") {
                toast("Você clicou em sim!")
            }
            negativeButton("Não"){
                toast("Você clicou em não!")
            }
        }.show()

        /* Dessa forma estamos internacionalizando o projeto.
        *  Note que estamos chamando o resources.getString(), assim
        *  mantemos a internacionalização do nosso projeto com base nas variáveis criadas
        *  dentro do strings.xml */
        alert(resources.getString(R.string.alert_title), resources.getString(R.string.alert_message)) {
            positiveButton(resources.getString(R.string.alert_button)) {}
        }.show()

    }
}