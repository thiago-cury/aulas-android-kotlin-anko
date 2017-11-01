package thiagocury.eti.br.extoast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Site lib Anko: https://github.com/Kotlin/anko
        //Para utilizar a Anko precisamos:
        //Adicionar em buildscript nível do projeto
        //ext.anko_version = '0.10.2' //Não esquecer de verificar por versões mais atuais.
        //Utilizar o compile a seguir:
        //compile "org.jetbrains.anko:anko:$anko_version"

        //Dessa forma não estamos internacionalizando o projeto.
        toast("Olá, mensagem enviada via Toast!");

        /* Dessa forma estamos internacionalizando o projeto.
        *  Note que estamos chamando resources().getString(), assim
        *  mantemos a internacionalização do nosso projeto com base nas variáveis criadas
        *  dentro do strings.xml */
        toast(resources.getString(R.string.toast_message));

        /* Chamando toast normal ela vai permanecer na tela conforme o tempo de: Toast.LENGTH_SHORT
         * enquanto o método longToast vai permanecer conforme: Toast.LENGTH_LONG */
        longToast(resources.getString(R.string.long_toast_message));
    }
}
