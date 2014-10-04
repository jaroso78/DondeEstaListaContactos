package com.example.dondeestas;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	
	private static final String TAG ="Ventana Principal";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//Recuperamos los objetos de la Vista
		final Button boton=(Button) findViewById(R.id.Button1);
		final Button botonContactos = (Button) findViewById(R.id.CopiarContactos);
		final EditText eText =(EditText)findViewById(R.id.editText1);
		
		
		//Listener a la espera de que el botón sea pulsado de busqueda.
		boton.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {   //Una vez pulsado ejecuta un Intent
				Intent mapa = new Intent(
						android.content.Intent.ACTION_VIEW,
											
						Uri.parse("geo:0,0?q="+eText.getText()) //Le pasamos la dirección para ello contatenamos el
						);                                      // el texto del EditTExt 
						startActivity(mapa);
						
			
				
			}
			
		}
		
		);
		
		
		//Listener a la espera de que el boton de contactos sea pulsado.
		botonContactos.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				//Una vez pulsado lanza un Intent que lo envia a la segunda Activiti.
				Intent segunda = new Intent (
						MainActivity.this, SecondActivity.class						
						);
		
					startActivityForResult(segunda,1); // Y espera que devuelva algo.
				
			}
			
		}
		
		);
		
	}
	
	
	
	//Método para la espera del resultado de la segunda activity.
	
protected void onActivityResult(int requestCode, int resultCode, Intent data){
		
	
	final EditText eText =(EditText)findViewById(R.id.editText1);
		if (requestCode ==1){ 
			if (resultCode == RESULT_OK) {  // Si el resultado es OK.
				String resultado = data.getStringExtra("lugar"); // Recoge el dato lugar 
																 // enviado desde la SecondActivity.
				eText.setText(resultado); // Muestra el texto en el editText.
			}
			if (resultCode == RESULT_CANCELED){
				
				Log.i(TAG,"Error resultado cancelado.");
			}
		}
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
