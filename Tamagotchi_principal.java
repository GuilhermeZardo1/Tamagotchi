  
    // Ciências da Computação - Unisinos
    // Trabalho para a disciplina de Algoritmos e Programação: Fundamentos.
    // Tarefa 3
    // Aluno Guilherme Luthemaier Zardo
  
public class Tamagotchi_principal  {

    public static void main( String[] args ) {

    //Cria uma instância da classe teclado;
    
    Teclado teclado = new Teclado();

    /*Ao iniciar o jogo, solicita ao usuário que crie um nome para o Tamagotchi e depois
    associa o nome à instância criada do Tamagotch*/

    System.out.println("Digite um nome para o seu Tamagotchi:\n");
    String nome = teclado.leString();
    Tamagotchi jogo = new Tamagotchi(nome, 0, 1);

    /*Enquanto a variável flag da instância criada estiver como falsa, chama a função
    geraNumero() da instância criada. Quando a variável flag mudar para falso, encerrar a execução do programa*/

    do {

        jogo.geraNumero();
    }

    while(!jogo.flag );

    }  
}
