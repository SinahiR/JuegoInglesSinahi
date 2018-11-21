package mx.edu.ittepic.dadm_u3_juegoinglescolores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

public class MediaColores {
    private Bitmap icono;
    private float x,y;
    boolean visible;

    public MediaColores(int resource, float xpara, float ypara, final Lienzo3 l3)
    {
        icono=BitmapFactory.decodeResource(l3.getResources(),resource);
        x=xpara;
        y=ypara;
        visible=true;
    }


    public void pintar(Canvas c, Paint p)
    {
        if(visible) c.drawBitmap(icono, x,y,p);
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
