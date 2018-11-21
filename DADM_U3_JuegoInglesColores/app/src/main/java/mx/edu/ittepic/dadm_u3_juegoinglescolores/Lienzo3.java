package mx.edu.ittepic.dadm_u3_juegoinglescolores;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Lienzo3 extends View {

    MediaColores redB,blueB,greenB,yellowB,purpleB,pinkB;
    MediaPlayer mp;
    Main3Activity obj2;
    String mensaje, bluec, redc, greenc, yellow, pink, purple;

    public Lienzo3(Context context) {
        super(context);

        redc="Red";
        greenc="Green";
        bluec="Blue";
        yellow="Yellow";
        pink="Pink";
        purple="Purple";
        mensaje="Presiona un color y escucharas su nombre";
        blueB=new MediaColores(R.drawable.blue, 400, 300,this);
        redB=new MediaColores(R.drawable.red, 800, 300,this);
        greenB=new MediaColores(R.drawable.green, 400, 800,this);
        yellowB=new MediaColores(R.drawable.amarillo, 800, 800,this);
        pinkB=new MediaColores(R.drawable.rosita, 400, 1300,this);
        purpleB=new MediaColores(R.drawable.moradop, 800, 1300,this);

        obj2=(Main3Activity)context;

    }

    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p=new Paint();

        p.setTextSize(50);
        p.setColor(Color.BLACK);
        c.drawText(mensaje, 450, 100, p);

        p.setTextSize(60);
        p.setColor(Color.RED);
        c.drawText(redc, 900, 700, p);

        p.setTextSize(60);
        p.setColor(Color.BLUE);
        c.drawText(bluec, 500, 700, p);

        p.setTextSize(60);
        p.setColor(Color.parseColor("#0B3B0B"));
        c.drawText(greenc, 480, 1200, p);

        p.setTextSize(60);
        p.setColor(Color.YELLOW);
        c.drawText(yellow, 880, 1200, p);

        p.setTextSize(60);
        p.setColor(Color.parseColor("#F781BE"));
        c.drawText(pink, 500, 1700, p);

        p.setTextSize(60);
        p.setColor(Color.parseColor("#BE81F7"));
        c.drawText(purple, 900, 1700, p);



        blueB.pintar(c,p);
        redB.pintar(c,p);
        yellowB.pintar(c,p);
        greenB.pintar(c,p);
        purpleB.pintar(c,p);
        pinkB.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xtoque = e.getX();
        float ytoque = e.getY();


        switch (e.getAction()) {

            //TOCAR
            case MotionEvent.ACTION_DOWN:
                if (blueB.siSeToco(xtoque, ytoque))
                {
                mp=MediaPlayer.create(obj2, R.raw.color);
                mp.start();
                }

                if (redB.siSeToco(xtoque, ytoque))
                {
                    mp=MediaPlayer.create(obj2, R.raw.recolor);
                    mp.start();
                }

                if (yellowB.siSeToco(xtoque, ytoque))
                {
                    mp=MediaPlayer.create(obj2, R.raw.yellowcolor);
                    mp.start();
                }

                if (pinkB.siSeToco(xtoque, ytoque))
                {
                    mp=MediaPlayer.create(obj2, R.raw.pinkcolor);
                    mp.start();
                }

                if (purpleB.siSeToco(xtoque, ytoque))
                {
                    mp=MediaPlayer.create(obj2, R.raw.purplecolor);
                    mp.start();
                }

                if (greenB.siSeToco(xtoque, ytoque))
                {
                    mp=MediaPlayer.create(obj2, R.raw.greencolor);
                    mp.start();
                }


                break;
        }
            invalidate();
            return true;
        }




   /* redB=(ImageView) findViewById(R.id.redB);
    mp2=MediaPlayer.create(this,R.raw.recolor);
        redB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            mp2.start();

        }
    });

    greenB=(ImageView) findViewById(R.id.green);
    mp3=MediaPlayer.create(this,R.raw.greencolor);
        greenB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            mp3.start();

        }
    });

    yellowB=(ImageView) findViewById(R.id.yellow);
    mp4=MediaPlayer.create(this,R.raw.yellowcolor);
        yellowB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            mp4.start();

        }
    });

    pinkB=(ImageView) findViewById(R.id.pink);
    mp5=MediaPlayer.create(this,R.raw.pinkcolor);
        pinkB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            mp5.start();

        }
    });

    purpleB=(ImageView) findViewById(R.id.purple);
    mp6=MediaPlayer.create(this,R.raw.purplecolor);
        purpleB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            mp6.start();

        }
    });*/

}






