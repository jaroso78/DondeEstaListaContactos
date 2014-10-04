package com.example.dondeestas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

	
	private static final String TAG ="Ventana Contactos";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		//Recuperamos los objetos.
		final Button botonValencia=(Button) findViewById(R.id.Valencia);
		final Button botonBilbao= (Button) findViewById (R.id.Bilbao);
		final Button botonBarcelona = (Button) findViewById (R.id.Barcelona);
		final Button botonMadrid =(Button) findViewById (R.id.Madrid);
		final Button botonSevilla = (Button) findViewById (R.id.Sevilla);
		final Button botonValladolid = (Button) findViewById (R.id.Valladolid);
		
		
		//Implementamos los Listeners con la clase que nos devolvera el contenido en función
		//del Id del Boton pulsado.
		botonValencia.setOnClickListener(new devolverLugar() );
		botonBilbao.setOnClickListener(new devolverLugar());
		botonBarcelona.setOnClickListener(new devolverLugar());
		botonMadrid.setOnClickListener(new devolverLugar());
		botonSevilla.setOnClickListener(new devolverLugar());
		botonValladolid.setOnClickListener(new devolverLugar());
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	//Método que implementa ONclik de manera que recuperamos de la vista.
	// el id del objeto pulsado.
	
	class devolverLugar implements Button.OnClickListener {
		
		@Override
		public void onClick(View v) {
			final Button boton = (Button) findViewById (v.getId()); //Recuperamos el ID.
			Intent devolucion = new Intent();   //Creamos un intent.
			//En el Intent devolvemos la información a la primera ventana.
			
			devolucion.putExtra("lugar",boton.getText()); //Devolvemos a Main activiti.
														  // En el par lugar, el texto del Boton.
			
			Log.i(TAG,"El Botón pulsado -> "+boton.getText()); // Lo mostramos en el Log para comprobar.
			
			setResult (RESULT_OK,devolucion); //Indicamos que el resultado es Ok, y enviamos la información.
			finish(); //Finalizamos la Activity.
		}
	}
	
	
}
