
    // Ciências da Computação - Unisinos
    // Trabalho para a disciplina de Algoritmos e Programação: Fundamentos.
    // Tarefa 3
    // Aluno Guilherme Luthemaier Zardo

public class Tamagotchi {

    /*Inicia todas as variáveis utilizadas pelo programa
    A variávl flag controla o fluxo do programa. Ela é alterada para true quando 
    o Tamagotchi morre.*/

    String nome;
    int idade;
    int peso;
    int contadorsono;
    Teclado teclado = new Teclado();
    Boolean flag = false;
    Boolean primeiravez = true;
    
    /*Declara o método construtor*/

    public Tamagotchi (String nome, int idade, int peso) {

        this.nome = nome;
        this.idade = 1;
        this.peso = 0;
    }

    /*Declara o método continuar(), que irá questionar o usuário se ele quer continuar jogando o programa
    ou se prefere encerrá-lo.*/

    public void continuar() {

        System.out.println("Voce gostaria de criar um novo tamagotchi e continuar jogando?" +
        "Se sim, digite 1, se não digite 2 para sair.\n");

        int numero = teclado.leInt();

        if(numero == 1){

            flag = false;
            Tamagotchi_principal.main(null); 
        }

        else if (numero == 2) {

            flag = true;
            System.out.println("Tchau!\n");

        }

        else {

            System.out.println("Digite um número válido!\n");
            continuar();
        }
        
    }

    /*Declara o método permanecerAcordado().*/

    public void permaneceAcordado() {

        if (contadorsono!=5) {
             contadorsono++;
             imprimeInfo();
        }
        else {
            
            flag = true;
            System.out.println("Seu tamagotchi dormiu porque estava com muito sono!\n");
            dormir();
        }

    }

    /*Declara o método dormir().*/

    public void dormir() {

        if(idade!=15) {

        idade++;
        imprimeInfo();

       }
        else {

            flag = true;
            System.out.println("Seu tamagotchi engordou demais e morreu.\n");
            imprimeInfo();
            continuar();

        }
    }

    /*Declara o método comerMuito()*/

    public void comerMuito() {

        if(((peso+5)<20)) {

        peso = peso + 5;
        imprimeInfo();

        }

        else {

            flag = true;
            System.out.println("Seu tamagotchi comeu demais e morreu.\n");
            continuar();

        }
    }

    /*Declara o método comperPouco().*/

    public void comerPouco() {
        
        if(((peso+5)<20)) {

            peso = peso + 1;
            imprimeInfo();
            }

            else {
    
               flag = true;
               System.out.println("Seu tamagotchi emagreceu demais e morreu.\n");
               continuar();
               
            }

    }

    /*Declara o método nãoComer()*/

    public void naoComer() {

        if(((peso-2)>0)) {

            peso = peso - 2;
            imprimeInfo();

            }

            else {
    
            flag = true;
               System.out.println("Seu tamagotchi emagreceu demais e morreu.\n");
               continuar();
               
            }
    }

     /*Declara o método correr()*/

    public void correr() {

        if(((peso-4)>0)) {

            peso = peso - 4;
            comerMuito();
            
            }

            else {
    
                flag = true;
               System.out.println("Seu tamagotchi emagreceu demais e morreu.\n");
               continuar();
               
            }
        
    }
    
    /*Declara o método caminhar()*/

    public void caminhar() {

        if(((peso-1)>0)) {

            peso = peso - 1;
            sentirFome();
            imprimeInfo();

            }

            else {
    
                flag = true;
               System.out.println("Seu tamagotchi emagreceu demais e morreu.\n");
               continuar();
               
            }

    }

    /*Declara o método imprimeInfo(), que mostras as informações atualizadas do Tamagotchi
    cada vez que uma ação é completada.*/

    public void imprimeInfo(){
        
        System.out.println("/////////////////////////////////////////////////////\n");
        System.out.println("O nome do Tamagotchi é: " +  this.nome + " " + "\n");
        System.out.println("A idade de " +  this.nome + " é: " + " " + this.idade + " ano/anos.\n");
        System.out.println("O peso de " +  this.nome + " é: " + " " + this.peso + " quilo/quilos.\n");
        System.out.println("/////////////////////////////////////////////////////\n");

    }

    /*Declara o método geraNumero(), que gerará um número aleatório entre 1 e 3 e, de acordo com
    esse número gerado, irá selecionar um dos 3 estados de ânimo possíveis do Tamagotchi*/

    public void geraNumero() {

        int randomInt = (int)((10.0 * Math.random()) / 3);
        if(randomInt == 1) {

            sentirFome();
        }

        else if (randomInt == 2){

            sentirSono();

        }

        else {

            ficarEntendiado();

        }

    }

    /*Declara o método sentirSono(), que irá questionar o usuário a respeito da ação desejada
    de acordo com esse estado de ânimo do Tamagotchi. A variável "primeiravez" é utilizada para
    controlar o fluxo do programa em relação ao método ficarEntendiado()*/

    public void sentirSono() {

    primeiravez = false;
    
    System.out.println("Seu tamagotchi está com sono! Digite 1 para dormir e 2 para permanecer acordado.");

    int numero = teclado.leInt();

    if((numero==1) || (numero==2)) {

    switch (numero) {

        case 1:
            dormir();
            break;
        case 2:
            permaneceAcordado();
            break;

                    }

    }

    else {

        System.out.println("Digite um número válido!");
        sentirSono();
        
        }

    }

    /*Declara o método sentirFome(), que irá questionar o usuário a respeito da ação desejada
    de acordo com esse estado de ânimo do Tamagotchi. A variável "primeiravez" é utilizada para
    controlar o fluxo do programa em relação ao método ficarEntendiado()*/

    public void sentirFome() {

    primeiravez = false;

    System.out.println("Seu tamagotchi está com fome! Digite 1 para comer muito,  2 para comer pouco e 3 para não comer.");

    int numero = teclado.leInt();

    if((numero==1) || (numero==2) || (numero==3)) {

    switch (numero) {

        case 1:
            comerMuito();
            break;
        case 2:
            comerPouco();
            break;
        case 3:
            naoComer();
            break;       
        }
    }
    else {

        System.out.println("Digite um número válido!");
        sentirFome();
    }
    
    }

    /*Declara o método ficarEntendiado(), que irá questionar o usuário a respeito da ação desejada
    de acordo com esse estado de ânimo do Tamagotchi. A variável "primeira vez" garantirá que 
    esse não será o primeiro método mostrado no programa, já que, neste caso, a morte do Tamagotchi
    seria certa, visto que ele inicia o jogo com 1 quilo e as duas ações o fazem perder 1 quilo.*/

    public void ficarEntendiado() {

    if(!primeiravez) {

    System.out.println("Seu tamagotchi está entendiado! Digite 1 para correr 10 minutos 2 para caminhar 10 minutos.");

    int numero = teclado.leInt();

    if((numero==1) || (numero==2)) {

    switch (numero) {

        case 1:
            correr();
            break;
        case 2:
            caminhar();
            break;     
        }
    }

    else {

        System.out.println("Digite um número válido!\n");
        sentirFome();

    }
    
    }

    else {

    geraNumero();
    
    }

    }

}