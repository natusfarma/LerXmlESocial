package br.com.pc.layout;

/**
 *
 * @author Paulo César
 */
public class ResumoContratual {
    
    private String cpfTrabalhador;
    private String dataAlterecao;
    private String descricaoAlteracao;
    private String valorSalario;

    /**
     * @return the cpfTrabalhador
     */
    public String getCpfTrabalhador() {
        return cpfTrabalhador;
    }

    /**
     * @param cpfTrabalhador the cpfTrabalhador to set
     */
    public void setCpfTrabalhador(String cpfTrabalhador) {
        this.cpfTrabalhador = cpfTrabalhador;
    }

    /**
     * @return the dataAlterecao
     */
    public String getDataAlterecao() {
        return dataAlterecao;
    }

    /**
     * @param dataAlterecao the dataAlterecao to set
     */
    public void setDataAlterecao(String dataAlterecao) {
        this.dataAlterecao = dataAlterecao;
    }

    /**
     * @return the descricaoAlteracao
     */
    public String getDescricaoAlteracao() {
        return descricaoAlteracao;
    }

    /**
     * @param descricaoAlteracao the descricaoAlteracao to set
     */
    public void setDescricaoAlteracao(String descricaoAlteracao) {
        this.descricaoAlteracao = descricaoAlteracao;
    }

    /**
     * @return the valorSalario
     */
    public String getValorSalario() {
        return valorSalario;
    }

    /**
     * @param valorSalario the valorSalario to set
     */
    public void setValorSalario(String valorSalario) {
        this.valorSalario = valorSalario;
    }

    @Override
    public String toString() {
        return  getCpfTrabalhador() + ";" +
                getDataAlterecao() + ";" +
                getDescricaoAlteracao()+ ";" +
                getValorSalario().replace(",", "").replace(".", ",");
    }
    
    
    
}
