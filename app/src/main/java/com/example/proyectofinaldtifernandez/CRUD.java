package com.example.proyectofinaldtifernandez;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CRUD extends AppCompatActivity {
    public EditText etCodigo, etDescripcion, etUbicacion,etExistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//inicia metodo on create
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        //integrar XML
        etCodigo = findViewById(R.id.etCodigo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etUbicacion = findViewById(R.id.etUbicacion);
        etExistencia = findViewById(R.id.etExistencia);

    }//termina metodo on create

    public void altaProducto(View view){
        //abrir programa base de datos SQLite y generar la base de datos administracion
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();//CRUD
        //Guardar los valores en las variables del formulario
        String Codigo = etCodigo.getText().toString();
        String Descripcion = etDescripcion.getText().toString();
        String Ubicacion = etUbicacion.getText().toString();
        String Existencia = etExistencia.getText().toString();

        //Para guardar datos en la tabla utilizando un contenedor de valores en variables
        ContentValues registro = new ContentValues();
        registro.put("cod",Codigo);
        registro.put("descripcion",Descripcion);
        registro.put("ubicacion",Ubicacion);
        registro.put("existencia",Existencia);

        bd.insert("articulo",null,registro);

        etCodigo.setText(null);
        etDescripcion.setText(null);
        etUbicacion.setText(null);
        etExistencia.setText(null);

        Toast.makeText(this,"Exito al ingresar producto",Toast.LENGTH_LONG).show();
    }//termina alta
    //Metodo busqueda por campo distintivo consulta
    public void consultaProducto(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos se reescribible

        //se asigna una variable para busqueda y consulta por campo distintivo
        String codigoConsulta = etCodigo.getText().toString();
        //Cursor recorre los campos de una tabla articulo hasta encontralo por campo distintivo
        Cursor fila = bd.rawQuery("SELECT descripcion,ubicacion,existencia from articulo where cod="+codigoConsulta,null);

        if(fila.moveToFirst()){//si condicion es verdadera, es decir, encontro un campo y sus datos
            etDescripcion.setText(fila.getString(0));
            etUbicacion.setText(fila.getString(1));
            etExistencia.setText(fila.getString(2));
            Toast.makeText(this,"Registro encontrado de forma EXITOSA",Toast.LENGTH_LONG).show();
        }else{//condicion falsa si no encontro un registro
            Toast.makeText(this,"No existe Articulo con ese Codigo\nVerifica",Toast.LENGTH_LONG).show();
            bd.close();
        }

    }//termina metodo consulta producto

    //Metodo para eliminar por campo distintivo
    public void eliminarProducto(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos  reescribible

        //se asigna variable para busqueda por campo distitivo caodigo producto
        String codigoBaja = etCodigo.getText().toString();
        //Se genera instrtuccion SQL para que se elimine el registro de producto
        int c = bd.delete("articulo","cod="+codigoBaja,null);
        if(c==1){
            Toast.makeText(this,"Registro eliminado de BD exitoso\nVerifica Consulta",Toast.LENGTH_LONG).show();
            //Limpia cajas de texto
            this.etCodigo.setText("");
            this.etDescripcion.setText("");
            this.etUbicacion.setText("");
            this.etExistencia.setText("");
        }else{
            Toast.makeText(this,"Error\nNo existe Articulo con ese codigo",Toast.LENGTH_LONG).show();
        }

    }//termina metodo para eliminar producto

    public void modificarProductos(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();//objetos de base de datos  reescribible

        //se declaran variables que vienen desde formulario sus datos
        String Codigo = etCodigo.getText().toString();
        String Descripcion = etDescripcion.getText().toString();
        String Ubicacion = etUbicacion.getText().toString();
        String Existencia = etExistencia.getText().toString();

        //se genera un contenedor para almacenar los valores anteriores
        ContentValues registro = new ContentValues();
        registro.put("cod",Codigo);
        registro.put("descripcion",Descripcion);
        registro.put("ubicacion",Ubicacion);
        registro.put("existencia",Existencia);

        //Se crea la variable que contine la instruccion SQL encargada de modificar y almacenar valor 1 si edito
        int cant = bd.update("articulo",registro,"cod="+Codigo,null);
        bd.close();
        if(cant==1) {//condicion si realizo modificacion
            Toast.makeText(this,"Registro actualizado de forma correcta",Toast.LENGTH_LONG).show();
            //Se limpian los campos de texto
            etCodigo.setText(null);
            etDescripcion.setText(null);
            etUbicacion.setText(null);
            etExistencia.setText(null);

        }else {//contrario a no modificacion
            Toast.makeText(this,"Error\nNo se modifico registro",Toast.LENGTH_LONG).show();
        }
    } //termina metodo
}
