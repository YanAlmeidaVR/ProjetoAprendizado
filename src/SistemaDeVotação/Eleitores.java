public class Eleitores {
    private String cpf;
    private String nome;
    private boolean votou;

    public Eleitores(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void setVotou(boolean votou) {
        this.votou = votou;
    }

    public boolean isVotou(){
        return votou;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

}
