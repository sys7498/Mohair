package com.example.mohartest1;

import android.Manifest;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link kakaomap#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kakaomap extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    MapView mapView;
    MapPOIItem marker;
    static final int GPS_ENABLE_REQUEST_CODE = 2001;
    static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION};
    String keyword;
    String longitude = "1";
    String latitude = "1";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public kakaomap() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static kakaomap newInstance(String param1, String param2) {
        kakaomap fragment = new kakaomap();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kakaomap, container, false);
        mapView = new MapView(getActivity());
        marker = new MapPOIItem();

        ViewGroup mapViewContainer = (ViewGroup) view.findViewById(R.id.map_view);
        TextInputEditText search_place = view.findViewById(R.id.search_place);
        Button searchbutton = view.findViewById(R.id.searchbutton);
        mapViewContainer.addView(mapView);


        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyword = search_place.getText().toString();
                if(keyword != null){
                    retrofit2.Call<kakao_data_address> calladdress = retrofit.getRetrofit().getSearchAddressService().searchAddressList(keyword, "KakaoAK faa493acd8ae730128b2d673abf1a1d7");
                    calladdress.enqueue(new Callback<kakao_data_address>() {
                        @Override
                        public void onResponse(retrofit2.Call<kakao_data_address> call, Response<kakao_data_address> response) {
                            if(response.isSuccessful()){
                                Log.d("response", "successful");
                                if(response.body() != null){
                                    Log.e("tag", "body: " + new Gson().toJson(response.body()));
                                    latitude = response.body().documents.get(0).address.y;
                                    longitude = response.body().documents.get(0).address.x;
                                    mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(Double.parseDouble(latitude), Double.parseDouble(longitude)), true);
                                    retrofit2.Call<kakao_data_HairShop> callhairshop = retrofit.getRetrofit().getSearchKeywordService().searchKeywordList("미용실", latitude, longitude, 10000, "KakaoAK faa493acd8ae730128b2d673abf1a1d7");
                                    callhairshop.enqueue(new Callback<kakao_data_HairShop>() {
                                        @Override
                                        public void onResponse(retrofit2.Call<kakao_data_HairShop> call, Response<kakao_data_HairShop> response) {
                                            if(response.isSuccessful()){
                                                Log.d("response", "hairshopsuccessful");
                                                if(response.body() != null){
                                                    for (int i = 0; i < response.body().documents.size(); i++){
                                                        MapPoint point1 = MapPoint.mapPointWithGeoCoord(Double.parseDouble(response.body().documents.get(i).y), Double.parseDouble(response.body().documents.get(i).x));
                                                        MapPOIItem marker1 = new MapPOIItem();
                                                        marker1.setItemName("" + response.body().documents.get(i).place_name + "/" + response.body().documents.get(i).phone);
                                                        marker1.setTag(0);
                                                        marker1.setMapPoint(point1);
                                                        marker1.setMarkerType(MapPOIItem.MarkerType.BluePin);
                                                        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
                                                        mapView.addPOIItem(marker1);

                                                    }
                                                }
                                            }else{
                                                Log.d("response", "failed");
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<kakao_data_HairShop> call, Throwable t) {
                                            Log.d("response", ""+t);
                                        }
                                    });



                                }
                            }else{
                                Log.d("response", "failed");
                            }
                        }

                        @Override
                        public void onFailure(Call<kakao_data_address> call, Throwable t) {
                            Log.d("response", ""+t);
                        }
                    });




                }

            }
        });





        /*mapPoint = MapPoint.mapPointWithGeoCoord(Double.parseDouble(latitude)
                , Double.parseDouble(longitude));
        marker.setMapPoint(mapPoint);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);*/

        return view;
    }


}