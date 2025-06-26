public class Main {
    public static void main(String[] args) {
        Votacao votacao = new Votacao();

        votacao.registrarCandidato(new Candidato(1,"Alice"));
        votacao.registrarCandidato(new Candidato(2,"Bob"));

        votacao.registrarEleitor(new Eleitores("111", "João"));
        votacao.registrarEleitor(new Eleitores("222","Maria"));
        votacao.registrarEleitor(new Eleitores("333","Pedro"));

        votacao.votar("111",1);
        votacao.votar("222",2);
        votacao.votar("333",1);
        votacao.votar("111",2);

        votacao.ExibirResultado();
        votacao.ExibirVencedor();

    }
}
