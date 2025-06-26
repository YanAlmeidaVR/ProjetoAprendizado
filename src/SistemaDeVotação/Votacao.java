import java.util.ArrayList;
import java.util.List;

public class Votacao {

    private List<Candidato> candidatos = new ArrayList<>();
    private List<Eleitores> eleitores = new ArrayList<>();

    public void registrarCandidato(Candidato c) {
        candidatos.add(c);
    }

    public void registrarEleitor(Eleitores e) {
        eleitores.add(e);
    }

    public void votar(String cpfEleitor, int idCandidato) {
        Eleitores eleitor = buscarEleitorPorCpf(cpfEleitor);
        if (cpfEleitor == null) {
            System.out.println("Eleitor não encontrado");
            return;
        }
        if (eleitor.isVotou()) {
            System.out.println("Este eleitor já votou.");
            return;
        }

        Candidato candidato = buscarCandidatoPorId(idCandidato);

        if (candidato == null) {
            System.out.println("Candidato não encontrado");
            return;
        }

        candidato.incrementarVoto();
        eleitor.setVotou(true);
        System.out.println("Voto computado com sucesso!");

    }

    private Eleitores buscarEleitorPorCpf(String cpf) {
        for (Eleitores e : eleitores) {
            if (e.getCpf().equals(cpf)) {
                return e;
            }
        }
        return null;
    }

    private Candidato buscarCandidatoPorId(int id) {
        for (Candidato c : candidatos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void ExibirResultado() {
        int voto = 0;

        System.out.println("Resutaldo da votação:");
        for (Candidato c : candidatos) {
            System.out.println(c.getNome() + " - " + c.getVotos() + " votos.");
        }
    }

    public void ExibirVencedor(){
        int maiorVoto = 0;
        List<Candidato> vencedores = new ArrayList<>();

        for (Candidato c : candidatos){
            if (c.getVotos() > maiorVoto){
                maiorVoto = c.getVotos();
                vencedores.clear();
                vencedores.add(c);
            }
        }

        System.out.println("Vencedor: ");
        if (vencedores.size() == 1){
            Candidato vencedor = vencedores.get(0);
            System.out.println(vencedor.getNome() + " com " + vencedor.getVotos() + " votos.");
        }
        else {
            System.out.println("Empatou!");
            for (Candidato c : vencedores){
                System.out.println(c.getNome() + " com " + c.getVotos() + " votos.");
            }
        }
    }
}
