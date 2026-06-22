package com.hamburgueria;

import org.example.gerenciamento.ExpressaoPreco;
import org.example.gerenciamento.ExpressaoTotem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Interpreter: ExpressaoPreco no Totem")
class ExpressaoPrecoTest {

    @Test
    @DisplayName("Deve interpretar corretamente a busca de preço para o hambúrguer de carne")
    void deveInterpretarPrecoCarne() {
        ExpressaoTotem interpretador = new ExpressaoPreco();
        String resultado = interpretador.interpretar("Quanto custa o preco carne?");

        assertTrue(resultado.contains("Hamburguer de Carne"));
        assertTrue(resultado.contains("25.0"));
    }

    @Test
    @DisplayName("Deve interpretar corretamente a busca de preço para o hambúrguer vegano")
    void deveInterpretarPrecoVegano() {
        ExpressaoTotem interpretador = new ExpressaoPreco();
        String resultado = interpretador.interpretar("Me informe o preco do vegano por favor");

        assertTrue(resultado.contains("Hamburguer Vegano"));
        assertTrue(resultado.contains("28.0"));
    }

    @Test
    @DisplayName("Deve pedir especificação caso o cliente envie apenas a palavra PRECO")
    void devePedirEspecificacaoParaComandoIncompleto() {
        ExpressaoTotem interpretador = new ExpressaoPreco();
        String resultado = interpretador.interpretar("Quero ver o preco");

        assertEquals("Por favor, especifique o produto (CARNE ou VEGANO).", resultado);
    }

    @Test
    @DisplayName("Deve retornar mensagem padrão para qualquer texto aleatório não reconhecido")
    void deveRetornarMensagemPadraoParaTextoDesconhecido() {
        ExpressaoTotem interpretador = new ExpressaoPreco();
        String resultado = interpretador.interpretar("Quero falar com o gerente");

        assertEquals("Comando não reconhecido pelo Totem.", resultado);
    }
}