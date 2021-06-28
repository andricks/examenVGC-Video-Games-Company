/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogamescompany;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Borge
 */
public class VGCPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VGCPrincipal
     */
    public VGCPrincipal() {
        initComponents();
       
    }

    ArrayList<Inventario>Marvel = new ArrayList<Inventario>();
    ArrayList<Inventario>DC = new ArrayList<Inventario>();
    ArrayList<Inventario>Capcom = new ArrayList<Inventario>();
    ArrayList<compra>Ventas = new ArrayList<compra>();
    int seleccion;
    
    public void NuevoIngreso(){
      if(txtNombreProducto.getText().isEmpty() || txtDescripcionProducto.getText().isEmpty() ||
          txtPrecioProducto.getText().isEmpty() || txtExistenciasProducto.getText().isEmpty()){
          JOptionPane.showMessageDialog(this, "Complete los Campos Solicitados");
      
      }else{
            Inventario nuevoIngreso = new Inventario();
            nuevoIngreso.setNombre(txtNombreProducto.getText());
            nuevoIngreso.setDescripcion(txtDescripcionProducto.getText());
            nuevoIngreso.setPrecio(txtPrecioProducto.getText());
            nuevoIngreso.setExixtencia(txtExistenciasProducto.getText());
            nuevoIngreso.setFranquicia(comboFranquicias.getSelectedItem().toString());
            String franquicia = comboFranquicias.getSelectedItem().toString();
       
            switch(franquicia){
                case "Marvel":
                    Marvel.add(nuevoIngreso);
                    JOptionPane.showMessageDialog(this,"Producto Agregado a la Franquicia:  "+franquicia);
                    inventarioTabla();
 
                    break;    
                case "DC":
                    DC.add(nuevoIngreso);
                    JOptionPane.showMessageDialog(this,"Producto Agregado a la Franquicia:  "+franquicia);
                    inventarioTabla();
                    break;    
   
                    
                case "Capcom":
                    Capcom.add(nuevoIngreso);
                    JOptionPane.showMessageDialog(this,"Producto Agregado a la Franquicia:  "+franquicia);
                    inventarioTabla();
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(this, "Error al Guardar el Nevo Registro");
                    break;
                    
          }
      }
}

   public void  inventarioTabla(){
       String franquicia = comboFranquicias.getSelectedItem().toString();
       switch(franquicia){
           case "Marvel":
            String matriz [][] = new String [Marvel.size()][6];
                    if(Marvel.size() != 0){ 
                       for(int i= 0; i< Marvel.size(); i++){
                           matriz [i][0] = Integer.toString(i+1);
                           matriz [i][1] = Marvel.get(i).getNombre();
                           matriz [i][2] = Marvel.get(i).getDescripcion();
                           matriz [i][3] = Marvel.get(i).getPrecio();
                           matriz [i][4] = Marvel.get(i).getExixtencia();
                           matriz [i][5] = Marvel.get(i).getFranquicia();   
                        }
                        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
                        matriz,
                        new String [] {
                        "ID", "Nombre", "Descripcion", "Precio", "Existencia", "Franquicia"
                                }
                        ));
                    }else{
                        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
                        matriz,
                        new String [] {
                        "ID", "Nombre", "Descripcion", "Precio", "Existencia", "Franquicia"
                                }
                        ));
                    }
          break;
          
           case "DC":
                String matriz2 [][] = new String [DC.size()][6];
                     if(DC.size() != 0){ 
                       for(int i= 0; i< DC.size(); i++){
                           matriz2 [i][0] = Integer.toString(i+1);
                           matriz2 [i][1] = DC.get(i).getNombre();
                           matriz2 [i][2] = DC.get(i).getDescripcion();
                           matriz2[i][3] =  DC.get(i).getPrecio();
                           matriz2[i][4] = DC.get(i).getExixtencia();
                           matriz2 [i][5] = DC.get(i).getFranquicia();   
                        }
                        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
                        matriz2,
                        new String [] {
                        "ID", "Nombre", "Descripcion", "Precio", "Existencia", "Franquicia"
                                }
                        ));
                    }else{
                        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
                        matriz2,
                        new String [] {
                        "ID", "Nombre", "Descripcion", "Precio", "Existencia", "Franquicia"
                                }
                        ));
                    }
                    break;
           case "Capcom":
                     String matriz3 [][] = new String [Capcom.size()][6];
                     if(Capcom.size() != 0){ 
                       for(int i= 0; i< Capcom.size(); i++){
                           matriz3 [i][0] = Integer.toString(i+1);
                           matriz3 [i][1] = Capcom.get(i).getNombre();
                           matriz3 [i][2] = Capcom.get(i).getDescripcion();
                           matriz3[i][3] =  Capcom.get(i).getPrecio();
                           matriz3[i][4] =  Capcom.get(i).getExixtencia();
                           matriz3 [i][5] = Capcom.get(i).getFranquicia();   
                        }
                        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
                        matriz3,
                        new String [] {
                        "ID", "Nombre", "Descripcion", "Precio", "Existencia", "Franquicia"
                                }
                        ));
                    }else{
                        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
                        matriz3,
                        new String [] {
                        "ID", "Nombre", "Descripcion", "Precio", "Existencia", "Franquicia"
                                }
                        ));
                    }
                    break;
           default:
               JOptionPane.showMessageDialog(this, "Error al cargar la tabla");
               break;
}
   }

   public void modificacionProducto(){
      String  franquicia = comboFranquicias.getSelectedItem().toString();
    if(txtNombreProducto.getText().isEmpty() || txtDescripcionProducto.getText().isEmpty() ||
          txtPrecioProducto.getText().isEmpty() || txtExistenciasProducto.getText().isEmpty()){
          JOptionPane.showMessageDialog(this, "Los campos deben estar completos para guardar los cambios");
    
    }else{
    switch(franquicia){
        case "Marvel":
        Marvel.get(seleccion).setNombre(txtNombreProducto.getText());
        Marvel.get(seleccion).setDescripcion(txtDescripcionProducto.getText());
        Marvel.get(seleccion).setPrecio(txtPrecioProducto.getText());
        Marvel.get(seleccion).setExixtencia(txtExistenciasProducto.getText());
        inventarioTabla();
        break;
        
        case "DC":
        DC.get(seleccion).setNombre(txtNombreProducto.getText());
        DC.get(seleccion).setDescripcion(txtDescripcionProducto.getText());
        DC.get(seleccion).setPrecio(txtPrecioProducto.getText());
        DC.get(seleccion).setExixtencia(txtExistenciasProducto.getText());
        inventarioTabla();
        break;
        
        case "Capcom":
        Capcom.get(seleccion).setNombre(txtNombreProducto.getText());
        Capcom.get(seleccion).setDescripcion(txtDescripcionProducto.getText());
        Capcom.get(seleccion).setPrecio(txtPrecioProducto.getText());
        Capcom.get(seleccion).setExixtencia(txtExistenciasProducto.getText());
        inventarioTabla();
        break;
        default:
        JOptionPane.showMessageDialog(this, "Error al modificar el producto");
        inventarioTabla();
      
    }
   }
   }
   
