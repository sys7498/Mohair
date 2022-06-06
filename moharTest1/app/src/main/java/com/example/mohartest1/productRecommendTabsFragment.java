package com.example.mohartest1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link productRecommendTabsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class productRecommendTabsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static RequestQueue requestQueue;
    hairproductAdapter hairproductAdapter;
    RecyclerView hairproductRecycler;
    ArrayList<ArrayList<product_json>> productList = new ArrayList<ArrayList<product_json>>();
    int category = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public productRecommendTabsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment waxtabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static productRecommendTabsFragment newInstance(String param1, String param2) {
        productRecommendTabsFragment fragment = new productRecommendTabsFragment();
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
        String url = "http://39.115.234.33:5000/";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        processResponse(response);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product_recommend_tabs, container, false);
        makeRequest();

        hairproductRecycler = view.findViewById(R.id.recycler_wax);
        hairproductRecycler.setLayoutManager(new GridLayoutManager(hairproductRecycler.getContext(), 2));
        hairproductAdapter = new hairproductAdapter();
        hairproductRecycler.setAdapter(hairproductAdapter);

        return view;
    }


    public void processResponse(String response){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        product_category product_category = gson.fromJson(response, product_category.class);

        switch(category) {
            case 1:
                for (int i = 0; i < product_category.wax.size(); i++) {
                    product_json wax_json = product_category.wax.get(i);
                    hairproductAdapter.addItem(wax_json);
                }
                break;
            case 2:
                for (int i = 0; i < product_category.fomard.size(); i++){
                    product_json fomard_json = product_category.fomard.get(i);
                    hairproductAdapter.addItem(fomard_json);
                }
                break;
            case 3:
                for (int i = 0; i < product_category.spray.size(); i++){
                    product_json spray_json = product_category.spray.get(i);
                    hairproductAdapter.addItem(spray_json);
                }
                break;
            case 4:
                for (int i = 0; i < product_category.curlcream.size(); i++){
                    product_json curlcream_json = product_category.curlcream.get(i);
                    hairproductAdapter.addItem(curlcream_json);
                }
                break;
            case 5:
                for (int i = 0; i < product_category.shampoo.size(); i++){
                    product_json shampoo_json = product_category.shampoo.get(i);
                    hairproductAdapter.addItem(shampoo_json);
                }
                break;
            case 6:
                for (int i = 0; i<product_category.dye.size(); i++){
                    product_json dye_json = product_category.dye.get(i);
                    hairproductAdapter.addItem(dye_json);
                }
                break;
            }
        hairproductAdapter.notifyDataSetChanged();
    }
}