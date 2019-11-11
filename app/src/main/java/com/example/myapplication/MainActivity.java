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

  Random rd = new Random();

  public void resultadoSoma(){
    resultado = n1 + n2;
  }

  public void resultadoMultiplicacao(){
    resultado = n1 * n2;
  }

  public void resultadoDivisao(){
    resultado = n1 / n2;
  }

  public void resultadoSubtracao(){
    resultado = n1 - n2;
  }

  public void geraOperador(){

    int bool = rd.nextInt(11);
    if (bool == 0){
      // Multiplicacao;
      operador(n1, n2, " X ");
      resultadoMultiplicacao();
    }else if(bool == 1) {
      // Soma;
      operador(n1, n2," + ");
      resultadoSoma();
    }else if(bool == 2) {
      // Divisão
      operador(n1, n2, " / ");
      resultadoDivisao();
    }else {
      operador(n1, n2, " - ");
      resultadoSubtracao();
    }

  }

  public void geraNumeroAleatorio() {
  
    edtreaposta = (EditText) findViewById(R.id.edtResposta);

    n1 = rd.nextInt(9);
    n2 = rd.nextInt(9);
    
    edtreaposta.setText("");
  }

  public void operador(int v1, int v2, String op) {

    txtpergunta = (TextView) findViewById(R.id.txtQuestao);
    txtpergunta.setText(Integer.toString(v1) + op + Integer.toString(v2) + " =");
  }

  public void verifica() {
    resposta = edtreaposta.getText().toString();
    
    txtresultado = findViewById(R.id.txtResultadoCorreto);

    int res = Integer.parseInt(resposta);

    if (res == resultado) {
    
      txtresultado.setText("Acertou! resposta correta é: "+resultado);
      
      geraNumeroAleatorio();
      geraOperador();
    } else {

      txtresultado.setText("errou! resposta correta é: " + resultado);
     
      geraNumeroAleatorio();
      geraOperador();
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
    geraOperador();
  }
}