public void Disponible(){
   String seleccion = comboFranquicia.getSelectedItem().toString();
   
   switch(seleccion){
       case "Marvel":
           comboStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            String matriz[] = new String [Marvel.size()];
            for(int i = 0; i<Marvel.size(); i++){
            matriz[i]= Marvel.get(i).getNombre();
            comboStock.addItem(matriz[i]);
            }
            break;
      case "DC":
            comboStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            String matriz2[] = new String [DC.size()];
            for(int i = 0; i<DC.size(); i++){
            matriz2[i]= DC.get(i).getNombre();
            comboStock.addItem(matriz2[i]);
            }
            break;
      case "Capcom":
            comboStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            String matriz3[] = new String [Capcom.size()];
            for(int i = 0; i<Capcom.size(); i++){
            matriz3[i]= Capcom.get(i).getNombre();
            comboStock.addItem(matriz3[i]);
            }
            break;
      default:
                 comboStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
                 break;
   }
    
}

public void ProductoSeleccionado(){
int producto = comboStock.getSelectedIndex();
String franquicia = comboFranquicia.getSelectedItem().toString();

switch(franquicia){
    case"Marvel":
        txtDescripcionCompra.setText(Marvel.get(producto).getDescripcion());
        txtPrecioUnidad.setText(Marvel.get(producto).getPrecio());
        txtExistenciaProducto.setText(Marvel.get(producto).getExixtencia());
        break;
    case"DC":
        txtDescripcionCompra.setText(DC.get(producto).getDescripcion());
        txtPrecioUnidad.setText(DC.get(producto).getPrecio());
        txtExistenciaProducto.setText(DC.get(producto).getExixtencia());
        break;
    case"Capcom":
        txtDescripcionCompra.setText(Capcom.get(producto).getDescripcion());
        txtPrecioUnidad.setText(Capcom.get(producto).getPrecio());
        txtExistenciaProducto.setText(Capcom.get(producto).getExixtencia());
        break;
    default:
        JOptionPane.showMessageDialog(this, "Seleccione una franquicia Producto");
        
}
}

