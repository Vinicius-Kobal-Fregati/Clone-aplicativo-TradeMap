package br.com.dio.trademapclone.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.dio.trademapclone.MainActivity
import br.com.dio.trademapclone.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModel() // Com isso, o Koin pode ser utilizado, com ele podemos fazer injeção de independência.

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observaUsuario()
        configuraBotaoLogin()
    }

    private fun configuraBotaoLogin() {
        button.setOnClickListener { //Aqui vamos setar a ação de quando o botão de login ser clicado
            val usuario = textInputLayout.editText?.text.toString() //Criamos a variável usuário que vai possuir o valor que passamos na entrada do editText, temos o "?" porque ela pode ser nula.
            viewModel.login(usuario) //Realizaremos nosso login, passamos essa responsabilidade para o viewModel, para isso usamos o Koin, presente no arquivo LoginViewModel.kt.
        }
    }

    private fun observaUsuario() { //Essa função fica observando o usuário, qualquer mudança nele, ela lança um "alerta".
        viewModel.usuario.observe(viewLifecycleOwner, {
            (activity as MainActivity).toolbar.visibility = View.VISIBLE
            val direcao = LoginFragmentDirections.actionLoginFragmentToFirstFragment()
            findNavController().navigate(direcao)
        })
    }

}