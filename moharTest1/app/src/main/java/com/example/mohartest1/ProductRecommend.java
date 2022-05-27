package com.example.mohartest1;



import static java.sql.DriverManager.println;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductRecommend#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductRecommend extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static RequestQueue requestQueue;
    hairproductAdapter hairproductAdapter;
    RecyclerView hairproductRecycler;
    ArrayList<ArrayList<product_json>> productList = new ArrayList<ArrayList<product_json>>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductRecommend() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductRecommend.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductRecommend newInstance(String param1, String param2) {
        ProductRecommend fragment = new ProductRecommend();
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
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        }
    }

    public void makeRequest() {
        String url = "http://192.168.0.6:5000/";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        processResponse(response);
                        Log.d("wow", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
    }


    /*public String loadJSONFromAsset(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("test.json");

            //InputStream is = new URL("http://127.0.0.1:5000/").openStream();

            //BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            //String str;
            //StringBuffer buffer = new StringBuffer();
            //while((str = rd.readLine()) != null){
            //    buffer.append(str);
            //}
            //receiveJson = buffer.toString();
            //Log.d("wow", receiveJson);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }*/

    /*private void json_parsing(String json){
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray waxArray = jsonObject.getJSONArray("wax");
            JSONArray fomardArray = jsonObject.getJSONArray("fomard");
            JSONArray curlcreamArray = jsonObject.getJSONArray("curlcream");
            JSONArray sprayArray = jsonObject.getJSONArray("spray");
            JSONArray shampooArray = jsonObject.getJSONArray("shampoo");
            JSONArray dyeArray = jsonObject.getJSONArray("dye");

            JSONArray[] products = {
                    waxArray, fomardArray, curlcreamArray, sprayArray, shampooArray, dyeArray};

            for(int j = 0; j < products.length; j++){
                ArrayList<product_json> row = new ArrayList<product_json>();
                for(int i=0; i<products[j].length(); i++)
                {
                    JSONObject object = products[j].getJSONObject(i);

                    product_json product_json = new product_json();

                    product_json.setBrand(object.getString("brand"));
                    product_json.setName(object.getString("name"));
                    product_json.setPrice(object.getString("price"));
                    product_json.setURL(object.getString("img_url"));

                    row.add(product_json);
                }
                productList.add(row);
            }

        }catch (JSONException e) {
            e.printStackTrace();
        }
    }*/



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //json_parsing(loadJSONFromAsset(this.getContext()));
        View view = inflater.inflate(R.layout.fragment_product_recommend, container, false);
        makeRequest();




        hairproductRecycler = view.findViewById(R.id.recycler_hairproduct);
        hairproductRecycler.setLayoutManager(new GridLayoutManager(hairproductRecycler.getContext(), 2));
        hairproductAdapter = new hairproductAdapter();
        hairproductRecycler.setAdapter(hairproductAdapter);


        //RecyclerView hairtypeRecycler = view.findViewById(R.id.recycler_hairproduct);
        //hairtypeRecycler.setLayoutManager(new LinearLayoutManager(hairtypeRecycler.getContext(), RecyclerView.HORIZONTAL, false));
        //hairtypeAdapter hairtypeAdapter = new hairtypeAdapter();
        //hairtypeRecycler.setAdapter(hairtypeAdapter);
        //or(int i = 0; i < 3; i++){
           //hairtypeAdapter.addItem(new hairtypeItem(getResources().getDrawable(DrawableToInt.HairType[i][0]), getResources().getDrawable(DrawableToInt.HairType[i][1]), DrawableToInt.HairTypeName[i]));
        //}
        return view;
    }


    public void processResponse(String response){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        product_category product_category = gson.fromJson(response, product_category.class);

        for (int i = 0; i<product_category.wax.size(); i++){
            product_json product_json = product_category.wax.get(i);
            hairproductAdapter.addItem(product_json);
        }
        hairproductAdapter.notifyDataSetChanged();

        //for(int i = 0; i < product_category.wax.size(); i++){
        //    //hairproductAdapter.addItem(new hairproductItem(Oliveyoung.URL[i], "gatsby", "Wax", "5000원"));
        //    hairproductAdapter.addItem(
        //            new hairproductItem(
        //                    product_category.wax.get(i).getURL(), product_category.wax.get(i).getBrand(),
        //                    product_category.wax.get(i).getName(), product_category.wax.get(i).getPrice())
        //    );
        //}

        //JsonParser parser = new JsonParser();
        //JsonElement element = parser.parse(response);

    }
}