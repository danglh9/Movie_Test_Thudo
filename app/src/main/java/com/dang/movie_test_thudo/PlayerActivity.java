package com.dang.movie_test_thudo;


import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.TimeBar;

import com.google.android.material.snackbar.Snackbar;

import java.util.Formatter;

public class PlayerActivity extends AppCompatActivity {

    private ExoPlayer player;
    private PlayerView playerView;

    private final String TAG = PlayerActivity.class.getName();

    private final Handler handler = new Handler();

    private Runnable updateTimeRunnable;

    @OptIn(markerClass = UnstableApi.class)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.statusBars());

        String title = getIntent().getStringExtra("title");
        String url = getIntent().getStringExtra("url");

        Log.i(TAG, "onCreate: " + url);


        player = new ExoPlayer.Builder(this)
                .setSeekForwardIncrementMs(1).setSeekBackIncrementMs(1).
                build();
        PlayerView playerView = findViewById(R.id.playerView);
        playerView.setPlayer(player);
        TextView titleMovie = playerView.findViewById(R.id.title);
        titleMovie.setText(title);
        DefaultTimeBar timeBar = playerView.findViewById(R.id.exo_progress);
        TextView currentTimeOverlay = playerView.findViewById(R.id.exo_current_time_overlay);
        onTimeBarListening(timeBar, currentTimeOverlay);
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(url));


        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();


    }

    @Override
    protected void onStart() {
        super.onStart();
        findViewById(R.id.exo_play_pause).requestFocus();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            View focused = getCurrentFocus();
            if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER ||
                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                if (focused.getId() == R.id.btn_choose_episode) {
                    Snackbar.make(findViewById(android.R.id.content), "Đang mở danh sách tập", Snackbar.LENGTH_SHORT).show();
                    return true;
                } else if (focused.getId() == R.id.btn_next) {
                    Snackbar.make(findViewById(android.R.id.content), "Đang mở tập tiếp theo", Snackbar.LENGTH_SHORT).show();
                    return true;
                }
            }
            if(event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT){
                if (focused.getId() == R.id.exo_progress){
                    long current = player.getCurrentPosition();
                    player.seekTo(current - 10000);  // Tua lùi 5s
                    Snackbar.make(findViewById(android.R.id.content), "Tua lùi 10s", Snackbar.LENGTH_SHORT).show();
                    return true;
                }
            }
            if(event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT){
                if (focused.getId() == R.id.exo_progress){
                    long current = player.getCurrentPosition();
                    player.seekTo(current + 10000);  // Tua tới 5s
                    Snackbar.make(findViewById(android.R.id.content), "Tua tiến 10s", Snackbar.LENGTH_SHORT).show();
                    return true;
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @OptIn(markerClass = UnstableApi.class)
    private void onTimeBarListening(DefaultTimeBar timeBar, TextView currentTimeOverlay) {
        player.addListener(new Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int state) {
                Log.i(TAG, "onPlaybackStateChanged: " + state);
                if (state == Player.STATE_READY) {
                    handler.removeCallbacks(updateTimeRunnable);
                    updateTimeRunnable = new Runnable() {
                        @Override
                        public void run() {
                            if (player != null && player.isPlaying()) {
                                long positionMs = player.getCurrentPosition();
                                String time = Util.getStringForTime(new StringBuilder(), new Formatter(), positionMs);
                                currentTimeOverlay.setText(time);
                                updatePositionTimeBar(timeBar, currentTimeOverlay, positionMs);
                            }
                            handler.postDelayed(this, 1000);
                        }
                    };
                    handler.post(updateTimeRunnable);
                }
            }
        });

        timeBar.addListener(new TimeBar.OnScrubListener() {
            @Override
            public void onScrubStart(TimeBar bar, long position) {
                Log.i(TAG, "onScrubStart: " + position);
                updatePosition(position);
            }

            @Override
            public void onScrubMove(TimeBar bar, long position) {
                Log.i(TAG, "onScrubMove: " + position);
                updatePosition(position);
            }

            @Override
            public void onScrubStop(TimeBar bar, long position, boolean canceled) {
                Log.i(TAG, "onScrubStop: " + position);
                updatePosition(position);
            }

            private void updatePosition(long positionMs) {
                Log.i(TAG, "updatePosition: " + positionMs);
                updatePositionTimeBar(timeBar, currentTimeOverlay, positionMs);
            }
        });

    }

    @OptIn(markerClass = UnstableApi.class)

    private void updatePositionTimeBar(DefaultTimeBar timeBar, TextView currentTimeOverlay, long positionMs) {
        String time = Util.getStringForTime(new StringBuilder(), new Formatter(), positionMs);
        currentTimeOverlay.setText(time);

        long duration = player.getDuration();
        int progressBarWidth = timeBar.getWidth();
        int scrubX = (int) ((float) positionMs / duration * progressBarWidth);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) currentTimeOverlay.getLayoutParams();
        params.leftMargin = scrubX;
        Log.i(TAG, "scrubX: " + scrubX);
        currentTimeOverlay.setLayoutParams(params);
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(updateTimeRunnable);
    }
}