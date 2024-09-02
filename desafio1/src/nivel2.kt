class Livro(var nome: String, var genero: String, var autor: String, var total_paginas: Int, var paginas_lidas: Int) {

    fun impressao_final(): Boolean {

        var porcentagem = paginas_lidas.toFloat()/total_paginas.toFloat() * 100f
        var porcentagem_formatada = String.format("%.2f", porcentagem)

        println("Livro: $nome")
        println("Esse livro possui $total_paginas páginas!")
        println("Você já leu $paginas_lidas páginas, isto é $porcentagem_formatada% desse livro!")
        println("Gênero: $genero")
        println("Autor: $autor")

        return true
    }
}

fun main() {
    val livros = mutableListOf<Livro>()

    println("Adicionando livros!")
    println("--------------------------------------------------------------------------------")

    var confirm: String? = "S"
    do {

        print("Digite o nome do livro: ")
        var nome_livro: String? = readLine()

        print("Digite o gênero: ")
        var genero_livro: String? = readLine()

        print("Digite o nome do autor: ")
        var autor_livro: String? = readLine()

        print("Digite o total de páginas: ")
        var total_paginas_livro: Int = readlnOrNull()?.toInt() ?: 0

        print("Digite o total de páginas lidas até o momento: ")
        var paginas_lidas_livros: Int = readlnOrNull()?.toInt() ?: 0

        try {

            if (total_paginas_livro < 1) {
                throw IllegalArgumentException("O número total de páginas deve ser maior que zero.")
            }

            if(paginas_lidas_livros > total_paginas_livro) {
                throw IllegalArgumentException("O número de páginas lidas não pode ser maior que o de páginas do livro.")
            }

            if(nome_livro == "" || genero_livro == "" || autor_livro == "") {
                throw IllegalArgumentException("Você não pode deixar nenhuma informação vazia")
            }

            var livro: Livro = Livro(nome_livro!!, genero_livro!!, autor_livro!!, total_paginas_livro, paginas_lidas_livros)
            livros.add(livro)

        } catch (e: IllegalArgumentException) {

            println("Erro: ${e.message}")
        }

        print("Deseja adicionar outro livro? (S/N): ")
        confirm = readlnOrNull()

        println("--------------------------------------------------------------------------------")
    } while (confirm?.uppercase() != "N")

    println("Acompanhe o progresso de suas leituras aqui!")

    do {
        print("Você deseja acompanhar a leitura qual livro?: ")
        var consulta_livro: String? = readlnOrNull()
        println("--------------------------------------------------------------------------------")

        val livro_procurado = livros.find { it.nome == consulta_livro}

        try {
            val resultado = livro_procurado?.impressao_final() ?: false
            if (!resultado) {
                throw IllegalArgumentException("Digite o nome do livro de forma correta")
            }
        } catch (e: IllegalArgumentException) {
            println("Erro: ${e.message}")
        }

        print("Deseja procurar por outro livro? (S/N): ")
        confirm = readlnOrNull()

        println("--------------------------------------------------------------------------------")
    } while (confirm?.uppercase() != "N")
}