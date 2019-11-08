package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.R;
import java.util.Random;

public class MainActivity extends Activity {

  public TextView txtresultado, txtpergunta;
  public EditText edtreaposta;
  public Button btnverifica;

  public int n1;
  public int n2;
  public int resultado;
  public String resposta;

  public void geraNumeroAleatorio() {
  
    edtreaposta = (EditText) findViewById(R.id.edtResposta);

    Random rd = new Random();

    n1 = rd.nextInt(9);
    n2 = rd.nextInt(9);
    
    edtreaposta.setText("");
  }

  public void soma(int v1, int v2) {

    txtpergunta = (TextView) findViewById(R.id.txtQuestao);
    txtpergunta.setText(Integer.toString(v1) + " + " + Integer.toString(v2) + " =");
  }

  public void verifica() {
    resposta = edtreaposta.getText().toString();
    
    txtresultado = findViewById(R.id.txtResultadoCorreto);

    resultado = n1 + n2;
    int res = Integer.parseInt(resposta);

    if (res == resultado) {
    
      txtresultado.setText("Acertou! resposta correta é: "+resultado);
      
      geraNumeroAleatorio();
      soma(n1, n2);
    } else {

      txtresultado.setText("errou! resposta correta é: " + resultado);
     
      geraNumeroAleatorio();
      soma(n1, n2);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnverifica = findViewById(R.id.btnVerifica);
    btnverifica.setOnClickListener(
        new View.OnClickListener() {

          @Override
          public void onClick(View v) {
            verifica();
          }
        });

    geraNumeroAleatorio();
    soma(n1, n2);
  }
}
