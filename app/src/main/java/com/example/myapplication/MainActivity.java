package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.myapplication.R;
import java.util.Random;

public class MainActivity extends Activity {

  public int n1;
  public int n2;
  public int resultado;
  public int resposta;

  public void geraNumeroAleatorio() {

    Random rd = new Random();

    n1 = rd.nextInt(10);
    n2 = rd.nextInt(10);
  }

  public void soma(int v1, int v2) {

    TextView pergunta = (TextView) findViewById(R.id.txtQuestao);
    pergunta.setText(Integer.toString(v1) + " + " + Integer.toString(v2) + " =");
  }

  public void verifica() {

    TextView txtresultado = (TextView) findViewById(R.id.txtResultadoCorreto);

    resposta = n1 + n2;

    if (resposta == resultado) {
      txtresultado.setText(Integer.toString(resultado));
    }else{
      //linpa caixa de respostas, diminuir score
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    geraNumeroAleatorio();
    soma(n1, n2);
  }
}