public void Compra(){
compra orden = new compra(); 
int n1 = Integer.parseInt(txtCantidad.getText());
int n2 = Integer.parseInt(txtExistenciaProducto.getText());
if(txtDescripcionCompra.getText().isEmpty() || txtPrecioUnidad.getText().isEmpty() || txtExistenciaProducto.getText().isEmpty()){
    JOptionPane.showMessageDialog(this, "Seleccione una Franquicia y/o Producto");
}else if(n1>n2){
    JOptionPane.showMessageDialog(this, "No contamos con suficiente producto para tramitar esta compra!!");
}else if(n1<0){
    JOptionPane.showMessageDialog(this, "No se pueden ingresar numeros negativos!!!!");
}else{
    String franquicia =comboFranquicia.getSelectedItem().toString();
    int producto = comboStock.getSelectedIndex();
    int precio = Integer.parseInt(txtPrecioUnidad.getText());
    int cantidad = Integer.parseInt(txtCantidad.getText());
    int total = cantidad*precio;
    
    orden.setCantidad(txtCantidad.getText());
    orden.setNombre(comboStock.getSelectedItem().toString());
    orden.setTotal(Integer.toString(total));
    Ventas.add(orden);
    
    switch(franquicia){
        case "Marvel":
            int existeciaActual = Integer.parseInt(Marvel.get(producto).getExixtencia());
            int ExistenciaFinal =0;
            ExistenciaFinal =  existeciaActual-cantidad;
            Marvel.get(producto).setExixtencia(Integer.toString(ExistenciaFinal));
            break;
             case "DC":
            int existeciaActual2 = Integer.parseInt(DC.get(producto).getExixtencia());
            int ExistenciaFinal2 =0;
            ExistenciaFinal2 =  existeciaActual2-cantidad;
            DC.get(producto).setExixtencia(Integer.toString(ExistenciaFinal2));
            break;
             case "Capcom":
            int existeciaActual3 = Integer.parseInt(Capcom.get(producto).getExixtencia());
            int ExistenciaFinal3=0;
            ExistenciaFinal3 =  existeciaActual3-cantidad;
            Capcom.get(producto).setExixtencia(Integer.toString(ExistenciaFinal3));
            break;
        default:
            JOptionPane.showMessageDialog(this, "Error de existencias");
            
    }
    
    String  matriz [][] = new String [Ventas.size()][3];
    
    for(int i = 0; i< Ventas.size(); i++){
    matriz[i][0] = Ventas.get(i).getCantidad();
    matriz[i][1]= Ventas.get(i).getNombre();
    matriz[i][2] = Ventas.get(i).getTotal();
    }
    
    
jTable1.setModel(new javax.swing.table.DefaultTableModel(
   matriz,
    new String [] {
        "Cantidad", "Producto", "Total"
    }
));

}
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ADMINISTRACION = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        comboFranquicias = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionProducto = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtExistenciasProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInventarios = new javax.swing.JTable();
        btnIngresarInventario = new javax.swing.JButton();
        btnModificarProducto = new javax.swing.JButton();
        txtescripcionCompra = new javax.swing.JPanel();
        btnComprar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboFranquicia = new javax.swing.JComboBox<>();
        comboStock = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDescripcionCompra = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPrecioUnidad = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtExistenciaProducto = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        comboFranquicias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marvel", "DC", "Capcom" }));
        comboFranquicias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFranquiciasItemStateChanged(evt);
            }
        });
        comboFranquicias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboFranquiciasMouseClicked(evt);
            }
        });
        comboFranquicias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFranquiciasActionPerformed(evt);
            }
        });

        jLabel1.setText("Area de Administracion VGC");

        jLabel2.setText("Catalogo");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Figura de acción");

        jLabel4.setText("Descripcion");

        txtDescripcionProducto.setColumns(20);
        txtDescripcionProducto.setRows(5);
        jScrollPane1.setViewportView(txtDescripcionProducto);

        jLabel5.setText("Precio");

        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });

        jLabel6.setText("Existencias");

        tablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Precio", "Existencia", "Franquicia"
            }
        ));
        tablaInventarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInventariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaInventarios);

        btnIngresarInventario.setText("INGRESAR AL INVENTARIO");
        btnIngresarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarInventarioActionPerformed(evt);
            }
        });

        btnModificarProducto.setText("MODIFICAR PRODUCTO");
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(comboFranquicias, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIngresarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(17, 17, 17))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtExistenciasProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFranquicias))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtExistenciasProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnIngresarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        ADMINISTRACION.addTab("ADMINISTRACION", jPanel2);

        txtescripcionCompra.setBackground(new java.awt.Color(204, 204, 204));
        txtescripcionCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtescripcionCompra.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        btnComprar.setText("Agregar a la lista");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        jLabel7.setText("Area de venta");

        comboFranquicia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marvel", "DC", "Capcom" }));
        comboFranquicia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFranquiciaItemStateChanged(evt);
            }
        });
        comboFranquicia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboFranquiciaMouseClicked(evt);
            }
        });
        comboFranquicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFranquiciaActionPerformed(evt);
            }
        });

        comboStock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStockItemStateChanged(evt);
            }
        });
        comboStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboStockMouseClicked(evt);
            }
        });
        comboStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStockActionPerformed(evt);
            }
        });

        jLabel8.setText("Producto Disponible");

        jLabel9.setText("Franquicia");

        jLabel10.setText("Descripcion:");

        jLabel12.setText("Precio:");

        jLabel13.setText("Stock:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jLabel11.setText("candidad ");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtescripcionCompraLayout = new javax.swing.GroupLayout(txtescripcionCompra);
        txtescripcionCompra.setLayout(txtescripcionCompraLayout);
        txtescripcionCompraLayout.setHorizontalGroup(
            txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcionCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExistenciaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                        .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(comboStock, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnComprar)))
                        .addGap(67, 67, 67))))
        );
        txtescripcionCompraLayout.setVerticalGroup(
            txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(21, 21, 21)
                .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescripcionCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                                .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                    .addComponent(txtExistenciaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(txtescripcionCompraLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10)))
                .addGap(17, 17, 17)
                .addGroup(txtescripcionCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar)
                    .addComponent(jLabel11)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ADMINISTRACION.addTab("VENTAS", txtescripcionCompra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADMINISTRACION)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADMINISTRACION)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarInventarioActionPerformed
        NuevoIngreso();
    }//GEN-LAST:event_btnIngresarInventarioActionPerformed

    private void comboFranquiciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFranquiciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFranquiciasActionPerformed

    private void comboFranquiciasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFranquiciasItemStateChanged
        inventarioTabla();
    }//GEN-LAST:event_comboFranquiciasItemStateChanged

    private void comboFranquiciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboFranquiciasMouseClicked
        inventarioTabla();
    }//GEN-LAST:event_comboFranquiciasMouseClicked

    private void tablaInventariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInventariosMouseClicked
         seleccion = tablaInventarios.rowAtPoint(evt.getPoint());
         txtNombreProducto.setText(tablaInventarios.getValueAt(seleccion,1).toString());
         txtDescripcionProducto.setText(tablaInventarios.getValueAt(seleccion, 2).toString());
         txtPrecioProducto.setText(tablaInventarios.getValueAt(seleccion, 3).toString());
         txtExistenciasProducto.setText(tablaInventarios.getValueAt(seleccion,4).toString());
         
    }//GEN-LAST:event_tablaInventariosMouseClicked

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
            modificacionProducto();
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void comboFranquiciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFranquiciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFranquiciaActionPerformed

    private void comboFranquiciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFranquiciaItemStateChanged
        Disponible();
    }//GEN-LAST:event_comboFranquiciaItemStateChanged

    private void comboStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboStockMouseClicked
         ProductoSeleccionado();
    }//GEN-LAST:event_comboStockMouseClicked

    private void comboFranquiciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboFranquiciaMouseClicked
       Disponible();
    }//GEN-LAST:event_comboFranquiciaMouseClicked

    private void comboStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStockActionPerformed

    private void comboStockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStockItemStateChanged
        ProductoSeleccionado();
    }//GEN-LAST:event_comboStockItemStateChanged

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
         Compra();
    }//GEN-LAST:event_btnComprarActionPerformed

    private void txtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioProductoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VGCPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VGCPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VGCPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VGCPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VGCPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ADMINISTRACION;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnIngresarInventario;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JComboBox<String> comboFranquicia;
    private javax.swing.JComboBox<String> comboFranquicias;
    private javax.swing.JComboBox<String> comboStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaInventarios;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtDescripcionCompra;
    private javax.swing.JTextArea txtDescripcionProducto;
    private javax.swing.JLabel txtExistenciaProducto;
    private javax.swing.JTextField txtExistenciasProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JLabel txtPrecioUnidad;
    private javax.swing.JPanel txtescripcionCompra;
    // End of variables declaration//GEN-END:variables
}
