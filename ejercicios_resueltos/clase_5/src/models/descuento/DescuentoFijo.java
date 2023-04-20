package models.descuento;

public class DescuentoFijo extends Descuento {
    public DescuentoFijo() {
    }
    public DescuentoFijo(double valorDesc){
        this.valorDesc = valorDesc;
    }
    @Override
    public double descuento(double valorInicial) {
        return valorInicial - this.valorDesc;
    }
    @Override
    public double getValorDesc() {
        return super.getValorDesc();
    }
    @Override
    public void setValorDesc(double valorDesc) throws Exception {
        super.setValorDesc(valorDesc);
    }
}

