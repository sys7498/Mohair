package com.example.mohartest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mohartest1.DrawableToInt;
import com.example.mohartest1.HomeFragment;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class CameraActivity extends AppCompatActivity implements AutoPermissionsListener {
    CameraSurfaceView cameraView;
    private DrawableToInt Draw = new DrawableToInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        FrameLayout previewFrame = findViewById(R.id.CameraPreviewFrame);
        cameraView = new CameraSurfaceView(this);
        previewFrame.addView(cameraView); //CameraSurfaceView를 framelayout에 넣기
        HomeFragment Homefragment = new HomeFragment();
        Intent Inte = getIntent();
        int ima1 = Inte.getIntExtra("selectHair",0);
        ImageView imageView;
        imageView = findViewById(R.id.hairImage);
        Button button = findViewById(R.id.cameraButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(ima1);
            }
        });
        AutoPermissions.Companion.loadAllPermissions(this, 101);
    }
    private class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback { //SurfaceView 클래스를 상속하고 Callback 인터페이스를 구현하는 새로운 클래스 정의
        private SurfaceHolder mHolder;
        private Camera camera = null;
        private int findFrontSideCamera(){
            int cameraId = -1;
            int numberOfCameras = Camera.getNumberOfCameras();
            for(int i=0;i<numberOfCameras;i++){
                Camera.CameraInfo cminfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i,cminfo);
                if(cminfo.facing== Camera.CameraInfo.CAMERA_FACING_FRONT){
                    cameraId = i;
                    break;
                }
            }
            return cameraId;
        }

        public CameraSurfaceView(Context context) { //생성자에서 서피스홀더 객체 참조후 설정
            super(context);
            mHolder = getHolder();
            mHolder.addCallback(this);
        }

        public void surfaceCreated(SurfaceHolder holder) { //서피스뷰가 만들어질 떄 카메라 객체를 참조한 후 미리보기 화면으로 홀더 객체 설정
            int cameraId = findFrontSideCamera();
            camera = Camera.open(cameraId);
            setCameraOrientation();

            try {
                camera.setPreviewDisplay(mHolder);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { //서피스뷰의 화면 크기가 바뀌는 등의 변경 시점에 미리보기 시작
            camera.startPreview();
        }

        public void surfaceDestroyed(SurfaceHolder holder) { //서피스뷰가 없어질떄 미리보기 중지
            camera.stopPreview();
            camera.release();
            camera = null;
        }
        public void setCameraOrientation() {
            if (camera == null) {
                return;
            }

            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(0, info);

            WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            int rotation = manager.getDefaultDisplay().getRotation();

            int degrees = 0;
            switch (rotation) {
                case Surface.ROTATION_0: degrees = 0; break;
                case Surface.ROTATION_90: degrees = 90; break;
                case Surface.ROTATION_180: degrees = 180; break;
                case Surface.ROTATION_270: degrees = 270; break;
            }

            int result;
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                result = (info.orientation + degrees) % 360;
                result = (360 - result) % 360;
            } else {
                result = (info.orientation - degrees + 360) % 360;
            }

            camera.setDisplayOrientation(result);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
    }

    @Override
    public void onDenied(int requestCode, String[] permissions) {
        Toast.makeText(this, "permissions denied : " + permissions.length, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGranted(int requestCode, String[] permissions) {
        Toast.makeText(this, "permissions granted : " + permissions.length, Toast.LENGTH_LONG).show();
    }
}