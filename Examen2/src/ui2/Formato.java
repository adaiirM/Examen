package ui2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formato extends JFrame {
        //Panel
        private JPanel panel;
        //Botones
        private JButton bCE;
        private JButton bC;
        private JButton bBorrar1;
        private JButton bDiv;
        private JButton b7;
        private JButton b8;
        private JButton b9;
        private JButton bMul;
        private JButton b4;
        private JButton b5;
        private JButton b6;
        private JButton bResta;
        private JButton b1;
        private JButton b2;
        private JButton b3;
        private JButton bSuma;
        private JButton bSigno;
        private JButton b0;
        private JButton bPunto;
        private JButton bIgual;
        //Labels
        private JLabel label1;
        private JLabel label2;
        private JLabel signo;
        //Variables
        private float n1 = 0, n2 = 0, total = 0;
        private boolean b = false, punto = false;
        private String op = null;

        public Formato(){

            super("Calculadora");
            //Opcion para cerrar ventana
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Crear un contenedor el cual sera el JPanel: panel
            this.setContentPane(panel);
            pack();
            //Tamaño del panel
            setSize(400, 600);
            setVisible(true);
            //Asignar el color de letras los JLabel que se utilizaran para hacer contraste con el fondo negro
            label1.setForeground(Color.white);
            label2.setForeground(Color.white);
            //Tipo, fuente y tamaño de la letra de los JLabel
            label1.setFont(new Font("Serif", Font.BOLD, 16));
            label2.setFont(new Font("Serif", Font.BOLD, 16));


            //Accion para los botones.
            // Cada que se presiones un numero al Label ubicado abajo (abajoR) se le agregara el caracter del numero elegido.
            b0.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"0");
            });
            b1.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"1");
            });
            b2.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"2");
            });
            b3.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"3");
            });
            b4.addActionListener(e -> {
               reiniciar();
                label2.setText(label2.getText()+"4");
            });
            b5.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"5");
            });
            b6.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"6");
            });
            b7.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"7");
            });
            b8.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"8");
            });
            b9.addActionListener(e -> {
                reiniciar();
                label2.setText(label2.getText()+"9");
            });

            bSuma.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Verificar si los labels estan vacios
                    if(label1.getText().equals("") && label2.getText() == ""){
                        //SI los estan entonces se agrega un 0 al label de arriba y al label del signo se le asigna el mas.
                        label1.setText("0"); signo.setText("+");
                        //Se pasa el caracter de suma para indicar que el operando actual es una suma
                        op = "+";
                        //Se convierte a verdadero la varibale b
                        b = true;
                    }else{
                        //Si no estan vacias entonces vuelva a comparar, si no el label2 esta vacio entonces
                        if (label2.getText() != "") {
                            //Compara si b es verdadero (si aun se sigue operando)
                            if(b){
                                //Si el operador es "+"
                                if(op == "+"){
                                    //Entonces realiza la suma de lo que haya en los dos label
                                    //Para ello convierte los Strings en flotante para poder operar
                                    total = Float.parseFloat(label1.getText()) + Float.parseFloat(label2.getText());
                                    //Una vez operados el resultado se coloca en el label1(el de arriba) y el signo de operadorse coloca en el label signo
                                    label1.setText(""+total); signo.setText("+");
                                    //Y se limpia el label2
                                    label2.setText("");
                                }
                            }else{
                                //Si no se esta operando entonces al label1 se le pasa lo que hay en el label2
                                label1.setText(label2.getText()); signo.setText("+");
                                label2.setText("");
                                op = "+";
                                b = true;
                            }
                        }else{
                            //Si esta vacio entonces solo guarda el caracter de suma
                            op = "+";
                        }
                    }
                }
            });

            bResta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(label1.getText() == "" && label2.getText() == ""){
                        label1.setText("0"); signo.setText("-");
                        op = "-";
                        b = true;
                    }else{
                        if (label2.getText() != "") {
                            if(b){
                                if(op == "-"){

                                    total = Float.parseFloat(label1.getText()) - Float.parseFloat(label2.getText());
                                    label1.setText(""+total); signo.setText("-");
                                    label2.setText("");
                                }
                            }else{
                                label1.setText(label2.getText()); signo.setText("-");
                                label2.setText("");
                                op = "-";
                                b = true;
                            }
                        }else{
                            op = "-";
                        }
                    }
                }
            });

            bMul.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(label1.getText() == "" && label2.getText() == ""){
                        label1.setText("0"); signo.setText("*");
                        op = "*";
                        b = true;
                    }else{
                        if (label2.getText() != "") {
                            if(b){
                                if(op == "*"){
                                    total = Float.parseFloat(label1.getText()) * Float.parseFloat(label2.getText());
                                    label1.setText(""+total); signo.setText("*");
                                    label2.setText("");
                                }
                            }else{
                                label1.setText(label2.getText()); signo.setText("*");
                                label2.setText("");
                                op = "*";
                                b = true;
                            }
                        }else{
                            op = "*";
                        }
                    }
                }
            });

            bDiv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(label1.getText() == "" && label2.getText() == ""){
                        label1.setText("0"); signo.setText("/");
                        op = "/";
                        b = true;
                    }else{
                        if (label2.getText() != "") {
                            if(b){
                                if(op == "/"){
                                    //Si el divisor ingresado es diferente a 0 se opera normalmente
                                    if(label2.getText() != "0"){
                                        total = Float.parseFloat(label1.getText()) / Float.parseFloat(label2.getText());
                                        label1.setText(""+total); signo.setText("/");
                                        label2.setText("");
                                    }else{
                                        //Si es 0 entonces se ingresa en el label2 que no se puede dividir entre 0
                                        label2.setText("No se puede dividir entre 0");
                                    }
                                }
                            }else{
                                label1.setText(label2.getText()); signo.setText("/");
                                label2.setText("");
                                op = "/";
                                b = true;
                            }
                        }else{
                            op = "/";
                        }
                    }
                }
            });

            bIgual.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    switch (op){
                        case "+":
                            if (label2.getText() != "") {
                                n1 = Float.parseFloat(label2.getText());
                                n2 = Float.parseFloat(label1.getText());
                                total = n1 + n2;
                                label2.setText(""+total);
                                label1.setText(""+total);
                            }
                            break;
                        case "-":
                            if (label2.getText() != "") {
                                n1 = Float.parseFloat(label1.getText());
                                n2 = Float.parseFloat(label2.getText());
                                total = n1 - n2;
                                label2.setText(""+total);
                                label1.setText(""+total);
                            }
                            break;
                        case "*":
                            if (label2.getText() != "") {
                                n1 = Float.parseFloat(label1.getText());
                                n2 = Float.parseFloat(label2.getText());
                                total = n1 * n2;
                                label2.setText(""+total);
                                label1.setText(""+total);
                            }
                            break;
                        case "/":
                            if (label2.getText() != "") {
                                n1 = Float.parseFloat(label1.getText());
                                n2 = Float.parseFloat(label2.getText());
                                if(n2 == 0){
                                    label2.setText("No se puede dvidir entre 0");
                                    label1.setText("");
                                }else{
                                    total = n1 / n2;
                                    label2.setText(""+total);
                                    label1.setText(""+total);
                                }
                            }
                            break;
                    }
                    b = false;
                    op = "=";
                }
            });

            bC.addActionListener(e -> {
                n1 = 0; n2 = 0; label2.setText(""); total = 0; label1.setText("");
                op = ""; b = false; signo.setText(""); punto = false;
            });
            bCE.addActionListener(e -> {
                label2.setText("");
            });
            bBorrar1.addActionListener(e -> {
                if(label2.getText() != "" && op != "="){
                    int t = label2.getText().length() - 1;
                    label2.setText(label2.getText().substring(0, t));
                }
            });

            bSigno.addActionListener(e -> {
                float a = Float.parseFloat(label2.getText());
                if(a != 0){
                    label2.setText(""+(a-(a*2)));
                }
            });
            bPunto.addActionListener(e -> {
                reiniciar();
                if(!punto){
                    label2.setText(label2.getText()+".");
                    punto = true;
                }

            });

        }
        //Metodo para cuando se toque el boton de "igual" se borren los numeros en pantalla al teclear un digito nuevo.
        public void reiniciar(){
            if (op == "=") {
                label2.setText("");
                label1.setText("");
                n1 = 0; n2 = 0; total = 0; op = ""; signo.setText(""); punto = false;
            }
        }

    }

