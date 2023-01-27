package br.com.pc.layout;

/**
 *
 * @author Paulo César
 */
public class Resumo {
    
    private String matricula;
    private String nrRecibo;
    private String nmTrabalhador;
    private String cpfTrabalhador;
    

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nrRecibo
     */
    public String getNrRecibo() {
        return nrRecibo;
    }

    /**
     * @param nrRecibo the nrRecibo to set
     */
    public void setNrRecibo(String nrRecibo) {
        this.nrRecibo = nrRecibo;
    }

    /**
     * @return the nmTrabalhador
     */
    public String getNmTrabalhador() {
        return nmTrabalhador;
    }

    /**
     * @param nmTrabalhador the nmTrabalhador to set
     */
    public void setNmTrabalhador(String nmTrabalhador) {
        this.nmTrabalhador = nmTrabalhador;
    }

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
    
    @Override
    public String toString() {
        return  getMatricula() + ";" +
                getCpfTrabalhador() + ";" +
                getNmTrabalhador()+ ";" +
                getNrRecibo();
    }
    
}
