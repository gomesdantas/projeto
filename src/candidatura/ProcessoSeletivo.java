package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    private static int candidatosAtual;
   public static void main(String[] args) {
    String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
    for(String candidato: candidatos){
entrandoEmContato(candidato);
    }
   } 

   static void  entrandoEmContato(String candidato){
   
    int tentativasRealizadas = 1;
    boolean continuarTentando= true;
    boolean atendeu= false;
    do{

    atendeu= atender();
    continuarTentando = !atendeu;
    if (continuarTentando) 
        tentativasRealizadas++;   
        else 
            System.out.println("Contato realizado com sucesso ");
       
    }while (continuarTentando && tentativasRealizadas <=3);

if (atendeu) 
System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa ");
else 
    System.out.println("Não conseguimos contato com " + candidato + ", numero maximo tentativas "+ tentativasRealizadas + " realizadas");
}

static  boolean  atender(){
    return  new Random().nextInt(3)==1;

}

   static void imprimirSelecionados(){
    String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
    System.out.println("Imprimindo a lista de candidatos informando o índice do elemento ");

    for(int indice =0; indice < candidatos.length; indice++){
        System.out.println("O candidato de nº  " + (indice+1)+ " é o " + candidatos[indice]) ;
    }
    System.out.println("Forma abreviada de interação for each");
    for(String candidato:candidatos){
        System.out.println("O candidato selecionado foi " + candidato);
    }
   }
   static  void  selecaoCandidatos(){
 
    String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge"};

    int candidatosSelecionados = 0;
    double salarioBase= 2000.0;

    while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
        String candidato = candidatos[candidatosAtual];
        double salarioPretendido= valorPretendido();

        System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
        if(salarioBase >= salarioPretendido){
            System.err.println("O candidato " + candidato + " foi selecionado para a vaga ");
            candidatosSelecionados++;
        }
        candidatosAtual++;
}
   }

static  double valorPretendido(){
    return ThreadLocalRandom.current().nextDouble(1800,2200);
}

   static void analisarCandidato(double salarioPretendido){
    double salarioBase= 2000.0;
    if(salarioBase > salarioPretendido){
        System.out.println("LIGAR PARA O CANDIDATO ");
    }
    else if(salarioBase == salarioPretendido){
        System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS ");
    }
    else{
        System.out.println("AGUARDANDO DEMAIS CANDIDATOS ");
    }
   }
}
