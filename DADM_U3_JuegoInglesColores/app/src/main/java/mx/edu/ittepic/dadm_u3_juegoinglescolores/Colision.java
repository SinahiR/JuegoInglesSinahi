package mx.edu.ittepic.dadm_u3_juegoinglescolores;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Colision {

    private Bitmap icono;
    private float x,y;
    private boolean visible;

    public Colision(int resource, float xpara, float ypara, final Lienzo2 l)
    {
        icono=BitmapFactory.decodeResource(l.getResources(),resource);

        x=xpara;
        y=ypara;
        visible=true;
    }

    public void pintar(Canvas c, Paint p)
    {
        if(visible) c.drawBitmap(icono, x,y,p);
    }

    public void hacerVisible(boolean v)
    {
        visible=v;

    }

    public boolean siSeToco(float xtoque, float ytoque)
    {
        if(!visible)
        {
            return false;
        }

        float x2,y2;

        //final de la imagen
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xtoque>=x && xtoque<=x2)
        {
            if (ytoque>=y && ytoque<=y2)
            {
                return true;
            }

        }
        return false;

    }

    public  void mover(float xtoque, float ytoque)
    {
        x=xtoque-(icono.getWidth()/2);
        y=ytoque-(icono.getHeight()/2);
    }

    public boolean colision(Colision objetoB)
    {
        float x2=x+icono.getWidth(); //Calculas el tocque
        float y2=y+icono.getHeight();

        if(objetoB.siSeToco(x2,y))
        {
            //revisando caso 1
            return true;
        }

        if(objetoB.siSeToco(x,y))
        {
            //revisando caso 2
            return true;
        }

        if(objetoB.siSeToco(x2,y2))
        {
            //revisando caso 3
            return true;
        }

        if(objetoB.siSeToco(x,y2))
        {
            //revisando caso 4
            return true;
        }

        return false;
    }


}
