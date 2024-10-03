package TableroMvc;

public class TableroController {
    
    private TableroModel tableroModel;
    private TableroView tableroView;

    public TableroController(TableroModel tableroModel, TableroView tableroView) {
        this.tableroModel = tableroModel;
        this.tableroView = tableroView;
        
        tableroView.agregarObservador((String estado) -> {
            if(estado.equals("inicio")){
                tableroModel.repartirFichas();
            }
        });
    }
    
    
}
