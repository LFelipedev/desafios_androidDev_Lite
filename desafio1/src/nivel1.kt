fun main() {

    print("Livro: ")
    val nome_livro = readlnOrNull()

    print("Quantas páginas esse livro tem?: ")
    val total_paginas = readLine()?.toInt() ?: 0

    print("Quantas páginas você já leu?: ")
    val paginas_lidas = readLine()?.toInt() ?: 0

    val porcentagem = paginas_lidas.toFloat()/total_paginas.toFloat() * 100f
    val porcentagem_formatada = String.format("%.2f", porcentagem)

    println("-------------------------------------------------------------")

    try {

        if (total_paginas < 1) {
            throw IllegalArgumentException("O número total de páginas deve ser maior que zero.")
        }
        if (paginas_lidas > total_paginas) {
            throw IllegalArgumentException("O número de páginas lidas não pode ser maior que o total de páginas do livro.")
        }

        println("Livro: $nome_livro")
        println("Você já leu $porcentagem_formatada% desse livro!")

    } catch (e: IllegalArgumentException) {

        println("Erro: ${e.message}")
    }
}
