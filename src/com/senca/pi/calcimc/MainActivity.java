package com.senca.pi.calcimc;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText editPeso, editAltura;
	private String msg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.editPeso = (EditText) findViewById(R.id.editPeso);
		this.editAltura= (EditText) findViewById(R.id.editAltura);
		this.msg = getResources().getString(R.string.resultado);
	}
	
	private String getSituacao(Float imc){
		
		if (imc < 17.0) {
			return "Muito Abaixo do Peso";
		}else if (imc >= 17.0 && imc <= 18.49){
			return "Abaixo do Peso";
		}else if (imc >= 18.50 && imc <= 24.99){
			return "Peso Norma";
		}else if (imc >= 25.0 && imc <= 29.99){
			return "Acima do Peso";
		}else if (imc >= 30.0 && imc <= 34.99){
			return "Obesidade I";
		}else if (imc >= 35.0 && imc <= 39.99){
			return "Obesidade II (SEVERA)";
		}else{
			return "Obesidade III (MÓRBIDA)";
		}
		
	}
	
	public void calcularIMC(View view){
		float imc;
		
		float pot;
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		pot = Float.parseFloat(this.editAltura.getText().toString()) * Float.parseFloat(this.editAltura.getText().toString());
		
		imc = Float.parseFloat(this.editPeso.getText().toString()) / pot ;
		
		String texto = msg + String.valueOf(df.format(imc)) + "\nDiagnostico: "+ this.getSituacao(imc) ;
		
		Toast toast = Toast.makeText(getApplicationContext(), texto	, Toast.LENGTH_LONG );	
		
		toast.show();
		
	}

}
