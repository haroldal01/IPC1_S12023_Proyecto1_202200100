
package Ventanas.usuarios.Cotizacion;


public class Cotizacion {
    
    private String codigoC;
    private String usuario;
    private String origenD;
    private String origenM;
    private String destinoD;
    private String destinoM;
    private String destinoR;
    private double precioEnvio;
    private String tipoEnvio;
    private double cantPk;
    private double pesoPk;
    private String tipoPk;
    private double precioCotizacion;
    private String destinatario;
    private String fecha;
    private String tipoPago;
    private String AliasFactura;
    
    @Override
    public String toString()
    {
        return "Cotizacion{" + "codigoC=" + codigoC + ", usuario=" + usuario + 
                ", origenD=" + origenD + ", origenM=" + origenM + ", destinoD=" +
                destinoD + ", destinoM=" + destinoM + ", destinoR=" + destinoR + 
                ", precioEnvio=" + precioEnvio + ", tipoEnvio=" + tipoEnvio + 
                ", cantPk=" + cantPk + ", pesoPk=" + pesoPk + ", tipoPk=" + 
                tipoPk + ", precioCotizacion=" + precioCotizacion + 
                ", destinatario=" + destinatario + ", fecha=" + fecha + 
                ", tipoPago=" + tipoPago + ", AliasFactura=" + AliasFactura + '}';
    }
    
    public Cotizacion(String usuario, String origenD, String oringM,
            String destinoD, String destinoM, String destinoR, String tipoEnvio,
            double precioEnvio, double cantPk,double pesoPk, String tipoPk,
            double precioCotizacion, String codigoC, String destinatario,
            String tipoPago, String aliasFacturacion, String fecha)
    {
        this.usuario = usuario;
        this.origenD = origenD;
        this.origenM = oringM;
        this.destinoD = destinoD;
        this.destinoM = destinoM;
        this.destinoR = destinoR;
        this.tipoEnvio = tipoEnvio;
        this.precioEnvio = precioEnvio;
        this.cantPk = cantPk;
        this.pesoPk = pesoPk;
        this.tipoPk = tipoPk;
        this.precioCotizacion = precioCotizacion;
        this.codigoC = codigoC;
        this.destinatario = destinatario;
        this.tipoPago = tipoPago;
        this.AliasFactura = aliasFacturacion;
        this.fecha = fecha;
    }

    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario2){
        this.usuario = usuario2;
    }
    
    public String getOrigenD(){
        return origenD;
    }
    public void setOrigenD(String origenD){
        this.origenD = origenD;
    }
    
    public String getOrigenM(){
        return origenM;
    }
    public void setOrigenM(String origenM){
        this.origenM = origenM;
    }
    
    public String getDestinoD(){
        return destinoD;
    }
    public void setDestinoD(String destinoD){
        this.destinoD = destinoD;
    }
    
    public String getDestinoM(){
        return destinoM;
    }
    public void setDestinoM(String destinoM){
        this.destinoM = destinoM;
    }
    
    public String getDestinoR(){
        return destinoR;
    }
    public void setDestinoR(String destinoR){
        this.destinoR = destinoR;
    }
    
    public String gettipoEnvio(){
        return tipoEnvio;
    }
    public void setTipoEnvio(String tipoEnvio){
        this.tipoEnvio = tipoEnvio;
    }
    
    public double getPrecioEnvio(){
        return precioEnvio;
    }
    public void setPrecioEnvio(double precioEnvio){
        this.precioEnvio = precioEnvio;
    }
    
    public double getCantidadPaquetes(){
        return cantPk;
    }
    public void setCantidadPaquetes(double cantPk){
        this.cantPk = cantPk;
    }
    
    public double getPesoPaquetes(){
        return pesoPk;
    }
    public void setPesoPaquetes(double PesoPk){
        this.pesoPk = PesoPk;
    }
    
    public String getTipoPaquete(){
        return tipoPk;
    }
    public void setTipoPaquete(String tipoPk){
        this.tipoPk = tipoPk;
    }
    
    public double getPrecioCotizacion(){
        return precioCotizacion;
    }
    public void setPrecioCotizacion(double PrecioCotizacion){
        this.precioCotizacion = PrecioCotizacion;
    }
    
    public String getCodigo(){
        return codigoC;
    }
    public void setCodigo(String codigo){
        this.codigoC = codigo;
    }
    
    public String gesDestinatario(){
        return destinatario;
    }
    public void setDestinatario(String detinatario){
        this.destinatario = destinatario;
    }
    
    public String getTipoPago(){
        return tipoPago;
    }
    public void setTipoPago(String pago){
        this.tipoPago = pago;
    }
    
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public String getAlias(){
        return AliasFactura;
    }
    public void setFactura(String facturacion){
        this.AliasFactura = facturacion;
    }
    
}
