package com.example.joni.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Puntuación user.
    private int puntuacion = 0;
    // Progreso de cuestionario en la parte superior de la pantalla.
    private int progressStatus = 0;

    // Barra de progreso.
    public void mostrarProgress(int barraStatus) {
        ProgressBar progessB = (ProgressBar) findViewById(R.id.progress_bar);
        progessB.setProgress(progressStatus);
    }

    // Actualizar el progreso de la barra en baremos de 10 en 10.
    public void sumarProgress() {
        progressStatus = progressStatus + 10;
        mostrarProgress(progressStatus);
    }

    // Comenzar el cuestioniario reseteando todos los campos a su valores por defecto. Primero
    // localizamos los elementos y para posteriori definirlo con los valores predeterminados.
    public void inicio(View view) {
        puntuacion = 0;
        comenzarDeNuevo(view);
        TextView cuestionario = (TextView) findViewById(R.id.cuestionario);
        cuestionario.setVisibility(View.GONE);
        ImageView fotoPortada = (ImageView) findViewById(R.id.fotoprofe);
        fotoPortada.setVisibility(View.GONE);
        ScrollView scrollView = (ScrollView) findViewById(R.id.rollo);
        scrollView.setVisibility(View.VISIBLE);
    }

    // Comprobación pregunta 1.
    public void comprobacionPregunta1(View view) {
        // Localización de los elementos del RadioGroup y commprobación de los mismos.
        RadioGroup question1 = (RadioGroup) findViewById(R.id.question1);
        ImageView resultado1 = (ImageView) findViewById(R.id.foto_resultado1);
        Boolean imagenResultado = resultado1.isShown();
        RadioButton respuestaMal1 = (RadioButton) findViewById(R.id.joanPeterson);
        Boolean opcion1 = respuestaMal1.isChecked();
        RadioButton respuestaMal2 = (RadioButton) findViewById(R.id.luisCervantes);
        Boolean opcion2 = respuestaMal2.isChecked();
        RadioButton respuestaMal3 = (RadioButton) findViewById(R.id.andyDublin);
        Boolean opcion3 = respuestaMal3.isChecked();
        RadioButton respuestaBien = (RadioButton) findViewById(R.id.andyRubin);
        Boolean opcion4 = respuestaBien.isChecked();

        // Si la imagen está mostrada, se muestra un toast.
        if (imagenResultado) {
            Toast.makeText(this, R.string.respuesta_enviada, Toast.LENGTH_SHORT).show();
            return;
        }
        // Cuestionario y acción según elección del user.
        if (opcion1) {
            question1.setVisibility(View.GONE);
            resultado1.setImageResource(R.drawable.resmal);
            resultado1.setVisibility(View.VISIBLE);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (opcion2) {
            question1.setVisibility(View.GONE);
            resultado1.setImageResource(R.drawable.resmal);
            resultado1.setVisibility(View.VISIBLE);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (opcion3) {
            question1.setVisibility(View.GONE);
            resultado1.setImageResource(R.drawable.resmal);
            resultado1.setVisibility(View.VISIBLE);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (opcion4) {
            question1.setVisibility(View.GONE);
            resultado1.setImageResource(R.drawable.resbien);
            resultado1.setVisibility(View.VISIBLE);
            sumarProgress();
            puntuacion = puntuacion + 10;
            Toast.makeText(this, R.string.acierto, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.seleccione_respuesta, Toast.LENGTH_SHORT).show();
        }
    }

    // Comprobación pregunta 2.
    public void comprobacionPregunta2(View view) {
        //Localización de elementos.
        EditText question2 = (EditText) findViewById(R.id.question2);
        ImageView resultado2 = (ImageView) findViewById(R.id.foto_resultado2);
        Boolean imagenResultado = resultado2.isShown();

        // Si la pregunta ya fue respondida o si no a escrito nada el usuario se informa con un
        // toast.
        if (imagenResultado) {
            Toast.makeText(this, R.string.respuesta_enviada, Toast.LENGTH_SHORT).show();
            return;
        } else if (question2.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.escriba_respuesta, Toast.LENGTH_SHORT).show();
            return;
        }
        // @rUser es la respuesta del usuario.
        String rUser = question2.getText().toString();
        // Posibles opciones de la respuesta correcta.
        String rCorrecta = "MICROSOFT";
        String rCorrecta1 = "microsoft";
        String rCorrecta2 = "Microsoft";

        // Reaccioón a la elección del usuario.
        if (rUser.equals(rCorrecta) || rUser.equals(rCorrecta1) || rUser.equals(rCorrecta2)) {
            puntuacion = puntuacion + 10;
            question2.setVisibility(View.GONE);
            resultado2.setImageResource(R.drawable.resbien);
            resultado2.setVisibility(View.VISIBLE);
            sumarProgress();
            Toast.makeText(this, R.string.acierto, Toast.LENGTH_SHORT).show();
        } else {
            question2.setVisibility(View.GONE);
            resultado2.setImageResource(R.drawable.resmal);
            resultado2.setVisibility(View.VISIBLE);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        }
    }

    // Comprobación pregunta 3.
    public void comprobacionPregunta3(View view) {
        // Localización de elementos.
        RadioGroup question3 = (RadioGroup) findViewById(R.id.question3);
        ImageView resultado3 = (ImageView) findViewById(R.id.foto_resultado3);
        Boolean imagenResultado = resultado3.isShown();

        // Comprobación si la pregunta fué respondida.
        if (imagenResultado) {
            Toast.makeText(this, R.string.respuesta_enviada, Toast.LENGTH_SHORT).show();
            return;
        }
        // Localización de elementos del RadioGroup de la pregunta 3 y comprobación si el elemento
        // a sido seleccionado.
        RadioButton falso1 = (RadioButton) findViewById(R.id.sanSerif);
        Boolean marcafalso1 = falso1.isChecked();
        RadioButton falso2 = (RadioButton) findViewById(R.id.androFont);
        Boolean marcafalso2 = falso2.isChecked();
        RadioButton falso3 = (RadioButton) findViewById(R.id.casual);
        Boolean marcafalso3 = falso3.isChecked();
        RadioButton verda1 = (RadioButton) findViewById(R.id.roboto);
        Boolean verdadera1 = verda1.isChecked();

        // Según la elección del usuario se muestra una foto de resultado y un toast informativo.
        if (marcafalso1) {
            question3.setVisibility(View.GONE);
            resultado3.setVisibility(View.VISIBLE);
            resultado3.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (marcafalso2) {
            question3.setVisibility(View.GONE);
            resultado3.setVisibility(View.VISIBLE);
            resultado3.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (marcafalso3) {
            question3.setVisibility(View.GONE);
            resultado3.setVisibility(View.VISIBLE);
            resultado3.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (verdadera1) {
            question3.setVisibility(View.GONE);
            resultado3.setVisibility(View.VISIBLE);
            resultado3.setImageResource(R.drawable.resbien);
            puntuacion = puntuacion + 10;
            Toast.makeText(this, R.string.acierto, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else {
            Toast.makeText(this, R.string.seleccione_respuesta, Toast.LENGTH_SHORT).show();
        }
    }

    // Comprobación pregunta 4.
    public void comprobacionPregunta4(View view) {
        // Localización de elementos de la pregunta 4 y comprobación si está marcado.
        ImageView resultado4 = (ImageView) findViewById(R.id.foto_resultado4);
        RadioGroup question4 = (RadioGroup) findViewById(R.id.question4);
        RadioButton ete = (RadioButton) findViewById(R.id.ete);
        Boolean respuestaMal1 = ete.isChecked();
        RadioButton eth = (RadioButton) findViewById(R.id.eth);
        Boolean respuestaMal2 = eth.isChecked();
        RadioButton eht = (RadioButton) findViewById(R.id.eht);
        Boolean respuestaMal3 = eht.isChecked();
        RadioButton het = (RadioButton) findViewById(R.id.het);
        Boolean respuestaCorrecta = het.isChecked();
        Boolean imagenResultado = resultado4.isShown();

         /* Si la respuesta fue enviada se informa en un toast */
        if (imagenResultado == true) {
            Toast.makeText(this, R.string.respuesta_enviada, Toast.LENGTH_SHORT).show();
            return;
        }
        if (respuestaMal1) {
            question4.setVisibility(View.GONE);
            resultado4.setVisibility(View.VISIBLE);
            resultado4.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaMal2) {
            question4.setVisibility(View.GONE);
            resultado4.setVisibility(View.VISIBLE);
            resultado4.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaMal3) {
            question4.setVisibility(View.GONE);
            resultado4.setVisibility(View.VISIBLE);
            resultado4.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaCorrecta) {
            puntuacion = puntuacion + 10;
            question4.setVisibility(View.GONE);
            resultado4.setVisibility(View.VISIBLE);
            resultado4.setImageResource(R.drawable.resbien);
            Toast.makeText(this, R.string.acierto, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else {
            Toast.makeText(this, R.string.seleccione_respuesta, Toast.LENGTH_SHORT).show();
        }
    }

    // Comprobación pregunta 5.
    public void comprobacionPregunta5(View view) {
        // Localización de elementos y comprobación si está marcada cada opción.
        LinearLayout question5 = (LinearLayout) findViewById(R.id.question5);
        ImageView resultado5 = (ImageView) findViewById(R.id.foto_resultado5);
        CheckBox alfa = (CheckBox) findViewById(R.id.alfa);
        Boolean respuestaRegular = alfa.isChecked();
        CheckBox astroPetit = (CheckBox) findViewById(R.id.astroBoy);
        Boolean respuestaBien = astroPetit.isChecked();
        CheckBox xy = (CheckBox) findViewById(R.id.xy);
        Boolean respuestaMal = xy.isChecked();
        CheckBox gooandgle = (CheckBox) findViewById(R.id.gooandgle);
        Boolean respuestaMal1 = gooandgle.isChecked();
        Boolean imagenResultado = resultado5.isShown();

        // Si la respuesta fue respondida se informa en un toast
        if (imagenResultado) {
            Toast.makeText(this, R.string.respuesta_enviada, Toast.LENGTH_SHORT).show();
            return;
        }
        if (respuestaRegular && respuestaMal || respuestaRegular && respuestaMal1 ||
                respuestaBien && respuestaMal || respuestaBien && respuestaMal1) {
            puntuacion = puntuacion + 10;
            question5.setVisibility(View.GONE);
            resultado5.setVisibility(View.VISIBLE);
            resultado5.setImageResource(R.drawable.regular);
            Toast.makeText(this, R.string.regular, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaBien && respuestaRegular) {
            puntuacion = puntuacion + 20;
            question5.setVisibility(View.GONE);
            resultado5.setVisibility(View.VISIBLE);
            resultado5.setImageResource(R.drawable.resbien);
            Toast.makeText(this, R.string.acierto_doble, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaMal & respuestaMal1) {
            question5.setVisibility(View.GONE);
            resultado5.setVisibility(View.VISIBLE);
            resultado5.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaMal1 && respuestaMal) {
            question5.setVisibility(View.GONE);
            resultado5.setVisibility(View.VISIBLE);
            resultado5.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else {
            Toast.makeText(this, R.string.seleccione_dos, Toast.LENGTH_SHORT).show();
        }
    }

    // Comprobación pregunta 6.
    public void comprobacionPregunta6(View view) {
        // Localización elementos pregunta 6 y posterior comprobación de cada uno de ellos.
        RadioGroup question6 = (RadioGroup) findViewById(R.id.question6);
        ImageView resultado6 = (ImageView) findViewById(R.id.foto_resultado6);
        RadioButton opcion_caja = (RadioButton) findViewById(R.id.caja);
        Boolean respuestaMal = opcion_caja.isChecked();
        RadioButton opcion_garantia = (RadioButton) findViewById(R.id.garantia);
        Boolean respuestaMal1 = opcion_garantia.isChecked();
        RadioButton opcion_easter_egg = (RadioButton) findViewById(R.id.easteregg);
        Boolean respuestaBuena = opcion_easter_egg.isChecked();
        RadioButton opcion_web = (RadioButton) findViewById(R.id.web);
        Boolean respuestaMal2 = opcion_web.isChecked();
        Boolean imagenResultado = resultado6.isShown();

        // Si la pregunta fue respondida se informa en un toast.
        if (imagenResultado) {
            Toast.makeText(this, R.string.respuesta_enviada, Toast.LENGTH_SHORT).show();
            return;
        }
        // Comprobación de la selección del usuario y su correspondiente reacción.
        if (respuestaMal) {
            question6.setVisibility(View.GONE);
            resultado6.setVisibility(View.VISIBLE);
            resultado6.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaMal1) {
            question6.setVisibility(View.GONE);
            resultado6.setVisibility(View.VISIBLE);
            resultado6.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaBuena) {
            puntuacion = puntuacion + 10;
            question6.setVisibility(View.GONE);
            resultado6.setVisibility(View.VISIBLE);
            resultado6.setImageResource(R.drawable.resbien);
            Toast.makeText(this, R.string.acierto, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else if (respuestaMal2) {
            question6.setVisibility(View.GONE);
            resultado6.setVisibility(View.VISIBLE);
            resultado6.setImageResource(R.drawable.resmal);
            Toast.makeText(this, R.string.fallo, Toast.LENGTH_SHORT).show();
            sumarProgress();
        } else {
            Toast.makeText(this, R.string.seleccione_respuesta, Toast.LENGTH_SHORT).show();
        }
    }

    // Comprobación puntuación final.
    public void puntuacionFinal(View view) {
        // Si faltan preguntas por contestar se muestra en un toast.
        if (progressStatus < 60) {
            Toast.makeText(this, R.string.faltan_preguntas, Toast.LENGTH_SHORT).show();
            return;
        }
        // Localización del botón de comprobación de puntuación y del texto informando de la
        // puntuación final.
        Button botonPuntuacion = (Button) findViewById(R.id.botonfinal);
        botonPuntuacion.setVisibility(View.GONE);
        TextView puntuacion = (TextView) findViewById(R.id.texfinal);
        // Si es mayor a 60, felicitación por puntuación máxima.
        if (this.puntuacion > 60) {
            puntuacion.setVisibility(View.VISIBLE);
            puntuacion.setText(R.string.enhorabuena);
            Toast.makeText(this, R.string.puntuacionMaxima, Toast.LENGTH_SHORT).show();
        } else { // resto de los casos.
            puntuacion.setVisibility(View.VISIBLE);
            puntuacion.setText("Puntuación Final Acumulada: " + this.puntuacion);
            Toast.makeText(this, R.string.puntuacionMaxima, Toast.LENGTH_SHORT).show();
        }
    }

    // Botón para comenzar o repetir de nuevo el cuestionario, reseteando todos los elementos a sus
    // valores por defecto. Conjunto de localización de elementos y posterior definición del valor
    // predeterminado.
    public void comenzarDeNuevo(View view) {
        progressStatus = 0;
        mostrarProgress(progressStatus);
        TextView cuestionario = (TextView) findViewById(R.id.cuestionario);
        ImageView fotoPortada = (ImageView) findViewById(R.id.fotoprofe);
        Boolean portadaMostrada = fotoPortada.isShown();
        ScrollView scrollView = (ScrollView) findViewById(R.id.rollo);
        RadioGroup question1 = (RadioGroup) findViewById(R.id.question1);
        ImageView resultado1 = (ImageView) findViewById(R.id.foto_resultado1);
        EditText question2 = (EditText) findViewById(R.id.question2);
        ImageView resultado2 = (ImageView) findViewById(R.id.foto_resultado2);
        RadioGroup question3 = (RadioGroup) findViewById(R.id.question3);
        ImageView resultado3 = (ImageView) findViewById(R.id.foto_resultado3);
        RadioGroup question4 = (RadioGroup) findViewById(R.id.question4);
        ImageView resultado4 = (ImageView) findViewById(R.id.foto_resultado4);
        LinearLayout question5 = (LinearLayout) findViewById(R.id.question5);
        CheckBox alfa = (CheckBox) findViewById(R.id.alfa);
        CheckBox astroBoy = (CheckBox) findViewById(R.id.astroBoy);
        CheckBox beta = (CheckBox) findViewById(R.id.xy);
        CheckBox petitFour = (CheckBox) findViewById(R.id.gooandgle);
        ImageView resultado5 = (ImageView) findViewById(R.id.foto_resultado5);
        RadioGroup question6 = (RadioGroup) findViewById(R.id.question6);
        ImageView resultado6 = (ImageView) findViewById(R.id.foto_resultado6);
        TextView puntuacion = (TextView) findViewById(R.id.texfinal);

        //Si la foto de la portada esta mostrada, no hace nada e invita a comenzar la actividad
        if (portadaMostrada) {
            Toast.makeText(this, R.string.comience, Toast.LENGTH_SHORT).show();
            return;
        }
       /* Inicio actividad mostrando portada y scroll Up*/
        scrollView.setVisibility(View.GONE);
        scrollView.fullScroll(0);
        cuestionario.setVisibility(View.VISIBLE);
        fotoPortada.setVisibility(View.VISIBLE);
        question1.clearCheck();
        question1.setVisibility(View.VISIBLE);
        resultado1.setVisibility(View.GONE);
        question2.setVisibility(View.VISIBLE);
        question2.setText("");
        resultado2.setVisibility(View.GONE);
        question3.clearCheck();
        question3.setVisibility(View.VISIBLE);
        resultado3.setVisibility(View.GONE);
        question4.setVisibility(View.VISIBLE);
        question4.clearCheck();
        resultado4.setVisibility(View.GONE);
        question5.setVisibility(View.VISIBLE);
        resultado5.setVisibility(View.GONE);
        alfa.setChecked(false);
        astroBoy.setChecked(false);
        beta.setChecked(false);
        petitFour.setChecked(false);
        question6.setVisibility(View.VISIBLE);
        question6.clearCheck();
        resultado6.setVisibility(View.GONE);
        Button botonFi = (Button) findViewById(R.id.botonfinal);
        botonFi.setVisibility(View.VISIBLE);
        puntuacion.setVisibility(View.GONE);
    }
}
