public enum Tipo {
    AGUA,
    FUEGO,
    PLANTA;
    //Este metodo debe recibir un tipo de un pokemon x y otro y
    public double calcularVentaja(Tipo atacante, Tipo defensor){
        switch(atacante) {
            case AGUA:
                return defensor == AGUA ? 1.0 : defensor == FUEGO ? 2.0 : 0.5;
            case FUEGO:
                return defensor == AGUA ? 0.5 : defensor == FUEGO ? 1.0 : 2.0;
            case PLANTA:
                return defensor == AGUA ? 2.0 : defensor == FUEGO ? 0.5 : 1.0;
        }
        return 0.0;
    }


}
