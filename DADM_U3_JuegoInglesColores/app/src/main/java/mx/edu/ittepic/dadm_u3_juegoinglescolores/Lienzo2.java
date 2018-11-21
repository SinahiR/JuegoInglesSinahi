package mx.edu.ittepic.dadm_u3_juegoinglescolores;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {

    Colision c1, c2, puntero, c3,c4, c5,c6;
    String mensaje;

    public Lienzo2(Context context) {
        super(context);

        mensaje = "Arrastra la imagen";
        puntero = null;
        c1 = new Colision(R.drawable.red, 100, 300, this);
        c2 = new Colision(R.drawable.redcolision, 800, 300, this);

        c3=new Colision(R.drawable.blue, 100, 800, this);
        c4=new Colision(R.drawable.bluecolision, 800, 800,this);

        c5=new Colision(R.drawable.green, 100, 1300, this);
        c6=new Colision(R.drawable.greencolision, 800, 1300,this);




    }

    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();
        p.setTextSize(50);
        p.setColor(Color.RED);
        c.drawText(mensaje, 50, 50, p);
        c1.pintar(c, p);
        c2.pintar(c, p);
        c3.pintar(c,p);
        c4.pintar(c,p);
        c5.pintar(c,p);
        c6.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xtoque = e.getX();
        float ytoque = e.getY();

        switch (e.getAction()) {

            //TOCAR
            case MotionEvent.ACTION_DOWN:
                if(c1.siSeToco(xtoque,ytoque))
                {
                    mensaje="se toco ICONO 1";
                    puntero=c1;
                }

                if(c2.siSeToco(xtoque,ytoque))
                {
                    mensaje="Se toco ICONO 2";
                    puntero=c2; //Puntero APUNTA A ICONO2
                }

                if(c3.siSeToco(xtoque,ytoque))
                {
                    mensaje="se toco ICONO 3";
                    puntero=c3;
                }

                if(c4.siSeToco(xtoque,ytoque))
                {
                    mensaje="Se toco ICONO 4";
                    puntero=c4; //Puntero APUNTA A ICONO4
                }

                if(c5.siSeToco(xtoque,ytoque))
                {
                    mensaje="se toco ICONO 5";
                    puntero=c5;
                }

                if(c6.siSeToco(xtoque,ytoque))
                {
                    mensaje="Se toco ICONO 6";
                    puntero=c6; //Puntero APUNTA A ICONO4
                }
                break;

            //MOVER
            case MotionEvent.ACTION_MOVE:
                if(puntero!=null)
                {
                    puntero.mover(xtoque,ytoque);

                    if(puntero.colision(c1) && puntero==c2)
                    {
                        mensaje="Objeto B fue tocado por objeto A";
                        c2.hacerVisible(false);
                        c1.hacerVisible(false);
                    }

                    if(puntero.colision(c3) && puntero==c4)
                    {
                        mensaje="Objeto B fue tocado por objeto A";
                        c3.hacerVisible(false);
                        c4.hacerVisible(false);
                    }

                   if(puntero.colision(c5) && puntero==c6)
                    {
                        mensaje="Objeto B fue tocado por objeto A";
                        c5.hacerVisible(false);
                        c6.hacerVisible(false);
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                puntero=null;
                break;

        }
        invalidate();
        return true;
    }

}
