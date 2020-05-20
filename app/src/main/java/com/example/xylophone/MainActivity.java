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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //TODO: Criar objetos para reprodução de Sons
    private AudioManager audioManager;
    private SoundPool mSoundPool;
    private SparseIntArray mSoundMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            mSoundMap.put(R.id.botaoVermelho, mSoundPool.load(getApplicationContext(), R.raw.note1, 1));
            mSoundMap.put(R.id.botaoLaranja, mSoundPool.load(getApplicationContext(), R.raw.note2, 1));
            mSoundMap.put(R.id.botaoAmarelo, mSoundPool.load(getApplicationContext(), R.raw.note3, 1));
            mSoundMap.put(R.id.botaoVerde, mSoundPool.load(getApplicationContext(), R.raw.note4, 1));
            mSoundMap.put(R.id.botaoVerdeescuro, mSoundPool.load(getApplicationContext(), R.raw.note5, 1));
            mSoundMap.put(R.id.botaoAzul, mSoundPool.load(getApplicationContext(), R.raw.note6, 1));
            mSoundMap.put(R.id.botaoPurpura, mSoundPool.load(getApplicationContext(), R.raw.note7, 1));

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
