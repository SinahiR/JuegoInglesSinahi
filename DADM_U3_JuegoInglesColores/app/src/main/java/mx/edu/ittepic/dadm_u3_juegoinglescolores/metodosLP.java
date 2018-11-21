package mx.edu.ittepic.dadm_u3_juegoinglescolores;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class metodosLP {

    private Bitmap icono;
    private float x,y;
    private boolean visible;

    public metodosLP(int resource, float xpara, float ypara, final LienzoPrincipal lp)
    {
        icono=BitmapFactory.decodeResource(lp.getResources(),resource);
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


}
