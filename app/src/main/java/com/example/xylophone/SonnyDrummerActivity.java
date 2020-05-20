package com.example.xylophone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Toast;

public class SonnyDrummerActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //TODO: Criar objetos para reprodução de Sons
    private AudioManager audioManager;
    private SoundPool mSoundPool;
    private SparseIntArray mSoundMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonny_drummer);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();
            mSoundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(1)
                    .build();
        } else {
            mSoundPool = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        }

        //TODO: Inicializar Mapa de Sons
        mSoundMap = new SparseIntArray();
        try {
            mSoundMap.put(R.id.botao1, mSoundPool.load(getApplicationContext(), R.raw.beat_01, 1));
            mSoundMap.put(R.id.botao2, mSoundPool.load(getApplicationContext(), R.raw.beat_02, 1));
            mSoundMap.put(R.id.botao3, mSoundPool.load(getApplicationContext(), R.raw.beat_03, 1));
            mSoundMap.put(R.id.botao4, mSoundPool.load(getApplicationContext(), R.raw.beat_04, 1));
            mSoundMap.put(R.id.botao5, mSoundPool.load(getApplicationContext(), R.raw.beat_05, 1));
            mSoundMap.put(R.id.botao6, mSoundPool.load(getApplicationContext(), R.raw.beat_06, 1));
            mSoundMap.put(R.id.botao7, mSoundPool.load(getApplicationContext(), R.raw.beat_07, 1));
            mSoundMap.put(R.id.botao8, mSoundPool.load(getApplicationContext(), R.raw.beat_08, 1));
            mSoundMap.put(R.id.botao9, mSoundPool.load(getApplicationContext(), R.raw.beat_09, 1));
            mSoundMap.put(R.id.botao10, mSoundPool.load(getApplicationContext(), R.raw.beat_10, 1));
            mSoundMap.put(R.id.botao11, mSoundPool.load(getApplicationContext(), R.raw.beat_11, 1));
            mSoundMap.put(R.id.botao12, mSoundPool.load(getApplicationContext(), R.raw.beat_12, 1));
            mSoundMap.put(R.id.botao13, mSoundPool.load(getApplicationContext(), R.raw.beat_13, 1));
            mSoundMap.put(R.id.botao14, mSoundPool.load(getApplicationContext(), R.raw.beat_14, 1));
            mSoundMap.put(R.id.botao16, mSoundPool.load(getApplicationContext(), R.raw.beat_16, 1));
            mSoundMap.put(R.id.botao17, mSoundPool.load(getApplicationContext(), R.raw.beat_17, 1));

        } catch (Exception e) {
            Log.e("MainActivity", "Error: " + e.getLocalizedMessage());
        }
    }
    //TODO: Criar onDestroy
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSoundPool.release();
        mSoundPool = null;
    }
    public void toast (String cor){
        Toast.makeText(this, "Click do botao: "+cor, Toast.LENGTH_SHORT).show();
    }
    public void botaoClick(View view) {

        //TODO: Reproduzir Som
        int idSom = mSoundMap.get(view.getId());
        mSoundPool.play(idSom, 1.0F, 1.0F, 1, 0, 1.0F);
    }
}
