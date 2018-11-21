package mx.edu.ittepic.dadm_u3_juegoinglescolores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoPrincipal extends View {

    metodosLP start, bienvenido, play;
    String mensaje, mensaje2;
    MainActivity obj;

    public LienzoPrincipal(Context context) {
        super(context);

            mensaje = "Start";
            mensaje2="Play Game";
            bienvenido = new metodosLP(R.drawable.w, 10, 50, this);
            start=new metodosLP(R.drawable.start ,600, 750,this );
            play = new metodosLP(R.drawable.play, 600, 1300, this);

            obj = (MainActivity) context;
        }

        protected void onDraw(Canvas c) {
            super.onDraw(c);
            Paint p = new Paint();

            c.drawColor(Color.WHITE);

            bienvenido.pintar(c,p);

            start.pintar(c,p);
            p.setTextSize(80);
            p.setColor(Color.parseColor("#FF0040"));
            c.drawText(mensaje, 650, 1180, p);


            play.pintar(c,p);
            p.setTextSize(80);
            p.setColor(Color.parseColor("#FF0040"));
            c.drawText(mensaje2, 550, 1700, p);


        }

        public boolean onTouchEvent(MotionEvent e) {
            float xtoque = e.getX();
            float ytoque = e.getY();

            switch (e.getAction()) {

                //TOCAR
                case MotionEvent.ACTION_DOWN:
                    if (start.siSeToco(xtoque, ytoque)) {
                    Intent otraventana=new Intent(obj, Main2Activity.class);
                    obj.startActivity(otraventana);
                }

                    if (play.siSeToco(xtoque, ytoque)) {
                        Intent otraventana=new Intent(obj, Main3Activity.class);
                        obj.startActivity(otraventana);
                    }

                break;

                //MOVER
                case MotionEvent.ACTION_MOVE:


                    break;

                case MotionEvent.ACTION_UP:

                    break;
            }

            invalidate();
            return true;
        }


}
