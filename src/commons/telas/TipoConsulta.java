package commons.telas;

public enum TipoConsulta {

    CONSULTA_PARA_CADASTRO, //Tela de listagem ao selecionar abre a tela de cadastro
    CADASTRO_PARA_CONSULTA; //Em um cadastro é necessario consultar e recuperar outra entidade

    private TipoConsulta(){}
}
